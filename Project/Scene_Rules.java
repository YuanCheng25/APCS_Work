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
   // private PImage Avatar;
    private PImage normal;
  // private SoundFile music2;
   
    String text = "All 3 players must choose a number from 0-100. The average is multiplied by 0.8; the winner is the person with the number closest to the average*0.8. Everyone starts at 0 points; each round, the winners get no points and the losers lose 1 point. When someone reaches -2 points, they are eliminated. Players 1 and 2 must eliminate the King to win the game.";
   
    int n = 0;
   
    public Scene_Rules(PApplet p)
    {
        this.p = p;
    //    RulesboardImage = p.loadImage("K.png");
        cardImage = p.loadImage("normal2.png");  
        customFont = p.createFont("slkscr.ttf", 45); 
    //    Avatar = p.loadImage("bunny.png");
        normal=p.loadImage("arcade2.png");
      //   music2 = new SoundFile(p, "typing.mp3");
            // ChishiyaGif = new Gif(p, "ChishiyaBetter.gif");
    }

    public void display()
    {
      //  p.image(RulesboardImage, 0, 0, p.width, p.height);
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
        p.image(cardImage, p.width/2-(cardImage.width/2), p.height-cardImage.height-180, cardImage.width, cardImage.height); 

        p.textFont(customFont);
        p.textAlign(PApplet.CENTER); 

       /* float textX = p.width / 2 + 50; 
        float textY = p.height / 3; */
        
        
        float textX = cardX + cardWidth; 
        float textY = cardY; // Move text closer to the card
         p.fill(225,9,9, cardAlpha);
         p.textSize(40);
        p.text("Inspired by 'Alice in Borderland' S2:E6", textX+200, textY+150);
        p.fill(255,cardAlpha);
        p.textSize(30);
        p.text("Music: 'Waltz No. 3 in A Minor, Op. 34 No. 2' by Frederic Chopin", textX+200, textY + 230);
        p.text("Coded by Sally Cheng", textX+200, textY + 310);

        p.noTint();
        
        if (fadingOut == false && visible == false && fadingIn == false)
        {   
            p.tint(255, 255);
            
            p.image(normal,0,0, p.width, p.height);
            
    /*     float avatarWidth = p.width / 1.2f; // Increase the width to make the image larger
        float avatarHeight = avatarWidth * (Avatar.height / (float) Avatar.width); // Maintain aspect ratio
          float avatarX = p.width - avatarWidth - 30; // Move further into lower-right
            float avatarY = p.height - avatarHeight - 30; // Move further into lower-right
            p.image(Avatar, avatarX+430, avatarY+100, avatarWidth, avatarHeight);*/
      //  p.image(Avatar, p.width - lowerRightImageWidth, p.height - lowerRightImageHeight, lowerRightImageWidth, lowerRightImageHeight);
            // p.image(ChishiyaGif, 670, 50, p.width / 2, p.height + 100);
            // ChishiyaGif.loop();
            
       
          
            p.fill(255);  
            p.textFont(customFont);
            p.textSize(35);
            
            
      //   p.text("How to Play: Everyone must choose a number from 0-100. The average is taken and multiplied by 0.8; the winner is the person with the number closest to the average*0.8. Everyone starts at 0 points; each round, the winners get no points and the losers lose 1 point. When someone reaches -2 points, they are eliminated. The last person left is the winner.", 190, 140, textX+200, textY + 400);

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