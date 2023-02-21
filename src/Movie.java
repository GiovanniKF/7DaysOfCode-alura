import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String title;
    String urlImage;
    String year;
    String rating;

    public Movie(String title, String urlImage, String year, String rating) {
        this.title = title;
        this.urlImage = urlImage;
        this.year = year;
        this.rating = rating;
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
