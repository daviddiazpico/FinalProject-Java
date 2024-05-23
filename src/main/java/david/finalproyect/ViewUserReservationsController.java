package david.finalproyect;

import david.finalproyect.classes.*;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewUserReservationsController implements IController
{
    Admin admin;
    @FXML
    Button btnComeBack;
    @FXML
    Label lblReservations;
    @FXML
    TextField tfDni;
    @FXML
    Button btnShowReservations;

    public void initialitze(Admin admin)
    {
        this.admin = admin;
    }

    @FXML
    private void showReservations()
    {
        String dniBuscar = tfDni.getText();

        if (admin.getUsers().containsKey(dniBuscar))
        {
            lblReservations.setText(admin.getUsers().get(dniBuscar).viewReservations());
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
