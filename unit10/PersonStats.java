import java.util.*;

public class PersonStats 
{
public static int averagePets(ArrayList<Person> people)
{
    int result=0;
    for(Person person: people)
    {
        result += person.getPets();
    }
    return result/people.size();
}

    
public static String mostPets(ArrayList<Person> people)
{
Person mostPets=people.get(0);
    for(Person person: people)
    {
        if(person.getPets() > mostPets.getPets())
            mostPets=person;
    }
    return mostPets.getName();
}

public static ArrayList<String> twoplusPets(ArrayList<Person> people)
{
ArrayList<String> solution = new ArrayList<String>();    
    for(Person person: people)
    {
    if(person.getPets() >= 2)
        solution.add(person.getName());
    }
    return solution;
}

    
public static void testAveragePets() {
    PersonStats calculator = new PersonStats();
    ArrayList<Person> people = new ArrayList<>();
    
    people.add(new Person("Lilian", 3));
    people.add(new Person("Mandy", 20));
    people.add(new Person("Tina", 1));
    people.add(new Person("Joelle", 0));
    int expected=6;
    int answer=calculator.averagePets(people);
       if(expected==answer)
            System.out.println("Yay");
        else
            System.out.println("No");
}
    
    public static void testMostPets() {
        PersonStats calculator = new PersonStats();
        ArrayList<Person> people = new ArrayList<>();
        
 people.add(new Person("Lilian", 3));
    people.add(new Person("Mandy", 20));
    people.add(new Person("Tina", 1));
    people.add(new Person("Joelle", 0));
 String expected2="Mandy";
    String answer2=calculator.mostPets(people);
       if(expected2==answer2)
            System.out.println("Yay");
        else
            System.out.println("No");
    }
    
    public static void testtwoplusPets() {
        PersonStats calculator = new PersonStats();
        ArrayList<Person> people = new ArrayList<>();
        
 people.add(new Person("Lilian", 3));
    people.add(new Person("Mandy", 20));
    people.add(new Person("Tina", 1));
    people.add(new Person("Joelle", 0));
 ArrayList<String>expected2=new ArrayList<>();
        expected2.add("Lilian");
        expected2.add("Mandy");
 ArrayList<String> answer2=calculator.twoplusPets(people);
       if(expected2.equals(answer2))
            System.out.println("Yay");
        else
            System.out.println("No");
    }
    
    public static void main(String[] args) {        
        
   PersonStats calculator = new PersonStats();
        ArrayList<Person> people = new ArrayList<>();
        
 people.add(new Person("Lilian", 3));
    people.add(new Person("Mandy", 20));
    people.add(new Person("Tina", 1));
    people.add(new Person("Joelle", 0));
        
        System.out.println("Average pets:" + calculator.averagePets(people));
        System.out.println("Most amount of pets: " + calculator.mostPets(people));
         System.out.println("At least two pets: " + calculator.twoplusPets(people));
        
        testAveragePets();
        testMostPets();
        testtwoplusPets();
    }
}
