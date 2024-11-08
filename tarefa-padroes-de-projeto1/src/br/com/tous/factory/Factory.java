package br.com.tous.factory;

public abstract class Factory {
    public Car create(String requestedCar) {
        Car car = retrieveCar(requestedCar);
        return car;
    }
    abstract Car retrieveCar(String requestedCar);
}
