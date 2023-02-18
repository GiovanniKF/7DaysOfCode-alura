import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    public void parseTitles(JSONArray json) {
        List<String> titles = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            JSONObject movies = json.getJSONObject(i);
            String title = movies.getString("title");

            titles.add(title);
        }

        titles.forEach(System.out::println);
    }

    public void parseUrlImages(JSONArray json) {
        List<String> urlImages = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            JSONObject movies = json.getJSONObject(i);
            String image = movies.getString("image");

            urlImages.add(image);
        }

        urlImages.forEach(System.out::println);
    }

    public void parseYears(JSONArray json) {
        List<String> years = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            JSONObject movies = json.getJSONObject(i);
            String year = movies.getString("year");

            years.add(year);
        }

        years.forEach(System.out::println);
    }

    public void parseRatings(JSONArray json) {
        List<String> ratings = new ArrayList<>();

        for (int i = 0; i < json.length(); i++) {
            JSONObject movies = json.getJSONObject(i);
            String rating = movies.getString("imDbRating");

            ratings.add(rating);
        }

        ratings.forEach(System.out::println);
    }

}
