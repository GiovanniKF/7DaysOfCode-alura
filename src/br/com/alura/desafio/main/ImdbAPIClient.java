package br.com.alura.desafio.main;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ImdbAPIClient implements APIClient{

    private String apiKey;

    public ImdbAPIClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public JSONArray getBody() {

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
                    .timeout(Duration.ofMinutes(1))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Utilizei o JSONObject para formatar no console e manipulá-lo depois.
            JSONObject jsonObject = new JSONObject(response.body());

            //Buscando apenas os array dos items (filmes).
            return jsonObject.getJSONArray("items");
        } catch (IOException | InterruptedException e) {
            throw new IllegalStateException(e);
        }

    }
}
