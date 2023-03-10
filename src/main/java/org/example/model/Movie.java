package org.example.model;

import org.example.interfaces.Content;

public record Movie(
         String title,
         String urlImage,
         Float rating,
         Integer year
) implements Content {

}
