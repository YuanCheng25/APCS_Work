import java.util.*;

public class SumOfSquares {
    public static double sumOfSquares(ArrayList<Double> values) {
        double result=0.0;
        
        for(double value: values) {
            result+=value*value;
        }
        return result;
    }
    
    public static void testsumOfSquares(ArrayList<Double> values, double expected)
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
        ArrayList<Double> values=new ArrayList<Double>();
        values.add(0.0);
        
        ArrayList<Double> values2=new ArrayList<Double>();
        values2.add(1.0);
        values2.add(2.0);
        values2.add(3.0);
        
        ArrayList<Double> values3=new ArrayList<Double>();
        values3.add(2.0);
        values3.add(2.0);
        values3.add(2.0);
        
        testsumOfSquares(values,0);
        testsumOfSquares(values2,14.0);
        testsumOfSquares(values3,12.0);
    }
}