package data;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import TestedModel.weather;

public class ConverterWeather {
    @TypeConverter
    public static List<weather> fromString(String value) {
        Type listType = new TypeToken<List<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<weather> options) {
        Gson gson = new Gson();
        String json = gson.toJson(options);
        return json;
    }
}
