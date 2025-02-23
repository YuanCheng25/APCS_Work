import processing.core.*;
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

            roundNumber++;
        }
    }

    public void display() {
        p.background(255);
        
    }
}