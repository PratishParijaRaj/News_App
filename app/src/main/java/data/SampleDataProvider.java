package data;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerViewAdapter;
import model.CardModel;

public class SampleDataProvider {
    List<CardModel> data = new ArrayList<>();

    public List<CardModel> data() {
        data.add(new CardModel("Sports", (long) 12, "", "IPL 2018 Week Highlights", "Trent Boult. 5.4 over: Boult comes around the wicket, angles one in from the corner of the crease, slight drop in pace, seaming in from just short of good length. Kohli takes it on the up, stays upright, bottom hand takes over, balls disappears into the Delhi night, hits the sponsors’ box at extra cover", "", 10, 11));
        data.add(new CardModel("Breaking News", (long) 13, "", "", "", "", 100, 101));
        data.add(new CardModel("Technology", (long) 14, "", "", "", "", 101, 110));
        data.add(new CardModel("Politics", (long) 15, "", "", "", "", 102, 112));
        data.add(new CardModel("Entertainment", (long) 16, "", "", "", "", 104, 131));
        data.add(new CardModel("Food", (long) 17, "", "", "", "", 103, 121));
        return data;
    }
}


