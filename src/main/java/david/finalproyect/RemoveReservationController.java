package david.finalproyect;

import david.finalproyect.classes.Person;
import david.finalproyect.classes.Reservation;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RemoveReservationController implements IController
{
    Person person;
    @FXML
    TextField tfCourtNumber;
    @FXML
    public Button btnRemove;

    public void initialitze(Person person)
    {
        this.person = person;
    }

    @FXML
    private void removeReservation()
    {
        person.removeReservations(new Reservation(person, Integer.parseInt(tfCourtNumber.getText())));

        FXMLLoader loader = Utils.changeScene("menuPerson-view.fxml", this, btnRemove);
        MenuPersonController controller = loader.getController();
        controller.initialitze(person);
    }
}
