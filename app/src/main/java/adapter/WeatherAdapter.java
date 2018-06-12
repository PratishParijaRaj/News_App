package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pratishparija.news.R;
import com.squareup.picasso.Picasso;

import java.util.List;


import TestedModel.Weather;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {

    private List<Weather> models;
    private Context context;
    private String str;

    public WeatherAdapter(Context context, List<Weather> models) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public WeatherAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.MyViewHolder holder, int position) {
        holder.textView1.setText(models.get(position).getDescription());
        holder.textView2.setText(models.get(position).getMain());
//        holder.textView3.setText(models.get(position).getIcon());
        holder.textView4.setText(Integer.toString(models.get(position).getId()));
        Picasso.get().load(models.get(position).getIcon()).resize(400, 400).into(holder.textView3);

    }

    @Override
    public int getItemCount() { return models.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text1)
        TextView textView1;
        @BindView(R.id.text2)
        TextView textView2;
        @BindView(R.id.text3)
        ImageView textView3;
        @BindView(R.id.text4)
        TextView textView4;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
}
