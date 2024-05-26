package david.finalproyect;

import david.finalproyect.classes.Person;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuPersonController implements IController
{
    Person person;
    @FXML
    Label lblTypeUser;
    @FXML
    Label lblWelcome;
    @FXML
    Button btnViewAllReservations;
    @FXML
    Button btnViewReservationsOrdenedByField;
    @FXML
    Button btnAddReservations;
    @FXML
    Button btnRemoveReservations;
    @FXML
    Button btnLogout;

    public void initialitze(Person person)
    {
        this.person = person;
        lblTypeUser.setText(this.person.getType().toUpperCase());
        lblWelcome.setText("Welcome " + this.person.getName());
    }

    @FXML
    private void viewMyReservations()
    {
        FXMLLoader loader = Utils.changeScene("viewMyReservations-view.fxml", this, btnLogout);
        ViewMyReservationsController controller = loader.getController();
        controller.initialitze(person);
    }

    @FXML
    private void viewMyReservationOrderedByField()
    {
        FXMLLoader loader = Utils.changeScene("viewMyReservationsOrdered-view.fxml", this, btnLogout);
        ViewMyReservationsOrderedController controller = loader.getController();
        controller.initialitze(person);
    }

    @FXML
    private void addReservation()
    {
        FXMLLoader loader = Utils.changeScene("addReservationPerson-view.fxml", this, btnLogout);
        AddReservationPersonController controller = loader.getController();
        controller.initialitze(person);
    }

    @FXML
    private void removeReservation()
    {
        FXMLLoader loader = Utils.changeScene("removeReservationPerson-view.fxml", this, btnLogout);
        RemoveReservationPersonController controller = loader.getController();
        controller.initialitze(person);
    }

    @FXML
    private void logout()
    {
        Utils.changeScene("login-view.fxml", this, btnLogout);
    }
}
