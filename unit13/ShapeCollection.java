import java.util.ArrayList;

class ShapeCollection {
    private ArrayList<Shape> shapes;
    
    public ShapeCollection() {
        shapes = new ArrayList<>();
    }
    
    // Add a shape to the collection
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    
    public int numberOfSides(String shapeName) {
        for (Shape shape : shapes) {
            if (shape.getName().equals(shapeName)) {
                return shape.getNumSides();
            }
        }
        return -1; // Shape not found
    }
    
    // Return average number of sides
    public double averageNumberOfSides() {
        if (shapes.isEmpty()) return 0;
        
        int total = 0;
        for (Shape shape : shapes) {
            total += shape.getNumSides();
        }
        return (double) total / shapes.size();
    }
    
    // Return shapes with even number of sides
    public ArrayList<Shape> getEvenSidedShapes() {
        ArrayList<Shape> evenShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.getNumSides() % 2 == 0) {
                evenShapes.add(shape);
            }
        }
        return evenShapes;
    }
}