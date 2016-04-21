public class Person implements Comparable<Person>
{
    private String name;
    public Person(String name)
    {
        this.name = name;
    }
    public int compareTo(Person otherPerson)
    {
        return this.name.compareTo(otherPerson.name);
    }
    public String toString()
    {
        return name;
    }
}