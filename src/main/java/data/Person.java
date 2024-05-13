package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Person implements IViewAddRemoveReservations, Serializable
{
    String type;
    String name;
    String dni;
    int age;
    String password;
    List<Reservation> reservations;

    public Person(String type, String name, String dni, int age, String password)
    {
        this.type = type;
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.password = password;
        reservations = new ArrayList<Reservation>();
    }
    public Person() { }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return dni + " - " + name + " - " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    public static void save(List<Person> users)
    {
        try (ObjectOutputStream serializer = new ObjectOutputStream(
                new FileOutputStream("users.dat")))
        {
            for (Person p: users)
            {
                serializer.writeObject(p);
            }
        }
        catch (IOException mes)
        {
            System.err.println("Error with the files");
        }
        catch (Exception mes)
        {
            System.err.println("Error storing people");
        }
    }

    public static List<Person> load()
    {
        List<Person> users = new ArrayList<Person>();

        try (ObjectInputStream deserializer = new ObjectInputStream(
                new FileInputStream("users.dat")))
        {
            Person p = (Person)deserializer.readObject();
            while (p != null)
            {
                users.add(p);
                p = (Person)deserializer.readObject();
            }
        }
        catch (IOException mes)
        {
            System.err.println("Error with the files");
        }
        catch (Exception mes)
        {
            System.err.println("Error reading people");
        }

        return users;
    }
}
