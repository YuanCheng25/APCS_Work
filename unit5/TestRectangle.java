public class TestRectangle {
    public static void main(String[] args) {
        Rectangle c = new Rectangle(3, 6);

        System.out.println("Base: " + c.Base());
        System.out.println("Height: " + c.Height());
        System.out.println("Area: " + c.Area());
        System.out.println("Perimeter: " + c.Perimeter());
        System.out.println("Diagonal: " + c.Diagonal());
    }
}