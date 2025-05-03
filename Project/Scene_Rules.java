import processing.core.*;
import gifAnimation.*;
import processing.sound.*;

public class Scene_Rules implements Scene
{
    private PImage RulesboardImage;
    private PImage cardImage;
    private Gif ChishiyaGif; 
    private float cardAlpha = 0; 
    private int startTime; 
    private boolean fadingIn = true; 
    private boolean visible = false; 
    private boolean fadingOut = false; 
    private PFont customFont;
    private PImage normal;
   
    String text = "All 3 players must choose a number from 0-100. The average is multiplied by 0.8; the winner is the person with the number closest to the average*0.8. Everyone starts at 0 points; each round, the winners get no points and the losers lose 1 point. When someone reaches -3 points, they are eliminated. Check ending after two players are eliminated.";
   
    int n = 0;
   
    public Scene_Rules(PApplet p)
    {
        this.p = p;
        cardImage = p.loadImage("normal2.png");  
        customFont = p.createFont("slkscr.ttf", 45); 
        normal=p.loadImage("arcade2.png");
    }

    public void display()
    {
      p.fill(0);
        
        float fadeSpeed = 0.1f;
        
        if (fadingIn) {
            cardAlpha += 5; 
            if (cardAlpha >= 255) {
                cardAlpha = 255;  
                fadingIn = false;
                visible = true;  
                startTime = p.millis(); 
            }
        } else if (visible) {
            if (p.millis() - startTime >= 2700) {
                visible = false;
                fadingOut = true;
            }
        } else if (fadingOut) {
            cardAlpha -= 2;  
            if (cardAlpha <= 0) {
                cardAlpha = 0;  
                fadingOut = false;  
            }
        }

        // Apply the same alpha to both the card and the text
        p.tint(255, cardAlpha);  
        
        float cardWidth = p.width / 4; 
        float cardHeight = cardWidth * (356.0f / 244.0f); 
        float cardX = p.width / 10;
        float cardY = (p.height - cardHeight) / 2;
        p.image(cardImage, p.width/2-(cardImage.width/2), p.height-500, cardImage.width/1.2f, cardImage.height/1.2f); 

        p.textFont(customFont);
        p.textAlign(PApplet.CENTER); 
        
        
        float textX = cardX + cardWidth; 
        float textY = cardY; // Move text closer to the card
         p.fill(225,9,9, cardAlpha);
         p.textSize(40);
        p.text("Inspired by 'Alice in Borderland' S2:E6", textX+200, textY+80);
        p.fill(255,cardAlpha);
        p.textSize(30);
        p.text("Music: 'Waltz No. 3 in A Minor, Op. 34 No. 2' by Frederic Chopin", textX+200, textY + 160);
        p.text("Coded by Sally Cheng", textX+200, textY + 240);

        p.noTint();
        
        if (fadingOut == false && visible == false && fadingIn == false)
        {   
            p.tint(255, 255);
            
            p.image(normal,0,0, p.width, p.height);
       
          
            p.fill(255);  
            p.textFont(customFont);
            p.textSize(35);
            
            
         if (n > text.length()) 
                n = text.length();
        
            String sub = text.substring(0, n);
            p.textAlign(PApplet.LEFT);
           // p.text(sub, 190, 140, p.width / 2 + 80, p.height + 50);
           p.textLeading(45);
           p.text(sub, 70, 250, textX+200, textY + 400);
            
           if (p.frameCount % 0.0000001 == 0)
                n++;
        }
    }
        
    public void keyPressed() {
    }
        
    private PApplet p;
}