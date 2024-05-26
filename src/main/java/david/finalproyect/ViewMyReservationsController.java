package david.finalproyect;

import david.finalproyect.classes.Person;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ViewMyReservationsController implements IController
{
    Person person;
    int numShowedTotal;
    int numShowedPerRound;
    @FXML
    Label lblReservations;
    @FXML
    Button btnComeBack;
    @FXML
    Button btnNext;
    @FXML
    Button btnBack;

    public void initialitze(Person person)
    {
        this.person = person;
        numShowedTotal = 10;
        numShowedPerRound = 0;
        showReservations();
    }

    private void showReservations()
    {
        lblReservations.setText(person.viewReservations());
    }

    @FXML
    private void next()
    {
        if (person.getReservations().size() >= 10 && numShowedTotal < person.getReservations().size())
        {
            numShowedPerRound = 0;
            String reservations = "";
            int i = numShowedTotal;

            while (i < numShowedTotal+10 && i < person.getReservations().size())
            {
                reservations += person.getReservations().get(i) + "\n";
                i++;
                numShowedPerRound++;
            }
            numShowedTotal=i;

            lblReservations.setText(reservations);
        }
    }

    @FXML
    private void back()
    {
        if (person.getReservations().size() >= 10 && numShowedTotal > 10)
        {
            numShowedTotal-=numShowedPerRound+10;
            numShowedPerRound = 0;
            String reservations = "";
            int i = numShowedTotal;

            while (i < numShowedTotal+10 && i < person.getReservations().size())
            {
                reservations += person.getReservations().get(i) + "\n";
                i++;
                numShowedPerRound++;
            }
            numShowedTotal=i;

            lblReservations.setText(reservations);
        }
    }

    @FXML
    private void comeBackToMenu(){
        FXMLLoader loader = Utils.changeScene("menuPerson-view.fxml", this, btnComeBack);
        MenuPersonController controller = loader.getController();
        controller.initialitze(person);
    }
}
