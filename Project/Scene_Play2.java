/*import processing.core.*;
import java.util.ArrayList;

public class Scene_Play2 implements Scene {
    private PApplet p;
    private ArrayList<Player> players;
    private Game game;
    private int currentState;
    private PFont customFont;
    private PImage GridImage;
    private PImage EndScene;

    public Scene_Play(PApplet p) {
        this.p = p;
        this.players = new ArrayList<>();
        this.game = new Game;
        this.currentState = 0;
        customFont = p.createFont("slkscr.ttf", 32);
        players.add(new Player("1"));
        players.add(new Player("2"));
        players.add(new Player("3"));
    }

    public class Player {
        private String name;
        private int points;
        private boolean isAlive;
        private int currentNumber = -2;

        public Player(String name) {
            this.name = name;
            this.points = 0;
            this.isAlive = true;
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

        public void losePoints() {
            points--;
            if (points <= -3)
                isAlive = false;
        }
    }

    public class Game {
        private ArrayList<Player> players;
        private int roundNumber;

        public Game(ArrayList<Player> players) {
            this.players = players;
            roundNumber = 1;
        }

        private ArrayList<Player> getActivePlayers() {
            ArrayList<Player> active = new ArrayList<>();
            for (Player p : players) {
                if (p.getIsAlive()) {
                    active.add(p);
                }
            }
            return active;
        }

        public boolean isGameOver() {
            return getActivePlayers().size() == 1;
        }

        private double calculateAverage() {
            ArrayList<Player> activePlayers = getActivePlayers();
            double sum = 0.0;
            for (Player a : activePlayers) {
                sum += a.getCurrentNumber();
            }
            return sum / activePlayers.size();
        }

        private ArrayList<Player> findWinners(double target) {
            ArrayList<Player> winners = new ArrayList<>();
            double smallestDifference = Double.MAX_VALUE;

            for (Player a : getActivePlayers()) {
                double diff = Math.abs(a.getCurrentNumber() - target);
                if (diff < smallestDifference) {
                    winners.clear();
                    winners.add(a);
                    smallestDifference = diff;
                } else if (diff == smallestDifference) {
                    winners.add(a);
                }
            }
            return winners;
        }

        private void updatePoints(ArrayList<Player> winners) {
            for (Player a : getActivePlayers()) {
                if (!winners.contains(a)) {
                    a.losePoints();
                }
            }
        }

        public void playRound() {
            double average = calculateAverage();
            double target = average * 0.8;

            ArrayList<Player> winners = findWinners(target);
            updatePoints(winners);
import processing.core.*;
import java.util.ArrayList;

public class Scene_Play2 implements Scene {
    private PApplet p;
    private ArrayList<Player> players;
    private Game game;
    private int currentState;
    private PFont customFont;
    private boolean isWinnerScreen; // Track if we're in the winner screen
    private ArrayList<Player> roundWinners; // Track winners of the current round
    private ArrayList<Player> roundLosers; // Track losers of the current round
    private double targetValue; // Store the value of average * 0.8

    public Scene_Play2(PApplet p) {
        this.p = p;
        this.players = new ArrayList<>();
        this.game = new Game(players); // Initialize the Game object with the players list
        this.currentState = 0;
        this.isWinnerScreen = false; // Start in the game round state
        this.roundWinners = new ArrayList<>();
        this.roundLosers = new ArrayList<>();
        this.targetValue = 0.0; // Initialize target value
        customFont = p.createFont("slkscr.ttf", 32);
        players.add(new Player("1"));
        players.add(new Player("2"));
        players.add(new Player("3"));
    }

    public class Player {
        private String name;
        private int points;
        private boolean isAlive;
        private int currentNumber = -2;

        public Player(String name) {
            this.name = name;
            this.points = 0;
            this.isAlive = true;
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

        public void losePoints() {
            points--;
            if (points <= -2) // Changed to -2 as per the game rules
                isAlive = false;
        }
    }

    public class Game {
        private ArrayList<Player> players;
        private int roundNumber;

        public Game(ArrayList<Player> players) {
            this.players = players;
            roundNumber = 1;
        }

        private ArrayList<Player> getActivePlayers() {
            ArrayList<Player> active = new ArrayList<>();
            for (Player p : players) {
                if (p.getIsAlive()) {
                    active.add(p);
                }
            }
            return active;
        }

        public boolean isGameOver() {
            return getActivePlayers().size() == 1;
        }

        private double calculateAverage() {
            ArrayList<Player> activePlayers = getActivePlayers();
            double sum = 0.0;
            for (Player a : activePlayers) {
                sum += a.getCurrentNumber();
            }
            return sum / activePlayers.size();
        }

        private ArrayList<Player> findWinners(double target) {
            ArrayList<Player> winners = new ArrayList<>();
            double smallestDifference = Double.MAX_VALUE;

            for (Player a : getActivePlayers()) {
                double diff = Math.abs(a.getCurrentNumber() - target);
                if (diff < smallestDifference) {
                    winners.clear();
                    winners.add(a);
                    smallestDifference = diff;
                } else if (diff == smallestDifference) {
                    winners.add(a);
                }
            }
            return winners;
        }

        private void updatePoints(ArrayList<Player> winners) {
            for (Player a : getActivePlayers()) {
                if (!winners.contains(a)) {
                    a.losePoints();
                }
            }
        }

        public void playRound() {
            double average = calculateAverage();
            double target = average * 0.8;

            ArrayList<Player> winners = findWinners(target);
            updatePoints(winners);

            roundNumber++;
        }
    }

    public void display() {
        p.background(255);
        p.textFont(customFont);
        p.fill(0);

        if (isWinnerScreen) {
            // Display the winner screen
            displayWinnerScreen();
        } else {
            // Display the game round
            displayGameRound();
        }
    }

    private void displayGameRound() {
        p.textAlign(PApplet.CENTER, PApplet.CENTER); // Center text
        p.text("Round: " + game.roundNumber, p.width / 2, 30);

        // Display player information
        int yOffset = 60;
        for (Player player : players) {
            if (player.getIsAlive()) {
                p.text("Player " + player.getName() + ": " + player.getPoints() + " points, Number: " + player.getCurrentNumber(), p.width / 2, yOffset);
                yOffset += 30;
            } else {
                p.text("Player " + player.getName() + ": ELIMINATED", p.width / 2, yOffset);
                yOffset += 30;
            }
        }

        // Simulate player input (for demonstration purposes)
        for (Player player : players) {
            if (player.getIsAlive()) {
                player.setCurrentNumber((int) p.random(0, 101)); // Random number for demonstration
            }
        }

        // Play the round
        game.playRound();

        // Determine winners and losers
        double average = game.calculateAverage();
        targetValue = average * 0.8
            roundNumber++;
        }
    }

    public void display() {
        p.background(255);
        
    }
}*/
/*
import processing.core.PApplet;
import processing.core.*;
import java.util.ArrayList;

public class Scene_Play2 implements Scene {
    private PApplet p;
 //   private Player[] players;
    private int round;
    private float average;
    private float target;
    private Game game;
        private ArrayList<Player>players;


    public Scene_Play2(PApplet p) {
        this.p = p;
        this.game = (Game) p;
//players = new ArrayList<>(); // Dynamic ArrayList
        round = 1;
    }

    public void display() {
        p.background(17, 23, 30);
        p.fill(255);
        
        // Calculate the average and target (average * 0.8)
        int total = 0;
        for (Player player : players) {
            total += player.getCurrentNumber();
        }
        average = total / players.length;
        target = average * 0.8f;

        // Display round information
        p.textSize(32);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text("Round: " + round, p.width / 2, 50);
        p.text("Average: " + average, p.width / 2, 100);
        p.text("Target (Average * 0.8): " + target, p.width / 2, 150);

        // Display each player's input
  for (int i = 0; i < players.size(); i++) {
    p.text("Player " + (i + 1) + " Input: " + players.get(i).getValue(), p.width / 2, 200 + (i * 50));
}

        // Calculate and display results
        calculateWinner();
    }

    public void keyPressed() {
        // Move to next round or scene when space key is pressed
        if (p.key == ' ') {
            for (Player player : players) {
                player.inputComplete = false; // Reset inputComplete for the next round
            }
            game.nextScene();
        }
    }

    private void calculateWinner() {
        // Find the player with the closest value to the target (average * 0.8)
        Player winner = players[0];
        float closestDiff = Math.abs(winner.value - target);

        for (Player player : players) {
            float diff = Math.abs(player.value - target);
            if (diff < closestDiff) {
                winner = player;
                closestDiff = diff;
            }
        }

        // Update points
        for (Player player : players) {
            if (player == winner) {
                player.points += 0; // Winner gets 0 points
            } else {
                player.points -= 1; // Losers lose 1 point
            }
        }

        // Display winner
        p.textSize(40);
        p.fill(0, 255, 0); // Green for winner
        p.text("Winner: Player " + (getPlayerIndex(winner) + 1), p.width / 2, 400);
    }
private int getPlayerIndex(Player players) {
    for (int i = 0; i < players.size(); i++) {
        if (players.get(i) == players) {
            return i;
        }
    }
    return -1; // Return -1 if the player is not found
}

    public void setPlayers(Player players) {
        this.players = players;
    }

  /*  private class Player {
        int value = 0;
        int points = 0;
        boolean inputComplete = false;

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }*/
//}
    
/*import processing.core.PApplet;
import java.util.ArrayList;

public class Scene_Play2 implements Scene {
    private PApplet p;
    private ArrayList<Player> players; // Use ArrayList for dynamic player list
    private int round;
    private float average;
    private float target;
    private Game game;

    public Scene_Play2(PApplet p) {
        this.p = p;
        this.game = (Game) p;
        this.players = new ArrayList<>(); // Initialize the ArrayList
        round = 1;
    }

    public void display() {
        p.background(17, 23, 30);
        p.fill(255);

        // Calculate the average and target (average * 0.8)
        int total = 0;
        for (Player player : players) {
            total += player.getCurrentNumber(); // Assuming getCurrentNumber() is a public method in Player
        }
        average = total / players.size(); // Use size() for ArrayList
        target = average * 0.8f;

        // Display round information
        p.textSize(32);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text("Round: " + round, p.width / 2, 50);
        p.text("Average: " + average, p.width / 2, 100);
        p.text("Target (Average * 0.8): " + target, p.width / 2, 150);

        // Display each player's input
        for (int i = 0; i < players.size(); i++) {
            p.text("Player " + (i + 1) + " Input: " + players.get(i).getValue(), p.width / 2, 200 + (i * 50));
        }

        // Calculate and display results
        calculateWinner();
    }

    public void keyPressed() {
        // Move to next round or scene when space key is pressed
        if (p.key == PApplet.ENTER) {
            for (Player player : players) {
                player.setInputComplete(false); // Use a setter method to reset inputComplete
            }
            game.nextScene();
        }
    }

    private void calculateWinner() {
        // Find the player with the closest value to the target (average * 0.8)
        Player winner = players.get(0); // Use get() for ArrayList
        float closestDiff = Math.abs(winner.getValue() - target); // Use getter for value

        for (Player player : players) {
            float diff = Math.abs(player.getValue() - target); // Use getter for value
            if (diff < closestDiff) {
                winner = player;
                closestDiff = diff;
            }
        }

        // Update points
        for (Player player : players) {
            if (player == winner) {
                player.setPoints(player.getPoints() + 0); // Winner gets 0 points (no change)
            } else {
                player.setPoints(player.getPoints() - 1); // Losers lose 1 point
            }
        }

        // Display winner
        p.textSize(40);
        p.fill(0, 255, 0); // Green for winner
        p.text("Winner: Player " + (getPlayerIndex(winner) + 1), p.width / 2, 400);
    }

    private int getPlayerIndex(Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) == player) {
                return i;
            }
        }
        return -1; // Return -1 if the player is not found
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players; // Set the ArrayList of players
    }
}*/

import processing.core.*;
import java.util.ArrayList;

public class Scene_Play2 implements Scene {
    private PApplet p;
    private ArrayList<Player> players;
    private int round;
    private float average;
    private float target;
    private Game game;

    public Scene_Play2(PApplet p) {
        this.p = p;
        this.game = (Game) p;
        this.players = new ArrayList<>();
      //  this.players =players;
        round = 1;
    }

   /* public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }*/
    
    public void display() {
        p.background(17, 23, 30);
        p.fill(255);

        // Calculate the average and target (average * 0.8)
        int total = 0;
        for (Player player : players) {
            total += player.getValue();
        }
        average = total / players.size();
        target = average * 0.8f;

        // Display round information
        p.textSize(32);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text("Round: " + round, p.width / 2, 50);
        p.text("Average: " + average, p.width / 2, 100);
        p.text("Target (Average * 0.8): " + target, p.width / 2, 150);

        // Display each player's input
        for (int i = 0; i < players.size(); i++) {
            p.text("Player " + (i + 1) + " Input: " + players.get(i).getValue(), p.width / 2, 200 + (i * 50));
        }

        // Calculate and display results
        calculateWinner();
    }

    public void keyPressed() {
        // Move to next round or scene when space key is pressed
        if (p.key == PApplet.ENTER) {
            for (Player player : players) {
                player.setInputComplete(false);
            }
            game.nextScene();
        }
    }

    private void calculateWinner() {
        // Find the player with the closest value to the target (average * 0.8)
        Player winner = players.get(0);
        float closestDiff = Math.abs(winner.getValue() - target);

        for (Player player : players) {
            float diff = Math.abs(player.getValue() - target);
            if (diff < closestDiff) {
                winner = player;
                closestDiff = diff;
            }
        }

        // Update points
        for (Player player : players) {
            if (player == winner) {
                player.setPoints(player.getPoints() + 1); // Winner gains 1 point
            } else {
                player.setPoints(player.getPoints() - 1); // Losers lose 1 point
            }
        }

        // Display winner
        p.textSize(40);
        p.fill(0, 255, 0); // Green for winner
        p.text("Winner: Player " + (getPlayerIndex(winner) + 1), p.width / 2, 400);
    }

    private int getPlayerIndex(Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) == player) {
                return i;
            }
        }
        return -1; // Return -1 if the player is not found
    }


}