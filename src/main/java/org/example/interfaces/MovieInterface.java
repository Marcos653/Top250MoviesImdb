package org.example.interfaces;

import org.example.model.Movie;

import java.util.List;

public interface MovieInterface {
    public List<Movie> addMovie(List<String> titles,
                                List<String> urlImages, List<String> ratings,
                                List<String> years);
}
