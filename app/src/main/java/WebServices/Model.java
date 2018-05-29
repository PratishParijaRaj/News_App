package WebServices;

import java.util.List;

public class Model {
    private int card_id;
    private int cardtype;
    private Long timestamp;
    private int likes;
    private int comments;
    private String url;
    private String categories;
    private String imageUrl;
    private String heading;
    private String description;
    public String descImage;
    private List<String> options;

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public void setCardtype(int cardtype) {
        this.cardtype = cardtype;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDescImage(String descImage) {
        this.descImage = descImage;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCard_id() {
        return card_id;
    }

    public int getCardtype() {
        return cardtype;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public String getUrl() {
        return url;
    }

    public String getCategories() {
        return categories;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public String getDescImage() {
        return descImage;
    }

    public List<String> getOptions() {
        return options;
    }
}
