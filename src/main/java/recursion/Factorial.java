package recursion;

public class Factorial {

    public long calcFactorial(int n) {
        long result;
        if (n == 1) {
            return 1;
        }
        return n * calcFactorial(n-1);
    }

    public long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(f.calcFactorial(5));
        System.out.println(f.fibonacci(20));
    }
}
