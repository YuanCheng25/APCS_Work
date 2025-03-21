import processing.core.*;
import java.util.ArrayList;
import gifAnimation.*;

public class Scene_Play2 implements Scene {
    private PApplet p;
    private ArrayList<Player> players;
    private int round;
    private Game game;
    private int currentPlayerIndex = 0;
    private ArrayList<Winner> winners;
    private boolean winnerCalculated = false;
    private float cardAlpha2 = 0; 
    private int startTime2; 
    private boolean fadingIn2 = true; 
    private boolean visible2 = false; 
    private boolean fadingOut2 = false; 
    private Gif round1Gif; 
    private Gif round2Gif;
    private PImage roundImage;
    private String input;
    
String text2=". . .";
    int n=0;
    
    public Scene_Play2(PApplet p, ArrayList<Player> players, Game game) {
        this.p = p;
        this.game = (Game) p;
        this.players = players;
        this.round = 1;
        
      round1Gif=new Gif(p,"card.gif");
      round1Gif.loop();
       round2Gif=new Gif(p,"gum.gif");
        round2Gif.loop();
    }

    public void resetFadeEffect() {
        cardAlpha2 = 0; 
        fadingIn2 = true; 
        visible2 = false;
        fadingOut2 = false; 
        n=0;
    }
    
    private Gif getCurrentRoundGif() {
    if (round%2 == 0) {
        return round2Gif;
    } else 
        return round1Gif; 
    }
    
    public double calculateAverageAndTarget() {
        int total = 0;
        for (Player player : players) {
            total += player.getValue();
        }
        return (total / (double) players.size()) * 0.8; // Ensure floating-point division
    }

    public static ArrayList<Winner> calculateWinner(ArrayList<Player> players, double target) {
        ArrayList<Winner> winners = new ArrayList<>();
        double closestDiff = Double.MAX_VALUE;

        // Find the closest difference to the target
        for (Player player : players) {
            double diff = Math.abs(player.getValue() - target);
            if (diff < closestDiff) {
                closestDiff = diff;
            }
        }

        for (Player player : players) {
            double diff = Math.abs(player.getValue() - target);
            if (diff == closestDiff) {
                winners.add(new Winner(player.getName()));
            }
        }

        for (Player player : players) {
            boolean isWinner = false;
            for (Winner winner : winners) {
                if (winner.getName().equals(player.getName())) {
                    isWinner = true;
                   break;
                }
            }
            if (isWinner) {
                player.setPoints(player.getPoints() + 0); 
            } else if (!player.hasLostPoint()) {
                player.setPoints(player.getPoints() - 1); 
                player.setHasLostPoint(true);
            }
        }

        return winners;
    }

    public void display() {
        p.background(0);
        
        float fadeSpeed = 0.1f;
        
        if (fadingIn2) {
            cardAlpha2 += 9; 
            if (cardAlpha2 >= 255) {
                cardAlpha2 = 255;  
                fadingIn2 = false;
                visible2 = true;  
                startTime2 = p.millis(); 
            }
        } else if (visible2) {
            if (p.millis() - startTime2 >= 2700) {
                visible2 = false;
                fadingOut2 = true;
            }
        } else if (fadingOut2) {
            cardAlpha2 -= 3;  
            if (cardAlpha2 <= 0) {
                cardAlpha2 = 0;  
                fadingOut2 = false;  
            }
        }

        // Apply the same alpha to both the card and the text
        p.tint(255, cardAlpha2);  
        p.fill(255, cardAlpha2);
        p.textSize(60);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text("Round " + round, p.width / 2, p.height/2+150);
        Gif currentGif = getCurrentRoundGif();
        p.image(currentGif, (p.width - currentGif.width) / 2, p.height/2-230, currentGif.width, currentGif.height);
        
        p.textSize(30);
        p.textAlign(PApplet.LEFT);
        p.fill(225,9,9, cardAlpha2);
        p.text("Loading", p.width/2-110, p.height/2+250);
       
        if (n > text2.length()) 
                n = text2.length();
        
            String sub2 = text2.substring(0, n);
        p.text(sub2, p.width / 2 + 30, p.height / 2 + 250);
        
        if (p.frameCount % 15 == 0) 
        n++;
    
        
        p.noTint();
        
       
        if (fadingOut2 == false && visible2 == false && fadingIn2 == false)
        {  
        p.textSize(35);
        p.fill(255);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text("Target (Average * 0.8): " + calculateAverageAndTarget(), p.width / 2, 150);

        // Display each player's input
        for (int i = 0; i < players.size(); i++) {
            p.text("Player " + (i + 1) + " Input: " + players.get(i).getValue(), p.width / 2, 200 + (i * 50));
        }
    
        ArrayList<Winner> winners = calculateWinner(players, calculateAverageAndTarget());

        StringBuilder winnerNames = new StringBuilder();
        for (Winner winner : winners) {
            winnerNames.append(winner.getName()).append(", ");
        }
        if (winnerNames.length() > 0) {
            winnerNames.setLength(winnerNames.length() - 2);
        }
        p.textSize(40);
        p.fill(225, 9, 9); 
        p.text("Winner(s): " + winnerNames.toString(), p.width / 2, 400);

        // Display each player's points
        p.fill(255);
        for (int i = 0; i < players.size(); i++) {
            p.text(players.get(i).getName() + "'s Total Points: " + players.get(i).getPoints(), p.width / 2, 450 + (i * 50));
        }
    }
    }
    
    public void endRound() {
  for (Player player : players) {
            player.setHasLostPoint(false);
        }
        calculateWinner(players, calculateAverageAndTarget());
        round++;
    }

    public void keyPressed() {
        if (p.key == PApplet.TAB) {
            endRound();
           for (Player player : players) {
                player.setInputComplete(false); 
                player.setInput("");
                player.setValue(0);
            }
       Scene_Play scenePlay = (Scene_Play) game.getScene(2); // Assuming Scene_Play is at index 2
            scenePlay.resetToPlayer1();
            resetFadeEffect();
           game.setCurrentScene(2);
        }
    }

    public int getPlayerIndex(Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) == player) {
                return i;
            }
        }
        return -1; // Return -1 if the player is not found
    }
}