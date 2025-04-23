import java.util.ArrayList;

class Shape {
    private String name;
    private int numSides;
    
    public Shape(String name, int numSides) {
        this.name = name;
        this.numSides = numSides;
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumSides() {
        return numSides;
    }
}

