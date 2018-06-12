package data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import TestedModel.WeatherModel;
import model.CardModel;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM card_table")
    List<CardModel> getAll();

    @Query("SELECT * FROM weather_table ")
    List<WeatherModel> getWeatherDetails();

    @Query("DELETE FROM card_table")
    void deleteAll();

    @Insert
    void insert(List<CardModel> news);

    @Insert
    void insertWeather(WeatherModel weatherModel);


    @Update
    void update(CardModel repos);


    @Delete
    void delete(CardModel news);

    @Delete
    void delete(CardModel... news);

}

