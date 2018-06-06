package data;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import TestedModel.Weather;

public class ConverterWeather {
    @TypeConverter
    public static List<Weather> fromString(String value) {
        Type listType = new TypeToken<List<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<Weather> options) {
        Gson gson = new Gson();
        String json = gson.toJson(options);
        return json;
    }
}
