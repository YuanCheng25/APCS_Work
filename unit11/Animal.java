/*class Animal {
    private String name;
    private int legCount;
    private boolean furry;

    public Animal(String name, int legCount, boolean furry) {
        this.name = name;
        this.legCount = legCount;
        this.furry = furry;
    }

    public String getName() {
        return name;
    }

    public int getLegCount() {
        return legCount;
    }

    public boolean isFurry() {
        return furry;
    }
}*/

public class Animal {
    // Private member variables
    private String name;
    private int legCount;
    private boolean furry;

    // Constructor to set member variables
    public Animal(String name, int legCount, boolean furry) {
        this.name = name;
        this.legCount = legCount;
        this.furry = furry;
    }

    // Accessor functions
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegCount() {
        return legCount;
    }

    public void setLegCount(int legCount) {
        this.legCount = legCount;
    }

    public boolean Furriness() {
     if (furry) {
            return true;  
        } else {
            return false; 
        }
    }


    public void setFurriness(boolean furry) {
        this.furry = furry;
    }
}