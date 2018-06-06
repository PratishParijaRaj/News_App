package WebServices;

import TestedModel.WeatherModel;
import model.Model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather")
    Call<WeatherModel> getcheckWeatherList(@Query("q") String a, @Query("appid") String c);
}
