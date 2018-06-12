package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "weathers_db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WeatherSqliteModel.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + WeatherSqliteModel.TABLE_NAME);

        onCreate(db);

    }

    public long insertWeatherDetails(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WeatherSqliteModel.COLUMN_CITY_NAME, name);

        long id = db.insert(WeatherSqliteModel.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public WeatherSqliteModel getWeatherDetails(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(WeatherSqliteModel.TABLE_NAME,
                new String[]{WeatherSqliteModel.COLUMN_ID, WeatherSqliteModel.COLUMN_CITY_NAME, WeatherSqliteModel.COLUMN_TIMESTAMP},
                WeatherSqliteModel.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        WeatherSqliteModel note = new WeatherSqliteModel(
                cursor.getLong(cursor.getColumnIndex(WeatherSqliteModel.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(WeatherSqliteModel.COLUMN_CITY_NAME)),
                cursor.getLong(cursor.getColumnIndex(WeatherSqliteModel.COLUMN_TIMESTAMP)));

        cursor.close();

        return note;
    }

    public List<WeatherSqliteModel> getAllNotes() {
        List<WeatherSqliteModel> notes = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + WeatherSqliteModel.TABLE_NAME + " ORDER BY " +
                WeatherSqliteModel.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                WeatherSqliteModel note = new WeatherSqliteModel();
                note.setId(cursor.getInt(cursor.getColumnIndex(WeatherSqliteModel.COLUMN_ID)));
                note.setName(cursor.getString(cursor.getColumnIndex(WeatherSqliteModel.COLUMN_CITY_NAME)));
                note.setTimestamp(cursor.getLong(cursor.getColumnIndex(WeatherSqliteModel.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        db.close();

        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + WeatherSqliteModel.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        return count;

    }
}
