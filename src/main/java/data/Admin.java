package data;

public class Admin implements IViewAddRemoveReservations
{
    String name;
    int age;
    String password;

    public Admin(String name, int age, String password)
    {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
