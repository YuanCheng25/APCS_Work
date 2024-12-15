public class findMax {
public static double maxValue(double[] values){
    if(values==null || values.length==0)
    {
        return Double.NaN;
    }
    double result=values[0];
    for(double value: values)
    {
        if(value>result)
            result=value;
    }
    return result;
}
    public static void testfindMax(double[] values, double expected)
    {
        double answer=maxValue(values);
        
        for(double value: values)
            System.out.println(value + "");
        System.out.println("expected:" + expected + "answer" + answer);
        
        if(expected==answer)
            System.out.println("Yay");
        else
            System.out.println("No");
    }
    
    public static void main(String[] args){
        double[] values={1.0,2.1,5.3};
        System.out.println("max:"+ maxValue(values));
        double[] values2={0.0,-35.0,90.1};
        System.out.println("max:"+ maxValue(values2));
        testfindMax(values,5.3);
        testfindMax(values2,90.1);
    }
}