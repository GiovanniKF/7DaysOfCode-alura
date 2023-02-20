import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GetMovies {

    public record Movie (String title, String urlImage, String year, String rating) {}

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_l4zt2oir"))
                .timeout(Duration.ofMinutes(1))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Utilizei o JSONObject para formatar no console e manipulá-lo depois.
        JSONObject jsonObject = new JSONObject(response.body());

        //Buscando apenas os array dos items (filmes).
        JSONArray items = jsonObject.getJSONArray("items");

        List<Movie> movies = parse(items);

        PrintWriter writer = new PrintWriter("movies.html");

        HTMLGenerator generator = new HTMLGenerator(writer);
        generator.generate(movies);
        writer.close();

    }

    public static List<Movie> parse(JSONArray items) {
        List<String> titles = parseTitles(items);
        List<String> urlImages = parseUrlImages(items);
        List<String> years = parseYears(items);
        List<String> ratings = parseRatings(items);

        List<Movie> movies = new ArrayList<>(titles.size());

        for (int i = 0; i < titles.size(); i++) {
            movies.add(new Movie(titles.get(i), urlImages.get(i), years.get(i), ratings.get(i)));
        }

        return movies;
    }

    public static List<String> parseTitles(JSONArray json) {
        List<String> titles = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            JSONObject movies = json.getJSONObject(i);
            String title = movies.getString("title");

            titles.add(title);
        }

        return titles;
    }

    public static List<String> parseUrlImages(JSONArray json) {
        List<String> urlImages = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            JSONObject movies = json.getJSONObject(i);
            String image = movies.getString("image");

            urlImages.add(image);
        }

        return urlImages;
    }

    public static List<String> parseYears(JSONArray json) {
        List<String> years = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            JSONObject movies = json.getJSONObject(i);
            String year = movies.getString("year");

            years.add(year);
        }

        return years;
    }

    public static List<String> parseRatings(JSONArray json) {
        List<String> ratings = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            JSONObject movies = json.getJSONObject(i);
            String rating = movies.getString("imDbRating");

            ratings.add(rating);
        }

        return ratings;
    }

}
