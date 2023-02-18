import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GetMovies {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_l4zt2oir"))
                .timeout(Duration.ofMinutes(1))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Capturando o resultado da API com o JSONObject
        JSONObject jsonObject = new JSONObject(response.body());

        //Buscando apenas os array dos items
        JSONArray items = jsonObject.getJSONArray("items");
//        System.out.println(items.toString(2));

        Movie movie = new Movie();
        System.out.println("----------Titles----------");
        movie.parseTitles(items);

        System.out.println("----------Images----------");
        movie.parseUrlImages(items);

        System.out.println("----------Years----------");
        movie.parseYears(items);

        System.out.println("----------Ratings----------");
        movie.parseRatings(items);

    }

}
