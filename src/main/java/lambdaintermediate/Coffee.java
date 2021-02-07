package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.round;

public class Coffee {
    private final CoffeeType type;
    private final BigDecimal price;

    public Coffee(CoffeeType type, BigDecimal price) {
        this.type = type;
        this.price = new BigDecimal(price.doubleValue()).setScale(2, RoundingMode.HALF_UP)  ;
    }

    public CoffeeType getType() {
        return type;
    }

    public double getPrice() {
        return price.doubleValue();
    }
}
