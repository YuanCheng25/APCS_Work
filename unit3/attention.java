public class attention {
    
    public static boolean attention(String str) {
        return str.startsWith("Hey, you!");
    }

    public static void testAttention(String str, boolean expected) {
        boolean result = attention(str);

        System.out.print(str +  "expected: " + expected + " result: " + result);
        
        if (result == expected) {
            System.out.print(" I am a winner!");
        } else {
            System.out.print(" I am sad.");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Testing...");

        // Unit tests
        testAttention("Hello, my name is Inigo Montoya.", false);
        testAttention("Hey, you! Give me your code!", true);
        testAttention("Excuse me, Dr.Kessner?", false);
    }
}