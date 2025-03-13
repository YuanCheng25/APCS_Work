public class rectangleTest {
    public static void main(String[] args) {
        Rectangle[][] rectangles = {
            { new Rectangle("Rect1", 5.0, 6.0), new Rectangle("Rect2", 8.0, 8.0) },
            { new Rectangle("Rect3", 2.0, 8.0), new Rectangle("Rect4", 3.0, 10.0) }
        };

        System.out.println("Average Perimeter: " + averagePerimeter(rectangles));
        System.out.println("Rectangle with Largest Area: " + largestArea(rectangles));
    }
}
