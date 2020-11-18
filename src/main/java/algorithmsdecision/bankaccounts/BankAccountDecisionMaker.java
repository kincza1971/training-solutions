package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

    public boolean containsBalanceGreaterThan(List<BankAccount> bankAccounts, int amount){
        for (BankAccount ba: bankAccounts) {
            if (ba.getBalance() > amount) {
                return true;
            }
        }
        return false;
    }
}
