public class factorial{
static int factorial(int n) {
    int multiplication = 1;
    for(int i=n; i>0; i--){
        multiplication*=i;
    }
    
    return multiplication;
}
     public static void testfactorial(int n, int expected)
    {
        int result = factorial(n);

        System.out.print(n + " expected: " + expected + " result: " + result);

        if (result==expected)
            System.out.print(" I am a winner!");
        else
            System.out.print(" I am sad.");

        System.out.println();
    }

    public static void main(String[] args)
    {
        testfactorial(0,1);
        testfactorial(1,1);
        testfactorial(2,2);
        testfactorial(3,6);
        testfactorial(4,24);
        testfactorial(5,120);
        testfactorial(6,720);
        testfactorial(7,5040);
    }
}