package br.com.tous.factory;

public class Customer {

    private String carName;
    private String model;

    public Customer(String carName, String model) {
        this.carName = carName;
        this.model   = model;
    }
    public String getCarName() {
        return carName;
    }
    public String getModel() {
        return model;
    }
}
