package methodstructure.bmi;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class BodyMass {
    private double weight;
    private double height;

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double bodyMassIndex() {
        return weight/pow(height,2);
    }

    public BmiCategory body() {
        double bmi = bodyMassIndex();
        if (bmi <25 && bmi > 18.5) {
            return BmiCategory.NORMAL;
        } else return bmi<=18.5 ? BmiCategory.UNDERWEIGHT:BmiCategory.OVERWEIGHT;
    }

    public boolean isThinnerThan(BodyMass bodyMass) {
        return  (this.bodyMassIndex() < bodyMass.bodyMassIndex());
    }

}
