import processing.core.*;
import java.util.ArrayList;

public class Scene_Play implements Scene {
    private PApplet p;
    private ArrayList<Player> players;
        private ArrayList<PImage> playerImages;
      private String input = "";
        private int value = 0;
        private boolean inputComplete = false;
        private Game game;
 private ArrayList<Scene> scenes;
    private int current;

    private int currentPlayerIndex = 0;
    private PImage backgroundSky;

    public Scene_Play(PApplet p, ArrayList<Player> players, Game game) {
        this.p = p;
      this.game = (Game) p;    
        this.players = players;
        backgroundSky = p.loadImage("blk.png");
    }
    
     public void resetToPlayer1() {
        currentPlayerIndex = 0; // Reset to Player 1
        input = ""; 
        value = 0; 
        inputComplete = false; 
    }

    public void display() {
        p.background(17, 23, 30);
        p.image(backgroundSky, 0, 0, p.width, p.height);

        // Display the current player's input and value
        players.get(currentPlayerIndex).display();
        
         if(currentPlayerIndex==2){
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.fill(225,9,9);
        p.text("Press 'Enter' to Start the Round!", p.width/2, 950);
                    }
    }

    public void keyPressed() {
        players.get(currentPlayerIndex).keyPressed();

        if (p.key == PApplet.BACKSPACE && input.length() > 0) {
            input = input.substring(0, input.length() - 1); // Handle backspace
        } else if (p.key == ' ') { // Use SPACE key to submit input
            try {
                if (!input.isEmpty()) {
                    value = Integer.parseInt(input); // Parse input to integer
                    players.get(currentPlayerIndex).setValue(value);
                    inputComplete = true; // Mark input as complete

                   
                    if (currentPlayerIndex == 2 && p.key == ' ') { // Player 3 is index 2
                        Scene_Play2 scenePlay2 = new Scene_Play2(p, players, game);
                        game.setScene(scenePlay2); // Transition to Scene_Play2
                        return; 
                        
                    }

                    // Move to the next player
                    currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
                    input = ""; 
                }
            } catch (NumberFormatException e) {
                input = ""; // Clear input
            }
        } else if (Character.isDigit(p.key)) {
            input += p.key; 
        }
    }
    
}