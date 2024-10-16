public class stringTimes
{
public static String stringTimes(String str, int n) {
  String result = "";
  for (int i=0; i<n; i++) {
    result = result + str;  // could use += here
  }
  return result;
}


    public static void teststringTimes(String str, int n, String expected)
    {
        String result = stringTimes(str,n);

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

        teststringTimes("Hi",2, "HiHi");
        teststringTimes("Hi",3, "HiHiHi");
        teststringTimes("Hi",1, "Hi");

    }

}
