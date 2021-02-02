package week14.d02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private final String customerId;
    private Map<String, List<Item>> transactions = new HashMap<>();

    public void addTransaction(String id, List<Item> items) {
        transactions.put(id, items);
    }


    public Map<String, List<Item>> getTransactions() {
        return transactions;
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

}
