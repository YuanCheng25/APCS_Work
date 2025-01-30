
import java.util.ArrayList;

class AnimalCalculator {

    public static void printAnimals(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getName() + animal.getLegCount() + (animal.Furriness()));
        }
    }

    public static double averageLegCount(ArrayList<Animal> animals) {
        int totalLegs = 0;
        for (Animal animal : animals) {
            totalLegs += animal.getLegCount();
        }
        return (double) totalLegs / animals.size();
    }

    public static Animal fewestLegs(ArrayList<Animal> animals) {
        Animal minLegAnimal = animals.get(0);
        for (Animal animal : animals) {
            if (animal.getLegCount() < minLegAnimal.getLegCount()) {
                minLegAnimal = animal;
            }
        }
        return minLegAnimal;
    }

    public static void testAverageLegCount(ArrayList<Animal> animals, double expected) {
        double answer = AnimalCalculator.averageLegCount(animals);
        
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
        System.out.println("expected: " + expected + " answer: " + answer);
        
        if (expected == answer) {
            System.out.println("Yay");
        } else {
            System.out.println("No");
        }
    }

    public static void testFewestLegs(ArrayList<Animal> animals, String expected) {
        Animal answer = AnimalCalculator.fewestLegs(animals);
        
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
        System.out.println("expected: " + expected + " answer: " + answer.getName());
        
        if (expected.equals(answer.getName())) {
            System.out.println("Yay");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
         Human human = new Human("John", 2, true);
        Cat cat = new Cat("Whiskers", 4, false);
        Sponge sponge = new Sponge("Bob", 0, false);
        Centipede centipede = new Centipede("Centi", 100, true);


        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(human);
        animals.add(cat);
        animals.add(sponge);
        animals.add(centipede);

        testAverageLegCount(animals, (2 + 4 + 0 + 100) / 4.0);
        
        testFewestLegs(animals, "Bob");
    }
}