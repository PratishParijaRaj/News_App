package activity;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.pratishparija.news.R;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import data.NewsRepo;
import data.SampleDataProvider;
import model.CardModel;

import static data.SampleDataProvider.getData;

public class SecondActivity extends AppCompatActivity {
    List<CardModel> data = new ArrayList<>();
    @BindView(R.id.rec_view)
    RecyclerView recView;
    NewsRepo newsRepo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        newsRepo = new NewsRepo(this);
        List<CardModel> cardModelList = new ArrayList<>();
        cardModelList = getData();
        for (int pos = 0; pos < cardModelList.size(); pos++) {
            newsRepo.insertCardModel(cardModelList.get(pos));

        }

        Log.d("q",""+newsRepo.getAllCards().size());
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, getData());
        recView.setLayoutManager(new GridLayoutManager(this, 1));
        recView.setAdapter(recyclerViewAdapter);
    }

}
