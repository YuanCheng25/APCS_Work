import processing.core.*;

public class Triangle 
{
    public Triangle(PApplet p) 
    {
        this.p = p;
        position = new PVector(200, 200);
        velocity = new PVector(p.random(-3, 3), p.random(-3, 3));
        size = p.random(10, 30);  
        c = p.color(p.random(256), p.random(256), p.random(256));
    }

    public void display() 
    {
        p.fill(c);
        p.triangle(
            position.x,           position.y - size,      
            position.x - size,    position.y + size,      
            position.x + size,    position.y + size       
        );

        position.add(velocity);

        if (position.x < size || position.x > p.width - size) 
            velocity.x *= -1;

        if (position.y < size || position.y > p.height - size) 
            velocity.y *= -1;
    }

    private PApplet p;
    private PVector position;
    private PVector velocity;
    private float size;  
    private int c;
}