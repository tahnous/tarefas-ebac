import br.com.tous.factory.AudiFactory;
import br.com.tous.factory.Customer;
import br.com.tous.factory.Factory;
import br.com.tous.factory.FiatFactory;
import br.com.tous.factory.Car;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer client = new Customer("A3", "AUDI");
        Factory factory = getCarFactory(client);
        Car car = factory.create(client.getCarName());
        car.info();
}
    private static Factory getCarFactory(Customer client) {
        if (client.getModel().contains("AUDI")) {
            return new AudiFactory();
        }
        else if(client.getModel().contains("FIAT")) {
            return new FiatFactory();

        }
        return null;
    }
}