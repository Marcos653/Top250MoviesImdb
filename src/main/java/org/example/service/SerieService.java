package org.example.service;

import org.example.enums.Attribute;
import org.example.interfaces.JsonParser;
import org.example.model.Serie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SerieService implements JsonParser {

    public static List<String> extractAttributes(String[] arraySeries, Attribute attributeType) {
        if (arraySeries == null) {
            throw new IllegalArgumentException("arraySeries cannot be null");
        }

        return Arrays.stream(arraySeries)
                .map(serie -> extractAttributeFromSerie(serie, attributeType))
                .collect(Collectors.toList());
    }

    private static String extractAttributeFromSerie(String serie, Attribute attributeType) {
        if (serie == null) {
            throw new IllegalArgumentException("serie cannot be null");
        }

        String[] parts = serie.split("\",\"");
        String value = parts[attributeType.getValue()]
                .substring(parts[attributeType.getValue()]
                        .indexOf(":")+1).replaceAll("\"","");
        return value;
    }

    public static String[] extractArraySerie(String json) {
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
    public List<Serie> addObject(List<String> titles,
                                 List<String> urlImages, List<String> ratings,
                                 List<String> years) {
        var series = new ArrayList<Serie>();

        for (int i = 0; i < titles.size(); i++) {
            series.add(new Serie(titles.get(i), urlImages.get(i),
                    Float.parseFloat(ratings.get(i)), Integer.parseInt(years.get(i))));
        }

        return series;
    }


}
