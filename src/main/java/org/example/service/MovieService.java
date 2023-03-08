package org.example.service;

import org.example.enums.Attribute;

import java.util.*;
import java.util.stream.Collectors;

public class MovieService {

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
        String value = parts[attributeType.getValue()].substring(parts[attributeType.getValue()].indexOf(":")+1).replaceAll("\"","");
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
}
