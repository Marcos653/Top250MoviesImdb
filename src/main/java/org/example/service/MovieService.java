package org.example.service;

import org.example.enums.Attribute;

import java.util.*;

public class MovieService {

    public static List<String> extractAttributes(String[] arrayMovies, ArrayList<String> list, Attribute typeAttribute) {
        for (String movie : arrayMovies) {
            String atributo = movie.split("\",\"")[typeAttribute.getValue()]
                    .substring(movie.split("\",\"")[typeAttribute.getValue()]
                            .indexOf(":")+1).replaceAll("\"","");

            list.add(atributo);
        }

        return list;
    }

    public static String[] extractArrayMovies(String json) {
        return json.split("},");
    }

    public static String formatJson(String json) {
        return json.substring(json.indexOf("[")+1, json.indexOf("]"));
    }
}
