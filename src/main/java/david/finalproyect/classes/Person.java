package david.finalproyect.classes;

import david.finalproyect.interfaces.IViewAddRemoveReservations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a person associated with the sports project.
 * This is an abstract class that implements reservation-related functionality
 * and supports serialization.
 */
public abstract class Person implements IViewAddRemoveReservations, Serializable {

    /** The type of person (ex., "Member", "Coach"). */
    String type;

    /** The name of the person. */
    String name;

    /** The DNI of the person. */
    String dni;

    /** The age of the person. */
    int age;

    /** The password for the person's account. */
    String password;

    /** List of reservations associated with the person. */
    List<Reservation> reservations;

    /**
     * Constructs a new Person object with specified attributes.
     *
     * @param type     The type of the person (e.g., "Member", "Coach").
     * @param name     The name of the person.
     * @param dni      The DNI of the person.
     * @param age      The age of the person.
     * @param password The password for the person's account.
     */
    public Person(String type, String name, String dni, int age, String password) {
        this.type = type;
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.password = password;
        reservations = new ArrayList<>();
    }

    /**
     * Constructs a new empty Person object.
     * (Default constructor)
     */
    public Person() { }

    /**
     * Retrieves the type of the person.
     *
     * @return The type of the person.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the person.
     *
     * @param type The type of the person to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The name of the person to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the DNI (national identification document) of the person.
     *
     * @return The DNI of the person.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Sets the DNI (national identification document) of the person.
     *
     * @param dni The DNI of the person to set.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Retrieves the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age The age of the person to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Retrieves the password of the person's account.
     *
     * @return The password of the person's account.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the person's account.
     *
     * @param password The password to set for the person's account.
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Displays the list of reservations.
     * Implementation will be added.
     */
    public void viewReservations()
    {

    }

    /**
     * Adds a new reservation.
     * Implementation will be added.
     */
    public void addReservation()
    {

    }

    /**
     * Removes existing reservations.
     * Implementation will be added.
     */
    public void removeReservations()
    {

    }

    /**
     * Returns a string representation of the person.
     * The format is: DNI - Name - Age
     */
    @Override
    public String toString() {
        return dni + " - " + name + " - " + age;
    }

    /**
     * Compares this person to another object.
     *
     * @param o The object to compare to.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(dni, person.dni);
    }

    /**
     * Generates a hash code for the person.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    /**
     * Saves a list of Person objects to a file using serialization.
     *
     * @param users The list of Person objects to save.
     */
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

    /**
     * Loads a list of Person objects from a file using deserialization.
     *
     * @return The list of loaded Person objects.
     */
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
        catch (ClassNotFoundException mes)
        {
            System.err.println(mes.getMessage());
        }

        return users;
    }
}
