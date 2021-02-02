package week14.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {

    public static final String TRANSACTION_SEPARATOR = ":";
    public static final String CUSTOMAR_SEPARATOR = "-";
    public static final String ITEM_SEPARATOR = ",";
    private List<Customer> customers = new ArrayList<>();


    public void readFromFile() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Customer.class.getResourceAsStream("transactions.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                procLine(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    private void procLine(String line) {
        String[] strings = line.split(TRANSACTION_SEPARATOR);
        String[] custStrings = strings[0].split(CUSTOMAR_SEPARATOR);
        String[] itemStrings = strings[1].trim().split(ITEM_SEPARATOR);

        createCustomeList(custStrings[0], custStrings[1], itemStrings);
    }

    private void createCustomeList(String name, String custString, String[] itemStrings) {
        Customer customer = new Customer(name);
        customers.add(customer);
        String transactionId = custString;
        List<Item> items = new ArrayList<>();
        for (String item : itemStrings) {
            String[] itemParts = item.split("(");
            items.add(new Item(itemParts[0], Integer.parseInt(itemParts[1].substring(0, itemParts[1].length() - 1))));
        }
    }

    public int getTransactionsValue(String key) {
        int sum = 0;
        for (Customer customer : customers) {
            if (customer.getTransactions().containsKey(key)) {
                for (Item item : customer.getTransactions().get(key)) {
                    sum += item.getItemPrice();
                }
                return sum;
            }
        }
        throw new IllegalArgumentException("No such id");
    }

    public int getCustomerSpentSum(String customerId) {
        int sum = 0;
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                for (List<Item> items : customer.getTransactions().values()) {
                    for (Item item : items) {
                        sum += item.getItemPrice();
                    }
                }
            }
        }
        return sum;
    }

    public List<Item> getSortedItemsOfTransactions(String custId, String key) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(custId)) {
                if (customer.getTransactions().containsKey(key)) {
                    List<Item> items = customer.getTransactions().get(key);
                    items.sort(new Comparator<Item>() {
                        @Override
                        public int compare(Item o1, Item o2) {
                            return o1.getItemName().compareTo(o2.getItemName());
                        }
                    });
                    return items;
                }
            }
        }
        throw new IllegalArgumentException("Customer not found");
    }


}
