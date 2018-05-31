package activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pratishparija.news.R;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

import WebServices.ApiInterface;
import WebServices.ApiServices;
import WebServices.GLobalData;
import WebServices.Model;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherDetailsActivity extends AppCompatActivity {
    @BindView(R.id.bt_check_weather)
    Button btCheckWeather;
    List<String> data;
    @BindView(R.id.list_view)
    ListView listView;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bt_check_weather)
    public void onViewClicked() {
        getWeatherValue();

    }


    private void getWeatherValue() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("getting weather");
        progressDialog.show();

        ApiInterface apiInterface = ApiServices.getClient(GLobalData.Weather).create(ApiInterface.class);

        Call<Model> call = apiInterface.checkWeather("banglore,in", "b6907d289e10d714a6e88b30761fae22");

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                Log.e("R", new Gson().toJson(response));
                progressDialog.dismiss();
                if (response.isSuccessful()) {
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
