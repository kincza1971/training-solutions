package introcontrol;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Kérem a " + (i+1) + ". számot:");
            sum += scnr.nextInt();
        }
        System.out.println("Az összeg: " +sum);
    }
}
