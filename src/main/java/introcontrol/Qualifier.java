package introcontrol;

import java.util.Scanner;

public class Qualifier {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Kérem a számot");
        int number = scnr.nextInt();
        System.out.println(number>100?"nagyobb, mint száz":"száz, vagy kisebb");
    }
}
