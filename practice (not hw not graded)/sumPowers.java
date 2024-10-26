public class sumPowers
{
    public static int sumPowers(int n)
    {
        int result=0;
        for (int i=0; i<n; i++){
        result+=Math.pow(2,i);
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        System.out.println(sumPowers(4));
    }
}