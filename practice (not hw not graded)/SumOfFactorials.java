public class SumOfFactorials {
    public static int sumOfFactorials(int n) {
        int result=0;
        for(int i=0;i<(n+1);i++)
        {
            result+=(i*i);
        }
        return result;
    }
    
    public static void main(String args[])
    {
        System.out.println(sumOfFactorials(4));
    }
}