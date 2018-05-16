package data;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pratishparija.news.R;

import java.util.ArrayList;
import java.util.List;

import adapter.RecyclerViewAdapter;
import model.CardModel;

public class SampleDataProvider {
    List<CardModel> data = new ArrayList<>();

    public List<CardModel> getData() {
        List<String> xl = new ArrayList<String>();
        xl.add("England");
        xl.add("India");
        xl.add("Australia");
        xl.add("Pakistan");
        data.add(new CardModel(1,"Sports", (long) 12, R.mipmap.ic_launcher_round, "IPL 2018 Week Highlights", "Trent Boult. 5.4 over: Boult comes around the wicket, angles one in from the corner of the crease, slight drop in pace, seaming in from just short of good length. Kohli takes it on the up, stays upright, bottom hand takes over, balls disappears into the Delhi night, hits the sponsors’ box at extra cover", R.mipmap.a, 10, 11));
        data.add(new CardModel(1,"Breaking News", (long) 13, R.mipmap.ic_launcher_round, "Supreme Court Rejects Karnataka's Plea To Stall Finalisation Of Draft Cauvery Scheme", "\n" +
                "Supreme Court Rejects Karnataka's Plea To Stall Finalisation Of Draft Cauvery Scheme\n" +
                "The Supreme Court also asked the Centre to modify a provision in the draft Cauvery management scheme that authorises the Union government to issue directions \"from time to time\" on Cauvery water distribution between four southern riparian states, Tamil Nadu, Karnataka, Kerala and Puducherry.", R.mipmap.a, 100, 101));
        data.add(new CardModel(2,"Technology", (long) 14, R.mipmap.ic_launcher_round, "Who will win cricket worldcup 2019? ",101, 110, (ArrayList<String>) xl));
        data.add(new CardModel(2,"Entertainment", (long) 15, R.mipmap.ic_launcher_round, "IPL 2018 Week Highlights", 104, 131,(ArrayList<String>) xl));
        data.add(new CardModel(3,"Food", (long) 16, R.mipmap.ic_launcher_round, "IPL 2018 Week Highlights", "Description",  103, 121,""));
        data.add(new CardModel(3,"Politics", (long) 17, R.mipmap.ic_launcher_round, "IPL 2018 Week Highlights", "Description",  103, 121,""));
        return data;
    }
}


