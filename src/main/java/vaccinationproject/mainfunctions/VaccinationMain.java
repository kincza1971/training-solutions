package vaccinationproject.mainfunctions;

import java.util.Scanner;

public class VaccinationMain {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        VaccinationController covid = new VaccinationController(scr);
        covid.controllerMain();
    }

}
