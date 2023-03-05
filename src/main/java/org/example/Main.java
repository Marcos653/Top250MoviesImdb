package org.example;

import java.io.IOException;
import java.net.*;
import java.net.http.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        final var key = System.getenv("SECRET_KEY");

        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + key))
                .GET()
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        var json = formatJson(response);
        var arrayMovies = extractArrayMovies(json);

        var titles = extractAttributes(arrayMovies, new ArrayList<>(), Attribute.TITLE);
        var imageUrls = extractAttributes(arrayMovies, new ArrayList<>(), Attribute.IMAGE);
        var rating = extractAttributes(arrayMovies, new ArrayList<>(), Attribute.RATING);
        var years = extractAttributes(arrayMovies, new ArrayList<>(), Attribute.YEAR);

        System.out.println(titles);
        System.out.println(imageUrls);
        System.out.println(rating);
        System.out.println(years);
    }

    private static List<String> extractAttributes(String[] arrayMovies, ArrayList<String> list, Attribute typeAttribute) {
        for (String movie : arrayMovies) {
            String atributo = movie.split("\",\"")[typeAttribute.getValue()].substring(movie.split("\",\"")[typeAttribute.getValue()].indexOf(":")+1).replaceAll("\"","");
            list.add(atributo);
        }

        return list;
    }

    private static String[] extractArrayMovies(String json) {
        return json.split("},");
    }

    private static String formatJson(String json) {
        return json.substring(json.indexOf("[")+1, json.indexOf("]"));
    }
}