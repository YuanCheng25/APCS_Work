import processing.core.PApplet;
import processing.core.PImage;
import gifAnimation.*;


public class Scene_Play implements Scene {
    private PApplet p;
    private Player[] players;
    private int currentPlayerIndex;
  private PImage backgroundSky;
   private PImage[] playerImages; // Array to store player images
    
    public Scene_Play(PApplet p) {
        this.p = p;
        backgroundSky=p.loadImage("sky.png");

        players = new Player[3];
        playerImages = new PImage[3]; // Initialize the image array

        // Load images for each player
        playerImages[0] = p.loadImage("player01.gif"); // Replace with your image file path
        playerImages[1] = p.loadImage("hatter.png"); // Replace with your image file path
        playerImages[2] = p.loadImage("alice3.png"); // Replace with your image file path

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
        currentPlayerIndex = 0;
    }

    public void display() {
       p.background(17,23,30);
       p.image(backgroundSky, 0, 0, p.width, p.height);

           // Display the current player's image with proportional scaling
        PImage currentImage = playerImages[currentPlayerIndex];
        float aspectRatio = (float) currentImage.width / currentImage.height; // Calculate aspect ratio
        float imageHeight = p.height * 0.5f; // Set height to 50% of the screen height
        float imageWidth = imageHeight * aspectRatio; // Calculate width based on aspect ratio

        // Center the image horizontally and move it slightly up
        float x = (p.width - imageWidth) / 2;
        float y = p.height * 0.05f; // Position the image 5% from the top (moved up)

        p.image(currentImage, x, y, imageWidth, imageHeight); 
     
        // Display the current player's input and value
        players[currentPlayerIndex].display();
    }

    public void keyPressed() {
        players[currentPlayerIndex].keyPressed();
        if (players[currentPlayerIndex].isInputComplete()) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }
    }

    private class Player {
        String input = "";
        int value = 0;
        boolean inputComplete = false;

        public void display() {
            p.textSize(32);
            p.textAlign(PApplet.CENTER, PApplet.CENTER);

            // Display instructions and input
            p.text("Player " + (currentPlayerIndex + 1) + ", enter an integer between 0-100:", p.width / 2, 300);
            p.text("Input: " + input, p.width / 2, 350);
            p.text("Value: " + value, p.width / 2, 400);
        }

        public void keyPressed() {
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
    }
}