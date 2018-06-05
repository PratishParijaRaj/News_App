package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParsing {
    public static Model parseJSON(String response) {
        try {
            JSONObject object = new JSONObject(response);
            JSONObject coord = object.optJSONObject("coord");
            Double longitude = coord.optDouble("lon");
            Double latitude = coord.optDouble("lat");
            JSONArray array = object.optJSONArray("weather");
            for (int i = 0; i < array.length(); i++) {
                JSONObject object1 = array.optJSONObject(i);
            }
            JSONObject main = object.optJSONObject("main");
            Double temp = main.optDouble("temp");
            Integer pressure = main.optInt("pressure");
            Integer humidity = main.optInt("humidity");
            Double temp_min = main.optDouble("temp_min");
            Double temp_max = main.optDouble("temp_max");
            JSONObject visibility = object.optJSONObject("visibility");
            JSONObject wind = object.optJSONObject("wind");
            Double speed = wind.optDouble("speed");
            Integer direction = wind.optInt("deg");
            JSONObject Clouds = object.optJSONObject("clouds");
            Integer cloudiness = Clouds.optInt("all");
            JSONObject unixTimestamp = object.optJSONObject("dt");
            JSONObject sys = object.optJSONObject("sys");
            Integer type = sys.optInt("type");
            Integer id = sys.optInt("id");
            Double message = sys.optDouble("message");
            String country = sys.optString("country");
            Long sunrise = sys.optLong("sunrise");
            Long sunset = sys.optLong("sunset");
            JSONObject city_id = object.optJSONObject("id");
            JSONObject city_name = object.optJSONObject("name");
            JSONObject response_code = object.optJSONObject("cod");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
