public class sumOfSquares{
static int sumOfSquares(int n) {
    int sum = 0;
    for(int i=n; i>0; i--){
        sum+=(i*i);
    }
    
    return sum;
}
     public static void testsumOfSquares(int n, int expected)
    {
        int result = sumOfSquares(n);

        System.out.print(n + " expected: " + expected + " result: " + result);

        if (result==expected)
            System.out.print(" I am a winner!");
        else
            System.out.print(" I am sad.");

        System.out.println();
    }

    public static void main(String[] args)
    {
        testsumOfSquares(1,1);
         testsumOfSquares(2,5);
        testsumOfSquares(3,14);
        testsumOfSquares(4,30);
        testsumOfSquares(5,55);

    }
}