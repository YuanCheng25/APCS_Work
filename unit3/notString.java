public class notString
{
public static String notString(String str) {
  if (str.length() >= 3 && str.substring(0, 3).equals("not")) 
    return str;
    else
  return "not " + str;
}

    public static void testnotString(String str, String expected)
    {
        String result = notString(str);

        System.out.print(str + " expected: " + expected + " result: " + result);
        
        if (result.equals(expected))
            System.out.print(" I am a winner!");
        else
            System.out.print(" I am sad.");

        System.out.println();
    }


    public static void main(String[] args)
    {
        System.out.println("testing...");

        // unit tests

        testnotString("candy", "not candy");
        testnotString("x", "not x");
        testnotString("not bad", "not bad");

    }

}
