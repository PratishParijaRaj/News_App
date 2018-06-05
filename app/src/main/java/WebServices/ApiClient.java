package WebServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String Weather = "http://samples.openweathermap.org/data/2.5/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(GLobalData.Weather)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
