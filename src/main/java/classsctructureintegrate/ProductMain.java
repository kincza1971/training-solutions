package classsctructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem az új termék nevét:");
        String name = scanner.nextLine();
        System.out.println("Kérem az új termék árát:");
        int price =scanner.nextInt();
        Product product = new Product(name,price);
        System.out.println(product.getName() + ", " + product.getPrice());
        product.decreasePrice(1);
        System.out.println(product.getName() + ", csökkentett ár: " + product.getPrice());
        product.increasePrice(5);
        System.out.println(product.getName() + ", növelt ár: " + product.getPrice());

    }
}
