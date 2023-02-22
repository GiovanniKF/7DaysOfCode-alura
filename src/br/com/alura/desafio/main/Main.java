package br.com.alura.desafio.main;

import org.json.JSONArray;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Chamando API...");
        String apiKey = "k_l4zt2oir";
        ImdbAPIClient ImdbAPIClient = new ImdbAPIClient(apiKey);
        JSONArray items = ImdbAPIClient.getBody();

        System.out.println("Parseando JSON...");
        List<? extends Content> contents = new ImdbMovieJsonParser().parse(items);

        System.out.println("Gerando HTML...");
        PrintWriter writer = new PrintWriter("movies.html");
        HTMLGenerator generator = new HTMLGenerator(writer);
        generator.generate(contents);
        writer.close();

    }

}
