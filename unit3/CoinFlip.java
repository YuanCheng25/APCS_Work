public class CoinFlip {

    public static String Coinflip() {
        if((int)(Math.random()*2)==1)
        return "Head";
        else 
        return "Tails";
    }

    public static void main(String[] args) {
        System.out.println("Flipping & testing...");
        for (int i = 0; i < 20; i++) {
            System.out.println("Flip:" + Coinflip());
        }
    }
}