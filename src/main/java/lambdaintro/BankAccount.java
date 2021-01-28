package lambdaintro;

import java.util.Comparator;

public class BankAccount implements Comparable<BankAccount>{
    private final String accountNumber;
    private final String nameOfOwner;
    private final double balance;

    public BankAccount(String accountNumber, String nameOfOwner, double balance) {
        this.accountNumber = accountNumber;
        this.nameOfOwner = nameOfOwner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public double getBalance() {
        return balance;
    }

    public double getAbsBalance() {
        return Math.abs(getBalance());
    }

    @Override
    public int compareTo(BankAccount o) {
        return this.getAccountNumber().compareTo(o.getAccountNumber());
    }
}
