package org.example.config;

import org.example.interfaces.ApiClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class ImdbApiClient implements ApiClient {
    private static final String key = System.getenv("SECRET_KEY");

    public String getApi() throws IOException, InterruptedException {
        var client = java.net.http.HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + "k_zn8y3r37"))
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
    }

}
