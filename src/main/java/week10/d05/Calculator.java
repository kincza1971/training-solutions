package week10.d05;

import java.util.*;

public class Calculator {

    public static final int NUMBER_OF_NUMBERS_TO_ADD = 4;

    public static void findMinMaxSum(int[] numbers) {
        Arrays.sort(numbers);
        int sumMin=0;
        int sumMax=0;
        for (int i = 0; i < NUMBER_OF_NUMBERS_TO_ADD; i++) {
            sumMin += numbers[i];
            sumMax += numbers[numbers.length-1-i];
        }
        System.out.printf("Legkisebbek összege: %d %nLegnagyobbak összege: %d", sumMin, sumMax);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int db;

        System.out.println("Hány darab szám lesz?");
        db = scanner.nextInt();
        scanner.nextLine();

        if (db<NUMBER_OF_NUMBERS_TO_ADD) {
            throw new IllegalArgumentException(String.format("A darabszám %d, vagy több lehet", NUMBER_OF_NUMBERS_TO_ADD));
        }
        int[] recNums = new int[db];
        for (int i =0; i<db; i++) {
            System.out.println("Kérem a számot:");
            recNums[i] =scanner.nextInt();
        }
        scanner.nextLine();

        findMinMaxSum(recNums);
    }
}
