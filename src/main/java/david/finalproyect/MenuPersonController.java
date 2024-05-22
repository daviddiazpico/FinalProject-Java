package david.finalproyect;

import david.finalproyect.classes.Person;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPersonController implements IController
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
    Button btnLogout;

    public void initialitze(Person person)
    {
        this.person = person;
        lblTypeUser.setText(this.person.getType().toUpperCase());
    }

    @FXML
    private void logout()
    {
        Utils.changeScene("login-view.fxml", this, btnLogout);
    }

    @FXML
    private void viewAllReservations()
    {
        FXMLLoader loader = Utils.changeScene("viewReservations-view.fxml", this, btnLogout);
        ViewReservationsController controller = loader.getController();
        controller.initialitze(person);
    }

    @FXML
    private void viewReservationOrderedByField()
    {
        FXMLLoader loader = Utils.changeScene("viewReservationsOrdered-view.fxml", this, btnLogout);
        ViewReservationOrderedController controller = loader.getController();
        controller.initialitze(person);
    }

    @FXML
    private void addReservation()
    {
        FXMLLoader loader = Utils.changeScene("addReservation-view.fxml", this, btnLogout);
        AddReservationController controller = loader.getController();
        controller.initialitze(person);
    }

    @FXML
    private void removeReservation()
    {
        FXMLLoader loader = Utils.changeScene("removeReservation-view.fxml", this, btnLogout);
        RemoveReservationController controller = loader.getController();
        controller.initialitze(person);
    }
}
