package classsctructureintegrate;

import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérem az 1. tulajdonos nevét:");
        String owner = scanner.nextLine();
        System.out.println("Kérem az 1. bankszámlaszámot:");
        String acc = scanner.nextLine();
        System.out.println("Kérem az 1. nyitóegyenleget:");
        int balance = scanner.nextInt();
        scanner.nextLine();

        BankAccount bankacc1 = new BankAccount(acc,owner,balance);

        System.out.println("Kérem a 2. tulajdonos nevét:");
        owner = scanner.nextLine();
        System.out.println("Kérem a 2. bankszámlaszámot:");
        acc = scanner.nextLine();
        System.out.println("Kérem a 2. nyitóegyenleget:");
        balance = scanner.nextInt();

        BankAccount bankacc2 = new BankAccount(acc,owner,balance);

        System.out.println(bankacc1.getInfo());
        System.out.println(bankacc2.getInfo());

        bankacc1.deposit(10000);
        bankacc2.deposit(5000);

        System.out.println(bankacc1.getInfo());
        System.out.println(bankacc2.getInfo());

        bankacc1.withrow(10000);
        bankacc2.withrow(5000);

        System.out.println(bankacc1.getInfo());
        System.out.println(bankacc2.getInfo());

        bankacc1.transfer(bankacc2,10000);

        System.out.println(bankacc1.getInfo());
        System.out.println(bankacc2.getInfo());

    }
}
