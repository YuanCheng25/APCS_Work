import processing.core.*;
import gifAnimation.*;

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
   
   String text="How to Play: Everyone must choose a number from 0-100. The average is taken and multiplied by 0.8; the winner is the person with the number closest to the average*0.8. Everyone starts at 0 points; each round, the winners get no points and the losers lose 1 point. When someone reaches -3 points, they are eliminated. The last person left is the winner.";
   
   int n=0;
   
    public Scene_Rules(PApplet p)
    {
        this.p = p;
        RulesboardImage = p.loadImage("rulesboard2.jpg");
        cardImage = p.loadImage("card.png");   
        customFont = p.createFont("slkscr.ttf", 32); 
        
    ChishiyaGif=new Gif(p,"ChishiyaBetter.gif");
        }

    public void display()
    {
        p.image(RulesboardImage, 0, 0, p.width, p.height);
        
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
            cardAlpha -= 5;  
           if (cardAlpha <= 0) {
                cardAlpha = 0;  
                fadingOut = false;  
            }
        }

        p.tint(255, cardAlpha);  
        p.image(cardImage, p.width/5, p.height/5, 244, 356); 
                 
        p.textFont(customFont);

        p.fill(255, cardAlpha);        
        p.textSize(50);
        p.text("Difficulty:", p.width/2+190, p.height/3);
        p.text("King of", p.width/2+180, p.height/3+100);
        p.text("Diamonds", p.width/2+190, p.height/3+200);
        
        
        if(fadingOut==false && visible==false && fadingIn==false)
        {   
        p.tint(255,255);
        p.image(ChishiyaGif,670, 50, p.width/2, p.height+100);
        ChishiyaGif.loop();

        p.fill(255);  
        p.textFont(customFont);
        p.textSize(30);
        
        if (n > text.length()) 
        n = text.length();
        
        String sub=text.substring(0,n);
        p.textAlign(PApplet.CENTER);
        p.text(sub, 190, 140, p.width/2+80, p.height+50);
        if(p.frameCount%30==0);
        n++;
                }
        
        p.noTint();
        }
        
        public void keyPressed() {
        // This scene doesn't need special key handling, but we must implement the method
    }
        
        private PApplet p;
    }


