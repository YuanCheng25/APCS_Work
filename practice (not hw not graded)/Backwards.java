public class Backwards {
    public static String backwards(String s)
    {
        String result="";
        int n=s.length();
        for(int i=n;i>0;i--)
        {
            result+=s.substring(i-1,i);
        }
        return result;
    }
    public static void main(String args[])
    {
        System.out.println(backwards("Bad"));
    }
}