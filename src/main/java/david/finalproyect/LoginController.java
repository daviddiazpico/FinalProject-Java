package david.finalproyect;

import david.finalproyect.classes.*;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.*;

public class LoginController implements IController
{
    @FXML
    TextField tfUsername;
    @FXML
    TextField tfPassword;
    @FXML
    Button btnEnter;
    @FXML
    Button btnExit;

    //List<Person> users = Person.load();
    List<Person> users = CrearUsuarios();
    public List<Person> CrearUsuarios()
    {
        List<Person> users = new ArrayList<Person>();
        users.add(new Member("Ismael", "dni1", 19, "i1234"));
        users.add(new Member("Sergi", "dni1", 19, "s1234"));
        users.add(new Member("Alvaro", "dni1", 18, "a1234"));
        users.add(new Member("Elvis", "dni1", 20, "e1234"));
        users.add(new Coach("Jose", "dni1", 22, "j1234"));
        users.add(new Coach("Bilel", "dni1", 18, "b1234"));
        users.add(new Admin("David", "dni1", 19, "d1234"));

        return users;
    }

    @FXML
    public void checkData()
    {
        String username, passwd;
        username = tfUsername.getText();
        passwd = tfPassword.getText();

        for (Person person: users)
        {
            if (person.getName().equals(username) && person.getPassword().equals(passwd))
            {
                if (person instanceof Admin)
                {
                    FXMLLoader loader = Utils.changeScene("menuAdmin-view.fxml", this, btnEnter);
                    MenuAdminController controller = loader.getController();
                    controller.initialitze(person);
                }
                else
                {
                    FXMLLoader loader = Utils.changeScene("menuPerson-view.fxml", this, btnEnter);
                    MenuPersonController controller = loader.getController();
                    controller.initialitze(person);
                }
            }
        }
    }

    @FXML
    public void closeProgram()
    {
        Stage currentStage = (Stage)this.btnExit.getScene().getWindow();
        currentStage.close();
    }
}