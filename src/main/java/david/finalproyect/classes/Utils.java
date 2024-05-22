package david.finalproyect.classes;


import david.finalproyect.interfaces.IController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Utils
{
    public static FXMLLoader changeScene(String viewName, IController controller, Button button)
    {
        FXMLLoader loader = null;

        try
        {
            loader = new FXMLLoader(controller.getClass().getResource(viewName));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();

            Stage currentStage = (Stage)button.getScene().getWindow();
            currentStage.close();
        }
        catch (IOException ioException)
        {
            System.err.println(ioException.getMessage());
        }

        return loader;
    }
}
