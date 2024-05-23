package david.finalproyect;

import david.finalproyect.classes.Person;
import david.finalproyect.classes.Reservation;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.Collections;
import java.util.List;

public class ViewMyReservationsOrderedController implements IController
{
    Person person;
    @FXML
    ComboBox cmbFields;
    @FXML
    Button btnOrder;
    @FXML
    Label lblReservations;
    @FXML
    Button btnComeBack;

    public void initialitze(Person person)
    {
        this.person = person;
        cmbFields.getItems().addAll("Date", "Court Number");
    }

    @FXML
    public void checkChosenField()
    {
        String option = (String)cmbFields.getSelectionModel().getSelectedItem();

        if (option.equals("Date"))
        {
            showReservationsOrderByDate(person.getReservations());
        }
        else if (option.equals("Court Number"))
        {
            showReservationsOrderByCourtNumber(person.getReservations());
        }
    }

    private void showReservationsOrderByDate(List<Reservation> reservations)
    {
        Collections.sort(reservations);
        showReservations(person);
    }

    private void showReservationsOrderByCourtNumber(List<Reservation> reservations)
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
        FXMLLoader loader = Utils.changeScene("menuPerson-view.fxml", this, btnComeBack);
        MenuPersonController controller = loader.getController();
        controller.initialitze(person);
    }
}
