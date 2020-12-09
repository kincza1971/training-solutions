package week07.d03;

public class Date {
    private final int year;
    private final int month;
    private final int day;

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


    private void checkYear(int year){
        if (year <0) {
            throw new IllegalArgumentException("Az év csak pozitív egész szám lehet");
        }
    }

    private void checkMonth(int month) {
        if (month>0 && month <13) {
            return;
        }
        throw new IllegalArgumentException("A hónap (" + month + ") 1 és 12 közötti egész szám lehet");
    }

    private void checkDay(int year,int month, int day) {
        if (day>0 && day<=calculateMonthLength(year,month)) {
            return;
        }
        throw new IllegalArgumentException("Hibás nap (" +year+ ","+ month +","+day+ ")");
    }

    private void checkParams(int year, int month, int day) {
        checkYear(year);
        checkMonth(month);
        checkDay(year, month,day);
    }

    static Date of(int year, int month, int day) {
         return new Date(year, month, day);
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

    public Date withYear(int year) {
        checkParams(year,getMonth(),getDay());
        return of(year,getMonth(),getDay());
    }

    public Date withMonth(int month) {
        checkParams(getYear(),month,getDay());
        return of(getYear(),month,getDay());
    }

    public Date withDay(int day) {
        checkParams(getYear(),getMonth(),day);
        return of(getYear(),getMonth(),day);
    }



    private Date(int year, int month, int day) {
        checkParams(year,month,day);
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
