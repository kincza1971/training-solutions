package week14.d02;

import collectionsmap.Entry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Shop {

    public static final String TRANSACTION_SEPARATOR = ":";
    public static final String CUSTOMER_SEPARATOR = "-";
    public static final String ITEM_SEPARATOR = ",";
    private Map<String,Integer> sold;
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
                sum= customer.getTransactions()
                        .get(key)
                        .stream()
                        .reduce(0,(sub,it) -> sub += it.getItemPrice(),(sub,othersub) -> sub += othersub);
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

    public int getCustomerSpentSumByStream(String customerId) {
        int sum = 0;
        Customer customer =customers.stream()
                .filter(cus -> cus.getCustomerId().equals(customerId))
                .collect(Collectors.toList())
                .get(0);
        for (List<Item> itemList : customer.getTransactions().values()) {
            sum += itemList.stream().reduce(0,(sub,it) -> sub+it.getItemPrice(),(sub,othersub) -> sub = sub+othersub);
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

    public List<Item> getSortedItemsOfTransactions(String custId, String key,Comparator comparator) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(custId)) {
                return getSortedItems(key, comparator, customer);
            }
        }
        throw new IllegalArgumentException("Customer not found");
    }

    private List<Item> getSortedItems(String key, Comparator<Item> comparator, Customer customer) {
        List<Item> items = getItems(key, customer);
        if (items != null) {
            items.sort(comparator);
            return items;
        }
        return null;
    }

    private List<Item> getItems(String key, Customer customer) {
        if (customer.getTransactions().containsKey(key)) {
            return customer.getTransactions().get(key);
        }
        throw new IllegalArgumentException("Invalid transaction id");
    }

    public int countOrdersByItemName(String itemName) {
        int counter = 0;
        for (Customer customer : customers) {
            for (List<Item> items : customer.getTransactions().values()) {
                counter += items.stream().filter(item -> item.getItemName().equals(itemName)).count();
            }
        }
        return counter;
    }

    private void collectItems (Item item) {
        if (sold.containsKey(item.getItemName())) {
            sold.put(item.getItemName(),sold.get(item.getItemName()).intValue()+1);
        } else {
            sold.put(item.getItemName(),1);
        }
    }

    private List<String> createStringList() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sold.entrySet()) {
            result.add(String.format("%s (%d db)", entry.getKey(),entry.getValue()));
        }
        return result;
    }

    public List<String> getItemStatistic() {
        sold = new HashMap<>();
        for (Customer customer : customers) {
            for (List<Item> items : customer.getTransactions().values()) {
                items.stream().forEach(this::collectItems);
            }
        }
        return createStringList();
    }

    public Shop() {
        readFromFile();
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Comparator<Item> comparator = (o1, o2) -> o1.getItemName().compareTo(o2.getItemName());
        System.out.println(shop.getSortedItemsOfTransactions("RA22","1145",comparator));
        comparator = (o1,o2) ->o1.getItemPrice()-o2.getItemPrice();
        System.out.println(shop.getSortedItemsOfTransactions("RA22","1145",comparator));
        System.out.println(shop.getCustomerSpentSumByStream("RA22"));
        System.out.println(shop.getTransactionsValue("1145"));
        System.out.println(shop.countOrdersByItemName("bread"));
        System.out.println(shop.getItemStatistic());
    }


}
