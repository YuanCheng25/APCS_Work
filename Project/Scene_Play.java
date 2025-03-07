/*import processing.core.PApplet;
import processing.core.PImage;
import gifAnimation.*;
import java.util.ArrayList;



public class Scene_Play implements Scene {
    private PApplet p;
  //  private Player[] players;
        private ArrayList<Player>players;
    private int currentPlayerIndex=0;
  private PImage backgroundSky;
  // private PImage[] playerImages; // Array to store player images
            private String input = "";
    private int value = 0;
    
    public Scene_Play(PApplet p, ArrayList<Player>players) {
        this.p = p;
        this.players = players;
        backgroundSky=p.loadImage("blk.png");

     /*   players = new Player[3];
        playerImages = new PImage[3]; // Initialize the image array

        // Load images for each player
        playerImages[0] = p.loadImage("eye2.png"); // Replace with your image file path
        playerImages[1] = p.loadImage("chess2.png"); // Replace with your image file path
        playerImages[2] = p.loadImage("cat.png"); // Replace with your image file path*/

      /*  for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }*/
    //    currentPlayerIndex = 0;
        
   /* Player currentPlayer = players.get(currentPlayerIndex);

    }

    public void display() {
       p.background(17,23,30);
       p.image(backgroundSky, 0, 0, p.width, p.height);

      /*     // Display the current player's image with proportional scaling
        PImage currentImage = playerImages[currentPlayerIndex];
        float aspectRatio = (float) currentImage.width / currentImage.height; // Calculate aspect ratio
        float imageHeight = p.height * 0.5f; // Set height to 50% of the screen height
        float imageWidth = imageHeight * aspectRatio; // Calculate width based on aspect ratio

        // Center the image horizontally and move it slightly up
        float x = (p.width - imageWidth) / 2;
        float y = p.height * 0.05f; // Position the image 5% from the top (moved up)

        p.image(currentImage, x, y, imageWidth, imageHeight); */
     
        // Display the current player's input and value
       // players[currentPlayerIndex].display();
   // currentPlayer.display();


   /* public void keyPressed() {
        players[currentPlayerIndex].keyPressed();
        if (players[currentPlayerIndex].isInputComplete()) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }
    }*/

   // private class Player {
  /*      String input = "";
        int value = 0;
        boolean inputComplete = false;
*/
        
       /*     p.textSize(32);
            p.textAlign(PApplet.CENTER, PApplet.CENTER);

            // Display instructions and input
            p.fill(255);
            p.text("Player " + (currentPlayerIndex + 1) + ", enter an integer between 0-100:", p.width / 2, 600);
            p.fill(225,9,9);
            p.text("Note: Do not let other players see your response!", p.width / 2, 650);
            p.fill(255);
            p.text("Input: " + input, p.width / 2, 700);
            p.text("Value: " + value, p.width / 2, 750);
            p.text("Press 'Space' upon completion", p.width / 2, 850);
            p.text("to confirm your choice.", p.width / 2, 900);*/
        
        
//}
    
   /* public void keyPressed() {
        
        if (p.key == PApplet.BACKSPACE && input.length() > 0) {
            input = input.substring(0, input.length() - 1);
        } else if (p.key == ' ') { // Use SPACE key to submit input
            try {
                if (!input.isEmpty()) {
                    value = Integer.parseInt(input); // Parse input to integer
                    currentPlayer.setInputComplete(true); // Mark input as complete
                }
            } catch (NumberFormatException e) {
                // Handle invalid input (e.g., non-numeric input)
                input = ""; // Clear input
            }
        } else if (Character.isDigit(p.key)) {
            input += p.key; // Append digit to input
        }
    }
}*/

      /*  public void keyPressed() {
            if (p.key == PApplet.BACKSPACE && input.length() > 0) {
                input = input.substring(0, input.length() - 1);
            } else if (p.key == ' ') { // Use SPACE key to submit input
                try {
                    if (!input.isEmpty()) {
                        value = Integer.parseInt(input); // Parse input to integer
                        inputComplete = true; // Mark input as complete
                    }
                } catch (NumberFormatException e) {
                    // Handle invalid input (e.g., non-numeric input)
                    input = ""; // Clear input
                }
            } else if (Character.isDigit(p.key)) {
                input += p.key; // Append digit to input
            }
        }

        public boolean isInputComplete() {
            return inputComplete;
        }
    }*/
//}

//import processing.core.PApplet.*;
//import processing.core.PImage;

/*public class Scene_Play implements Scene {
    private PApplet p;
    private Player[] players;
    private int currentPlayerIndex;
    private PImage backgroundSky;
    private PImage[] playerImages;
    private Game game;

    public Scene_Play(PApplet p) {
        this.p = p;
        this.game = (Game) p;
        backgroundSky = p.loadImage("blk.png");

        players = new Player[3];
        playerImages = new PImage[3];

        playerImages[0] = p.loadImage("eye.png");
        playerImages[1] = p.loadImage("dumdum.png");
        playerImages[2] = p.loadImage("cat.png");

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
        currentPlayerIndex = 0;
    }

    public void display() {
        p.background(17, 23, 30);
        p.image(backgroundSky, 0, 0, p.width, p.height);

        // Display the current player's image with proportional scaling
        PImage currentImage = playerImages[currentPlayerIndex];
        float aspectRatio = (float) currentImage.width / currentImage.height;
        float imageHeight = p.height * 0.5f;
        float imageWidth = imageHeight * aspectRatio;

        float x = (p.width - imageWidth) / 2;
        float y = p.height * 0.05f;

        p.image(currentImage, x, y, imageWidth, imageHeight);

        // Display the current player's input and value
        players[currentPlayerIndex].display(p);  // Pass PApplet instance
    }

    public void keyPressed() {
        players[currentPlayerIndex].keyPressed(p);  // Pass PApplet instance

        if (players[currentPlayerIndex].isInputComplete()) {
            if (currentPlayerIndex == players.length - 1) {
                // All players have entered their numbers, move to Scene_Play2
         //       game.setPlayers(players); // Pass players to the next scene
                game.nextScene();
            } else {
                // Move to the next player
                currentPlayerIndex++;
            }
        }
    }

    private class Player {
        String input = "";
        int value = 0;
        boolean inputComplete = false;

        public void display(PApplet p) {
            p.textSize(32);
            p.textAlign(PApplet.CENTER, PApplet.CENTER);
            p.fill(255);  
            p.text("Player " + (currentPlayerIndex + 1) + ", enter an integer between 0-100:", p.width / 2, 600);
            p.text("Input: " + input, p.width / 2, 650);
            p.text("Value: " + value, p.width / 2, 700);
        }

        public void keyPressed(PApplet p) {
            if (p.key == PApplet.BACKSPACE && input.length() > 0) {
                input = input.substring(0, input.length() - 1);
            } else if (p.key == ' ') { // Use SPACE key to submit input
                try {
                    if (!input.isEmpty()) {
                        value = Integer.parseInt(input); // Store value input
                        inputComplete = true; // Mark input as complete
                    }
                } catch (NumberFormatException e) {
                    input = "";
                }
            } else if (Character.isDigit(p.key)) {
                input += p.key; // Append digit to input
            }
        }

        public boolean isInputComplete() {
            return inputComplete;
        }
    }
}
*/

   // import processing.core.PApplet.*;
//import processing.core.PImage;
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

                    // Set the value for the current player

                    // Check if the current player is Player 3 (index 2)
                   
                    if (currentPlayerIndex == 2 && p.key == ' ') { // Player 3 is index 2
                        Scene_Play2 scenePlay2 = new Scene_Play2(p, players, game);
                       // scenePlay2.setPlayers(players); // Pass the list of players
                        game.setScene(scenePlay2); // Transition to Scene_Play2
                        //game.nextScene();
                        return; // Exit the method to avoid further processing
                        
                    }

                    // Move to the next player
                    currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
                    input = ""; 
                }
            } catch (NumberFormatException e) {
                // Handle invalid input (e.g., non-numeric input)
                input = ""; // Clear input
            }
        } else if (Character.isDigit(p.key)) {
            input += p.key; // Append digit to input
        }
    }
    
}