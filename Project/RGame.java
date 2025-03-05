/*import java.util.ArrayList;
import processing.core.*;

public class RGame {
    private ArrayList<Player> players;
    private double targetValue;

    public RGame(ArrayList<Player> players) {
        this.players = players;
        this.targetValue = 0.0;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue; // Set target once per round
    }

    public double getTargetValue() {
        double sum = 0.0;
        int count = 0;
        for (Player player : players) {
            if (player.getIsAlive()) {
                sum += player.getCurrentNumber();
                count++;
            }
        }
        return (sum / count)*0.8;
    }

    public ArrayList<Player> findWinners() {
        ArrayList<Player> winners = new ArrayList<>();
        double minDiff = Double.MAX_VALUE;

        for (Player player : players) {
            if (player.getIsAlive()) {
                double diff = Math.abs(player.getCurrentNumber() - targetValue);
                if (diff < minDiff) {
                    winners.clear();
                    winners.add(player);
                    minDiff = diff;
                } else if (diff == minDiff) {
                    winners.add(player);
                }
            }
        }
        return winners;
    }

    public void updatePoints(ArrayList<Player> winners) {
        for (Player player : players) {
            if (player.getIsAlive() && !winners.contains(player)) {
                player.losePoints(); // Players who are not winners lose points
            }
        }
    }
}
