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
    private PImage Avatar;
    private PImage normal;
   
    String text = "How to Play: Everyone must choose a number from 0-100. The average is taken and multiplied by 0.8; the winner is the person with the number closest to the average*0.8. Everyone starts at 0 points; each round, the winners get no points and the losers lose 1 point. When someone reaches -2 points, they are eliminated. The last person left is the winner.";
   
    int n = 0;
   
    public Scene_Rules(PApplet p)
    {
        this.p = p;
        RulesboardImage = p.loadImage("K.png");
      //  cardImage = p.loadImage("card4.png");  
      cardImage = p.loadImage("card4.png");  
        customFont = p.createFont("Miller Text Regular.otf", 45); 
        Avatar = p.loadImage("bunny.png");
        normal=p.loadImage("bg4.png");
        
            // ChishiyaGif = new Gif(p, "ChishiyaBetter.gif");
    }

    public void display()
    {
        p.image(RulesboardImage, 0, 0, p.width, p.height);
        
        float fadeSpeed = 0.1f;
        
        if (fadingIn) {
            cardAlpha += 30; 
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
            cardAlpha -= 30;  
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
        p.image(cardImage, cardX, cardY, cardWidth, cardHeight); 

        // Draw the text with the same alpha
        p.fill(0, cardAlpha); // Apply alpha to the text
        p.textFont(customFont);
        p.textSize(30);
        p.textAlign(PApplet.LEFT, PApplet.CENTER); 

       /* float textX = p.width / 2 + 50; 
        float textY = p.height / 3; */
        
        
        float textX = cardX + cardWidth + 100; 
        float textY = cardY + 20; // Move text closer to the card
      //  p.text("Game by Sally Cheng", textX, textY);
    //    p.text("Music: ChessType", textX, textY + 60);
      //  p.text("Beat by joyful", textX, textY + 120);
        p.text("Game by Sally Cheng", textX+100, textY+180);
        p.text("Music: ChessType Beat by joyful", textX+100, textY + 240);
        p.text("Art by John Tenniel", textX+100, textY + 300);

        // Reset tint for other elements
        p.noTint();
        
        // Display the main text after the card and title have faded out
        if (fadingOut == false && visible == false && fadingIn == false)
        {   
            p.tint(255, 255);
            
            p.image(normal,0,0, p.width, p.height);
            
         float avatarWidth = p.width / 1.2f; // Increase the width to make the image larger
        float avatarHeight = avatarWidth * (Avatar.height / (float) Avatar.width); // Maintain aspect ratio
          float avatarX = p.width - avatarWidth - 30; // Move further into lower-right
            float avatarY = p.height - avatarHeight - 30; // Move further into lower-right
            p.image(Avatar, avatarX+430, avatarY+100, avatarWidth, avatarHeight);
      //  p.image(Avatar, p.width - lowerRightImageWidth, p.height - lowerRightImageHeight, lowerRightImageWidth, lowerRightImageHeight);
            // p.image(ChishiyaGif, 670, 50, p.width / 2, p.height + 100);
            // ChishiyaGif.loop();
            
       
          
            

            p.fill(0);  
            p.textFont(customFont);
            p.textSize(40);
            
            
        
            if (n > text.length()) 
                n = text.length();
        
            String sub = text.substring(0, n);
            p.textAlign(PApplet.LEFT, PApplet.CENTER);
           // p.text(sub, 190, 140, p.width / 2 + 80, p.height + 50);
           p.text(sub, 190, 140, textX+200, textY + 400);
            
           if (p.frameCount % 0.0000000001 == 0)
                n++;
        }
    }
        
    public void keyPressed() {
    }
        
    private PApplet p;
}