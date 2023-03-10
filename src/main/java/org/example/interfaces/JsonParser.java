package org.example.interfaces;

import org.example.model.Movie;

import java.util.List;

public interface JsonParser {
    List<? extends Content> addObject(List<String> titles,
                                List<String> urlImages, List<String> ratings,
                                List<String> years);
}
