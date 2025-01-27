import processing.core.*;


public class Scene_Start implements Scene
{
    private PApplet p;
    private float bWidth=170;
    private float bHeight=50;
    private float bX;  
    private float bY;
    private PImage backgroundImage;
    private PFont customFont;
        
    public Scene_Start(PApplet p)
    {
        this.p = p;
        bX=p.width/2-bWidth/2;
        bY=p.height/2-bHeight/2;
        backgroundImage = p.loadImage("aib.jpg");
        
        customFont = p.createFont("slkscr.ttf", 32); 
    }

    public void display()
    {
        p.image(backgroundImage, 0, 0, p.width, p.height);
        
        p.fill(41,61,61);
        p.rect(bX, bY, bWidth, bHeight);
        
        p.textFont(customFont);

        p.fill(255,255,255);
        p.textAlign(PApplet.CENTER);
        p.textSize(85);
        p.text("The Average Game", p.width/2, p.height/3);
        p.textSize(32);
        p.text("Start", p.width/2, p.height/2+bHeight/4);
    }
    
}