import java.util.ArrayList;
import processing.core.*;

public class Player {
    private String name;
    private int points;
    private boolean isAlive;
    private int currentNumber;

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

    public void setPoints(int newPoints) {
        this.points = newPoints;
    }

    public void losePoints() {
        points--;
        if (points <= -3) isAlive = false; // Eliminated when points reach -3
    }
}

