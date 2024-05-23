package david.finalproyect.classes;


import david.finalproyect.interfaces.IController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils
{
    public static FXMLLoader changeScene(String viewName, IController currentController, Button button)
    {
        FXMLLoader loader = null;

        try
        {
            loader = new FXMLLoader(currentController.getClass().getResource(viewName));
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

    public static Map<String,Person> readFile() throws IOException
    {
        Map<String,Person> users = new HashMap<String,Person>();

        BufferedReader file = null;
        try
        {
            file = new BufferedReader(new FileReader(new File("users.txt")));
            String line = "";

            while (line != null)
            {
                line = file.readLine();
                if (line != null)
                {
                    String[] lineSplited = line.split(";");
                    switch (lineSplited[0].toLowerCase())
                    {
                        case "member":
                            users.put(lineSplited[2], new Member(lineSplited[1], lineSplited[2],
                                    Integer.parseInt(lineSplited[3]), lineSplited[4]));
                            break;
                        case "coach":
                            users.put(lineSplited[2], new Coach(lineSplited[1], lineSplited[2],
                                    Integer.parseInt(lineSplited[3]), lineSplited[4]));
                            break;
                        case "admin":
                            users.put(lineSplited[2], new Admin(lineSplited[1], lineSplited[2],
                                    Integer.parseInt(lineSplited[3]), lineSplited[4]));
                            break;
                    }
                }
            }
        }
        catch (IOException ioException)
        {
            System.err.println(ioException.getMessage());
        }
        finally
        {
            if (file != null)
            {
                file.close();
            }
        }

        return users;
    }

    public static void saveUsersInFile(Map<String,Person> users)
    {
        PrintWriter file = null;

        try
        {
            file = new PrintWriter("users.txt");

            for (Person person: users.values())
            {
                file.println(person.toStringFileFormat());
            }
        }
        catch (IOException ioException)
        {
            System.err.println(ioException.getMessage());
        }
        finally
        {
            if (file != null)
            {
                file.close();
            }
        }
    }
}
