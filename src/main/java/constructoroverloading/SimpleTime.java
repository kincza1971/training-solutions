package constructoroverloading;

public class SimpleTime {
    private int hours;
    private int minutes;

    public int difference(SimpleTime time) {
        return (getHours()- time.getHours())*60 + getMinutes()-time.getMinutes();
    }
    public String toString() {
        return String.format("%d:%d", getHours(),getMinutes());
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes=minutes;
    }
    public SimpleTime(int hours) {
        this(hours,0);
    }
    public SimpleTime(SimpleTime time) {
        this(time.getHours(), time.getMinutes());
    }
}
