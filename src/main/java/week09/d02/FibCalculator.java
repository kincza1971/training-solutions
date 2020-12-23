package week09.d02;

public class FibCalculator {

    public long sumEvens(int bound) {
        int beforePrevious= 0;
        int previous =1;
        int number=0;
        long sum = 0;
        while (sum < bound) {
            if (number % 2 == 0) {
                sum += number;
            }
            number=beforePrevious + previous;
            beforePrevious=previous;
            previous = number;

        }
        return sum;
    }
}
