public class TestMagicEightBall {
    public static void main(String[] args) {
        MagicEightBall ball = new MagicEightBall();
        
        System.out.println("Will I be happy? " + ball.ask("Will I be happy?"));
        System.out.println("Will I ace that test? " + ball.ask("Will I ace that test?"));
    }
}