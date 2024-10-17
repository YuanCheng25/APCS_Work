public class reverse
{
    public static String reverse(String s)
    {
        String result="";
        for(int i=s.length(); i>0; i--){
            result+=s.substring(i-1,i);
        }
        return result;
    }
    public static void testreverse(String s, String expected)
    {
        String answer = reverse(s);

        System.out.print(s + " expected: " + expected + " answer: " + answer);

        if (answer.equals(expected))
            System.out.print(" I am a winner!");
        else
            System.out.print(" I am sad.");

        System.out.println();
    }

    public static void main(String[] args)
    {
        testreverse("bad","dab");
        testreverse("Hello, World!","!dlroW ,olleH");
        testreverse("tacocat","tacocat");
        testreverse("kailyn","nyliak");
        testreverse("riley","yelir");
    }
}

