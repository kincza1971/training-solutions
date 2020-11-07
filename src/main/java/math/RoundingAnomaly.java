package math;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Math.round;
import static java.lang.Math.pow;

public class RoundingAnomaly {

    static double roundAfterSum(double[] numbers) {
        double total = 0.0;
        for (double number:numbers) {
            total = total + number;
        }
        return round(total);
    }

    static double sumAfterRound(double[] numbers) {
        double total = 0.0;
        for (double number:numbers) {
            total = total + round(number);
        }
        return total;
    }

    static double difference(int size, double max, int scale) {
        double[] numbers = randomNumbers(size, max, scale);
        double a = roundAfterSum(numbers);
        double b = sumAfterRound(numbers);
        return a-b;
    }

    static double[] randomNumbers(int size, double max, int scale) {
        double[] numbers = new double[size];
        Random randomNumber = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = round((randomNumber.nextFloat()*max) * pow(10.0,scale))/pow(10.0,scale);
        }
        return numbers;
    }


    public static void main(String[] args) {
        RoundingAnomaly roundingAnomaly = new RoundingAnomaly();
        double[] doubles = randomNumbers(1000,1000000,5);


        System.out.println();
        System.out.printf("%5.0f%n",roundAfterSum(doubles));
        System.out.printf("%5.0f%n",sumAfterRound(doubles));

        double average = 0.0;
        for (int i =0; i<100;i++) {
            average += difference(1000,1000000,5);
            System.out.println(average/(i+1));
        }
        average = average/100;
        System.out.println("Átlagos eltérés: " + average);
    }
}
