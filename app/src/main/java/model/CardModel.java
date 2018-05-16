package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class CardModel implements Parcelable {
    public int cardtype;
    public String categories;
    public Long timestamp;
    public int imageUrl;
    public String heading;
    private String description;
    public int descImage;
    public int likes;
    public int comments;
    public ArrayList<String> options;
    public String url;

    public CardModel(){}
    public CardModel(int cardtype,String categories, Long timestamp, int imageUrl, String heading, int likes, int comments, ArrayList<String> options) {
        this.categories = categories;
        this.cardtype=cardtype;
        this.timestamp = timestamp;
        this.imageUrl = imageUrl;
        this.heading = heading;
        this.likes = likes;
        this.comments = comments;
        this.options = options;
    }
    public CardModel(int cardtype,String categories, Long timestamp, int imageUrl, String heading, String description, int descimage, int likes, int comments) {
        this.categories = categories;
        this.cardtype=cardtype;
        this.timestamp = timestamp;
        this.imageUrl = imageUrl;
        this.heading = heading;
        this.description = description;
        this.descImage = descimage;
        this.likes = likes;
        this.comments = comments;
    }



    public CardModel(int cardtype,String categories, Long timestamp, int imageUrl, String heading, String description,int likes, int comments, String url) {
        this.categories = categories;
        this.timestamp = timestamp;
        this.cardtype=cardtype;
        this.imageUrl = imageUrl;
        this.heading = heading;
        this.likes = likes;
        this.description=description;
        this.comments = comments;
        this.url = url;
    }

    public String getCategories() {
        return categories;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public int getDescimage() {
        return descImage;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDescimage(int descimage) {
        this.descImage = descimage;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.cardtype);
        dest.writeString(this.categories);
        dest.writeValue(this.timestamp);
        dest.writeInt(this.imageUrl);
        dest.writeString(this.heading);
        dest.writeString(this.description);
        dest.writeInt(this.descImage);
        dest.writeInt(this.likes);
        dest.writeInt(this.comments);
        dest.writeStringList(this.options);
        dest.writeString(this.url);
    }

    protected CardModel(Parcel in) {
        this.cardtype = in.readInt();
        this.categories = in.readString();
        this.timestamp = (Long) in.readValue(Long.class.getClassLoader());
        this.imageUrl = in.readInt();
        this.heading = in.readString();
        this.description = in.readString();
        this.descImage = in.readInt();
        this.likes = in.readInt();
        this.comments = in.readInt();
        this.options = in.createStringArrayList();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<CardModel> CREATOR = new Parcelable.Creator<CardModel>() {
        @Override
        public CardModel createFromParcel(Parcel source) {
            return new CardModel(source);
        }

        @Override
        public CardModel[] newArray(int size) {
            return new CardModel[size];
        }
    };
}
