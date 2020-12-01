package defaultconstuctor.date;

import java.time.Year;

public class SimpleDate {
    public static final int MIN_MONTH = 1;
    public static final int MAX_MONTH = 12;
    public static final int MIN_YEAR = 1900;
    private int year;
    private int month;
    private int day;


    private boolean isLeapYear(int year) {

        return (year %4 ==0 && year % 100 !=0) || (year % 400 ==0) ;
    }

    private int calculateMonthLength(int year, int month){
        int maxDay =0;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                maxDay=30;
                break;
            case 2:
                maxDay = isLeapYear(year) ? 29 : 28;
                break;
            default:
                maxDay =31;
                break;
        }
        return maxDay;
    }


    private boolean isCorrectDay(int year, int month, int day) {
        return (day >0 && day <= calculateMonthLength(year,month));
    }

    private boolean isCorrect(int year, int month, int day) {
        if (year<MIN_YEAR) {
            throw new IllegalArgumentException("Az év (" + year+") nem lehet korábbi mint " + MIN_YEAR);
        }
        if (month < MIN_MONTH || month > MAX_MONTH) {
            throw new IllegalArgumentException("A hónap (" + month+") 1 és 12 közötti szám lehet");
        }
        if (!isCorrectDay(year, month, day)) {
            throw new IllegalArgumentException("A nap (" + day+") 1 és " +calculateMonthLength(year,month) +" közötti szám lehet");
        }
        return true;
    }



    public void setDate(int year, int month, int day) {
        if (isCorrect(year,month,day)) {
            this.year  = year;
            this.month = month;
            this.day   = day;
        }

    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}
