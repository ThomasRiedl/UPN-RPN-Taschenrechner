package main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static void show(Stage stage)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("sample.fxml"));
            Parent root = fxmlLoader.load();

            Controller ctrl = fxmlLoader.getController();
            ctrl.stage = stage;

            Stage mainStage = new Stage();
            mainStage.setTitle("Main");
            mainStage.setScene(new Scene(root, 400, 600));
            mainStage.show();
        }
        catch(Exception ex)
        {
            System.out.println("Exception occured while loading main view!");
        }
    }




}
