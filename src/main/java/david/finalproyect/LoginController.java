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
    Map<String, Person> users = UsersManager.getInstance().getUsers();
    @FXML
    TextField tfUsername;
    @FXML
    TextField tfPassword;
    @FXML
    Button btnEnter;
    @FXML
    Button btnExit;

    @FXML
    public void checkData()
    {
        String username, passwd;
        username = tfUsername.getText();
        passwd = tfPassword.getText();

        for (Person person: users.values())
        {
            if (person.getName().equals(username) && person.getPassword().equals(passwd))
            {
                if (person instanceof Admin)
                {
                    ((Admin)person).setUsers(users);
                    FXMLLoader loader = Utils.changeScene("menuAdmin-view.fxml", this, btnEnter);
                    MenuAdminController controller = loader.getController();
                    controller.initialitze((Admin)person);
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
        for (Person person: users.values())
            System.out.println(person);
        Utils.saveUsersInFile(users);
    }

}