package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {
        System.out.println("gondoltam egy számra, tippelj!");
        Random rnd = new Random();
        int num = rnd.nextInt(101);
//        System.out.println(num);
        int guess = 0;
        boolean kitalalva = false;
        Scanner sc = new Scanner(System.in);
        while (!kitalalva)  {
            guess = sc.nextInt();
            if (num == guess) {
                System.out.println("Gratulálok!!");
                kitalalva = true;
            } else {
                System.out.println(num < guess ? "Kisebbre gondoltam" : "Nagyobbra gondoltam");
            }
        }

    }
}
