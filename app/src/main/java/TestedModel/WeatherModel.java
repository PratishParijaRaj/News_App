package TestedModel;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import data.ConverterCard;
import data.ConverterWeather;

@Entity(tableName = "weather_table")
public class WeatherModel {
    @PrimaryKey(autoGenerate = true)
    private int d_id;
    @SerializedName("base")
    private String base;
    @SerializedName("visibility")
    private int visibility;
    @SerializedName("dt")
    private int dt;
    @SerializedName("id")
    private int s_id;
    @SerializedName("name")
    private String name;
    @SerializedName("cod")
    private int cod;
    @Embedded
    @SerializedName("coord")
    private Coord coord;
    @Embedded
    @SerializedName("sys")
    private Sys sys;

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @Embedded
    @SerializedName("main")
    private Main main;
    @Embedded
    @SerializedName("wind")
    private Wind wind;


    @Embedded
    @SerializedName("clouds")
    private Clouds clouds;
    @TypeConverters(ConverterWeather.class)
    @SerializedName("weather")
    private List<Weather> weather;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public TestedModel.Coord getCoord() {
        return coord;
    }

    public void setCoord(TestedModel.Coord coord) {
        this.coord = coord;
    }

    public TestedModel.Main getMain() {
        return main;
    }

    public void setMain(TestedModel.Main main) {
        this.main = main;
    }

    public TestedModel.Wind getWind() {
        return wind;
    }

    public void setWind(TestedModel.Wind wind) {
        this.wind = wind;
    }

    public TestedModel.Clouds getClouds() {
        return clouds;
    }

    public void setClouds(TestedModel.Clouds clouds) {
        this.clouds = clouds;
    }

    public List<TestedModel.Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<TestedModel.Weather> weather) {
        this.weather = weather;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

}
