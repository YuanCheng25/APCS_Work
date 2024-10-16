public class attention
{
    public static void main(String[] args)
    {
        System.out.println(attention("Hello, mage!"));
        System.out.println(attention("yes, please."));
    }
    public static boolean attention(String str)
    {
       String result=str.substring(0,5);
        if (result.equals("Hello"))
            return true;
        else
            return false;
    }
}