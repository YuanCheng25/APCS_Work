public class testBoth {
    public static void main(String[] args) {
        ShapeCollection shapes = new ShapeCollection();
        shapes.addShape(new Shape("Triangle", 3));
        shapes.addShape(new Shape("Square", 4));
        shapes.addShape(new Shape("Pentagon", 5));
        
        System.out.println("Square sides: " + shapes.numberOfSides("Square"));
        System.out.println("Average sides: " + shapes.averageNumberOfSides());
        System.out.println("Even-sided shapes: " + shapes.getEvenSidedShapes().size());
        
    }
}