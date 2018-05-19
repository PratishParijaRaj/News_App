package activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pratishparija.news.R;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import data.SampleDataProvider;
import model.CardModel;

import static data.SampleDataProvider.getData;

public class SecondActivity extends AppCompatActivity {
    List<CardModel> data = new ArrayList<>();
    @BindView(R.id.rec_view)
    RecyclerView recView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, getData());
        recView.setLayoutManager(new GridLayoutManager(this, 1));
        recView.setAdapter(recyclerViewAdapter);
    }

}
