package david.finalproyect.classes;

import java.util.Map;

/**
 * Represents an administrator of the reservation system.
 */
public class Admin extends Person
{
    /** A map of users where the key is the user's DNI and the value is the Person object. */
    Map<String, Person> users;

    /**
     * Constructs a new Admin object with specified attributes.
     *
     * @param name     The name of the admin.
     * @param dni      The DNI of the admin.
     * @param age      The age of the admin.
     * @param password The password for the admin's account.
     */
    public Admin(String name, String dni, int age, String password) {
        super("Admin", name, dni, age, password);
        this.users = null;
    }

    /**
     * Retrieves the map of users.
     *
     * @return The map of users.
     */
    public Map<String, Person> getUsers() {
        return users;
    }

    /**
     * Sets the map of users.
     *
     * @param users The map of users to set.
     */
    public void setUsers(Map<String, Person> users) {
        this.users = users;
    }

    /**
     * Adds a person to the map of users.
     *
     * @param person The person to add.
     */
    public void addPerson(Person person) {
        users.put(person.getDni(), person);
    }

    /**
     * Removes a person from the map of users.
     *
     * @param person The person to remove.
     */
    public void removePerson(Person person) {
        users.remove(person.getDni());
    }
}
