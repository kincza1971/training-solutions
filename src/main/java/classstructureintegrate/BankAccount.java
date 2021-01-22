package classstructureintegrate;

public class BankAccount {
    String accountNumber;
    String owner;
    int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance +=amount;
    }

    public void withrow(int amount) {
        this.balance -= amount;
    }

    public void transfer (BankAccount to, int amount) {
        to.balance += amount;
        this.balance -= amount;
     }

     public String getInfo() {
        return owner + " (" + accountNumber + "): " + balance + " Ft";
    }
}
