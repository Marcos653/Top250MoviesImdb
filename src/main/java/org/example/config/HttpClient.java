package org.example.config;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class HttpClient {
    private static final String key = System.getenv("SECRET_KEY");

    public static String getApi() throws IOException, InterruptedException {
        var client = java.net.http.HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + key))
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

}
