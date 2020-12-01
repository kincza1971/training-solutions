package defaultconstuctor.date;


public class SimpleDateFormatter {

    public static final String SEPARATOR = "-";
    private CountryCode cc = CountryCode.HU;

    public SimpleDateFormatter() {

        cc = CountryCode.HU;
    }


    public String formatDateString(SimpleDate simpleDate) {
        return formatDateStringByCountryCode(CountryCode.HU,simpleDate);

    }
    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {

        if (countryCode.equals(CountryCode.HU)) {
            return simpleDate.getYear() + SEPARATOR + simpleDate.getMonth()+SEPARATOR + simpleDate.getDay();
        }

        if (countryCode.equals(CountryCode.EN)) {
            return simpleDate.getDay() + SEPARATOR + simpleDate.getMonth()+SEPARATOR + simpleDate.getYear();
        }

        return simpleDate.getMonth() + SEPARATOR + simpleDate.getDay()+SEPARATOR + simpleDate.getYear();
    }
}
