import java.util.*;

public class ItemCalculator 
{
    public static void printItems(ArrayList<Item> items){
     for (Item item: items)
         System.out.println(item.getName() + " is worth $" + item.getPrice());
    }

public static float averagePrice(ArrayList<Item> items)
{
    float result=0;
    for(Item item: items)
    {
        result += item.getPrice();
    }
    return result/items.size();
}

    
public static String mostExpensive(ArrayList<Item> items)
{
Item mostExpensive=items.get(0);
    for(Item item: items)
    {
        if(item.getPrice() > mostExpensive.getPrice())
            mostExpensive=item;
    }
    return mostExpensive.getName();
}
    
public static void testAveragePrice() {
    ItemCalculator calculator = new ItemCalculator();
    ArrayList<Item> items = new ArrayList<>();
    
    items.add(new Item("Purse", 50));
    items.add(new Item("Lipstick", 100));
    items.add(new Item("Candle", 20));
    items.add(new Item("Necklace", 30));
    float expected=50;
    float answer=calculator.averagePrice(items);
       if(expected==answer)
            System.out.println("Yay");
        else
            System.out.println("No");
}
    
    public static void testMostExpensive() {
        ItemCalculator calculator = new ItemCalculator();
        ArrayList<Item> items = new ArrayList<>();
        
   items.add(new Item("Purse", 50));
    items.add(new Item("Lipstick", 100));
    items.add(new Item("Candle", 20));
    items.add(new Item("Necklace", 30));
 String expected2="Lipstick";
    String answer2=calculator.mostExpensive(items);
       if(expected2==answer2)
            System.out.println("Yay");
        else
            System.out.println("No");
    }
    
    
    public static void main(String[] args) {        
        
        ItemCalculator calculator = new ItemCalculator();
        ArrayList<Item> items = new ArrayList<>();
        
        items.add(new Item("Purse", 50));
        items.add(new Item("Lipstick", 100));
        items.add(new Item("Candle", 20));
        items.add(new Item("Necklace", 30));
        
        calculator.printItems(items);
        
        System.out.println("Average price: $" + calculator.averagePrice(items));
        System.out.println("Most expensive item: " + calculator.mostExpensive(items));
        
        testAveragePrice();
        testMostExpensive();
    }
}
