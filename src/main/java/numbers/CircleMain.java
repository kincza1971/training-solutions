package numbers;

import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Átmérő?");
        Circle c1 = new Circle(Double.parseDouble(sc.nextLine()));
        System.out.println("Átmérő?");
        Circle c2 = new Circle(Double.parseDouble(sc.nextLine()));
        System.out.println("Első (kerület); (terület)" + "(" + c1.perimeter() + "; " + "(" + c1.area() + ")");
        System.out.println("Első (kerület); (terület)" + "(" + c2.perimeter() + "; " + "(" + c2.area() + ")");
    }
}
