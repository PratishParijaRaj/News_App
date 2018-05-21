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
    private static List<CardModel> data = new ArrayList<>();

    public static List<CardModel> getData() {
        List<String> xl = new ArrayList<>();
        xl.add("England");
        xl.add("India");
        xl.add("Australia");
        xl.add("Pakistan");
        data.add(new CardModel(1, "Sports", (long) 12, "https://firebasestorage.googleapis.com/v0/b/news-e5e04.appspot.com/o/coniglio_rabbit_small.png?alt=media&token=dda63b10-eb25-4095-9fcb-7919134a0a31", "IPL 2018 Week Highlights", "Trent Boult. 5.4 over: Boult comes around the wicket, angles one in from the corner of the crease, slight drop in pace, seaming in from just short of good length. " +
                "Kohliat extra cover", "https://firebasestorage.googleapis.com/v0/b/news-e5e04.appspot.com/o/a.png?alt=media&token=9cb72430-d90a-48e5-8f7a-e825efdcca46", 10, 11));
        data.add(new CardModel(2, "Technology", (long) 14, "https://firebasestorage.googleapis.com/v0/b/news-e5e04.appspot.com/o/a.png?alt=media&token=9cb72430-d90a-48e5-8f7a-e825efdcca46", "Who will win cricket worldcup 2019? ", 101, 110, (ArrayList<String>) xl));
        data.add(new CardModel(3, "Food", (long) 16, "https://firebasestorage.googleapis.com/v0/b/news-e5e04.appspot.com/o/a.png?alt=media&token=9cb72430-d90a-48e5-8f7a-e825efdcca46", "IPL 2018 Week Highlights", "Description", 103, 121, "https://www.nytimes.com/2018/05/08/technology/google-io.html?rref=collection%2Ftimestopic%2FAndroid&action=click&contentCollection=timestopics&region=stream&module=stream_unit&version=latest&contentPlacement=2&pgtype=collection"));
        data.add(new CardModel(1, "Breaking News politics", (long) 13, "https://firebasestorage.googleapis.com/v0/b/news-e5e04.appspot.com/o/coniglio_rabbit_small.png?alt=media&token=dda63b10-eb25-4095-9fcb-7919134a0a31", "Supreme Court Rejects Karnataka's Plea To Stall Finalisation", "\n" +
                "Supreme Court Rejects Karnataka's Draft Cauvery Scheme\n" +
                "The Supreme Court a issue directions \"from time to time\" on   Puducherry.", "https://firebasestorage.googleapis.com/v0/b/news-e5e04.appspot.com/o/b.png?alt=media&token=1fccbc9a-183a-4c7d-8ca3-e92295555148", 100, 101));
        data.add(new CardModel(2, "Entertainment", (long) 15, "https://firebasestorage.googleapis.com/v0/b/news-e5e04.appspot.com/o/a.png?alt=media&token=9cb72430-d90a-48e5-8f7a-e825efdcca46", "IPL 2018 Week Highlights", 104, 131, (ArrayList<String>) xl));
        data.add(new CardModel(3, "Politics", (long) 17, "https://firebasestorage.googleapis.com/v0/b/news-e5e04.appspot.com/o/a.png?alt=media&token=9cb72430-d90a-48e5-8f7a-e825efdcca46", "IPL 2018 Week Highlights", "Description", 103, 121, "https://www.nytimes.com/2018/05/19/technology/facebook-deletion-center-germany.html?rref=collection%2Fsectioncollection%2Ftechnology&action=click&contentCollection=technology&region=rank&module=package&version=highlights&contentPlacement=1&pgtype=sectionfront"));
        return data;
    }
}


