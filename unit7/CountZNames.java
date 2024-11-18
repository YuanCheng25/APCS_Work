public class CountZNames {
    public static int countZNames(String[] n){
    int result=0;
    for(String str: n) {
    if(str.substring(0,1).equals("z") || str.substring(0,1).equals("Z"))
    result+=str.length();
    }
    return result;
    }
     public static void testcountZNames(String[] n, int expected)
    {
        int answer=countZNames(n);
        
        for(String str: n)
            System.out.println(str + "");
        System.out.println("expected: " + expected + "answer: " + answer);
        
        if(expected==answer)
            System.out.println("Yay");
        else
            System.out.println("No");
    }
    public static void main(String[] args)
    {
        String[] n={"Dr. Kessner", "Dr. Sands"};
        String[] n2={"Zorro", "zero", "zippy"};
        
        testcountZNames(n,0);
        testcountZNames(n2,14);

    }
}
