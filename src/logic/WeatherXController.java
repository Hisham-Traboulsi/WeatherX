package logic;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class WeatherXController implements Initializable {

    public static BorderPane root = new BorderPane();

    @FXML
    private ImageView icon = new ImageView();

    @FXML
    private Text locationTxt;

    @FXML
    private Text temperature;

    @FXML
    private Text description;

    @FXML
    private Text minMaxTemps;

    @FXML
    private Text humidity;

    @FXML
    private Text sunrise;

    @FXML
    private Text sunset;

    @FXML
    private JFXButton refreshBtn;

    private Result res = SearchController.res;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            temperature.setText(Long.toString(Math.round(res.getMain().getTemp())) + "\u00B0");
            locationTxt.setText(res.getName() + ", " + res.getSys().getCountry());
            description.setText(res.getWeather().get(0).getMain());
            minMaxTemps.setText(Math.round(res.getMain().getTempMax()) + "\u00B0" + "/ " + Math.round(res.getMain().getTempMin()) + "\u00B0");
            humidity.setText(Math.round(res.getMain().getHumidity()) + "%");
            sunrise.setText(epochConverter(res.getSys().getSunrise()));
            sunset.setText(epochConverter(res.getSys().getSunset()));
            URL weatherIcon = getClass().getResource("/WeatherIcons/" + res.getWeather().get(0).getIcon() + ".png");
            Image img = new Image(weatherIcon.toString());
            icon.setImage(img);

        } catch (Exception ex) {
            System.out.println("Location doesnt exist");
        }

    }

    private String epochConverter(long time){
        long epoch = Long.parseLong(Long.toString(time));
        Date date = new Date( epoch * 1000 );
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        String timeStr = localDateFormat.format(date);
        return timeStr;
    }

    public void backToSearchScreen(){
        try{
            URL searchURL = getClass().getResource("/gui/SearchGUI.fxml");
            AnchorPane searchPane = FXMLLoader.load(searchURL);
            BorderPane root = WeatherX.getRoot();
            root.setCenter(searchPane);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void refreshContent(){
        try{
            URL weatherXURL = getClass().getResource("/gui/WeatherXGUI.fxml");
            AnchorPane weatherXPane = FXMLLoader.load(weatherXURL);
            BorderPane root = WeatherX.getRoot();
            root.setCenter(weatherXPane);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
