/*import java.util.ArrayList;
import processing.core.*;

public class Player {
    private String name;
    private int points;
    private boolean isAlive;
    private int currentNumber;
    private String input = "";
    private int value = 0;
    private boolean inputComplete = false;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.isAlive = true;
        this.currentNumber = -1; // Default invalid number
    }

    public String getName() { return name; }
    public int getPoints() { return points; }
    public boolean getIsAlive() { return isAlive; }
    public int getCurrentNumber() { return currentNumber; }

    public void setCurrentNumber(int number) {
        if (number >= 0 && number <= 100) {
            this.currentNumber = number;
        }
    }
    


        public void display() {
            p.textSize(32);
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
            p.text("to confirm your choice.", p.width / 2, 900);
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

    public void setPoints(int newPoints) {
        this.points = newPoints;
    }

    public void losePoints() {
        points--;
        if (points <= -3) isAlive = false; // Eliminated when points reach -3
    }
}
*/


/*import java.util.ArrayList;
import processing.core.*;

public class Player {
    private String name;
    private int points=0;
    private boolean isAlive;
    private int currentNumber;
    private String input = "";
    private int value = 0;
    private boolean inputComplete = false;
    private PImage playerImage;
    private PApplet p;     
        private  ArrayList<PImage> playerImages;
        private ArrayList<Player> players; // List to store Player instances


    public Player(String name, PApplet p, PImage playerImage) {
        this.name = name;
        this.points = 0;
        this.isAlive = true;
        this.currentNumber = -1; // Default invalid number
        this.p = p;
        this.playerImage = playerImage;
         playerImages = new ArrayList<>();
        playerImages.add(loadImage("eye2.png")); // Replace with your image file path
        playerImages.add(loadImage("chess2.png")); // Replace with your image file path
        playerImages.add(loadImage("cat.png")); // Replace with your image file path

        // Create players and add them to the ArrayList
        players.add(new Player("Player 1", this, playerImages.get(0)));
        players.add(new Player("Player 2", this, playerImages.get(1)));
        players.add(new Player("Player 3", this, playerImages.get(2)));

        // Pass the players list to Scene_Play
        scenes.add(new Scene_Start(this));
        scenes.add(new Scene_Rules(this));
        scenes.add(new Scene_Play(this, players)); // Pass players to Scene_Play
        scenes.add(new Scene_Play2(this));

    }

    public String getName() { return name; }
    public int getPoints() { return points; }
    public boolean getIsAlive() { return isAlive; }
    public int getCurrentNumber() { return currentNumber; }
    public boolean isInputComplete() { return inputComplete; }
    public int getValue() { return value; }

    public void setCurrentNumber(int number) {
        if (number >= 0 && number <= 100 && isInputComplete()) {
            this.currentNumber = number;
        }
    }

    public void display() {
        p.textSize(32);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);

//PImage playerImage = playerImages.get(currentPlayerIndex);
        /*float aspectRatio = (float) playerImage.width / playerImage.height; // Calculate aspect ratio
        float imageHeight = p.height * 0.5f; // Set height to 50% of the screen height
        float imageWidth = imageHeight * aspectRatio; // Calculate width based on aspect ratio

        // Center the image horizontally and move it slightly up
        float x = (p.width - imageWidth) / 2;
        float y = p.height * 0.05f; // Position the image 5% from the top (moved up)

        p.image(playerImage, x, y, imageWidth, imageHeight); 

        // Display instructions and input
        p.fill(255);
        p.text("Player " + name + ", enter an integer between 0-100:", p.width / 2, 600);
        p.fill(225, 9, 9);
        p.text("Note: Do not let other players see your response!", p.width / 2, 650);
        p.fill(255);
        p.text("Input: " + input, p.width / 2, 700);
        p.text("Value: " + value, p.width / 2, 750);
        p.text("Press 'Space' upon completion", p.width / 2, 850);
        p.text("to confirm your choice.", p.width / 2, 900);*/
        
        // Assuming playerImages is a list of PImage objects for each player
// and playerNames is a list of names for each player

/*for (int i = 0; i < playerImages.size(); i++) {
    PImage playerImage = playerImages.get(i);
 Player player = players.get(i);
    // Calculate aspect ratio
    float aspectRatio = (float) playerImage.width / playerImage.height;
    float imageHeight = p.height * 0.5f; // Set height to 50% of the screen height
    float imageWidth = imageHeight * aspectRatio; // Calculate width based on aspect ratio

    // Center the image horizontally and move it slightly up
    float x = (p.width - imageWidth) / 2;
    float y = p.height * 0.05f; // Position the image 5% from the top (moved up)

    // Display the image
    p.image(playerImage, x, y, imageWidth, imageHeight);

    // Display instructions and input
    p.fill(255);
    p.text("Player " + player.getName() + ", enter an integer between 0-100:", p.width / 2, 600);
    p.fill(225, 9, 9);
    p.text("Note: Do not let other players see your response!", p.width / 2, 650);
    p.fill(255);
    p.text("Input: " + input, p.width / 2, 700);
    p.text("Value: " + value, p.width / 2, 750);
    p.text("Press 'Space' upon completion", p.width / 2, 850);
    p.text("to confirm your choice.", p.width / 2, 900);

    // Add a delay or some mechanism to switch between players
    // For example, you can use a key press or a timer to move to the next player
}
    }

    public void keyPressed() {
       /* if (p.key == PApplet.BACKSPACE && input.length() > 0) {
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
        }*/
  //  }
    
  
     //   boolean inputComplete = false;

   /*     public void setValue(int value) {
            this.value = getValue();
        }

      /*  public int getValue() {
            return value;
        }*/

    /*public boolean setInputComplete() {
        return false;
    }*/
    
   /*  public void setInputComplete(boolean inputComplete) {
        this.inputComplete = inputComplete;
    }

    public void setPoints(int newPoints) {
        this.points = newPoints;
    }

    public void losePoints() {
        points--;
        if (points <= -3) isAlive = false; // Eliminated when points reach -3
    }
}
*/

//import java.util.ArrayList;
//import processing.core.*;

/*public class Player {
    private String name;
    private int points = 0;
    private boolean isAlive;
    private int currentNumber;
    private String input = "";
    private int value = 0;
    private boolean inputComplete = false;
    private PImage playerImage;
    private PApplet p;
    private ArrayList<PImage> playerImages;
    private ArrayList<Player> players; // List to store Player instances

    public Player(String name, PImage playerImage) {
        this.name = name;
        this.points = 0;
        this.isAlive = true;
        this.currentNumber = -1; // Default invalid number
        this.p = p;
        this.playerImage = playerImage;
    }

    public String getName() { return name; }
    public int getPoints() { return points; }
    public boolean getIsAlive() { return isAlive; }
    public int getCurrentNumber() { return currentNumber; }
    public boolean isInputComplete() { return inputComplete; }
    public int getValue() { return value; }

    public void setCurrentNumber(int number) {
        if (number >= 0 && number <= 100 && isInputComplete()) {
            this.currentNumber = number;
        }
    }

    public void display() {
        p.textSize(32);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            PImage playerImage = playerImages.get(i);

            // Calculate aspect ratio
            float aspectRatio = (float) playerImage.width / playerImage.height;
            float imageHeight = p.height * 0.5f; // Set height to 50% of the screen height
            float imageWidth = imageHeight * aspectRatio; // Calculate width based on aspect ratio

            // Center the image horizontally and move it slightly up
            float x = (p.width - imageWidth) / 2;
            float y = p.height * 0.05f; // Position the image 5% from the top (moved up)

            // Display the image
            p.image(playerImage, x, y, imageWidth, imageHeight);

            // Display instructions and input
            p.fill(255);
            p.text("Player " + player.getName() + ", enter an integer between 0-100:", p.width / 2, 600);
            p.fill(225, 9, 9);
            p.text("Note: Do not let other players see your response!", p.width / 2, 650);
            p.fill(255);
            p.text("Input: " + input, p.width / 2, 700);
            p.text("Value: " + value, p.width / 2, 750);
            p.text("Press 'Space' upon completion", p.width / 2, 850);
            p.text("to confirm your choice.", p.width / 2, 900);
        }
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

    public void setValue(int value) {
        this.value = value; // Fixed: Set the value directly
    }

    public void setInputComplete(boolean inputComplete) {
        this.inputComplete = inputComplete;
    }

    public void setPoints(int newPoints) {
        this.points = newPoints;
    }

    public void losePoints() {
        points--;
        if (points <= -3) isAlive = false; // Eliminated when points reach -3
    }
}*/


import processing.core.*;
import java.util.ArrayList;
import processing.core.PApplet.*;
import processing.core.PImage;

public class Player implements Scene {
    private String name;
    private int points = 0;
    private boolean isAlive;
    private int currentNumber;
    private String input = "";
    private int value = 0;
    private boolean inputComplete = false;
    private PImage playerImage;
    private PApplet p;
    private ArrayList<Player> players;

public Player(String name, PImage playerImage, PApplet p) {
    this.name = name;
    this.playerImage = playerImage;
    this.p = p;
    this.points = 0;
    this.isAlive = true;
    this.currentNumber = -1;
    this.input = "";
    this.value = 0;
    this.inputComplete = false;
}
    
    public String getName() { return name; }
    public int getPoints() { return points; }
    public boolean getIsAlive() { return isAlive; }
    public int getCurrentNumber() { return currentNumber; }
    public boolean isInputComplete() { return inputComplete; }
    public int getValue() { return value; }

    public void setCurrentNumber(int number) {
        if (number >= 0 && number <= 100 && isInputComplete()) {
            this.currentNumber = number;
        }
    }

    public void display() {
        p.textSize(32);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);

        // Calculate aspect ratio
        float aspectRatio = (float) playerImage.width / playerImage.height;
        float imageHeight = p.height * 0.5f; // Set height to 50% of the screen height
        float imageWidth = imageHeight * aspectRatio; // Calculate width based on aspect ratio

        // Center the image horizontally and move it slightly up
        float x = (p.width - imageWidth) / 2;
        float y = p.height * 0.05f; // Position the image 5% from the top (moved up)

        // Display the image
        p.image(playerImage, x, y, imageWidth, imageHeight);

        // Display instructions and input
        p.fill(255);
        p.text(name + ", enter an integer between 0-100:", p.width / 2, 600);
        p.fill(225, 9, 9);
        p.text("Note: Do not let other players see your response!", p.width / 2, 650);
        p.fill(255);
        p.text("Input: " + input, p.width / 2, 700);
        p.text("Value: " + value, p.width / 2, 750);
        p.text("Press 'Space' upon completion", p.width / 2, 850);
        p.text("to confirm your choice.", p.width / 2, 900);
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

    public void setValue(int value) {
        this.value = value;
    }

    public void setInputComplete(boolean inputComplete) {
        this.inputComplete = inputComplete;
    }

    public void setPoints(int newPoints) {
        this.points = newPoints;
    }

    public void losePoints() {
        points--;
        if (points <= -3) isAlive = false; // Eliminated when points reach -3
    }
}