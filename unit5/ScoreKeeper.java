public class ScoreKeeper {

    public ScoreKeeper()  
    {
        total = 0;
    }

    public void scoreNormal()
    {
        total += 100;
    }

    public void scoreBonus()
    {
        total += 1000;
    }
    
    public int getTotal()
    {
        return total;
    }

    private int total;
    
  public static void main(String[] args)
    {
        ScoreKeeper keeper = new ScoreKeeper();

        keeper.scoreNormal();
        keeper.scoreBonus();
        
        System.out.println("My total is:" + keeper.getTotal());
    }
}