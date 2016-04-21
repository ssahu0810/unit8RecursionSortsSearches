import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class PersonTester
{
    public static void main(String[] args)
    {
        ArrayList<Person> people = new ArrayList<Person>(10); 
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i<11; i++)
        {
            System.out.println("What is the name of person number " +i+"?");
            String name = scan.next();
            Person person1 = new Person(name);
            people.add(person1);
        }
        Collections.sort(people);
        System.out.println(people.get(0).toString());
        System.out.println(people.get(9).toString());
    }
}