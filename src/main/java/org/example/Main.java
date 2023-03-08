package org.example;

import org.example.model.Movie;
import org.example.service.HtmlGenerator;

import java.io.*;

import static org.example.config.HttpClient.getApi;
import static org.example.enums.Attribute.*;
import static org.example.service.MovieService.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        var json = formatJson(getApi());
        var arrayMovies = extractArrayMovies(json);
        var movie = new Movie();

        var titles = extractAttributes(arrayMovies, TITLE);
        var urlImages = extractAttributes(arrayMovies, IMAGE);
        var ratings = extractAttributes(arrayMovies, RATING);
        var years = extractAttributes(arrayMovies, YEAR);

        var movies = movie.addMovie(titles, urlImages, ratings, years);

        PrintWriter writer = new PrintWriter("content.html");
        new HtmlGenerator(writer).generate(movies);
        writer.close();
    }
}