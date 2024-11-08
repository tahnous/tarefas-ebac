package br.com.tous.factory;

public class AudiFactory extends Factory {
    @Override
    Car retrieveCar(String requestedCar) {
        if ("A5".equals(requestedCar)) {
            return new A5(100, 1.5,"Primeira geração");
        } else if ("A3".equals(requestedCar))  {
            return new A3(100, 1.7,"Segunda geração");
        }
        return null;
    }

}

