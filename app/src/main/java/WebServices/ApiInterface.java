package WebServices;

import java.util.List;

import TestedModel.WeatherModel;
import model.CardModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather")
    Call<WeatherModel> getcheckWeatherList(@Query("q") String a, @Query("appid") String c);

}
