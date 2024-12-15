import java.util.*;

public class FilterGoodScores{
public static ArrayList<Integer> filterGoodScores(int[] values){
ArrayList<Integer> result = new ArrayList<Integer>();
    for(int value: values)
    {
        if(value>90)
            result.add(value);
    }
    return result;
}
    
    public static void main(String[] args){
      int[] values={51,52,53,100};
        ArrayList<Integer> goodScores = filterGoodScores(values);
        System.out.print("good scores: ");
        for (double value : goodScores)
            System.out.print(value + " ");
        System.out.println();
        
        
        int[] values2={92,89,90,99};
        ArrayList<Integer> goodScores2=filterGoodScores(values2);
        System.out.print("good scores: ");
        for (double value : goodScores2)
            System.out.print(value + " ");
        System.out.println(); 
    }
}