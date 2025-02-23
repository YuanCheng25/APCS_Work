import processing.core.*;
import java.util.*;
import processing.sound.*;

public class Game extends PApplet
{

SoundFile music;
private String input = ""; 
private int value; 


    public void settings()
    {
        size(1050, 562);
    }

    public void setup()
    {
        scenes = new ArrayList<Scene>(); 
        scenes.add(new Scene_Start(this));
        scenes.add(new Scene_Rules(this));
        scenes.add(new Scene_Play(this));
    //    scenes.add(new Scene_Play2(this));
      //  scenes.add(new Scene_End(this));

        current = 0;
        
        music=new SoundFile(this, "cdl.mp3");
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
      /*  else if (current == 2) {
            if (key == BACKSPACE && input.length() > 0) {
                input = input.substring(0, input.length() - 1);
            } 
            else if (key == ENTER) {
                    value = Integer.parseInt(input);
                    input = ""; 
            
            } 
            else if (Character.isDigit(key)) {
                input += key;
            }
        } 
        }*/

    private ArrayList<Scene> scenes;
    private int current;

    public static void main(String[] args)
    {
        PApplet.main("Game");
    }
}
