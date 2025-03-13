import java.util.*;

public class twoDArrays {
    public static void printArrays(int[][] values){
        for(int i=0; i<values.length; i++){
            for(int j=0; j<values[i].length; j++)
            {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void printArrays2(String[][] values2){
        for(int i=0; i<values2.length; i++){
            for(int j=0; j<values2[i].length; j++)
            {
                System.out.print(values2[i][j] + " ");
            }
            System.out.println();
        }
    }
    
     public static void printArrays3(double[][] values3){
        for (double[] row : values3) {
            for (Double num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
     public static void printArrays4(int[][] values4) {
        for (int[] row : values4) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String args[]){
       int[][] values=new int[10][10];
    for (int i = 0; i < 10; i++) {
        for(int j = 0; j<10; j++){
            if(i==j)
                values[i][j]=1;
            else
                values[i][j]=0;
        }
    }
    printArrays(values);
        
    String[][] values2= {
        {"Work", "Aureole", "Rest"},
        {"Armani", "Work", "Aurora"}
    };
        printArrays2(values2);
        
 double[][] values3 = new double[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                values3[i][j] = (i + 1) * 10 + (j + 1); 
            }
        }
            printArrays3(values3);
        
int[][] values4 = new int[6][5];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                values4[i][j] = i + 1;
            }
        }
        printArrays4(values4);
}
}