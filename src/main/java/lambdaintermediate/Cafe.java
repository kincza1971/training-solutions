package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private final List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public List<CoffeeOrder> getOrders() {
        return orders;
    }

    public void addOrder(CoffeeOrder order) {
        orders.add(order);
    }

    public BigDecimal getTotalIncome() {
        return BigDecimal.valueOf(orders.stream()
                .flatMap(CoffeeOrder::getCoffeeListAsStream)
                .mapToDouble(Coffee::getPrice )
                .sum()).setScale(2,RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return BigDecimal.valueOf(orders.stream()
                .filter(order -> order.getDate().equals(date))
                .flatMap(CoffeeOrder::getCoffeeListAsStream)
                .mapToDouble(Coffee::getPrice )
                .sum()).setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream()
                .flatMap(CoffeeOrder::getCoffeeListAsStream)
                .filter(coffee -> coffee.getType()==type)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return orders.stream()
                .filter(coffeeOrder -> coffeeOrder.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }

    public List<Coffee> getFirstFiveOrdersCaffe(LocalDate date) {
        return orders.stream()
                .filter(coffeOrder -> coffeOrder.getDate().equals(date))
                .limit(5)
                .flatMap(CoffeeOrder::getCoffeeListAsStream)
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(coffeOrder -> coffeOrder.getDate().equals(date))
                .sorted()
                .limit(5)
                .collect(Collectors.toList());
    }

}

//A Cafe osztály tartalmazza a kávézó összes rendelését egy listában. A listát a konstruktorban kapja meg,
// de legyen lehetőség új rendelést hozzáadni. Készítsd el benne az alábbi metódusokat streamek segítségével:
//
//getTotalIncome(): az eddigi összes bevétel
//
//getTotalIncome(LocalDate date): adott napi teljes bevétel
//
//getNumberOfCoffee(CoffeeType type): az adott típusú kávéból eladott összmennyiség
//
//getOrdersAfter(LocalDateTime from): a megadott időpont utáni rendelések listája
//
//getFirstFiveOrder(LocalDate date): adott napon az első 5 vásárlásban lévő kávék listája