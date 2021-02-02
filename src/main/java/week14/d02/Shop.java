package week14.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {

    public static final String TRANSACTION_SEPARATOR = ":";
    public static final String CUSTOMER_SEPARATOR = "-";
    public static final String ITEM_SEPARATOR = ",";
    private List<Customer> customers = new ArrayList<>();


    public void readFromFile() {
        InputStream is = this.getClass().getResourceAsStream("/transactions.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
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
        String[] custStrings = strings[0].split(CUSTOMER_SEPARATOR);
        String[] itemStrings = strings[1].trim().split(ITEM_SEPARATOR);

        createCustomerList(custStrings[0], custStrings[1], itemStrings);
    }

    private Customer getOrCreateCustomer(String name) {
        Customer customer = new Customer(name);
        if (customers.contains(customer)) {
            return customers.get(customers.indexOf(customer));
        }
        customers.add(customer);
        return customer;
    }

    private void createCustomerList(String name, String transId, String[] itemStrings) {
        Customer customer = getOrCreateCustomer(name);
        List<Item> items = new ArrayList<>();
        String itemName;
        String price;
        for (String item : itemStrings) {
             itemName = item.substring(0,item.indexOf('('));
             price = item.substring(item.indexOf('(')+1,item.indexOf(')'));
            items.add(new Item(itemName,Integer.parseInt(price)));
        }
        customer.addTransaction(transId,items);
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
                sum = getSum(sum, customer);
            }
        }
        return sum;
    }

    private int getSum(int sum, Customer customer) {
        for (List<Item> items : customer.getTransactions().values()) {
            for (Item item : items) {
                sum += item.getItemPrice();
            }
        }
        return sum;
    }

    public List<Item> getSortedItemsOfTransactions(String custId, String key) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(custId)) {
                List<Item> items = getItems(key, customer);
                if (items != null) return items;
            }
        }
        throw new IllegalArgumentException("Customer not found");
    }

    private List<Item> getItems(String key, Customer customer) {
        if (customer.getTransactions().containsKey(key)) {
            List<Item> items = customer.getTransactions().get(key);
            items.sort((o1, o2) -> o1.getItemName().compareTo(o2.getItemName()));
            System.out.println(items);
            return items;
        }
        return null;
    }

    public Shop() {
        readFromFile();
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        System.out.println(shop.getSortedItemsOfTransactions("RA22","1145"));
        System.out.println("alma");
    }


}
