package logic;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private JFXTextField searchBox;

    @FXML
    private Text errorMessage;

    protected static Result res;

    public void displayWeather(){

        res = new WeatherDataCollector().getWeather(searchBox.getText());

        if(res == null){
            errorMessage.setText("Location not found.");
        }
        else {
            errorMessage.setText("");
            try {
                URL weatherURL = getClass().getResource("/gui/WeatherXGUI.fxml");

                AnchorPane weatherPane = FXMLLoader.load(weatherURL);

                BorderPane root = WeatherX.getRoot();

                root.setCenter(weatherPane);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchBox.setPromptText("Enter Location i.e London");
    }
}
