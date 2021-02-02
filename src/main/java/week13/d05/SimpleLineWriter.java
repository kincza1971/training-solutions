package week13.d05;

public class SimpleLineWriter implements RowWriter{
    @Override
    public String writeRow(BillItem billItem) {
        return String.format("%d %s, databja %d Ft\n", billItem.getNumber(),billItem.getName(),billItem.getUnitPrice());
    }
}
//3 kenyér, darabja 10 Ft