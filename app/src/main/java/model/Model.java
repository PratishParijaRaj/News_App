package model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import TestedModel.Weather;

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

        public int getCloudiness() {
            return cloudiness;
        }

        public void setCloudiness(int cloudiness) {
            this.cloudiness = cloudiness;
        }
    }


    public class Coord {
        @SerializedName("lon")
        private double lon;
        @SerializedName("lat")
        private double lat;

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }
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

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public double getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(double temp_min) {
            this.temp_min = temp_min;
        }

        public double getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(double temp_max) {
            this.temp_max = temp_max;
        }
    }


    public class Sys {
        @SerializedName("type")
        private int type;
        @SerializedName("id")
        private int id;


        public Double getMessage() {
            return message;
        }

        public void setMessage(Double message) {
            this.message = message;
        }

        @SerializedName("message")
        private Double message;
        @SerializedName("country")
        private String country;
        @SerializedName("sunrise")
        private long sunrise;
        @SerializedName("sunset")
        private long sunset;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public long getSunrise() {
            return sunrise;
        }

        public void setSunrise(long sunrise) {
            this.sunrise = sunrise;
        }

        public long getSunset() {
            return sunset;
        }

        public void setSunset(long sunset) {
            this.sunset = sunset;
        }
    }


    public class Weather {
        public Weather() {

        }

        @SerializedName("id")
        private int id;
        @SerializedName("main")
        private String main;
        @SerializedName("description")
        private String description;
        @SerializedName("icon")
        private String icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }


    public class Wind {
        @SerializedName("speed")
        private double speed;
        @SerializedName("deg")
        private int direction;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }
    }

    public Coord getCoord() {
        if (coord == null) {
            coord = new Coord();
        }
        return coord;
    }

    public ArrayList<Weather> getWeather() {
        if (weather == null) {
            weather = new ArrayList<Weather>();
        }
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {

        if (main == null) {
            main = new Main();
        }
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        if (wind == null) {
            wind = new Wind();
        }
        return wind;
    }

    public Clouds getClouds() {

        if (clouds == null) {
            clouds = new Clouds();
        }
        return clouds;
    }

    public Date getUnixTimestamp() {
        return new Date((long) (unixTimestamp * 1000));
    }

    public Sys getSys() {
        if (sys == null) {
            sys = new Sys();
        }
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


}

