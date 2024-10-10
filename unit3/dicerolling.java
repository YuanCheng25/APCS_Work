public class dicerolling
{
    public static void main(String[] args)
    {
        for (int i=0; i<10; i++)
            System.out.println(roll());
    }
    
    public static int roll()
    {
        int value = (int)(Math.random()*6+1);
        return value;
    }
}
