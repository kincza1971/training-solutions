package introcontrol;

import java.util.Scanner;

public class UserMenu {
    public static void main(String[] args) {
        System.out.println("1. Felhasználók listázása");
        System.out.println("2. Felhasználó felvétele");
        System.out.println("Többi: Kilépés");

        Scanner scnr = new Scanner(System.in);
        int i = scnr.nextInt();
        String toPrint;
        switch (i) {
            case 1:
                toPrint="Felhasználók listázása";
                break;
            case 2:
                toPrint="Felhasználó felvétele";
                break;
            default :
                toPrint="Kilépés";
        }
        System.out.println(toPrint);
    }
}
