/*import processing.core.PApplet;

public class Player extends PApplet {
    String input = ""; // To store user input
    int value = 0;

    public static void main(String[] args) {
        PApplet.main("Player");
    }

    public void settings() {
        size(400, 300);
    }

    public void setup() {
        textSize(32);
    }

    public void draw() {
        background(200);
        fill(0);
        text("Enter a number:", 50, 100);
        text(input, 50, 150);
        text(value, 50, 200);
    }

    public void keyPressed() {
        if (key == BACKSPACE && input.length() > 0) {
            input = input.substring(0, input.length() - 1);
        } else if (key == ENTER || key == RETURN) {
            value = Integer.parseInt(input);
        } else if (Character.isDigit(key)) {
            input += key;
        }
    }
} */


import processing.core.PApplet;

public class Player extends PApplet {
    String input = ""; // To store user input
    int value = 0;
    int playerNumber; // To identify which player this is

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public void settings() {
        size(400, 300);
    }

    public void setup() {
        textSize(32);
    }

    public void draw() {
        background(200);
        fill(0);
        text("Player " + playerNumber + " Enter a number:", 50, 100);
        text(input, 50, 150);
        text("Value: " + value, 50, 200);
    }

    public void keyPressed() {
        if (key == BACKSPACE && input.length() > 0) {
            input = input.substring(0, input.length() - 1);
        } else if (key == ENTER || key == RETURN) {
            value = Integer.parseInt(input);
            input = ""; // Clear input after pressing Enter
        } else if (Character.isDigit(key)) {
            input += key;
        }
    }
}
