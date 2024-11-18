import java.util.*;

public class CountLucky
{
    public static int countLucky(ArrayList<Integer> values){
    int result=0;
    for(int value: values){
        if(value%7==0||Math.abs(value)%10==7)
            result+=1;
        }
        return result;  
    }
    
     public static void testcountLucky(ArrayList<Integer> values, int expected)
    {
        int answer=countLucky(values);
        
        for(int value: values)
            System.out.println(value + "");
        System.out.println("expected:" + expected + "answer" + answer);
        
        if(expected==answer)
            System.out.println("Yay");
        else
            System.out.println("No");
    }
    
    public static void main(String[] args)
    {
        ArrayList<Integer> values=new ArrayList<Integer>();
        values.add(1);
        values.add(2);
        values.add(3);
        
        ArrayList<Integer> values2=new ArrayList<Integer>();
        values2.add(7);
        values2.add(13);
        values2.add(17);
        
        ArrayList<Integer> values3=new ArrayList<Integer>();
        values3.add(107);
        values3.add(207);
        
        testcountLucky(values,0);
        testcountLucky(values2,2);
        testcountLucky(values3,2);
    }
}