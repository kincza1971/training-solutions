package iozip.transactions;

import java.time.LocalDateTime;

public class Transaction {
    private long id;
    private LocalDateTime time;
    private String account;
    private double amount;


    public long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public Transaction(long id, LocalDateTime time, String account, double amount) {
        this.id = id;
        this.time = time;
        this.account = account;
        this.amount = amount;
    }
}
