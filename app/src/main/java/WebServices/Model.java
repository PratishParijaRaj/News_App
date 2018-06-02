package WebServices;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Model {

    @SerializedName("coord")
    private Coord coord;
    @SerializedName("weather")
    private ArrayList<Weather> weather;
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private Main main;
    @SerializedName("visibility")
    private int visibility;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("dt")
    private long unixTimestamp;
    @SerializedName("sys")
    private Sys sys;
    @SerializedName("id")
    private long city_id;
    @SerializedName("name")
    private String city_name;
    @SerializedName("cod")
    private int response_code;

    public Model() {
    }

    public class Clouds {
        @SerializedName("all")
        private int cloudiness;
    }


    public class Coord {
        @SerializedName("lon")
        private double lon;
        @SerializedName("lat")
        private double lat;
    }


    public class Main {
        @SerializedName("temp")
        private double temp;
        @SerializedName("pressure")
        private int pressure;
        @SerializedName("humidity")
        private int humidity;
        @SerializedName("temp_min")
        private double temp_min;
        @SerializedName("temp_max")
        private double temp_max;
    }


    public class Sys {
        @SerializedName("type")
        private int type;
        @SerializedName("id")
        private int id;
        @SerializedName("message")
        private double message;
        @SerializedName("country")
        private String country;
        @SerializedName("sunrise")
        private long sunrise;
        @SerializedName("sunset")
        private long sunset;
    }


    public class Weather {
        @SerializedName("id")
        private int id;
        @SerializedName("main")
        private String main;
        @SerializedName("description")
        private String description;
        @SerializedName("icon")
        private String icon;
    }


    public class Wind {
        @SerializedName("speed")
        private double speed;
        @SerializedName("deg")
        private int direction;
    }

    public Coord getCoord() {
        return coord;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Date getUnixTimestamp() {
        return new Date((long) (unixTimestamp * 1000));
    }

    public Sys getSys() {
        return sys;
    }

    public long getCity_id() {
        return city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setUnixTimestamp(long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public Model(Coord coord, ArrayList<Weather> weather, String base, Main main, int visibility, Wind wind, Clouds clouds, long unixTimestamp, Sys sys, long city_id, String city_name, int response_code) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.unixTimestamp = unixTimestamp;
        this.sys = sys;
        this.city_id = city_id;
        this.city_name = city_name;
        this.response_code = response_code;
    }
}

