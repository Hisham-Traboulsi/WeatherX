package logic;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;

public class WeatherX extends Application {

    public static BorderPane root = new BorderPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL searchURL = getClass().getResource("/gui/SearchGUI.fxml");
        AnchorPane searchPane = FXMLLoader.load(searchURL);

        root.setCenter(searchPane);

        Scene scene = new Scene(root);

        scene
                .getStylesheets()
                .add(getClass()
                    .getResource("/styling/style.css")
                    .toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("WeatherX");
        primaryStage.getIcons().add(new Image("/WeatherIcons/01d.png"));

    }

    public static BorderPane getRoot(){
        return root;
    }

    public static void main (String[] args){launch(args);}
}
