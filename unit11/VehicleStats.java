import java.util.ArrayList;

public class VehicleStats {
    public static int totalWheels(ArrayList<Vehicle> vehicles) {
        int total = 0;
        for (Vehicle v : vehicles) {
            total += v.wheelCount();
        }
        return total;
    }


    public static ArrayList<Vehicle> humanPoweredVehicles(ArrayList<Vehicle> vehicles) {
        ArrayList<Vehicle> humanPowered = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.isHumanPowered()) {
                humanPowered.add(v);
            }
        }
        return humanPowered;
    }

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Motorcycle());
        vehicles.add(new Bicycle());
        vehicles.add(new Unicycle());

        System.out.println("Total Wheels: " + totalWheels(vehicles));

        ArrayList<Vehicle> humanPowered = humanPoweredVehicles(vehicles);
        System.out.println("Human Powered Vehicles:");
        for (Vehicle v : humanPowered) {
            System.out.println(v.name());
        }
    }
}