package david.finalproyect;

import david.finalproyect.classes.Admin;
import david.finalproyect.classes.Person;
import david.finalproyect.classes.Reservation;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddReservationAdminController implements IController
{
    Admin admin;
    @FXML
    TextField tfDni;
    @FXML
    TextField tfCourtNumber;
    @FXML
    Button btnAdd;
    @FXML
    Button btnComeBack;

    public void initialitze(Admin admin)
    {
        this.admin = admin;
    }

    @FXML
    private void addReservation()
    {
        if (admin.getUsers().containsKey(tfDni.getText()))
        {
            Person person = admin.getUsers().get(tfDni.getText());
            person.addReservation(new Reservation(person, Integer.parseInt(tfCourtNumber.getText())));
        }

        comeBackToMenu();
    }

    @FXML
    private void comeBackToMenu()
    {
        FXMLLoader loader = Utils.changeScene("menuAdmin-view.fxml", this, btnComeBack);
        MenuAdminController controller = loader.getController();
        controller.initialitze(admin);
    }
}
