import processing.core.*;
import java.util.*;   


public class Bounce extends PApplet
{
    public void settings()
    {
        size(400, 400);
    }

    public void setup()
    {
        triangles = new ArrayList<Triangle>();
        triangles.add(new Triangle(this));
    }

    public void draw()
    {
        background(0);
        for (Triangle t : triangles)
            t.display();
    }

    public void keyPressed()
    {
        for (int i=0; i<10; i++)
            triangles.add(new Triangle(this));        
    }

    private ArrayList<Triangle> triangles;

    public static void main(String[] args)
    {
        PApplet.main("Bounce");
    }
}

