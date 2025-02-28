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
        
    public Scene_Start(PApplet p)
    {
        this.p = p;
        bX=p.width/2-bWidth/2;
        bY=p.height/2-bHeight/2;
      backgroundGif=new Gif(p,"avg3.gif");
      backgroundGif.loop();
    }

    public void display()
    {
   p.smooth();
   float gifAspectRatio = (float) backgroundGif.width / backgroundGif.height;
    float screenAspectRatio = (float) p.width / p.height;

    float scale;
    float offsetX = 0, offsetY = 0;

    if (gifAspectRatio > screenAspectRatio) {
        scale = (float) p.height / backgroundGif.height;
        offsetX = (p.width - backgroundGif.width * scale) / 2;
    } else {
        scale = (float) p.width / backgroundGif.width;
        offsetY = (p.height - backgroundGif.height * scale) / 2;
    }

    p.image(backgroundGif, offsetX, offsetY, backgroundGif.width * scale, backgroundGif.height * scale);
        
    }
    
    public void keyPressed() {
    }
    
}

