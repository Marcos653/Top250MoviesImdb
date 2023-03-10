package org.example.service;

import org.example.enums.Attribute;
import org.example.interfaces.Content;
import org.example.interfaces.JsonParser;
import org.example.model.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieService implements JsonParser {

    public static List<String> extractAttributes(String[] arrayMovies, Attribute attributeType) {
        if (arrayMovies == null) {
            throw new IllegalArgumentException("arrayMovies cannot be null");
        }

        return Arrays.stream(arrayMovies)
                .map(movie -> extractAttributeFromMovie(movie, attributeType))
                .collect(Collectors.toList());
    }

    private static String extractAttributeFromMovie(String movie, Attribute attributeType) {
        if (movie == null) {
            throw new IllegalArgumentException("movie cannot be null");
        }

        String[] parts = movie.split("\",\"");
        String value = parts[attributeType.getValue()]
                .substring(parts[attributeType.getValue()]
                        .indexOf(":")+1).replaceAll("\"","");
        return value;
    }

    public static String[] extractArrayMovies(String json) {
        if (json == null) {
            throw new IllegalArgumentException("json cannot be null");
        }

        return json.split("},");
    }

    public static String formatJson(String json) {
        if (json == null) {
            throw new IllegalArgumentException("json cannot be null");
        }

        return json.substring(json.indexOf("[") + 1, json.indexOf("]"));
    }

    @Override
    public List<Movie> addObject(List<String> titles,
                                List<String> urlImages, List<String> ratings,
                                List<String> years) {
        var movies = new ArrayList<Movie>();

        for (int i = 0; i < titles.size(); i++) {
            movies.add(new Movie(titles.get(i), urlImages.get(i),
                    Float.parseFloat(ratings.get(i)), Integer.parseInt(years.get(i))));
        }

        return movies;
    }
}
