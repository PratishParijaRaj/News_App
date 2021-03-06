package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.pratishparija.news.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import data.NewsDatabase;
import data.NewsRepo;

import static data.SampleDataProvider.getData;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.passcode)
    EditText passcode;
    @BindView(R.id.btn_signin)
    Button btn;
    @BindView(R.id.btn_async)
    Button btnasync;
    @BindView(R.id.btn_register)
    Button btn2;
    @BindView(R.id.du)
    LinearLayout du;
    NewsRepo newsRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        newsRepo = new NewsRepo(this);
        newsRepo.deleteCard();
        newsRepo.insertCardModel(getData());
    }

    @OnClick({R.id.btn_signin, R.id.btn_register, R.id.btn_async})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_signin:
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
                break;
            case R.id.btn_register:
                Intent j = new Intent(MainActivity.this, WeatherDetailsActivity.class);
                startActivity(j);
                break;
            case R.id.btn_async:
                Intent k = new Intent(MainActivity.this, AsyncTaskActivity.class);
                startActivity(k);
                break;
        }
    }
}
