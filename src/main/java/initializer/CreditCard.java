package initializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.round;

public class CreditCard {

    private static final List<Rate> DEFAULT_RATES;
    private static final Currency DEFAULT_CURRENCY;

    private long balance;
    private Currency currency;
    private List<Rate> currentRates;

    static {
        DEFAULT_RATES = new ArrayList<>(Arrays.asList(
                new Rate(Currency.EUR,308.23),
                new Rate(Currency.GBP, 460.4),
                new Rate(Currency.SFR, 150.2),
                new Rate(Currency.USD,320.0)
        ));
        DEFAULT_CURRENCY = Currency.HUF;
    }

    public long getBalance() {

        return balance;

    }
    public boolean payment(long amount, Currency currency) {
        long toPay = convertToHUF(amount,currency);
        return payment(toPay);
    }

    public boolean payment(long amount){
        if ( this.balance>= amount) {
            balance -= amount ;
            return true;
        }
        return false;
    }

    private double getConversionRate(Currency currencyToFind) {
        for (Rate rate : currentRates) {
            if(rate.getCurrency().equals(currencyToFind)) {
                return rate.getConversionFactor();
            }
        }
        return 1;
    }

    private double convertFromHUF(long amount,Currency toCurr) {
        if (toCurr == Currency.HUF) {
            return amount;
        } else {
            return amount / getConversionRate(toCurr);
        }
    }

    private long convertToHUF(long amount, Currency fromCurr) {
        if (fromCurr == Currency.HUF) {
            return amount;
        } else {
            return round(amount * getConversionRate(fromCurr));
        }
    }

    private Currency checkedCurrency(Currency currency) {
        if (currency == null) {
            return DEFAULT_CURRENCY;
        }
        return currency;
    }

    private List<Rate> checkedRates(List<Rate> convRates) {
        if (convRates == null || convRates.size()==0) {
            return DEFAULT_RATES;
        }
        return convRates;
    }


    public CreditCard(long balance, Currency currency,List<Rate> convRates){
        this.currency = checkedCurrency(currency);
        this.currentRates = checkedRates(convRates);
        this.balance = convertToHUF(balance,currency);
    }


    public CreditCard(long balance, Currency currency){
        this(balance,currency,DEFAULT_RATES);
    }
    public CreditCard(long balance){
        this(balance,DEFAULT_CURRENCY,DEFAULT_RATES);
    }

}
