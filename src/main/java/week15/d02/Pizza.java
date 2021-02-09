package week15.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Pizza {

    private List<Order> orderList = new ArrayList<>();

    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(this.getClass().getResourceAsStream("/orders.txt"), StandardCharsets.UTF_8)))
        {
            String line ="";
            LocalDate date = null;
            while ((line = br.readLine()) != null) {
                if (line.length() == 10) {
                    date = LocalDate.parse(line, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                }else {
                    String[] lineParts = br.readLine().split(" ");
                    String address = lineParts[0] + " "+lineParts[1] + " "+lineParts[2];
                    LocalTime time = LocalTime.parse(lineParts[3]);
                    orderList.add(new Order(date,time,line,address));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("cannot read file");
        }
    }

    public LocalDate findWorstDay() {
        int minOrders = Integer.MAX_VALUE;
        int aktOrders = 0;
        LocalDate aktDate = LocalDate.of(1,1,1);
        LocalDate minDate = aktDate;
        for (Order order : orderList) {
            if (aktDate.equals(order.getDate())) {
                aktOrders++;
            } else {
                if (aktOrders < minOrders) {
                    minOrders = aktOrders;
                    aktOrders=1;
                    minDate = aktDate;
                }
                aktDate = order.getDate();
            }
        }
        return minDate;
    }

    public Optional<Order> findOrder(LocalDate date, LocalTime time) {
        return orderList.stream().filter(m -> m.getDate().equals(date) && m.getTime().equals(time)).findFirst();
    }

    public Map<String, Integer> getStatisticByDriver() {
        Map<String, Integer> drivers = new TreeMap<>();
        String driver;
        for (Order order : orderList) {
            driver = order.getDriver();
            if (drivers.containsKey(driver)) {
                drivers.put(driver,drivers.get(driver)+1);
            } else {
                drivers.put(driver,1);
            }
        }
        return drivers;
    }

    public String getMostPopularAddress() {
        Map<String, Integer> addresses = getAddressMap();
        int maxVisit = 0;
        String mostPopularAddress = null;
        for (String anAddress : addresses.keySet()) {
            if (addresses.get(anAddress) > maxVisit) {
                maxVisit = addresses.get(anAddress);
                mostPopularAddress = anAddress;
            }
        }
        return mostPopularAddress;
    }

    private Map<String, Integer> getAddressMap() {
        Map<String, Integer> addresses = new TreeMap<>();
        String address;
        for (Order order : orderList) {
            address = order.getAddress();
            if (addresses.containsKey(address)) {
                addresses.put(address,addresses.get(address)+1);
            } else {
                addresses.put(address,1);
            }
        }
        return addresses;
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.loadFromFile();
        System.out.println(pizza.findWorstDay());
        System.out.println(pizza.getStatisticByDriver());
    }

}

//Adott egy fájl melyben pizza rendeléseket tárolunk. A fájl blokkokra van osztva, egy blokk egy napot jelöl,
// és minden ilyen blokk egy dátummal kezdődik. Ezután egy rendelés adatai két sorban találhatók.
// Az első sor a futár azonosítója, a második sorban irányítószám, utcanév, házszám és a szállítás pontos ideje található.
//​
//```
//2020.12.01
//FUT_1
//1113 Petőfi 12 12:30
//FUT_1
//1144 Tököly 11 16:33
//2020.12.02
//FUT_1
//1123 Ady 12 12:30
//....
//```
//​
//A fájl beolvasása után oldjátok meg a következő feladatokat!
//1. Melyik napon volt a legkevesebb rendelés?
//2. Egy metódus várjon paraméterül egy dátumot, pontos időponttal és adjuk vissza a hozzá tartozó rendelést.
// Ha nincs ilyen akkor dobjunk kivételt. (Vagy Optional)
//3. Készíts statisztikát a futárok szállításiból, futáronként add vissza, hogy mennyi rendelést teljesítettek.
//4. Melyik címre szállították a legtöbb pizzát?
