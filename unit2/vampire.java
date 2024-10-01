public class Vampire
{
    public static boolean isVampire(float hour, boolean awake) {
        if((!awake && (hour< 22 && hour>6))||(awake && (hour <6 || hour >22)))
            return true;
        else
            return false;
    }
    public static void testisVampire(boolean awake, float hour, boolean expected)
    {

        boolean result = isVampire(hour, awake);
        System.out.println("awake: " + awake + " hour: " + hour + " expected: " + expected + " result: " + result);
        
        if(result==expected)
            System.out.println("PASS!");
        else 
            System.out.println("NO PASS!");
    }
    public static void main(String[] args)
    {
        testisVampire(true, 6, false);
        testisVampire(true, 23, true);
        testisVampire(false, 1, false);
        testisVampire(false, 21, true);
    }
}