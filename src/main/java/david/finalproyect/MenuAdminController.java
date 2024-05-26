package david.finalproyect;

import david.finalproyect.classes.Admin;
import david.finalproyect.classes.UsersManager;
import david.finalproyect.classes.Utils;
import david.finalproyect.interfaces.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuAdminController implements IController
{
    Admin admin;
    @FXML
    Label lblTypeUser;
    @FXML
    Label lblWelcome;
    @FXML
    Button btnViewUserReservations;
    @FXML
    Button btnViewUserReservationsOrdered;
    @FXML
    Button btnAddReservations;
    @FXML
    Button btnRemoveReservations;
    @FXML
    Button btnAddPerson;
    @FXML
    Button btnRemovePerson;
    @FXML
    Button btnLogOut;

    public void initialitze(Admin admin)
    {
        this.admin = admin;
        lblTypeUser.setText(admin.getType().toUpperCase());
        lblWelcome.setText("Welcome " + this.admin.getName());
    }

    @FXML
    private void viewUserReservations()
    {
        FXMLLoader loader = Utils.changeScene("viewUserReservations-view.fxml",
                this, btnViewUserReservations);
        ViewUserReservationsController controller = loader.getController();
        controller.initialitze(admin);
    }

    @FXML
    private void viewUserReservationsOrderedByField()
    {
        FXMLLoader loader = Utils.changeScene("viewUserReservationsOrdered-view.fxml",
                this, btnViewUserReservationsOrdered);
        ViewUserReservationsOrderedController controller = loader.getController();
        controller.initialitze(admin);
    }

    @FXML
    private void addReservations()
    {
        FXMLLoader loader = Utils.changeScene("addReservationAdmin-view.fxml",
                this, btnAddReservations);
        AddReservationAdminController controller = loader.getController();
        controller.initialitze(admin);
    }

    @FXML
    private void removeReservations()
    {
        FXMLLoader loader = Utils.changeScene("removeReservationAdmin-view.fxml",
                this, btnRemoveReservations);
        RemoveReservationAdminController controller = loader.getController();
        controller.initialitze(admin);
    }

    @FXML
    private void addPerson()
    {
        FXMLLoader loader = Utils.changeScene("addPerson-view.fxml",
                this, btnAddPerson);
        AddPersonController controller = loader.getController();
        controller.initialitze(admin);
    }

    @FXML
    private void removePerson()
    {
        FXMLLoader loader = Utils.changeScene("removePerson-view.fxml",
                this, btnRemovePerson);
        RemovePersonController controller = loader.getController();
        controller.initialitze(admin);
    }

    @FXML
    private void logout()
    {
        UsersManager.getInstance().setUsers(admin.getUsers());
        Utils.changeScene("login-view.fxml", this, btnLogOut);
    }
}
