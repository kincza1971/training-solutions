package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class CoffeeOrder implements Comparable<CoffeeOrder>{
    private final LocalDateTime dateTime;
    private final List<Coffee> coffeeList;

    public CoffeeOrder( List<Coffee> coffeeList, LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.coffeeList = coffeeList;
    }
    public CoffeeOrder(List<Coffee> coffeeList) {
        this.dateTime = LocalDateTime.now();
        this.coffeeList = coffeeList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public Stream<Coffee> getCoffeeListAsStream() {
        return coffeeList.stream();
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }


    @Override
    public int compareTo(CoffeeOrder o) {
        return dateTime.compareTo(o.getDateTime());
    }
}
