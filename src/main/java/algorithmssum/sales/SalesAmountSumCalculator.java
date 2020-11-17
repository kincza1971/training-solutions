package algorithmssum.sales;

import java.util.List;

public class SalesAmountSumCalculator {
    public int sumSalesAmount(List<Salesperson> salespersonList){
        int sum = 0;
        for (Salesperson salesperson : salespersonList) {
            sum += salesperson.getAmount();
        }
        return sum;
    }
}
