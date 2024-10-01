public class Store
{
    public static boolean goodDeal(double originalPrice, double salePrice) {
        if(salePrice<=(0.75*originalPrice))
            return true;
        else
            return false;
    }
    public static void testgoodDeal(boolean goodDeal, double originalPrice, double salePrice, boolean expected)
    {

        boolean result = goodDeal(originalPrice, salePrice);
        System.out.println("goodDeal: " + goodDeal + " originalPrice: " + originalPrice + " salePrice: " + salePrice + " expected: " + expected + " result: " + result);
        
        if(result==expected)
            System.out.println("PASS!");
        else 
            System.out.println("NO PASS!");
    }
    public static void main(String[] args)
    {
        testgoodDeal(true, 100, 74, true);
        testgoodDeal(false, 100, 76, false);
    }
}