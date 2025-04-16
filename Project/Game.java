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
        playerImages.add(loadImage("eye2.png")); 
        playerImages.add(loadImage("chess2.png")); 
        playerImages.add(loadImage("cat.png")); 

        players.add(new Player("Player 1", playerImages.get(0), this));
        players.add(new Player("Player 2", playerImages.get(1), this));
        players.add(new Player("King", playerImages.get(2), this));

        scenes.add(new Scene_Start(this));
        scenes.add(new Scene_Rules(this));
        scenes.add(new Scene_Play(this, players, this));
        scenes.add(new Scene_Play2(this, players, this));
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
            current=current-1; 
        }
    }
    
    public void setCurrentScene(int index) {
    if (index >= 0 && index < scenes.size()) {
        current = index; // Change to the specified scene
    }
}
    
    public Scene getScene(int index) {
        if (index >= 0 && index < scenes.size()) {
            return scenes.get(index);
        }
        return null;
    }
    
 public void setScene(Scene newScene) {
        this.currentScene = newScene; // Update the current scene
    }
    
    public static void main(String[] args) {
        PApplet.main("Game");
    }
}
