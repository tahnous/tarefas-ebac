import generics.A3;
import generics.A5;
import generics.Car;
import generics.Mobi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Mobi(120, 0.7, "geracao 1"));
        cars.add(new A5(100, 1.5,"Primeira geração"));
        cars.add(new A3(100, 1.7,"Segunda geração"));

        Iterator<Car> it = cars.iterator();
        while(it.hasNext()) {
            Car car = it.next();
            car.info();
        }

    }
}