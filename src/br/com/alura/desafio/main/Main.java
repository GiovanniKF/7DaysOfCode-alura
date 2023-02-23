package br.com.alura.desafio.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Chamando API...");
        String apiKey = "k_l4zt2oir";
        ImdbAPIClient ImdbAPIClient = new ImdbAPIClient(apiKey);
        String content = ImdbAPIClient.getBody();

        System.out.println("Parseando JSON...");
        List<? extends Content> contents = new ImdbMovieJsonParser().parse(content);

        System.out.println("Ordenando elementos...");
        //Collections.sort(contents, Comparator.comparing(Content::rating));
        contents.sort(Comparator.reverseOrder());

        System.out.println("Gerando HTML...");
        PrintWriter writer = new PrintWriter("movies.html");
        HTMLGenerator generator = new HTMLGenerator(writer);
        generator.generate(contents);
        writer.close();

    }

}
