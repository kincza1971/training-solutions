package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem a nevét:");
        String nev = scanner.nextLine();
        System.out.println("Kérem az email címét:");
        String cim = scanner.nextLine();
        System.out.println("regisztrációs adatok: " + nev + ", " + cim);
    }
}
