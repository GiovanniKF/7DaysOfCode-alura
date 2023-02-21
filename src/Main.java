import org.json.JSONArray;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        JSONArray items = new ImdbApiClient().getBody();

        List<Movie> movies = Movie.parse(items);

        PrintWriter writer = new PrintWriter("movies.html");

        HTMLGenerator generator = new HTMLGenerator(writer);
        generator.generate(movies);
        writer.close();

    }



}
