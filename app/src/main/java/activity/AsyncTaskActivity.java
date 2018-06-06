package activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.pratishparija.news.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.ButterKnife;
import model.JSONParsing;
import model.Model;

public class AsyncTaskActivity extends AppCompatActivity {

    static String string = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
    MyAsyncTask myAsyncTask = new MyAsyncTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        ButterKnife.bind(this);
        myAsyncTask.execute();


    }

    public static class MyAsyncTask extends AsyncTask<String, Void, Model> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Model model) {
            super.onPostExecute(model);
        }

        @Override
        protected Model doInBackground(String... strings) {
            try {
                URL url = new URL(string);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();


                BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String value = bf.readLine();
                Log.e("w",value);
                return JSONParsing.parseJSON(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}


