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

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.passcode)
    EditText passcode;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.du)
    LinearLayout du;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
                break;
            case R.id.btn2:
                break;
        }
    }
}
