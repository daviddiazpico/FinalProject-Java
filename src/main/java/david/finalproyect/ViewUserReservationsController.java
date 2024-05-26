package david.finalproyect;

import david.finalproyect.classes.*;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewUserReservationsController implements IController
{
    Admin admin;
    int numShowedTotal;
    int numShowedPerRound;
    @FXML
    Button btnComeBack;
    @FXML
    Button btnNext;
    @FXML
    Button btnBack;
    @FXML
    Label lblReservations;
    @FXML
    TextField tfDni;
    @FXML
    Button btnShowReservations;

    public void initialitze(Admin admin)
    {
        this.admin = admin;
        numShowedTotal = 10;
        numShowedPerRound = 0;
    }

    @FXML
    private void showReservations()
    {
        String dniBuscar = tfDni.getText();

        if (admin.getUsers().containsKey(dniBuscar))
        {
            lblReservations.setText(admin.getUsers().get(dniBuscar).viewReservations());
        }
    }

    @FXML
    private void next()
    {
        String dniBuscar = tfDni.getText();

        if (admin.getUsers().get(dniBuscar).getReservations().size() >= 10 &&
                numShowedTotal < admin.getUsers().get(dniBuscar).getReservations().size())
        {
            numShowedPerRound = 0;
            String reservations = "";
            int i = numShowedTotal;

            while (i<numShowedTotal+10 && i < admin.getUsers().get(dniBuscar).getReservations().size())
            {
                reservations += admin.getUsers().get(dniBuscar).getReservations().get(i) + "\n";
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
        String dniBuscar = tfDni.getText();

        if (admin.getUsers().get(dniBuscar).getReservations().size() >= 10 &&
                numShowedTotal > 10)
        {
            numShowedTotal-=numShowedPerRound+10;
            numShowedPerRound = 0;
            String reservations = "";
            int i = numShowedTotal;

            while (i<numShowedTotal+10 && i < admin.getUsers().get(dniBuscar).getReservations().size())
            {
                reservations += admin.getUsers().get(dniBuscar).getReservations().get(i) + "\n";
                i++;
                numShowedPerRound++;
            }
            numShowedTotal=i;

            lblReservations.setText(reservations);
        }
    }

    @FXML
    private void comeBackToMenu()
    {
        FXMLLoader loader = Utils.changeScene("menuAdmin-view.fxml", this, btnComeBack);
        MenuAdminController controller = loader.getController();
        controller.initialitze(admin);
    }
}
