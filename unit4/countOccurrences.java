
public class countOccurrences
{
    public static int countOccurrences(String s, String w)
    {
        int total = 0;

        for (int i=0; i<(s.length()-w.length()+1); i++)
        {
            String sub = s.substring(i, i+w.length());
            if (sub.equals(w))
                total += 1; 
        }

        return total;
    }

    
    public static int sum(int n)
    {
        int total = 0;

        for (int i=1; i<=n; i++) 
        {
            total += i;
        }

        return total;
    }

public static void testcountOccurrences(String s, String w, int expected)
    {
        int result = countOccurrences(s, w);

        System.out.print(s + w + " expected: " + expected + " result: " + result);
        
        if (result==expected)
            System.out.print(" I am a winner!");
        else
            System.out.print(" I am sad.");

        System.out.println();
    }

    public static void main(String[] args)
    {
        testcountOccurrences("Mississippi","iss", 2);
        testcountOccurrences("banananana","na", 4);
        testcountOccurrences("LaLaLand","La", 3);
        testcountOccurrences("Sally","ll", 1);
    }
}

