package finalmodifier;

public class PiMain {

    public static void main(String[] args) {
        CircleCalculator calculator = new CircleCalculator();
        System.out.println(calculator.calculateArea(10));
        System.out.println(calculator.calculatePerimeter(10));
        System.out.println(calculator.PI);

    }
}
