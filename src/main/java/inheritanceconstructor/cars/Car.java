package inheritanceconstructor.cars;

public class Car {

    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public void modifyFuelAmount(double fuel) {
        this.fuel += fuel;
    }

    public void drive(int km) {
        double reqFuel = fuelRate*km/100;
        if (reqFuel > fuel) {
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        fuel -= reqFuel;
    }

    public double calculateRefillAmount() {
        return tankCapacity -fuel;
    }

    public double getFuel() {
        return fuel;
    }

    private void checkData(double fuelRate, double fuel, double tankCapacity){
        if (fuelRate <=0 || fuel<0  || tankCapacity <= 0) {
            throw new IllegalArgumentException("Hibás adatok (" + fuelRate + ", " + fuel + ", " + tankCapacity + ")");
        }
        if (fuel > tankCapacity) {
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
    }

    public Car(double fuelRate, double fuel, double tankCapacity) {
        checkData(fuelRate,fuel,tankCapacity);
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

}
