package org.example;

import java.io.IOException;
import java.net.*;
import java.net.http.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        final var key = System.getenv("SECRET_KEY");

        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + key))
                .GET()
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}