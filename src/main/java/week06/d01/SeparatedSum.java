package week06.d01;

public class SeparatedSum {

    private boolean isEmpty (String s) {
        return (s == null || s.isBlank());
    }

    public SumResult sum (String s){
        double pos =0.0;
        double neg = 0.0;
        double aValue;
        if (isEmpty(s)) {
            throw new IllegalArgumentException("A string nem lehet null, vagy üres (" + s +")");
        }
        String[] strValues = s.split(";");
        for (int i =0; i<strValues.length;i++) {
            aValue = Double.parseDouble(strValues[i].replace(",","."));
            if (aValue < 0) {
                neg += aValue;
            } else {
                pos += aValue;
            }
        }
        return new SumResult(neg,pos);
    };

}
