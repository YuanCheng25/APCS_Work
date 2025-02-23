import processing.core.*;
import gifAnimation.*;


public class Scene_Start implements Scene
{
    private PApplet p;
    private float bWidth=170;
    private float bHeight=50;
    private float bX;  
    private float bY;
     private Gif backgroundGif; 
    private PImage buttonImage;
    private PFont customFont;
        
    public Scene_Start(PApplet p)
    {
        this.p = p;
        bX=p.width/2-bWidth/2;
        bY=p.height/2-bHeight/2;
      backgroundGif=new Gif(p,"bg.gif");
      backgroundGif.loop();
        buttonImage=p.loadImage("button.png");
        
        customFont = p.createFont("slkscr.ttf", 32); 
    }

    public void display()
    {
        p.image(backgroundGif, 0, 0, p.width, p.height);
        p.image(buttonImage, bX, bY, bWidth, bHeight);
        
        p.fill(41,61,61);
        
        p.textFont(customFont);

        p.fill(255,255,255);
        p.textAlign(PApplet.CENTER);
        p.textSize(85);
        p.text("The Average Game", p.width/2, p.height/3);
    }
    
    public void keyPressed() {
        // This scene doesn't need special key handling, but we must implement the method
    }
    
}