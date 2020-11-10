package enumtype.unit;

import java.math.BigDecimal;

public class UnitConverterMain {
    public static void main(String[] args) {
        UnitConverter uc = new UnitConverter();
        System.out.println(uc.convert(new BigDecimal(100),LengthUnit.FOOT, LengthUnit.CENTIMÉTER));

    }

}
