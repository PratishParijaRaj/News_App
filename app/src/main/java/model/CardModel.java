package model;

public class CardModel {
    String categories;
    Long timestamp;
    String imageUrl;
    String heading;
    String description;
    String descImage;
    int likes;
    int comments;

    public CardModel(String categories, Long timestamp, String imageUrl, String heading, String description, String descimage, int likes, int comments) {
        this.categories = categories;
        this.timestamp = timestamp;
        this.imageUrl = imageUrl;
        this.heading = heading;
        this.description = description;
        this.descImage = descimage;
        this.likes = likes;
        this.comments = comments;
    }

    public String getCategories() {
        return categories;
    }

    public Long getTimestamp() {
        return timestamp;
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

    public String getDescimage() {
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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDescimage(String descimage) {
        this.descImage = descimage;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

}
