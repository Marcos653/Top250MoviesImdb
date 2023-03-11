package org.example;

import org.example.config.ImdbApiClient;
import org.example.config.MarvelApiClient;
import org.example.interfaces.Content;
import org.example.interfaces.JsonParser;
import org.example.service.HtmlGenerator;
import org.example.service.SerieService;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        var imdbApi = new ImdbApiClient();
        var marvelApi = new MarvelApiClient();

//        JsonParser jsonParserImdb = new MovieService(imdbApi.getApi());
//        List<? extends Content> contentList = jsonParserImdb.parse();
        JsonParser jsonParserMarvel = new SerieService(marvelApi.getApi());
        List<? extends Content> contentList = jsonParserMarvel.parse();
        Collections.sort(contentList, Comparator.comparing(Content::title));

        PrintWriter writer = new PrintWriter("content.html");
        new HtmlGenerator(writer).generate(contentList);
        writer.close();
    }
}