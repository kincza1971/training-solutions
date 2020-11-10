package enumtype.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class UnitConverter {
    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {
        BigDecimal bdSrc = new BigDecimal(source.getInMillimeter());
        BigDecimal bdTarget = new BigDecimal(target.getInMillimeter());
        return length.multiply(bdSrc.divide(bdTarget, 4, RoundingMode.HALF_UP));
    }

}
