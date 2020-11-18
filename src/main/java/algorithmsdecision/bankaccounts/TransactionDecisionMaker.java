package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime startTime,
                                                  LocalDateTime endTime, int limit) {
        for (Transaction tr : transactions) {
            if (tr.getTransactionOperation()==TransactionOperation.DEBIT
                    & tr.getDateOfTransaction().isBefore(endTime)
                    & tr.getDateOfTransaction().isAfter(startTime)
                    & tr.getAmount()>limit){
                return true;
            }
        }
        return false;
    }
    public boolean containsDebitEntryGreaterThan(List<Transaction> transactions, LocalDateTime startTime,
                                                  LocalDateTime endTime, int limit) {
        for (Transaction tr : transactions) {
            if (tr.getTransactionOperation()==TransactionOperation.CREDIT
                    & tr.getDateOfTransaction().isBefore(endTime)
                    & tr.getDateOfTransaction().isAfter(startTime)
                    & tr.getAmount()>limit){
                return true;
            }
        }
        return false;
    }
}
