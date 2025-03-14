/*import processing.core.*;
import java.util.*;
import processing.sound.*;

public class Game extends PApplet
{

SoundFile music;
private String input = ""; 
private int value; 


    public void settings()
    {
       // size(1050, 562);
       smooth(2);
       fullScreen();
    }

    public void setup()
    {
        scenes = new ArrayList<Scene>(); 
        scenes.add(new Scene_Start(this));
        scenes.add(new Scene_Rules(this));
        scenes.add(new Scene_Play(this));
      scenes.add(new Scene_Play2(this));
      //  scenes.add(new Scene_End(this));

        current = 0;
        
        music=new SoundFile(this, "chesstype.mp3");
        music.loop();
        
    }

    public void draw()
    {
        background(0);

        scenes.get(current).display();
    }
    
    public void keyPressed() {
        //if (current == 0 || current == 1) {
            if (key == ENTER) {
                current++;
                if (current >= scenes.size()) {
                    current = 0; // Loops back to the start if at the end
                }
            }
            
        scenes.get(current).keyPressed();

        } 

    private ArrayList<Scene> scenes;
    private int current;

    public static void main(String[] args)
    {
        PApplet.main("Game");
    }
}
*/

/*import processing.core.*;
import java.util.ArrayList;
import processing.sound.*;

public class Game extends PApplet {

    SoundFile music;
    private ArrayList<Scene> scenes;
    private int current;
//    Player[] players;
    int currentPlayerIndex = 0;
    private ArrayList<Player>players;
  //  PImage[] playerImages = new PImage[3];
    private  ArrayList<PImage> playerImages;

    public void settings() {
       smooth(2);
        fullScreen();
    }

    public void setup() {
        scenes = new ArrayList<Scene>(); 
        scenes.add(new Scene_Start(this));
        scenes.add(new Scene_Rules(this));
        scenes.add(new Scene_Play(this));
        scenes.add(new Scene_Play2(this));

        current = 0;
        
        music = new SoundFile(this, "chopin.mp3");
        music.loop();
        
     /*   playerImages[0] = loadImage("eye2.png"); // Replace with your image file path
        playerImages[1] = loadImage("chess2.png"); // Replace with your image file path
        playerImages[2] = loadImage("cat.png"); // Replace with your image file path

        players = new Player[3];
        players[0] = new Player("Player 1", this, playerImages[0]);
        players[1] = new Player("Player 2", this, playerImages[1]);
        players[2] = new Player("Player 3", this, playerImages[2]);*/
        
        
     /*   playerImages = new ArrayList<>();
        players = new ArrayList<>();

        // Load player images into the ArrayList
        playerImages.add(loadImage("eye2.png")); // Replace with your image file path
        playerImages.add(loadImage("chess2.png")); // Replace with your image file path
        playerImages.add(loadImage("cat.png")); // Replace with your image file path

        // Create players and add them to the ArrayList
        players.add(new Player("Player 1", this, playerImages.get(0)));
        players.add(new Player("Player 2", this, playerImages.get(1)));
        players.add(new Player("Player 3", this, playerImages.get(2)));
    }

    public void draw() {
        background(0);
        scenes.get(current).display();
    }
    
    public void keyPressed() {
        if (key == ENTER) {
            nextScene(); // Move to the next scene when ENTER is pressed
        
       //  players[currentPlayerIndex].keyPressed();
       if (players.get(currentPlayerIndex).isInputComplete()) {
    currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
}
        }
        scenes.get(current).keyPressed();
    }

    public void nextScene() {
        current++; 
        if (current >= scenes.size()) {
            current = 0; // Loops back to the first scene if at the end
        }
    }
    
    public static void main(String[] args) {
        PApplet.main("Game");
    }
}*/


/*import processing.core.*;
import java.util.ArrayList;
import processing.sound.*;

public class Game extends PApplet {

    SoundFile music;
    private ArrayList<Scene> scenes;
    private int currentPlayerIndex;
        private int current;
    private ArrayList<Player> players;
    private ArrayList<PImage> playerImages;

    public void settings() {
        smooth(2);
        fullScreen();
    }

    public void setup() {
        scenes = new ArrayList<Scene>();
        players = new ArrayList<>();

        // Load player images into the ArrayList
       
        current = 0;

        music = new SoundFile(this, "chopin.mp3");
        music.loop();
        
        players = new ArrayList<>();

        // Load player images
        playerImages = new ArrayList<>();
        playerImages.add(p.loadImage("eye2.png")); // Replace with your image file path
        playerImages.add(p.loadImage("chess2.png")); // Replace with your image file path
        playerImages.add(p.loadImage("cat.png")); // Replace with your image file path

        // Create players and add them to the ArrayList
        players.add(new Player("Player 1", p, playerImages.get(0)));
        players.add(new Player("Player 2", p, playerImages.get(1)));
        players.add(new Player("Player 3", p, playerImages.get(2)));
    }

    public void draw() {
        background(0);
        scenes.get(current).display();
    }

    public void keyPressed() {
        if (key == ENTER) {
            nextScene(); // Move to the next scene when ENTER is pressed

            // Check if the current player's input is complete
            if (players.get(currentPlayerIndex).isInputComplete()) {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }
        }
        scenes.get(current).keyPressed();
    }

    public void nextScene() {
        current++;
        if (current >= scenes.size()) {
            current = 0; // Loops back to the first scene if at the end
        }
    }

    public static void main(String[] args) {
        PApplet.main("Game");
    }
}*/

import processing.core.*;
import java.util.ArrayList;
import processing.sound.*;

public class Game extends PApplet {

    SoundFile music;
    private ArrayList<Scene> scenes;
    private int currentPlayerIndex;
    private int current;
    private ArrayList<Player> players;
    private ArrayList<PImage> playerImages;
    private Scene currentScene;

    public void settings() {
        smooth(2);
        fullScreen();
    }
    
    public void setup() {
        scenes = new ArrayList<Scene>();
        players = new ArrayList<>();
        currentScene = new Scene_Play(this, players, this);


        current = 0;

        music = new SoundFile(this, "chopin.mp3");
        music.loop();

        playerImages = new ArrayList<>();
        playerImages.add(loadImage("eye2.png")); // Replace with your image file path
        playerImages.add(loadImage("chess2.png")); // Replace with your image file path
        playerImages.add(loadImage("cat.png")); // Replace with your image file path

        players.add(new Player("Player 1", playerImages.get(0), this));
        players.add(new Player("Player 2", playerImages.get(1), this));
        players.add(new Player("King", playerImages.get(2), this));

        scenes.add(new Scene_Start(this));
        scenes.add(new Scene_Rules(this));
        scenes.add(new Scene_Play(this, players, this));
        scenes.add(new Scene_Play2(this, players, this));
      //  scenes.add(new Scene_Elimination(this, players, this));
    //  scenes.add(new Scene_Elimination2(this, players, this));
        //  scenes.add(new Scene_Ending(this, players, this));
    }

    public void draw() {
        background(0);
        scenes.get(current).display();
    }

    public void keyPressed() {
        if (key == ENTER) {
            nextScene(); 

            // Check if the current player's input is complete
      /*      if (players.get(currentPlayerIndex).isInputComplete()) {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }*/
        }
        scenes.get(current).keyPressed();
    }

    public void nextScene() {
        current++;
        if (current >= scenes.size()) {
            current=0; 
        }
    }
    
   /* public void setCurrentScene(int index) {
    if (index >= 0 && index < scenes.size()) {
        current = index; // Change to the specified scene
    }
}*/
    
 public void setScene(Scene newScene) {
        this.currentScene = newScene; // Update the current scene
    }
    
    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
