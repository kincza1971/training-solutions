package week14.d02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
