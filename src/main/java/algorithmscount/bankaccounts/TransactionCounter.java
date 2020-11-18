package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions,int amount) {
        int counter = 0;
        for (Transaction aTransaction : transactions) {
            if (aTransaction.getAmount()< amount){
                counter ++;
            }
        }
        return counter;
    }
}
