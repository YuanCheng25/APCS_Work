import processing.core.*;


public class Scene_Play implements Scene
{
  //  private PImage RulesboardImage;
 //   private PImage cardImage;
    private float cardAlpha = 0; 
    private int startTime; 
    private boolean fadingIn = true; 
    private boolean visible = false; 
    private boolean fadingOut = false; 
    private PFont customFont;
   
   String text="Player 1, enter your number.";
   
   int n=0;
   
    public Scene_Rules(PApplet p)
    {
        this.p = p;
        RulesboardImage = p.loadImage("rulesboard.jpg");
        cardImage = p.loadImage("card.png");        
        customFont = p.createFont("slkscr.ttf", 32); 
        
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
        p.textSize(90);
        p.text("Round 1", p.width/2, p.height/3+100);        
        
        if(fadingOut==false && visible==false && fadingIn==false)
        {
        p.fill(255);  
        p.textFont(customFont);
        p.textSize(30);
        String sub=text.substring(0,n);
        p.textAlign(PApplet.CENTER);
        p.text(sub, 262, 140, p.width/2, p.height+100);
        if(p.frameCount%30==0);
        n++;
        }
        
        p.noTint();
        }
        
        private PApplet p;
    }


