package data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.provider.SyncStateContract;

import model.CardModel;

@Database(entities = {CardModel.class}, version = 1)
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


