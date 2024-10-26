public class MagicEightBall {
    private final String reply1 = "It is certain";
    private final String reply2 = "Without a doubt";
    private final String reply3 = "Most likely";
    private final String reply4 = "Ask again later";
    private final String reply5 = "Idk now";
    private final String reply6 = "Don't count on it";
    private final String reply7 = "Very doubtful";
    private final String reply8 = "Nuh uh";
    
    public String ask(String question) {
        int b = (int)(Math.random() * 8);
        
        if(b==1)
            return reply1;
        else if(b==2)
            return reply2;
         else if(b==3)
            return reply3;
        else if(b==4)
            return reply4;
        else if(b==5)
            return reply5;
         else if(b==6)
            return reply6;
         else if(b==7)
            return reply7;
         else if(b==8)
            return reply8;
        else 
            return "nothing";
    }
}
