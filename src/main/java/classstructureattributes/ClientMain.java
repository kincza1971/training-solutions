package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        System.out.println("Kére, adja meg a Client nevét:");
        Scanner scanner = new Scanner(System.in);
        client.name = scanner.nextLine();
        System.out.println("kérem, adja meg a Client születési évét:");
        client.year = scanner.nextInt();
        System.out.println("Kérem, adja meg a Client címét:");
        client.address = scanner.nextLine();
        client.address = scanner.nextLine();
        System.out.println(client.name + ", " + client.year + ", " + client.address);
    }
}
