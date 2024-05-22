package david.finalproyect;

import david.finalproyect.classes.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuAdminController
{
    Person person;
    @FXML
    Label lblTypeUser;
    @FXML
    Button btnViewAllReservations;
    @FXML
    Button btnAddReservations;
    @FXML
    Button btnReservationsFilterDate;
    @FXML
    Button btnReservationsFilterCourtNum;
    @FXML
    Button btnExit;

    public void initialitze(Person person)
    {
        this.person = person;
        lblTypeUser.setText(person.getType().toUpperCase());
    }
}
