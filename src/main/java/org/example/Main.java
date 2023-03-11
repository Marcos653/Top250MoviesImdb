package org.example;

import org.example.config.ImdbApiClient;
import org.example.config.MarvelApiClient;
import org.example.interfaces.Content;
import org.example.interfaces.JsonParser;
import org.example.service.HtmlGenerator;
import org.example.service.MovieService;
import org.example.service.SerieService;

import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        var imdbApi = new ImdbApiClient();
        var marvelApi = new MarvelApiClient();

        JsonParser jsonParserImdb = new MovieService(imdbApi.getApi());
        List<? extends Content> moviesList = jsonParserImdb.parse();
        JsonParser jsonParserMarvel = new SerieService(marvelApi.getApi());
        List<? extends Content> seriesList = jsonParserMarvel.parse();

        List<? extends Content> mixedList = Stream.of(seriesList, moviesList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Collections.sort(mixedList, Comparator.comparing(Content::title));

        PrintWriter writer = new PrintWriter("content.html");
        new HtmlGenerator(writer).generate(mixedList);
        writer.close();
    }
}