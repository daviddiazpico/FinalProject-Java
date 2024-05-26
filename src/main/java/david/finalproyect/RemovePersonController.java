package david.finalproyect;

import david.finalproyect.classes.Admin;
import david.finalproyect.classes.Member;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RemovePersonController implements IController
{
    Admin admin;
    @FXML
    TextField tfDni;
    @FXML
    Button btnComeBack;
    @FXML
    Button btnRemove;

    public void initialitze(Admin admin)
    {
        this.admin = admin;
    }

    @FXML
    private void removePerson()
    {
        if (admin.getUsers().containsKey(tfDni.getText()))
        {
            admin.removePerson(new Member(tfDni.getText()));
            comeBackToMenu();
        }
    }

    @FXML
    private void comeBackToMenu()
    {
        FXMLLoader loader = Utils.changeScene("menuAdmin-view.fxml", this, btnComeBack);
        MenuAdminController controller = loader.getController();
        controller.initialitze(admin);
    }
}
