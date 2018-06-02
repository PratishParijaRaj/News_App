package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pratishparija.news.R;

import java.util.List;

import WebServices.Model;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder>{

    private List<Model> models;
    private Context context;
    private String str;

    public WeatherAdapter(Context contextList, List<Model> models) {
        this.models = models;
        this.context = contextList;
    }
    @NonNull
    @Override
    public WeatherAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.MyViewHolder holder, int position) {
        holder.textView1.setText(models.get(position).getCity_name());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text1)
        TextView textView1;
        @BindView(R.id.text2)
        TextView textView2;
        @BindView(R.id.text3)
        TextView textView3;
        @BindView(R.id.text4)
        TextView textView4;
        @BindView(R.id.text5)
        TextView textView5;
        @BindView(R.id.text6)
        TextView textView6;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
