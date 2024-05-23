package david.finalproyect.classes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UsersManager
{
    static UsersManager instance;

    Map<String,Person> users;

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

    public static UsersManager getInstance()
    {
        if (instance == null)
        {
            instance = new UsersManager();
        }

        return instance;
    }

    public Map<String, Person> getUsers() {
        return users;
    }

    public void setUsers(Map<String, Person> users) {
        this.users = users;
    }
}
