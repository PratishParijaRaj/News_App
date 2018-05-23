package data;

import android.content.Context;
import android.widget.LinearLayout;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

import model.CardModel;

public class NewsRepo {

    Context ctx;
    NewsDatabase newsDatabase;

    public NewsRepo(Context context) {
    this.ctx = context;
    newsDatabase = NewsDatabase.getDatabase(ctx);

    }

    public void insertCardModel(CardModel cardModel){
        newsDatabase.getNewsDao().insert(cardModel);
    }

    public List<CardModel> getAllCards(){

       return newsDatabase.getNewsDao().getAll();
    }
}
