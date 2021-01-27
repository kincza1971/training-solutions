package methodoverloading;

import java.time.LocalTime;

public class Time {

    private LocalTime time;
    private int hours;
    private int minutes;
    private int seconds;


    public boolean isEqual(Time time) {
        return this.time.equals(time.getTime());
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        return this.time.equals(LocalTime.of(hours,minutes,seconds));
    }

    public boolean isEarlier(Time time) {
        return time.getTime().isBefore(this.time);
    }
    public boolean isEarlier(int hours, int minutes, int seconds) {
        return LocalTime.of(hours, minutes, seconds).isBefore(this.time);
    }

    public LocalTime getTime() {
        return time;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public Time(int hours, int minutes, int seconds) {
        time = LocalTime.of(hours,minutes,seconds);
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public Time(int hours, int minutes) {
        time = LocalTime.of(hours,minutes);
        this.hours = hours;
        this.minutes = minutes;
    }
    public Time(int hours) {
        time = LocalTime.of(hours,0);
        this.hours = hours;
    }
    public Time(Time time){
        this.time = time.getTime();
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
        this.seconds = time.seconds;
    }

}
