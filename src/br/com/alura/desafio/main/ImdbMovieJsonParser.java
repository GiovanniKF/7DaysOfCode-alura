package br.com.alura.desafio.main;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

record Movie(String title, String urlImage, String year, String rating, String type) implements Content {

    @Override
    public int compareTo(Content o) {
        return this.rating().compareTo(o.rating());
    }

}

public class ImdbMovieJsonParser implements JsonParse {

    public List<? extends Content> parse(String json) {
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("items");

        List<String> titles = parseTitles(jsonArray);
        List<String> urlImages = parseUrlImages(jsonArray);
        List<String> years = parseYears(jsonArray);
        List<String> ratings = parseRatings(jsonArray);
        String type = "Movie";

        List<Movie> movies = new ArrayList<>(titles.size());

        for (int i = 0; i < titles.size(); i++) {
            movies.add(new Movie(titles.get(i), urlImages.get(i), years.get(i), ratings.get(i), type));
        }

        return movies;
    }

    public static List<String> parseTitles(JsonArray content) {
        List<String> titles = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            titles.add(content.get(i).getAsJsonObject().get("title").getAsString());
        }

        return titles;
    }

    public static List<String> parseUrlImages(JsonArray content) {
        List<String> titles = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            titles.add(content.get(i).getAsJsonObject().get("image").getAsString());
        }

        return titles;
    }

    public static List<String> parseYears(JsonArray content) {
        List<String> titles = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            titles.add(content.get(i).getAsJsonObject().get("year").getAsString());
        }

        return titles;
    }

    public static List<String> parseRatings(JsonArray content) {
        List<String> titles = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            titles.add(content.get(i).getAsJsonObject().get("imDbRating").getAsString());
        }

        return titles;
    }
}
