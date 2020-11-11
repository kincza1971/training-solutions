package numbers;

import static java.lang.Math.pow;

public class Circle {
    public static float PI = 3.14f;
    private double diameter;

    public Circle(double diameter) {
        this.diameter = diameter;
    }

    public double perimeter() {
        return PI * diameter;
    }
    public double area(){
        return PI* pow(diameter,2.0)/4;
    }
}
