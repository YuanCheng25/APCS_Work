import java.util.*;

public class ReverseAll{
public static ArrayList<String> reverseAll(String[] words)
{
ArrayList<String> result=new ArrayList<String>();
    for(String word: words){
        String answer="";
        int n=word.length();
        for(int i=n;i>0;i--)
        {
            answer+=word.substring(i-1,i);
        }
    result.add(answer);
}
    return result;
}
public static void main(String[] args){
    String[] words1 = {"abcd", "xyz"};
   ArrayList<String> reversed1 = reverseAll(words1);
        System.out.println(reversed1);
        System.out.println();
    
     String[] words2 = {"1234", "5678"};
   ArrayList<String> reversed2 = reverseAll(words2);
        System.out.println(reversed2);
        System.out.println();
    
     String[] words3 = {"racecar", "tacocat","izzi"};
   ArrayList<String> reversed3 = reverseAll(words3);
        System.out.println(reversed3);
        System.out.println();
    }
}