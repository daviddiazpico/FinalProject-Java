package david.finalproyect.classes;

import david.finalproyect.interfaces.IViewAddRemoveReservations;

/**
 * Represents an administrator of the reservation system.
 */
public class Admin implements IViewAddRemoveReservations {

    String name;
    int age;
    String password;

    /**
     * Constructs a new Admin object with specified name, age, and password.
     *
     * @param name     The name of the administrator.
     * @param age      The age of the administrator.
     * @param password The password for the administrator's account.
     */
    public Admin(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    /**
     * Retrieves the name of the administrator.
     *
     * @return The name of the administrator.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the age of the administrator.
     *
     * @return The age of the administrator.
     */
    public int getAge() {
        return age;
    }

    /**
     * Retrieves the password of the administrator.
     * Caution: Avoid exposing passwords in actual implementations.
     *
     * @return The password of the administrator.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Displays the list of reservations.
     * Implementation will be added in future development.
     */
    @Override
    public void viewReservations()
    {
    }

    /**
     * Adds a new reservation to the system.
     * Implementation will be added in future development.
     */
    @Override
    public void addReservation()
    {
    }

    /**
     * Removes existing reservations from the system.
     * Implementation will be added in future development.
     */
    @Override
    public void removeReservations()
    {
    }
}
