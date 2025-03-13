public class twoDComputations{
    public static void printArray(int[][] coolNumbers){
        for(int[] row: coolNumbers){
            for(int num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    System.out.println();
    }
    
    public static int smallestInput(int[][] coolNumbers){
      int result=coolNumbers[0][0];
        for(int[] row : coolNumbers){
            for(int num : row) {
           if (num < result) {
                    result = num;
            }
        }
    }
                return result;
    }
    
    public static void main(String[] args){
        int[][] coolNumbers = {
            {3, 5, 7},
            {2, 3, 6},
            {1, 0}
        };
    printArray(coolNumbers);
    System.out.println(smallestInput(coolNumbers));
    }
}