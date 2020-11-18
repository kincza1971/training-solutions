package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;

public class BankAccount {

    private String nameOfOwner;
    private String accountNumber;
    private int balance;

    public boolean deposit (int amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw (int amount) {
        if (balance< amount){
            return false;
        }
        balance -= amount;
        return true;
    }

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}
