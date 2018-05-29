package activity;

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
import model.CardModel;

import static data.SampleDataProvider.getData;

public class SecondActivity extends AppCompatActivity implements NewsRepo.CallbackInterface {
    List<CardModel> data = new ArrayList<>();
    @BindView(R.id.rec_view)
    RecyclerView recView;
    NewsRepo newsRepo;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        newsRepo = new NewsRepo(SecondActivity.this);
        newsRepo.getAllCards();
        bindData(data);

    }

    private void bindData(List<CardModel> data) {
        recyclerViewAdapter = new RecyclerViewAdapter(this, data);
        recView.setLayoutManager(new GridLayoutManager(this, 1));
        recView.setAdapter(recyclerViewAdapter);
    }


    @Override
    public void onDataRetrieved(List<CardModel> dataList) {
        data.clear();
        data = (ArrayList) dataList;
        bindData(data);
//        Log.d("q", "" + dataList);

    }
}
