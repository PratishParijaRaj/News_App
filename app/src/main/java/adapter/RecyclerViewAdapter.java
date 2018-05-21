package adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pratishparija.news.R;
import com.leocardz.link.preview.library.LinkPreviewCallback;
import com.leocardz.link.preview.library.SourceContent;
import com.leocardz.link.preview.library.TextCrawler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import activity.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
        } else if (viewType == 3) {
            ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.preview_layout, parent, false);
            return new MyPreviewViewHolder(view);
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
            Picasso.get().load(cardModels.get(position).getDescimage()).resize(400, 400).into(viewHolder.bodyImageView);
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
            Picasso.get().load(cardModels.get(position).getImageUrl()).resize(400, 400).centerCrop().into(viewHolder.headerImg);
            ArrayList<String> opt = new ArrayList<>();
            opt = cardModels.get(position).getOptions();
            viewHolder.radio1.setText(opt.get(0));
            viewHolder.radio2.setText(opt.get(1));
            viewHolder.radio3.setText(opt.get(2));
            viewHolder.radio4.setText(opt.get(3));
        }
        if (holder instanceof MyPreviewViewHolder) {

            final MyPreviewViewHolder viewHolder = (MyPreviewViewHolder) holder;
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
            Picasso.get().load(cardModels.get(position).getImageUrl()).resize(400, 400).centerCrop().into(viewHolder.headerImg);
            String preview = cardModels.get(position).getUrl();
            LinkPreviewCallback linkPreviewCallback = new LinkPreviewCallback() {
                @Override

                public void onPre() {
                }

                @Override

                public void onPos(final SourceContent sourceContent, boolean b) {
                    viewHolder.previewText.setText(sourceContent.getTitle());
                    List<String> images = new ArrayList();
                    images = sourceContent.getImages();
                    Picasso.get().load(images.get(0)).into(viewHolder.preview);
                    String str = sourceContent.getUrl();


                }

            };
            TextCrawler textCrawler = new TextCrawler();
            textCrawler.makePreview(linkPreviewCallback, preview);

            viewHolder.preview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return cardModels.size();
    }

    //    @OnClick(R.id.preview)
//    public void onViewClicked() {
//        Toast.makeText(context, "hiiiiii", Toast.LENGTH_LONG).show();
//        Uri uri = Uri.parse("https://android.jlelse.eu/room-store-your-data-c6d49b4d53a3");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        context.startActivity(intent);
//    }



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

    public class MyPreviewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cardview_id_3)
        CardView cardviewId3;
        @BindView(R.id.categories)
        TextView categories;
        @BindView(R.id.preview)
        ImageView preview;
        @BindView(R.id.timestamp)
        TextView timestamp;
        @BindView(R.id.header_img)
        CircleImageView headerImg;
        @BindView(R.id.header_headings)
        TextView headerHeadings;
        @BindView(R.id.preview_text)
        TextView previewText;
        @BindView(R.id.btn_like)
        Button btnLike;
        @BindView(R.id.btn_comment)
        Button btnComment;



        public MyPreviewViewHolder(View itemView1) {
            super(itemView1);
            ButterKnife.bind(this, itemView1);

        }
    }

}