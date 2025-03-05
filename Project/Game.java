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

import processing.core.*;
import java.util.*;
import processing.sound.*;

public class Game extends PApplet {

    SoundFile music;
    private ArrayList<Scene> scenes;
    private int current;

    public void settings() {
       smooth(2);
        fullScreen();
    }

    public void setup() {
        scenes = new ArrayList<Scene>(); 
        scenes.add(new Scene_Start(this));
        scenes.add(new Scene_Rules(this));
        scenes.add(new Scene_Play(this));
   //     scenes.add(new Scene_Play2(this));

        current = 0;
        
        music = new SoundFile(this, "chopin.mp3");
        music.loop();
    }

    public void draw() {
        background(0);
        scenes.get(current).display();
    }
    
    public void keyPressed() {
        if (key == ENTER) {
            nextScene(); // Move to the next scene when ENTER is pressed
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
}
