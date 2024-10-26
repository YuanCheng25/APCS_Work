public class FindLastE {
    public static int findLastE(String w)
    {
        int n=0;
        for(int i=0; i<w.length(); i++)
        {
          String l=w.substring(i,i+1);
            if(l.equals("e"))
                n+=1;
            if(n==2)
            return i;
        }
        return -1;
    }
    
    public static void main(String args[])
    {
        System.out.println(findLastE("exercise"));
    }
}