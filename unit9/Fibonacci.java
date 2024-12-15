import java.util.*;

public class Fibonacci{
public static ArrayList<Integer> fibonacci(int n)
{
    ArrayList<Integer> result = new ArrayList<Integer>();
     int a=1;
    result.add(a);
      int b=1;
    result.add(b);
    for(int i=2; i<n; i++){
            int c=a+b;
            result.add(c);
             a=b;
             b=c;
    }
    return result;
}
    public static void main(String[] args){
         ArrayList<Integer> Fibonacci2=fibonacci(2);
        System.out.println("Fibonacci 2" + Fibonacci2);
        
         ArrayList<Integer> Fibonacci3=fibonacci(3);
        System.out.println("Fibonacci 3" + Fibonacci3);
        
         ArrayList<Integer> Fibonacci4=fibonacci(4);
        System.out.println("Fibonacci 4" + Fibonacci4);
        
        ArrayList<Integer> Fibonacci5=fibonacci(5);
        System.out.println("Fibonacci 5" + Fibonacci5);
    }
}