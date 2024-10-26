public class Rectangle {
    public Rectangle(double baseIn, double heightIn) {
        base = baseIn;        
        height = heightIn;
    }

    public double Base() {
        return base;
    }

    public double Height() {
        return height;
    }

    public double Area() {
        return base * height;
    }

    public double Perimeter() {
        return 2 * (base + height);
    }

    public double Diagonal() {
        return Math.sqrt(base * base + height * height);
    }
    
private double base;
private double height;

}