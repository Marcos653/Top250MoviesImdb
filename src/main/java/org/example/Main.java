package org.example;

import org.example.model.Movie;

import java.io.IOException;
import java.util.ArrayList;

import static org.example.config.HttpClient.getApi;
import static org.example.enums.Attribute.*;
import static org.example.service.MovieService.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var json = formatJson(getApi());
        var arrayMovies = extractArrayMovies(json);
        var movie = new Movie();

        var titles = extractAttributes(arrayMovies, new ArrayList<>(), TITLE);
        var urlImages = extractAttributes(arrayMovies, new ArrayList<>(), IMAGE);
        var ratings = extractAttributes(arrayMovies, new ArrayList<>(), RATING);
        var years = extractAttributes(arrayMovies, new ArrayList<>(), YEAR);

        var movies = movie.addMovie(titles, urlImages, ratings, years);

        movies.forEach(System.out::println);
    }
}