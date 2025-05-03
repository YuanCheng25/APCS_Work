import processing.core.*;
import gifAnimation.*;



public class Scene_Ending implements Scene
{
    private PApplet p;
    private float bWidth=170;
    private float bHeight=50;
    private float bX;  
    private float bY;
    private Gif backgroundGif1; 
    private PFont customFont;
        private String input = "";
    private int value = 0;
        
    public Scene_Ending(PApplet p)
    {
        this.p = p;
        bX=p.width/2-bWidth/2;
        bY=p.height/2-bHeight/2;
        p.fill(0);
      backgroundGif1=new Gif(p,"maybe.gif");
      backgroundGif1.loop();
    customFont = p.createFont("slkscr.ttf", 60); 

    }

    public void display()
    {
  p.image(backgroundGif1, (p.width - backgroundGif1.width) / 2, 0, backgroundGif1.width, backgroundGif1.height);
        
p.textFont(customFont);
p.textSize(40);
p.textAlign(PApplet.CENTER);
p.fill(225,0,0);
p.text("Congrats on winning,", p.width/2, p.height/2+300);
p.text("and thank you for playing my game.", p.width/2, p.height/2+400);
    }
    
    public void keyPressed() {
    }
    
}

