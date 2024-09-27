public class IcyHot{
    public static boolean icyHot(int temp1, int temp2)
{
        if((temp1 < 0 && temp2 >100) || (temp1 > 100 && temp2<0))
        return true;
        else
        return false;
}
    public static void testIcyHot(int temp1, int temp2, boolean expected){
        boolean result=icyHot(temp1, temp2);
        System.out.println("temp1: " + temp1 + " temp2: " + temp2 + " expected: " + expected + " result: " + result);
       
        if(result==expected)
            System.out.println("PASS!");
        else 
            System.out.println("NO PASS!");
    }
    public static void main(String[] args)
    {
        testIcyHot(120, -1, true);
        testIcyHot(2, 120,false);
        testIcyHot(-2, -2, false);
        testIcyHot(-1, 120, true);
    }
}