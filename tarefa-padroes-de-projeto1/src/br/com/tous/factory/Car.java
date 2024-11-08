package br.com.tous.factory;

public abstract class Car {

    String model;
    double fuelTank;
    double fuelConsumption;

    public Car(double fuelTank, double fuelConsumption, String model) {
        this.fuelTank = fuelTank;
        this.fuelConsumption = fuelConsumption;
        this.model = model;
    }

    void supply(float l) {
        this.fuelTank += l;
    }

    void drive(int km) {
        fuelTank -= (km / this.fuelConsumption);
    }

 public void info() {
        System.out.println(getClass().getSimpleName());
    }
}
