package algorithmssum.transactions;

import java.util.List;

public class TransactionSumCalculator {
    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum =0;
        for (Transaction aTran : transactions) {
            if(aTran.isCredit()){
                sum +=aTran.getAmount();
            }
        }
        return sum;


    }
}
