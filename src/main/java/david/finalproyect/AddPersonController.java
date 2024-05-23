package david.finalproyect;

import david.finalproyect.classes.Admin;
import david.finalproyect.classes.Coach;
import david.finalproyect.classes.Member;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddPersonController implements IController
{
    Admin admin;
    @FXML
    ComboBox cbmType;
    @FXML
    TextField tfDni;
    @FXML
    TextField tfName;
    @FXML
    TextField tfAge;
    @FXML
    TextField tfPassword;
    @FXML
    Button btnAdd;

    public void initialitze(Admin admin)
    {
        this.admin = admin;
        cbmType.getItems().addAll("Member", "Coach");
    }

    @FXML
    private void addPerson()
    {
        if (!(admin.getUsers().containsKey(tfDni.getText())))
        {
            String type = (String)cbmType.getSelectionModel().getSelectedItem();
            if (type.equals("Member"))
            {
                admin.addPerson(new Member(tfName.getText(), tfDni.getText(),
                        Integer.parseInt(tfAge.getText()), tfPassword.getText()));
            }
            else if (type.equals("Coach"))
            {
                admin.addPerson(new Coach(tfName.getText(), tfDni.getText(),
                        Integer.parseInt(tfAge.getText()), tfPassword.getText()));
            }

            comeBackToMenu();
        }
    }

    @FXML
    private void comeBackToMenu()
    {
        FXMLLoader loader = Utils.changeScene("menuAdmin-view.fxml", this, btnAdd);
        MenuAdminController controller = loader.getController();
        controller.initialitze(admin);
    }
}
