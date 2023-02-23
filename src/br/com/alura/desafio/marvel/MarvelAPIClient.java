package br.com.alura.desafio.marvel;

import br.com.alura.desafio.main.APIClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarvelAPIClient implements APIClient {

    private final String endpoint;

    public MarvelAPIClient(String privateKey, String publicKey) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String hash = HashUtils.getHashMd5(timestamp + privateKey + publicKey);
        this.endpoint = String.format("https://gateway.marvel.com:443/v1/public/series?ts=%s&hash=%s&apikey=%s", timestamp, hash, publicKey);
    }

    public String getBody(){

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}

