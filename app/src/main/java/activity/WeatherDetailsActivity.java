package activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pratishparija.news.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import TestedModel.WeatherModel;
import TestedModel.weather;
import WebServices.ApiClient;
import WebServices.ApiInterface;
import WebServices.ApiClient;
import WebServices.ApiInterface;
import adapter.WeatherAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import data.NewsRepo;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static data.SampleDataProvider.getData;

public class WeatherDetailsActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.text5)
    TextView text5;
    @BindView(R.id.text6)
    TextView text6;
    @BindView(R.id.text7)
    TextView text7;
    @BindView(R.id.text8)
    TextView text8;
    private List<WeatherModel> data = new ArrayList<>();
    private List<weather> list = new ArrayList<>();
    WeatherModel weatherModel = new WeatherModel();
    WeatherAdapter weatherAdapter;
    NewsRepo newsRepo;
    Button btCheckWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);
        ButterKnife.bind(this);
        getWeatherValue();
        newsRepo = new NewsRepo(this);
        weatherAdapter = new WeatherAdapter(getApplicationContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(weatherAdapter);
        newsRepo.insertWeatherModel(weatherModel);

    }

    private void getWeatherValue() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("getting weather");
        progressDialog.show();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<WeatherModel> call = apiInterface.getcheckWeatherList("London,uk", "b6907d289e10d714a6e88b30761fae22");
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                progressDialog.dismiss();
                Log.e("R", new Gson().toJson(response));
                if (response.isSuccessful() && response.body() != null) {
                    list.addAll(response.body().getWeather());
                    text5.setText(response.body().getName());
//                    text6.setText(Integer.toString(response.body().getCod()));
//                    text7.setText(Integer.toString(response.body().getDt()));
                    text8.setText(Integer.toString(response.body().getVisibility()));
                    text6.setText(Double.toString(response.body().getCoord().getLat()));
                    text7.setText(Double.toString(response.body().getCoord().getLon()));
                    Toast.makeText(WeatherDetailsActivity.this, "Success", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(WeatherDetailsActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }
                weatherAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("TAG", t.getMessage());
            }
        });
    }


}
