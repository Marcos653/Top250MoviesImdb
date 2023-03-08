package org.example.model;

import org.example.interfaces.MovieInterface;

import java.util.*;

public class Movie implements MovieInterface {

    private String title;
    private String urlImage;
    private Float rating;
    private Integer year;

    public Movie(String title, String urlImage, Float rating, Integer year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public List<Movie> addMovie(List<String> titles,
                                List<String> urlImages, List<String> ratings,
                                List<String> years) {
        var movies = new ArrayList<Movie>();

        for (int i = 0; i < titles.size(); i++) {
            movies.add(new Movie(titles.get(i), urlImages.get(i),
                    Float.parseFloat(ratings.get(i)), Integer.parseInt(years.get(i))));
        }

        return movies;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }

}
