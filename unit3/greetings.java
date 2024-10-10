public class greetings
{
    public static void main(String[] args)
    {
        testGreetings("Dr.Kessner", "Hello, Dr.Kessner, how are you?");
    }
    public static String greetings(String name)
    {
        String answer;
        answer = "Hello, " + name + ", how are you?";
        return answer;
    }
     public static void testGreetings(String name, String expected)
    {
        String result = greetings("Dr.Kessner");
        System.out.println("expected: " + expected + " result: " + result);
        
        if(result.equals(expected))
            System.out.println("PASS!");
        else 
            System.out.println("NO PASS!");
    }
    }
