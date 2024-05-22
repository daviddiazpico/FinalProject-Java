package david.finalproyect;

import david.finalproyect.classes.Person;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class ViewReservationsController implements IController
{
    Person person;
    @FXML
    Label lblReservations;
    @FXML
    Button btnComeBack;

    public void initialitze(Person person)
    {
        this.person = person;
        showReservations();
    }

    private void showReservations()
    {
        lblReservations.setText(person.viewReservations());
    }

    @FXML
    private void comeBackToMenu(){
        FXMLLoader loader = Utils.changeScene("menuPerson-view.fxml", this, btnComeBack);
        MenuPersonController controller = loader.getController();
        controller.initialitze(person);
    }
}
