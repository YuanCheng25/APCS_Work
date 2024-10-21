public class Person
{
    public Person(String nameIn)
    {
        name = nameIn;
    }

    public void greeting()
    {
        System.out.println("Hello, my name is " + name);
        System.out.println("and I have this many pets: " + petCount);
    }

    public void setName(String newName)
    {
        name = newName;  
    }

    public String getName()
    {
        return name;
    }
    
    private String name;
    private static final int petCount = 1;
    
     public static void main(String[] args)
    {
        Person sally = new Person("Sally");
       
        sally.greeting();

        Person lola = new Person("Lola");
        lola.greeting();
    }
}
