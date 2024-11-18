import java.util.*;

public class CountZNames {
    public static int countZNames(ArrayList<String> names) {
        int result=0;
        
        for(int i=0; i< names.size(); i++) {
            String name = names.get(i);
        if(name.substring(0,1).equals("z")||name.substring(0,1).equals("Z"))
            result+=name.length();
        }
      return result;
        }
  public static void testcountZNames(ArrayList<String> names, int expected)
    {
        int answer=countZNames(names);
        
        for(String name: names)
            System.out.println(name + "");
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
        
        ArrayList<String> names=new ArrayList<String>();
        names.add("Dr.Kessner");
        names.add("Dr.Sands");

        ArrayList<String> names2=new ArrayList<String>();
        names2.add("Zorro");
        names2.add("zero");
        names2.add("zippy");
        
        testcountZNames(names,0);
        testcountZNames(names2,14);
    }
}

