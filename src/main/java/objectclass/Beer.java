package objectclass;

import java.util.Objects;

public class Beer {
    private final String name;
    private final int price;



    public Beer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Objects.equals(name, beer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
