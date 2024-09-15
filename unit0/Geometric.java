public class Geometric
{
    public static void main(String[] args)
    {
        int a=2;
        int r=3;
        int b;
        for(int i=1; i<=10; i++)
        {
            b=a*(int)(Math.pow(r,i-1));
            System.out.println(b);
        }
    }
}
    