package david.finalproyect;

import david.finalproyect.classes.Person;
import david.finalproyect.classes.Reservation;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddReservationPersonController implements IController
{
    Person person;
    @FXML
    TextField tfCourtNumber;
    @FXML
    Button btnAdd;
    @FXML
    Button btnComeBack;

    public void initialitze(Person person)
    {
        this.person = person;
    }

    @FXML
    private void addReservation()
    {
        int courtNum = Integer.parseInt(tfCourtNumber.getText());

        if (!(person.getReservations().contains(new Reservation(person, courtNum))))
        {
            person.addReservation(new Reservation(person, courtNum));

            comeBackToMenu();
        }
    }

    @FXML
    private void comeBackToMenu()
    {
        FXMLLoader loader = Utils.changeScene("menuPerson-view.fxml", this, btnAdd);
        MenuPersonController controller = loader.getController();
        controller.initialitze(person);
    }
}
