package staticattrmeth.bank;

import algorithmsdecision.bankaccounts.BankAccount;

import java.math.BigDecimal;

public class BankTransaction {

    public static final BigDecimal MIN = new BigDecimal(0);
    public static final BigDecimal MAX = new BigDecimal(10_000_000);

    private static long currentMinValue =0;
    private static long currentMaxValue = 0;
    private static BigDecimal sumOfTrxs = new BigDecimal(0);
    private static int counterOfTrxs = 0;

    private long trxValue;



    public static void initTheDay() {
            counterOfTrxs = 0;
            sumOfTrxs = BigDecimal.valueOf(0);
            currentMinValue = 0;
            currentMaxValue = 0;
    }
    public static BigDecimal averageOfTransaction(){
        return sumOfTrxs.divide(BigDecimal.valueOf(counterOfTrxs));
    }
    public static long getCurrentMinValue() {
        return currentMinValue;

    }
    public static long getCurrentMaxValue() {

        return currentMaxValue;
    }
    public static BigDecimal getSumOfTrxs(){

        return sumOfTrxs;
    }


    public static void setCurrentMinValue(long currentMinValue) {
        BankTransaction.currentMinValue = currentMinValue;
    }

    public static void setCurrentMaxValue(long currentMaxValue) {
        BankTransaction.currentMaxValue = currentMaxValue;
    }

    public static void addToSumOfTrxs(long valueOfTrxs) {
        BankTransaction.sumOfTrxs = BankTransaction.sumOfTrxs.add(BigDecimal.valueOf(valueOfTrxs));
        BankTransaction.counterOfTrxs++;
    }


    public long getTrxValue() {
        return trxValue;
    }

    private void setTrxValue(long trxValue) {
        this.trxValue = trxValue;
    }


    private void validator(long trxValue) {
        if(BankTransaction.MAX.compareTo(BigDecimal.valueOf(trxValue)) ==-1 ||
                BankTransaction.MIN.compareTo(BigDecimal.valueOf(trxValue))==1)
        {
            throw new IllegalArgumentException("A banki tranzakció értéke 1 és 10 000 000 között lehet");
        }

    }

    public BankTransaction(long trxValue) {
        validator(trxValue);
        this.trxValue = trxValue;
        if (getCurrentMaxValue()<trxValue) {
            setCurrentMaxValue(trxValue);
        }
        if (getCurrentMinValue()==0 || getCurrentMinValue() >trxValue){
            setCurrentMinValue(trxValue);
        }
        addToSumOfTrxs(trxValue);
    }
}
