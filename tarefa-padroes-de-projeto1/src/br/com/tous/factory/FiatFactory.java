package br.com.tous.factory;

public class FiatFactory extends Factory  {
    @Override
    Car retrieveCar(String requestedCar) {
        if ("Mobi".equals(requestedCar)) {
            return new Mobi(120, 0.7, "geracao 1");
        } else {
            return null;
        }
    }
}
