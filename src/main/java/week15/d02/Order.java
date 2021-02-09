package week15.d02;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private LocalDate date;
    private LocalTime time;
    private String driver;
    private String address;


    public Order(LocalDate date, LocalTime time, String driver, String address) {
        this.date = date;
        this.time = time;
        this.driver = driver;
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDriver() {
        return driver;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Order{" +
                       "date=" + date +
                       ", time=" + time +
                       ", driver='" + driver + '\'' +
                       ", address='" + address + '\'' +
                       '}';
    }
}
