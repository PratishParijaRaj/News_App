package data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import TestedModel.WeatherModel;
import model.CardModel;

@Database(entities = {CardModel.class, WeatherModel.class}, version = 1)
@TypeConverters({ConverterCard.class,ConverterWeather.class})
public abstract class NewsDatabase extends RoomDatabase {
    public abstract NewsDao getNewsDao();

    private static NewsDatabase newsDB;

    public static NewsDatabase getDatabase(final Context context) {
        if (newsDB == null) {
            synchronized (NewsDatabase.class) {
                if (newsDB == null) {
                    newsDB = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "word_database")
                            .build();

                }
            }
        }
        return newsDB;
    }

}


