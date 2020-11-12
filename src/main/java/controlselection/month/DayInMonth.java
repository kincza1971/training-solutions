package controlselection.month;

public class DayInMonth {

    public int dayInMonth(int year, String month) {
        switch (month.toUpperCase()) {
            case "JANUÁR" :
            case "MÁRCIUS":
            case "MÁJUS" :
            case "JÚLIUS" :
            case "AUGUSZTUS" :
            case "OKTÓBER" :
            case "DECEMBER" :
                return 31;
            case "ÁPRILIS" :
            case "JÚNIUS" :
            case "SZEPTEMBER":
            case "NOVEMBER":
                return 30;
            case "FEBRUÁR" :
                if ( (year % 400==0) || ( (year % 100 != 0) && (year % 4 == 0) ) ) {
                    return 29;
                } else {
                    return 28;
                }
            default: throw new IllegalArgumentException("Invalig Month + " + month);
        }
    }
}
