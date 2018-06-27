package logic;

import com.google.gson.Gson;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherDataCollector {

    public Result getWeather(String location){

        Gson gson = new Gson();
        //go to open weather map and get an API key
        String apikey = "";

        //The units are Kelvin(Default), metric (Celsius), imperial (Fahrenheit)
        String units = "metric";
        String urlStr = "http://api.openweathermap.org/data/2.5/weather?q="+location+"&appid="+apikey+"&units="+units;
        Result r = null;
        try {
            StringBuilder result = new StringBuilder();

            URL url = new URL(urlStr);

            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            r = gson.fromJson(rd, Result.class);

            rd.close();

        }catch(IOException ex){
           // ex.printStackTrace();
            System.out.println("Something went wrong");

        }
        return r;
    }

}
