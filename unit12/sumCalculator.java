public class sumCalculator {
    public static float sumOf2DArray(float[][] values) {
        float sum = 0;
        for (int i = 0; i < values.length; i++) { 
            for (int j = 0; j < values[i].length; j++) { 
                sum += values[i][j]; 
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        float[][] values = {
            {2.2f, 1.6f, 4.1f},
            {4.1f, 5.3f, 5.3f},
            {7.8f, 7.2f, 9.6f}
        };

        System.out.println(sumOf2DArray(values));

}
}
