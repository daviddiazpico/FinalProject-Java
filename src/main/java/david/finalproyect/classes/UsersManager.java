package david.finalproyect.classes;

import java.io.IOException;
import java.util.Map;

/**
 * Singleton class that manages user data.
 * It reads the user data from a file at the time of its instantiation.
 */
public class UsersManager
{
    /** The singleton instance of UsersManager. */
    static UsersManager instance;

    /** A map of users where the key is the user's DNI and the value is the Person object. */
    Map<String, Person> users;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the user data by reading from a file.
     */
    private UsersManager()
    {
        try
        {
            users = Utils.readFile();
        }
        catch (IOException ioException)
        {
            System.err.println(ioException.getMessage());
        }
    }

    /**
     * Retrieves the singleton instance of UsersManager.
     * If the instance is null, it creates a new instance.
     *
     * @return The singleton instance of UsersManager.
     */
    public static UsersManager getInstance()
    {
        if (instance == null)
        {
            instance = new UsersManager();
        }

        return instance;
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
}
