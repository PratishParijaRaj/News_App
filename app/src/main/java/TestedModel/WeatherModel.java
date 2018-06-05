package TestedModel;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import data.ConverterCard;
import data.ConverterWeather;

@Entity(tableName = "weather_table")
public class WeatherModel {
    private String base;
    @PrimaryKey(autoGenerate = true)
    private int d_id;
    private int visibility;
    private int dt;
    private int id;
    private String name;
    private int cod;
    @Embedded
    private coord coord;
    @Embedded
    private main main;
    @Embedded
    private wind wind;
    @Embedded
    private clouds clouds;

    @TypeConverters(ConverterWeather.class)
    private List<weather> weather;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setCod(int cod) {
        this.cod = cod;
    }

    public TestedModel.coord getCoord() {
        return coord;
    }

    public void setCoord(TestedModel.coord coord) {
        this.coord = coord;
    }

    public TestedModel.main getMain() {
        return main;
    }

    public void setMain(TestedModel.main main) {
        this.main = main;
    }

    public TestedModel.wind getWind() {
        return wind;
    }

    public void setWind(TestedModel.wind wind) {
        this.wind = wind;
    }

    public TestedModel.clouds getClouds() {
        return clouds;
    }

    public void setClouds(TestedModel.clouds clouds) {
        this.clouds = clouds;
    }

    public List<TestedModel.weather> getWeather() {
        return weather;
    }

    public void setWeather(List<TestedModel.weather> weather) {
        this.weather = weather;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

}
