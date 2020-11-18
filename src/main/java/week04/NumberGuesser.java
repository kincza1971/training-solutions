package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {
        System.out.println("gondoltam egy számra (0 és 100 között), tippelj!");
        Random rnd = new Random();
        int num = rnd.nextInt(101) ;
//        System.out.println(num);
        int guess = -1;
        int counter = 1;
        boolean kitalalva = false;
        Scanner sc = new Scanner(System.in);
        while (!kitalalva & counter <8)  {
            guess = sc.nextInt();
            if (num == guess) {
                System.out.println("Gratulálok!!");
                kitalalva = true;
            } else {
                counter++;
                System.out.println(num < guess ? "Kisebbre gondoltam " : "Nagyobbra gondoltam " );
            }
        }
        if (counter ==7) {
            System.out.println("vesztettél :)");
        }

    }
}
