public class Greetings
{
    public static String greetings(String name)
    {
        String answer;
        answer="Hello," + name + "how are you?";
        return answer;
    }
        public static void main(String[] args)
    {
       System.out.println(greetings("Dr.Kessner")); 
    }
}