/*import processing.core.*;
import java.util.ArrayList;

public class Scene_Play2 implements Scene {
    private PApplet p;
    private ArrayList<Player> players;
    private int round;
    private double average;
    private double target;
    private Game game;
    private int value;
    private int current;
    private Player winner; // Store the winner for display
        private int currentPlayerIndex = 0;
    private ArrayList<Winner> winners;
    //    private Scene currentScene;
        private ArrayList<Scene> scenes;
private boolean winnerCalculated = false;


    public Scene_Play2(PApplet p, ArrayList<Player> players, Game game) {
        this.p = p;
        this.game = (Game) p;
       // this.players = new ArrayList<>();
        this.players = players;
        this.round = 1;
       // this.winner = null; // Initialize winner as null
    

    // Method to set players from Scene_Play
   // public void setPlayers(ArrayList<Player> players) {
     //   this.players = players;
   //     this.calculateAverageAndTarget(); // Calculate average and target when players are set
    //    this.calculateWinner(); // Determine the winner immediately
    }
 public double calculateAverageAndTarget() {
        // Calculate the average and target (average * 0.8)
        int total = 0;
      //  double average=0.0;
        double target=0.0;
        for (Player player : players) {
            total += player.getValue();
        } 
        target += (total / players.size())*0.8; // Ensure floating-point division
       return target;// target += average * 0.8f;
    }

       /* public void calculateWinner() {
        winner = players.get(0);
        double closestDiff = Math.abs(winner.getValue() - target);

        for (Player player : players) {
            double diff = Math.abs(player.getValue() - target);
            if (diff < closestDiff) {
                winner = player;
                closestDiff = diff;
            }
        }

        // Update points
        for (Player player : players) {
            if (player == winner) {
                player.setPoints(player.getPoints() + 1); // Winner gains 1 point
            } else {
                player.setPoints(player.getPoints() - 1); // Losers lose 1 point
            }
        }
    }*/
    
    
    /*public ArrayList<Winner> winners calculateWinner(ArrayList<Player> players, double target) {
        ArrayList<Winner> winners=new ArrayList w<>();
    Player winner = players.get(0);
    double closestDiff = Math.abs(winner.getValue() - target);

    for (Player player : players) {
        double diff = Math.abs(player.getValue() - target);
        if (diff < closestDiff) {
            winner = player;
            closestDiff = diff;
        }
        w.add(player.getName());
        return w;
    }

    // Update points
    for (Player player : players) {
        if (player == winner) {
            player.setPoints(player.getPoints() + 1); // Winner gains 1 point
        } else {
            player.setPoints(player.getPoints() - 1); // Losers lose 1 point
        }
    }

    return winner; // Return the winner
}*/

/*public static ArrayList<Winner> calculateWinner(ArrayList<Player> players, double target) {
        ArrayList<Winner> winners = new ArrayList<>();
        double closestDiff = Double.MAX_VALUE; // Initialize with the largest possible difference
        // Find the closest difference to the target
        for (Player player : players) {
            double diff = Math.abs(player.getValue() - target);
            if (diff < closestDiff) {
                closestDiff = diff; // Update the closest difference
            }
        }

        // Add all players with the closest difference to the winners list
        for (Player player : players) {
            double diff = Math.abs(player.getValue() - target);
            if (diff == closestDiff) {
                winners.add(new Winner(player.getName()));
            }
        //boolean isWinner = false; // Declare isWinner for each player
        for (Winner winner : winners) {
            if (winner.getName().equals(player.getName())) {
          player.setPoints(player.getPoints() + 0); // Winner gains 1 point
        } else {
           player.setPoints(player.getPoints() - 1); // Losers lose 1 point
        }
    }
   // return winners; // Return the winners list
}
    return winners;

}
    
       /* // Update points for all players
         for (Player player : players) {
        boolean isWinner = false;
        for (Winner winner : winners) {
            if (winner.getName().equals(player.getName())) {
                isWinner = true;
                break;
            }
        }
         }
        if (isWinner) {
            player.setPoints(player.getPoints() + 1); // Winner gains 1 point
        } else {
            player.setPoints(player.getPoints() - 1); // Losers lose 1 point
        }
    

        return winners;
    }*/
    
   /* public void display() {
        p.background(0);
        p.fill(255);
        // Display round information
        p.textSize(32);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text("Round: " + round, p.width / 2, 50);
     //   p.text("Average: " + average, p.width / 2, 100);
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

    // Remove the trailing comma and space if there are winners
    if (winnerNames.length() > 0) {
        winnerNames.setLength(winnerNames.length() - 2);
    }

            p.textSize(40);
            p.fill(0, 255, 0); // Green for winner
            p.text("Winner(s): " + winnerNames.toString(), p.width / 2, 400);
        
        
         for (int i = 0; i < players.size(); i++) {
        p.text("Player " + (i + 1) + " Points: " + players.get(i).getPoints(), p.width / 2, 450 + (i * 50));
    }
    }
    
    public void endRound() {
    // Calculate the target value for this round
    double target = calculateAverageAndTarget();

    // Calculate the winner(s) and update points
    ArrayList<Winner> winners = calculateWinner(players, target);
  //  updatePlayerPoints(players, winners);

    // Display the winner(s) (optional, for debugging)
    StringBuilder winnerNames = new StringBuilder();
    for (Winner winner : winners) {
        winnerNames.append(winner.getName()).append(", ");
    }
    if (winnerNames.length() > 0) {
        winnerNames.setLength(winnerNames.length() - 2);
    }
    System.out.println("Winner(s): " + winnerNames.toString());

    // Increment the round counter
    round++;
}

    public void keyPressed() {
        // Move to next round or scene when Enter key is pressed
        if (p.key == PApplet.TAB) {
endRound();
            for (Player player : players) {
                player.setInputComplete(false); // Reset input completion for the next round
                player.setValue(0);
                currentPlayerIndex=0;
            }
                    winnerCalculated = false; // Reset the flag for the new round
            Scene_Play scenePlay = new Scene_Play(p, players, game);
            game.setScene(scenePlay); // Transition to the next scene
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
}*/

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
        //roundImage=p.loadImage("girl.png");
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

        // Add all players with the closest difference to the winners list
        for (Player player : players) {
            double diff = Math.abs(player.getValue() - target);
            if (diff == closestDiff) {
                winners.add(new Winner(player.getName()));
            }
        }

        // Update points for all players
        for (Player player : players) {
            boolean isWinner = false;
            for (Winner winner : winners) {
                if (winner.getName().equals(player.getName())) {
                    isWinner = true;
                   break;
                }
            }
            if (isWinner) {
                player.setPoints(player.getPoints() + 0); // Winner gains 1 point
            } else if (!player.hasLostPoint()) {
                player.setPoints(player.getPoints() - 1); // Losers lose 1 point
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
       // p.image(roundImage, (p.width - roundImage.width) / 2, p.height/2-300, roundImage.width, roundImage.height);
        p.image(round1Gif, (p.width - round1Gif.width) / 2, p.height/2-230, round1Gif.width, round1Gif.height);
        
        p.textSize(30);
        p.textAlign(PApplet.LEFT);
        p.fill(225,9,9, cardAlpha2);
        p.text("Loading", p.width/2-110, p.height/2+250);
       
        if (n > text2.length()) 
                n = text2.length();
        
            String sub2 = text2.substring(0, n);
        p.text(sub2, p.width / 2 + 30, p.height / 2 + 250);

  
         /*  if (p.frameCount % 10 == 0)
                n++;*/
        
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
        // Calculate winners and update points
        ArrayList<Winner> winners = calculateWinner(players, calculateAverageAndTarget());

        // Display winner(s)
        StringBuilder winnerNames = new StringBuilder();
        for (Winner winner : winners) {
            winnerNames.append(winner.getName()).append(", ");
        }
        if (winnerNames.length() > 0) {
            winnerNames.setLength(winnerNames.length() - 2);
        }
        p.textSize(40);
        p.fill(225, 9, 9); // Green for winner
        p.text("Winner(s): " + winnerNames.toString(), p.width / 2, 400);

        // Display each player's points
        p.fill(255);
        for (int i = 0; i < players.size(); i++) {
            p.text(players.get(i).getName() + " Total Points: " + players.get(i).getPoints(), p.width / 2, 450 + (i * 50));
        }
    }
    }
    public void endRound() {
     /* calculateAverageAndTarget();
       calculateWinner(players,calculateAverageAndTarget());
winnerCalculated =true;*/
        // Increment the round counter
    //     player.setInputComplete(false); 
        round++;
    }

    public void keyPressed() {
        if (p.key == PApplet.TAB) {
         game.setScene(new Scene_Play(game, players, game));
            currentPlayerIndex = 0;
            players.get(currentPlayerIndex).display();
            endRound();
           /* for (Player player : players) {
                player.setInputComplete(false); 
                player.setInput("0");
                player.setValue(0);
            }*/
         //   winnerCalculated = false; 
            //  currentPlayerIndex = 0;
        //  players.get(currentPlayerIndex).display();
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