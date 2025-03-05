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
    private PFont customFont;
        
    public Scene_Start(PApplet p)
    {
        this.p = p;
        bX=p.width/2-bWidth/2;
        bY=p.height/2-bHeight/2;
        p.fill(0);
      backgroundGif=new Gif(p,"bg10.gif");
      backgroundGif.loop();
    customFont = p.createFont("slkscr.ttf", 60); 

    }

    public void display()
    {

/*float gifAspectRatio = (float) backgroundGif.width / backgroundGif.height;
    float screenAspectRatio = (float) p.width / p.height;

    float scale;
    float offsetX = 0, offsetY = 0;

    if (gifAspectRatio > screenAspectRatio) {
        scale = (float) p.height / backgroundGif.height;
        offsetX = (p.width - backgroundGif.width * scale) / 2;
    } else {
        scale = (float) p.width / backgroundGif.width;
        offsetY = (p.height - backgroundGif.height * scale) / 2;
    }*/

   // p.image(backgroundGif, offsetX, offsetY, backgroundGif.width * scale, backgroundGif.height * scale);
  p.image(backgroundGif, (p.width - backgroundGif.width) / 2, 0, backgroundGif.width, backgroundGif.height);

        // Draw the two thin rectangles on either side of the GIF
        p.fill(0); // White color for the rectangles
        float rectWidth = 10; // Very thin width for the rectangles
        float rectHeight = backgroundGif.height; // Same height as the GIF

        // Calculate the x-position of the GIF
        float gifX = (p.width - backgroundGif.width) / 2;

        // Left rectangle (slightly overlapping into the GIF)
        p.rect(gifX - rectWidth + 5, 0, rectWidth, rectHeight);

        // Right rectangle (slightly overlapping into the GIF)
        p.rect(gifX + backgroundGif.width - 5, 0, rectWidth, rectHeight);

//p.image(backgroundGif, (p.width-backgroundGif.width)/2,0,backgroundGif.width,backgroundGif.height);
        
p.fill(255);
p.textFont(customFont);
p.textSize(60);
p.textAlign(PApplet.CENTER);
p.text("The Average Game", p.width/2,p.height-200);
p.textSize(30);
p.text("Press 'Enter' to Begin", p.width/2,p.height-300);
    }
    
    public void keyPressed() {
    }
    
}

