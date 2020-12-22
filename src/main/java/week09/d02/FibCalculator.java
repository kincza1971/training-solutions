package week09.d02;

public class FibCalculator {

    public double sumEvens(int bound) {
        int beforePrevious= 0;
        int previous =1;
        int number=0;
        double sum = 0;
        while (true) {
            number=beforePrevious + previous;
            beforePrevious=previous;;
            previous = number;

            if (number > bound) {
                return sum;
            }

            if (number % 2 == 0) {
                sum += number;
            }
        }
    }
}
