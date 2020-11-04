package introcontrol;

import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Kérem a csoport létszámát");
        int number = scnr.nextInt();
        String res;
        switch (number) {
            case 1: case 2:
                res = "kétszemélyes csónak, még 8-an mehetnek";
                break;
            case 3:
                res="Háromszemélyes csónak, még 7-en mehetnek";
                break;
            case 4: case 5:
                res="Ötszemélyes csónak, még 5-en mehetnek";
                break;
            case 6: case 7:
                res= "Öt- és kétszemélyes csónak, még 3-an mehetnek";
                break;
            case 8:
                res= "Öt- és háromszemélyes csónak, még 2-en mehetnek";
                break;
            case 9: case 10:
                res="Összes csónak, a helyek beteltek";
                break;
            default: res= "Összes csónak tele, még " + (number -10) + " ember maradt a parton";
        }
        System.out.println(res);
    }
}
