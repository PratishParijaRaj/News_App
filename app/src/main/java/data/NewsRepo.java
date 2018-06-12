package data;

import android.content.Context;

import java.util.List;

import TestedModel.WeatherModel;
import activity.SecondActivity;
import model.CardModel;

public class NewsRepo {
    List<CardModel> cardModelList;
    Context ctx;
    NewsDatabase newsDatabase;
    List<WeatherModel> weatherList;
    CallbackInterface callbackInterface;
    Call call;

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
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public void insertWeatherModel(final WeatherModel weatherModel) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                newsDatabase.getNewsDao().insertWeather(weatherModel);

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

    public String getWeather() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                weatherList = newsDatabase.getNewsDao().getWeatherDetails();

                ((SecondActivity) ctx).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        call.onWeatherRecived(weatherList);

                    }
                });
            }
        });
        thread.start();
        return null;

    }
    public interface  Call {
        void onWeatherRecived(List<WeatherModel> data);
    }

    public interface CallbackInterface {

        void onDataRetrieved(List<CardModel> dataList);
    }
}
