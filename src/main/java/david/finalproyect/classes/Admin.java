package david.finalproyect.classes;

import java.util.Map;

/**
 * Represents an administrator of the reservation system.
 */
public class Admin extends Person
{
    Map<String, Person> users;

    public Admin(String name, String dni, int age, String password) {
        super("Admin", name, dni, age, password);
        this.users = null;
    }

    public Map<String, Person> getUsers() {
        return users;
    }

    public void setUsers(Map<String, Person> users) {
        this.users = users;
    }

    /**
     * Displays the list of reservations.
     * Implementation will be added in future development.
     */

    public void addPerson(Person person)
    {
        users.put(person.getDni(), person);
    }

    public void removePerson(Person person)
    {
        users.remove(person.getDni());
    }
}
