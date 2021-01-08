package week10.d05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void findMinMaxSum(int[] numbers) {
        List<Integer> intList = new ArrayList<>();
        for (Integer i : numbers) {
            intList.add(i);
        }
        intList.sort(Comparator.naturalOrder());

        System.out.println(getMinSum(intList));
        System.out.println(getMaxSum(intList));
    }

    private static int getMaxSum(List<Integer> intList) {
        int sum=0;
        for (int i = intList.size() - 1; i > intList.size() - 5; i--) {
            sum += intList.get(i);
        }
        return sum;
    }

    private static int getMinSum(List<Integer> intList) {
        int sum =0;
        for (int i = 0; i < 4; i++) {
            sum += intList.get(i);
        }
        return sum;
    }


    public static void main(String[] args) {
        List<Integer> receiveNumbers = new ArrayList<>();
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
