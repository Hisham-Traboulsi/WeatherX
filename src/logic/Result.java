package logic;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {


    @SerializedName("weather")
    @Expose
    public List<Weather> weather = null;

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("sys")
    @Expose
    private Sys sys;


    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() { return main; }

    public String getName(){ return name; }

    public Sys getSys(){ return sys;}
}

