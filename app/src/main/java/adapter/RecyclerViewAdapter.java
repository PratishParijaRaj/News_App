package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.pratishparija.news.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import model.CardModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CardModel> cardModels;
    private Context context;

    public RecyclerViewAdapter(Context contextList, List<CardModel> cardModels) {
        this.cardModels = cardModels;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return cardModels.get(position).getCardtype();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == 2) {
            ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.card1_layout, parent, false);
            return new MyNewViewHolder(view);
        } else return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MyViewHolder) {

            MyViewHolder viewHolder = (MyViewHolder) holder;

            long i1 = cardModels.get(position).getTimestamp();
            int i2 = cardModels.get(position).getLikes();
            int i3 = cardModels.get(position).getComments();
            String s1 = Long.toString(i1) + "h ago";
            String s3 = Integer.toString(i2);
            String s4 = Integer.toString(i3);
            viewHolder.categories.setText(cardModels.get(position).getCategories());
            viewHolder.timestamp.setText(s1);
            viewHolder.headerHeadings.setText(cardModels.get(position).getHeading());
            viewHolder.bodyDesc.setText(cardModels.get(position).getDescription());
            viewHolder.btnLike.setText(s3);
            viewHolder.btnComment.setText(s4);
            Picasso.get().load(cardModels.get(position).getDescimage()).resize(400,400).into(viewHolder.bodyImageView);
            Picasso.get().load(cardModels.get(position).getImageUrl()).into(viewHolder.headerImg);
        }
        if (holder instanceof MyNewViewHolder) {

            MyNewViewHolder viewHolder = (MyNewViewHolder) holder;
            int i2 = cardModels.get(position).getLikes();
            int i3 = cardModels.get(position).getComments();
            String s3 = Integer.toString(i2);
            String s4 = Integer.toString(i3);
            long i1 = cardModels.get(position).getTimestamp();
            String s1 = Long.toString(i1) + "h ago";
            viewHolder.categories.setText(cardModels.get(position).getCategories());
            viewHolder.timestamp.setText(s1);
            viewHolder.headerHeadings.setText(cardModels.get(position).getHeading());
            viewHolder.btnLike.setText(s3);
            viewHolder.btnComment.setText(s4);
            Picasso.get().load(cardModels.get(position).getImageUrl()).resize(400,400).centerCrop().into(viewHolder.headerImg);
            ArrayList<String> opt =new ArrayList<>();
            opt = cardModels.get(position).getOptions();
            viewHolder.radio1.setText(opt.get(0));
            viewHolder.radio2.setText(opt.get(1));
            viewHolder.radio3.setText(opt.get(2));
            viewHolder.radio4.setText(opt.get(3));
        }
    }

    @Override
    public int getItemCount() {
        return cardModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.categories)
        TextView categories;
        @BindView(R.id.timestamp)
        TextView timestamp;
        @BindView(R.id.header_img)
        CircleImageView headerImg;
        @BindView(R.id.header_headings)
        TextView headerHeadings;
        @BindView(R.id.body_desc)
        TextView bodyDesc;
        @BindView(R.id.body_image_view)
        ImageView bodyImageView;
        @BindView(R.id.btn_like)
        Button btnLike;
        @BindView(R.id.btn_comment)
        Button btnComment;
        @BindView(R.id.cardview_id)
        CardView cardviewId;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }
    public class MyNewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cardview_id_2)
        CardView cardviewId2;
        @BindView(R.id.radio_button_1)
        RadioButton radio1;
        @BindView(R.id.radio_button_2)
        RadioButton radio2;
        @BindView(R.id.radio_button_3)
        RadioButton radio3;
        @BindView(R.id.radio_button_4)
        RadioButton radio4;
        @BindView(R.id.categories)
        TextView categories;
        @BindView(R.id.timestamp)
        TextView timestamp;
        @BindView(R.id.header_img)
        CircleImageView headerImg;
        @BindView(R.id.header_headings)
        TextView headerHeadings;
        @BindView(R.id.btn_like)
        Button btnLike;
        @BindView(R.id.btn_comment)
        Button btnComment;

        public MyNewViewHolder(View itemView1) {
            super(itemView1);
            ButterKnife.bind(this, itemView1);

        }
    }

}