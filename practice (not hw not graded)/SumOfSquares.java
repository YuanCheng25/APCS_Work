public class SumOfSquares {
public static double sumOfSquares(double[] values){
double sum=0.0;
for(int i=0; i<values.length; i++) {
    sum+=values[i]*values[i];
}
    return sum;
}
  public static void testsumOfSquares(double[] values, double expected)
    {
        double answer=sumOfSquares(values);
        
        for(double value: values)
            System.out.println(value + "");
        System.out.println("expected:" + expected + "answer" + answer);
        
        if(expected==answer)
            System.out.println("Yay");
        else
            System.out.println("No");
    }
    public static void main(String[] args)
    {
        double[] values={0};
        double[] values2={1.0,2.0,3.0};
        double[] values3={2.0,2.0,2.0};
        
        testsumOfSquares(values,0);
        testsumOfSquares(values2,14.0);
        testsumOfSquares(values3,12.0);

    }
}