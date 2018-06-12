package activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.pratishparija.news.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import TestedModel.WeatherModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import data.NewsRepo;
import model.JSONParsing;
import model.Model;

public class AsyncTaskActivity extends AppCompatActivity implements NewsRepo.Call{

    static String string = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
    MyAsyncTask myAsyncTask = new MyAsyncTask();
    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.txt2)
    TextView txt2;
    @BindView(R.id.txt3)
    TextView txt3;
    @BindView(R.id.txt4)
    TextView txt4;
    @BindView(R.id.txt5)
    TextView txt5;
    @BindView(R.id.txt6)
    TextView txt6;

    String value;
    List<WeatherModel> base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        ButterKnife.bind(this);
        myAsyncTask.execute(string);
    }

    @Override
    public void onWeatherRecived(List<WeatherModel> data) {
        base=data;

    }

    public class MyAsyncTask extends AsyncTask<String, Void, Model> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Model m) {
            super.onPostExecute(m);
            JSONParsing jsonParsing = new JSONParsing();
            Model model = jsonParsing.parseJSON(value);
//            Model.Coord cod = model.new Coord();
            txt1.setText(model.getCity_name());
            txt2.setText("" + model.getSys().getMessage());
            txt3.setText("" + model.getClouds().getCloudiness());
            txt4.setText("" + model.getCoord().getLat());
            txt5.setText("" + model.getMain().getTemp_min());
            txt6.setText("" + model.getWeather().get(0).getDescription());
//            txt6.setText(base.get(0).toString());
        }

        @Override
        protected Model doInBackground(String... strings) {
            try {
                URL url = new URL(string);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();


                BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                value = bf.readLine();
                Log.e("w", value);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}


