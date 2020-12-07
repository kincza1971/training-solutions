package week07.d01;

public class Fibonacci {

//    Készíts egy osztályt a week07d01 csomagba Fibonacci néven. Legyen benne egy fib metódus, ami egy `int n` paramétert vár.
//    A visszatérési értékünk legyen egy long szám, ami az n-edik fibonacci számot tartalmazza.
//    (A fibonacci szám az az az előző kettő fibonacci szám összege és az első két szám az `1, 1`.
//    Bónusz feladat: implementáljuk az algoritmust ciklus nélkül és mentsük el a részeredményeket egy statikus változóba.

    public int fibonacci(int n) {

        int beforePrevious= 0;
        int previous =1;
        int number=0;

        for (int i = 1; i < n; i++) {
            number=beforePrevious + previous;
            beforePrevious=previous;;
            previous = number;
        }
        return number;
    }

//    public static void main(String[] args) {
//        Fibonacci f = new Fibonacci();
//        int n = f.fibonacci(6);
//        System.out.println(n);
//    }
}
