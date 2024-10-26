public class Interlace {
    public static String interlace(String w, String s) 
    {
        String result="";
        for(int i=0; i<(s.length()); i++)
        {
            result+=w.substring(i,i+1);
            result+=s.substring(i,i+1);
        }
    return result;
    }
    public static void main(String args[])
    {
        System.out.println(interlace("abc", "123"));
    }
}