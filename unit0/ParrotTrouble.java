public class ParrotTrouble
{
    public static boolean parrotTrouble(boolean talking, int hour) {
        if(talking && (hour<7|| hour>20))
        return true;
        else
        return false;
}
    public static void testParrotTrouble(boolean talking, int hour, boolean expected)
    {
        boolean result = parrotTrouble(talking, hour);
        System.out.println("talking: " + talking + " hour: " + hour + " expected: " + expected + " result: " + result);
        
        if(result==expected)
            System.out.println("PASS!");
        else 
            System.out.println("NO PASS!");
    }
    public static void main(String[] args)
    {
        testParrotTrouble(true, 6, true);
        testParrotTrouble(false, 21,false);
        testParrotTrouble(true, 7, false);
        testParrotTrouble(false, 20, false);
    }
}