package model;

import android.graphics.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONParsing {


    public Model parseJSON(String response) {
        Model model = new Model();

        try {
            JSONObject object = new JSONObject(response);
            model.setCity_name(object.optString("name"));
            model.setBase(object.optString("base"));
            model.setVisibility(object.optInt("visibility"));
            model.setUnixTimestamp(object.optLong("dt"));
            model.setCity_id(object.optLong("id"));
            model.setResponse_code(object.optInt("cod"));
            JSONObject sys = object.optJSONObject("sys");
            model.getSys().setCountry(sys.optString("country"));
            model.getSys().setId(sys.optInt("id"));
            model.getSys().setSunrise(sys.optLong("sunrise"));
            model.getSys().setSunset(sys.optLong("sunset"));
            model.getSys().setMessage(sys.optDouble("message"));
            model.getSys().setType(sys.optInt("type"));
            JSONObject coord = object.optJSONObject("coord");
            model.getCoord().setLon(coord.optDouble("lon"));
            model.getCoord().setLat(coord.optDouble("lat"));
            JSONObject main = object.optJSONObject("main");
            model.getMain().setTemp_min(main.optDouble("temp_min"));
            model.getMain().setTemp_max(main.optDouble("temp_max"));
            model.getMain().setTemp(main.optDouble("temp"));
            model.getMain().setPressure(main.optInt("pressure"));
            model.getMain().setHumidity(main.optInt("humidity"));
            JSONObject wind = object.optJSONObject("wind");
            model.getWind().setSpeed(wind.optDouble("speed"));
            model.getWind().setDirection(wind.optInt("deg"));
            JSONObject clouds = object.optJSONObject("clouds");
            model.getClouds().setCloudiness(clouds.optInt("all"));

            JSONArray array = object.optJSONArray("weather");
            ArrayList<Model.Weather> weatherList = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                JSONObject object1 = array.optJSONObject(i);
                Model.Weather weather = model.new Weather();
                weather.setId(object1.optInt("id"));
                weather.setDescription(object1.optString("description"));
                weather.setMain(object1.optString("main"));
                weather.setIcon(object1.optString("icon"));
                weatherList.add(weather);
            }
            model.setWeather(weatherList);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return model;
    }

}
