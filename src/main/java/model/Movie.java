package model;

import java.util.List;
import java.util.Objects;

public class Movie {

    private Integer id;
    private String title;
    private List<BoxArt> boxarts;
    private String uri;
    private Double rating;
    private List<Bookmark> bookmark;
    private List<InterestingMoment> interestingMoments;

    public Movie() {
    }

    public Movie(Integer id, String title, List<BoxArt> boxarts, String uri, Double rating, List<Bookmark> bookmark, List<InterestingMoment> interestingMoments) {
        this.id = id;
        this.title = title;
        this.boxarts = boxarts;
        this.uri = uri;
        this.rating = rating;
        this.bookmark = bookmark;
        this.interestingMoments = interestingMoments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BoxArt> getBoxarts() {
        return boxarts;
    }

    public void setBoxarts(List<BoxArt> boxarts) {
        this.boxarts = boxarts;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Bookmark> getBookmark() {
        return bookmark;
    }

    public void setBookmark(List<Bookmark> bookmark) {
        this.bookmark = bookmark;
    }

    public List<InterestingMoment> getInterestingMoments() {
        return interestingMoments;
    }

    public void setInterestingMoments(List<InterestingMoment> interestingMoments) {
        this.interestingMoments = interestingMoments;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", boxarts=" + boxarts +
                ", uri='" + uri + '\'' +
                ", rating=" + rating +
                ", bookmark=" + bookmark +
                ", interestingMoments=" + interestingMoments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(boxarts, movie.boxarts) && Objects.equals(uri, movie.uri) && Objects.equals(rating, movie.rating) && Objects.equals(bookmark, movie.bookmark) && Objects.equals(interestingMoments, movie.interestingMoments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, boxarts, uri, rating, bookmark, interestingMoments);
    }
}
