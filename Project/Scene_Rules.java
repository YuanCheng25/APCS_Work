import processing.core.*;


public class Scene_Rules implements Scene
{
    private PImage RulesboardImage;
    private PImage cardImage;
    private float cardAlpha = 0; 
    private int startTime; 
    private boolean fadingIn = true; 
    private boolean visible = false; 
    private boolean fadingOut = false; 
    private PFont customFont;
   
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
        p.textSize(50);
        p.text("Difficulty:", p.width/2+190, p.height/3);
        p.text("King of", p.width/2+180, p.height/3+100);
        p.text("Diamonds", p.width/2+190, p.height/3+200);
        
        
        if(fadingOut==false && visible==false && fadingIn==false)
        {
        p.fill(255);  
        p.textFont(customFont);
        p.textSize(30);
        p.text("How to Play:", p.width/2, p.height/4);
        p.text("Everyone must choose a number from 0-100;", p.width/2, p.height/4+30);
        p.text("the average is taken and multiplied by 0.8;", p.width/2, p.height/4+60);   
        p.text("the winner is the person with the number.", p.width/2, p.height/4+90);
        p.text("closest to the average*0.8.", p.width/2, p.height/4+120);
        p.text("Everyone starts at 0 points.", p.width/2, p.height/4+150);
        p.text("Winners +0 points and losers -1 point.", p.width/2, p.height/4+180);
        p.text("Reach -3 points and you will be eliminated.", p.width/2, p.height/4+210);
        p.text("The last person left is the winner.", p.width/2, p.height/4+240);
        }
        
        p.noTint();
        }
        
        private PApplet p;
    }


