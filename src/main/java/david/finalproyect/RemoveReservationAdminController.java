package david.finalproyect;

import david.finalproyect.classes.*;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RemoveReservationAdminController implements IController
{
    Admin admin;
    @FXML
    TextField tfDni;
    @FXML
    TextField tfCourtNumber;
    @FXML
    Button btnRemove;
    @FXML
    Button btnComeBack;

    public void initialitze(Admin admin)
    {
        this.admin = admin;
    }

    @FXML
    private void removeReservation()
    {
        if (admin.getUsers().containsKey(tfDni.getText()))
        {
            int courtNum = Integer.parseInt(tfCourtNumber.getText());
            Person person = admin.getUsers().get(tfDni.getText());

            if (person.getReservations().contains(new Reservation(person, courtNum)))
            {
                person.removeReservations(new Reservation(person, courtNum));
                comeBackToMenu();
            }
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
