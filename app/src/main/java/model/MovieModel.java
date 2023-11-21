package model;

public class MovieModel {

    private String id;
    private String name;
    private String image;
    private String title;
    private String rating;
    private String releaseDate;

    public MovieModel() {
    }

    public MovieModel(String id, String name, String image, String title, String rating, String releaseDate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.title = title;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}