package org.example.model;

import org.example.interfaces.Content;

public record Movie(
        String title,
        String urlImage,
        String rating,
        String year,
        String type)
        implements Content {

    @Override
    public int compareTo(Content c) {
        return this.rating().compareTo(c.rating());
    }
}
