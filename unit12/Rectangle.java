public class Rectangle {
    private String name;
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getArea() {
        return width * height;
    }

public static double averagePerimeter(Rectangle[][] rectangles) {
    double totalPerimeter = 0;
    int count = 0;

    for (int i = 0; i < rectangles.length; i++) {
        for (int j = 0; j < rectangles[i].length; j++) {
            totalPerimeter += rectangles[i][j].getPerimeter();
            count++;
        }
    }

    return totalPerimeter/count; 
}

    public static Rectangle largestArea(Rectangle[][] rectangles) {
    Rectangle maxRectangle = rectangles[0][0]; 

    for (int i = 0; i < rectangles.length; i++) {
        for (int j = 0; j < rectangles[i].length; j++) {
            if (rectangles[i][j].getArea() > maxRectangle.getArea()) {
                maxRectangle = rectangles[i][j];
            }
        }
    }
    return maxRectangle;
}
  }