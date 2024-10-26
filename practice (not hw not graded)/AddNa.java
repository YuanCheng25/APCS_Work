public class AddNa {
    public static String addNa(String str, int n)
    {
        String result= "ba" + "";
        for (int i=0; i<n; i++)
        {
          result=result + str;            
        }
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(addNa("na", 3));
        System.out.println(addNa("na", 2));
    }
}