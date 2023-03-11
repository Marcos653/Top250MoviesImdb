package org.example.config;

import org.example.interfaces.ApiClient;
import org.example.tools.HashUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarvelApiClient implements ApiClient {
    private static final String key = "87272010e64852181a0f7751ae8cb8f4";
    private static final String privateKey = "5778c8310c5662e924af1f88b718e8484432541e";
    private final String endpoint;

    public MarvelApiClient() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String hash = HashUtils.getHashMd5(timestamp + privateKey + key);
        this.endpoint = String.format("https://gateway.marvel.com:443/v1/public/series?ts=%s&hash=%s&apikey=%s",
                timestamp, hash, key);
        System.out.println(endpoint);
    }

    @Override
    public String getApi() {
        String json = executeRequest();
        System.out.println(json);
        return json;

    }

    private String executeRequest() {
        try {
            URI apiIMDB = URI.create(this.endpoint);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(apiIMDB).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
