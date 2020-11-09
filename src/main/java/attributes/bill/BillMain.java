package attributes.bill;

import java.util.Random;

import static java.lang.Math.round;

public class BillMain {
    public static void main(String[] args) {
        Bill bill = new Bill();
        Random rnd = new Random();
        for (int i = 1; i < 10; i++) {

            bill.addItem(new Item("Item"+i, rnd.nextInt(5)+1, round(rnd.nextDouble()*10000)/100));

        }
        for (Item item : bill.getItems()){
            System.out.println(item.getProduct() + ":  " + item.getQuantity() + " * " + item.getPrice());
        }
        System.out.println("Total : " + bill.calculateTotalPrice());
    }
}
