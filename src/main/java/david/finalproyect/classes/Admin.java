package david.finalproyect.classes;

/**
 * Represents an administrator of the reservation system.
 */
public class Admin extends Person
{
    /**
     * Constructs a new Admin object with specified name, age, and password.
     *
     * @param name     The name of the administrator.
     * @param age      The age of the administrator.
     * @param password The password for the administrator's account.
     */
    public Admin(String name, String dni, int age, String password) {
        super("Admin", name, dni, age, password);
    }

    /**
     * Displays the list of reservations.
     * Implementation will be added in future development.
     */
    public String viewReservations()
    {
        return null;
    }

    /**
     * Adds a new reservation to the system.
     * Implementation will be added in future development.
     */
    public void addReservation()
    {
    }

    /**
     * Removes existing reservations from the system.
     * Implementation will be added in future development.
     */
    public void removeReservations()
    {
    }
}
