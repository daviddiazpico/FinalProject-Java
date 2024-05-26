package david.finalproyect;

import david.finalproyect.classes.Admin;
import david.finalproyect.classes.Person;
import david.finalproyect.classes.Reservation;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Collections;
import java.util.List;

public class ViewUserReservationsOrderedController implements IController
{
    Admin admin;
    @FXML
    Button btnComeBack;
    @FXML
    ComboBox cbmFields;
    @FXML
    TextField tfDni;
    @FXML
    Button btnOrder;
    @FXML
    Label lblReservations;

    public void initialitze(Admin admin)
    {
        this.admin = admin;
        cbmFields.getItems().addAll("Date", "Court Number");
    }

    @FXML
    private void checkChosenField()
    {
        if (admin.getUsers().containsKey(tfDni.getText()))
        {
            Person person = admin.getUsers().get(tfDni.getText());
            String option = (String)cbmFields.getSelectionModel().getSelectedItem();

            if (option.equals("Date"))
            {
                showReservationsOrderByDate(person, person.getReservations());
            }
            else if (option.equals("Court Number"))
            {
                showReservationsOrderByCourtNumber(person, person.getReservations());
            }
        }
    }

    private void showReservationsOrderByDate(Person person, List<Reservation> reservations)
    {
        Collections.sort(reservations);
        showReservations(person);
    }

    private void showReservationsOrderByCourtNumber(Person person, List<Reservation> reservations)
    {
        reservations.sort((r1, r2) -> Integer.compare(r1.getNumCourt(), r2.getNumCourt()));
        showReservations(person);
    }

    private void showReservations(Person person)
    {
        lblReservations.setText(person.viewReservations());
    }

    @FXML
    private void comeBackToMenu()
    {
        FXMLLoader loader = Utils.changeScene("menuAdmin-view.fxml", this, btnComeBack);
        MenuAdminController controller = loader.getController();
        controller.initialitze(admin);
    }
}
