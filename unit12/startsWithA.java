import java.util.*;

public class startsWithA {
    public static void printArrays2(String[][] values2){
        for(int i=0; i<values2.length; i++){
            for(int j=0; j<values2[i].length; j++)
            {
                System.out.print(values2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int startsWithA(String[][] values2){
        int result=0;
         for(int i=0; i<values2.length; i++){
            for(int j=0; j<values2[i].length; j++)
            {
                if(values2[i][j].startsWith("A"))
                    result+=1;
            }
         }
        return result;
    }
    
    public static void main(String args[]){
    String[][] values2= {
        {"Work", "Aureole", "Rest"},
        {"Armani", "Work", "Aurora"}
    };
        printArrays2(values2);
    System.out.println(startsWithA(values2));
}
}