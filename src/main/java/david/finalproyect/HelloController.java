package david.finalproyect;

import data.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.*;

public class HelloController
{
    @FXML
    TextField tfUsername;
    @FXML
    TextField tfPassword;
    @FXML
    Button btnEnter;

    List<Person> users = Person.load();
    /*List<Person> users = CrearUsuarios();
    public List<Person> CrearUsuarios()
    {
        List<Person> users = new ArrayList<Person>();
        users.add(new Member("Ismael", "dni1", 19, "i1234"));
        users.add(new Member("Sergi", "dni1", 19, "s1234"));
        users.add(new Member("Alvaro", "dni1", 18, "a1234"));
        users.add(new Member("Elvis", "dni1", 20, "e1234"));
        users.add(new Coach("Jose", "dni1", 22, "j1234"));
        users.add(new Coach("David", "dni1", 18, "d1234"));

        return users;
    }*/

    public void checkData()
    {
        String username, passwd;
        username = tfUsername.getText();
        passwd = tfPassword.getText();

        for (Person p: users)
        {
            if (p.getName().equals(username) && p.getPassword().equals(passwd))
            {
                System.out.println("Loged");
            }
        }
    }
}