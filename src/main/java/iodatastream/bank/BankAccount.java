package iodatastream.bank;


public class BankAccount {
    private final String accountNumber;
    private final String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }
}
