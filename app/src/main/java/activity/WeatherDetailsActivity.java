package activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.pratishparija.news.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import WebServices.ApiClient;
import WebServices.ApiInterface;
import WebServices.Model;
import adapter.WeatherAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherDetailsActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.bt_check_weather)
    Button btCheckWeather;
    List<Model> data = new ArrayList<>();
    Model model;
    WeatherAdapter weatherAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_check_weather)
    public void onViewClicked() {
        getWeatherValue();
        weatherAdapter = new WeatherAdapter(this, data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(weatherAdapter);

    }


    private void getWeatherValue() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("getting weather");
        progressDialog.show();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Model> call = apiInterface.checkWeather("Bangalore,in", "b6907d289e10d714a6e88b30761fae22");
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                progressDialog.dismiss();
                Log.e("R", new Gson().toJson(response));
                if (response.isSuccessful() && response.body() != null) {
//                    data.addAll(response.body());
//                    weatherAdapter.notifyDataSetChanged();
                    Toast.makeText(WeatherDetailsActivity.this, "Success", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(WeatherDetailsActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                progressDialog.dismiss();
                Log.e("TAG", t.getMessage());
            }
        });
    }


}
