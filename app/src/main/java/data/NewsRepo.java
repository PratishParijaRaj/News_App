package data;

import android.content.Context;

import java.util.List;

import activity.SecondActivity;
import model.CardModel;

public class NewsRepo {
    List<CardModel> cardModelList;
    Context ctx;
    NewsDatabase newsDatabase;
    CallbackInterface callbackInterface;

    public NewsRepo(Context context) {
        this.ctx = context;
        newsDatabase = NewsDatabase.getDatabase(ctx);
        if (ctx != null && ctx instanceof CallbackInterface) {
            callbackInterface = (CallbackInterface) ctx;
        }

    }

    public void deleteCard() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                newsDatabase.getNewsDao().deleteAll();

            }
        });
        thread.start();
    }

    public void insertCardModel(final List<CardModel> cardModel) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                newsDatabase.getNewsDao().insert(cardModel);

            }
        });
        thread.start();
    }

    public List<CardModel> getAllCards() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                cardModelList = newsDatabase.getNewsDao().getAll();

                ((SecondActivity) ctx).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callbackInterface.onDataRetrieved(cardModelList);

                    }
                });
            }
        });
        thread.start();

        return cardModelList;
    }

    public interface CallbackInterface {

        void onDataRetrieved(List<CardModel> dataList);
    }
}
