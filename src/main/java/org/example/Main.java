package org.example;

import org.example.config.ImdbApiClient;
import org.example.config.MarvelApiClient;
import org.example.service.HtmlGenerator;
import org.example.service.MovieService;
import org.example.service.SerieService;

import java.io.*;

import static org.example.enums.Attribute.*;
import static org.example.service.MovieService.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        var movieService = new MovieService();
        var serieService = new SerieService();
        var imdbApi = new ImdbApiClient();
        var marvelApi = new MarvelApiClient();

//        var jsonImdb = formatJson(imdbApi.getApi());
        var jsonMarvel = formatJson(marvelApi.getApi());
        var arrayObjects = extractArrayMovies(jsonMarvel);

        var titles = extractAttributes(arrayObjects, TITLE);
        var urlImages = extractAttributes(arrayObjects, IMAGE);
        var ratings = extractAttributes(arrayObjects, RATING);
        var years = extractAttributes(arrayObjects, YEAR);

//        var movies = movieService.addObject(titles, urlImages, ratings, years);
        var series = serieService.addObject(titles, urlImages, ratings, years);

        PrintWriter writer = new PrintWriter("content.html");
        new HtmlGenerator(writer).generate(series);
        writer.close();
    }
}