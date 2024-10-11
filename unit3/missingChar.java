public class missingChar
{
public static String missingChar(String str, int n) {
  String front = str.substring(0, n);
  String back = str.substring(n+1, str.length());
  
  return front + back;
}
    


    public static void testmissingChar(String str, int n, String expected)
    {
        String result = missingChar(str,n);

        System.out.print(str + n + " expected: " + expected + " result: " + result);
        
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

        testmissingChar("kitten",1, "ktten");
        testmissingChar("kitten",0, "itten");
        testmissingChar("kitten",3, "kiten");

    }

}