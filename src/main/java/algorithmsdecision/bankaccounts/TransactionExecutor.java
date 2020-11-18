package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {
    public void executeTransactions(List<Transaction> transactions, List<BankAccount> accounts) {
        for (Transaction tr : transactions) {
            for (BankAccount account : accounts) {
                if (tr.getAccountNumber() == account.getAccountNumber()){
                    if (tr.isCredit()) {
                        account.deposit(tr.getAmount());
                    } else {
                        account.withdraw(tr.getAmount());
                    }
                }
            }
        }
    }
}
