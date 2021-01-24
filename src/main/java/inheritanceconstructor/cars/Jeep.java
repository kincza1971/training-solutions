package inheritanceconstructor.cars;

public class Jeep extends Car{

    private double extraCapacity;
    private double extraFuel;

    private void decFuel(double fuel) {
        if (fuel > extraFuel+getFuel()) {
            throw new IllegalArgumentException ("Not enough fuel!");
        }
        if (fuel>extraFuel) {
            extraFuel=0;
            modifyFuelAmount(fuel+extraFuel);
        }
        extraFuel += fuel;
    }

    private void incFuel(double fuel) {
        double refillAmount = calculateRefillAmount();
        if (fuel > refillAmount + extraCapacity) {
            throw new IllegalArgumentException("Not enough space for fuel");
        }
        if (fuel > refillAmount) {
            super.modifyFuelAmount(refillAmount);
            extraFuel = fuel-refillAmount;
        } else {
            super.modifyFuelAmount(fuel);
        }
    }

    public void modifyFuelAmount(double fuel) {
        if (fuel<0) {
            decFuel(fuel);
        } else {
            incFuel(fuel);
        }
        super.modifyFuelAmount(fuel);
    }
    public void drive(int km) {
        super.drive(km);
    }
    public double calculateRefillAmount() {
        return super.calculateRefillAmount();
    }

    public double getExtraCapacity() {
        return extraCapacity;
    }

    public double getExtraFuel() {
        return extraFuel;
    }

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel + extraFuel, tankCapacity + extraCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }
}
