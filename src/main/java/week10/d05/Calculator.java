package week10.d05;

import java.util.*;

public class Calculator {

    public static void findMinMaxSum(int[] numbers) {
        Arrays.sort(numbers);
        System.out.println(getMinSum(numbers));
        System.out.println(getMaxSum(numbers));
    }

    private static int getMaxSum(int[] numbers) {
        int sum=0;
        for (int i = numbers.length - 1; i > numbers.length - 5; i--) {
            sum += numbers[i];
        }
        return sum;
    }

    private static int getMinSum(int[] numbers) {
        int sum =0;
        for (int i = 0; i < 4; i++) {
            sum += numbers[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int db;

        System.out.println("Hány darab szám lesz?");
        db = scanner.nextInt();
        scanner.nextLine();

        if (db<4) {
            throw new IllegalArgumentException("A darabszám 4, vagy több lehet");
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
