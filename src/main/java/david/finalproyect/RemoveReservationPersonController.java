package david.finalproyect;

import david.finalproyect.classes.Person;
import david.finalproyect.classes.Reservation;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RemoveReservationPersonController implements IController
{
    Person person;
    @FXML
    TextField tfCourtNumber;
    @FXML
    Button btnRemove;
    @FXML
    Button btnComeBack;

    public void initialitze(Person person)
    {
        this.person = person;
    }

    @FXML
    private void removeReservation()
    {
        person.removeReservations(new Reservation(person, Integer.parseInt(tfCourtNumber.getText())));
        comeBackToMenu();
    }

    @FXML
    private void comeBackToMenu()
    {
        FXMLLoader loader = Utils.changeScene("menuPerson-view.fxml", this, btnRemove);
        MenuPersonController controller = loader.getController();
        controller.initialitze(person);
    }
}
