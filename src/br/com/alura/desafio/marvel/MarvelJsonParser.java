package br.com.alura.desafio.marvel;

import br.com.alura.desafio.main.Content;
import br.com.alura.desafio.main.JsonParse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import java.util.ArrayList;

import java.util.List;


record Serie(String title, String urlImage, String year, String rating, String type) implements Content {

    @Override
    public int compareTo(Content o) {
        return 0;
    }
}

public class MarvelJsonParser implements JsonParse {

    @Override
    public List<? extends Content> parse(String json) {
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonObject("data").getAsJsonArray("results");

        List<String> titles = parseTitles(jsonArray);
        List<String> urlImages = parseUrlImages(jsonArray);
        List<String> years = parseYears(jsonArray);
        List<String> ratings = parseRatings(jsonArray);
        String type = "Series";

        List<Serie> series = new ArrayList<>(titles.size());

        for (int i = 0; i < titles.size(); i++) {
            series.add(new Serie(titles.get(i), urlImages.get(i), years.get(i), ratings.get(i), type));
        }

        return series;
    }

    public static List<String> parseTitles(JsonArray content) {
        List<String> titles = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            titles.add(content.get(i).getAsJsonObject().get("title").getAsString());
        }

        return titles;
    }

    public static List<String> parseUrlImages(JsonArray content) {
        List<String> urlImages = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            urlImages.add(content.get(i).getAsJsonObject().get("thumbnail").getAsJsonObject().get("path").getAsString() + "."
                    + content.get(i).getAsJsonObject().get("thumbnail").getAsJsonObject().get("extension").getAsString());
        }

        return urlImages;
    }

    public static List<String> parseYears(JsonArray content) {
        List<String> years = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            years.add(content.get(i).getAsJsonObject().get("startYear").getAsString());
        }

        return years;
    }

    public static List<String> parseRatings(JsonArray content) {
        List<String> ratings = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            ratings.add(content.get(i).getAsJsonObject().get("rating").getAsString());
        }

        return ratings;
    }

}
