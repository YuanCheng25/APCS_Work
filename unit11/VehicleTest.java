import java.util.ArrayList;

public class VehicleTest {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Motorcycle());
        vehicles.add(new Bicycle());
        vehicles.add(new Unicycle());

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle: " + v.name() + ", Wheels: " + v.wheelCount() + ", Human Powered: " + v.isHumanPowered());
        }
    }
}