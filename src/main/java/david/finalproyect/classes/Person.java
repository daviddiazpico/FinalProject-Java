package david.finalproyect.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a person associated with the sports project.
 * This is an abstract class that implements reservation-related functionality
 * and supports serialization.
 */
public abstract class Person implements Serializable {

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
        reservations = new ArrayList<Reservation>();
        reservations.add(new Reservation(this, 3));
        reservations.add(new Reservation(this, 4));
    }

    /**
     * Constructs a new Person object with only a DNI.
     * This constructor can be used for comparison purposes.
     *
     * @param dni The DNI of the person.
     */
    public Person(String dni) {
        this.dni = dni;
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
     * Retrieves the list of reservations associated with the person.
     *
     * @return The list of reservations.
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Displays the list of reservations.
     *
     * @return A string representation of the reservations.
     */
    public String viewReservations() {
        String stringReservation = "";
        for (Reservation r : reservations) {
            stringReservation += r + "\n";
        }
        return stringReservation;
    }

    /**
     * Adds a new reservation.
     *
     * @param reservation The reservation to add.
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /**
     * Removes an existing reservation.
     *
     * @param reservation The reservation to remove.
     */
    public void removeReservations(Reservation reservation) {
        reservations.remove(reservation);
    }

    /**
     * Returns a string representation of the person in file format.
     *
     * @return A string representation of the person in file format.
     */
    public String toStringFileFormat() {
        return type + ";" + name + ";" + dni + ";" + age + ";" + password;
    }

    /**
     * Returns a string representation of the person.
     * The format is: DNI - Name - Age
     *
     * @return A string representation of the person.
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
}
