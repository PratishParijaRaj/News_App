package WebServices;

import com.google.gson.Gson;

public class WeatherResponse {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static WeatherResponse fromJson(String json) {
        return new Gson().fromJson(json, WeatherResponse.class);
    }
}
