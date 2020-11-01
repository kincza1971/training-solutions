package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int szam1;
        int szam2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("kérem az első egész számot:");
        szam1 = scanner.nextInt();
 //       scanner.nextLine();
        System.out.println("kérem a második egész számot:");
        szam2 = scanner.nextInt();
        System.out.println(szam1 + " + " + szam2);
        System.out.println(szam1+szam2);
    }
}
