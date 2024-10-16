public class stringSplosion
{
public static String stringSplosion(String str) {
  String result = "";
  for (int i=0; i<str.length(); i++) {
    result = result + str.substring(0, i+1);
  }
  return result;
}

 public static void teststringSplosion(String str, String expected)
    {
        String result = stringSplosion(str);

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

        teststringSplosion("Code", "CCoCodCode");
        teststringSplosion("abc", "aababc");
        teststringSplosion("ab","aab");

    }


}