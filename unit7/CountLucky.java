public class CountLucky
{
    public static int countLucky(int[] values){
    int result=0;
    for(int value: values){
        if(value%7==0||Math.abs(value)%10==7)
            result+=1;
        }
        return result;  
    }
    public static void testcountLucky(int[] values, int expected)
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
        int[] values={1,2,3};
        int[] values2={7,13,17};
        int[] values3={107,207};
        
        testcountLucky(values,0);
        testcountLucky(values2,2);
        testcountLucky(values3,2);

    }
}