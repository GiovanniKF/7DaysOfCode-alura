package br.com.alura.desafio.marvel;

import br.com.alura.desafio.main.Content;
import br.com.alura.desafio.main.HTMLGenerator;
import br.com.alura.desafio.main.ImdbAPIClient;
import br.com.alura.desafio.main.ImdbMovieJsonParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMarvel {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Chamando API da Marvel...");
        String privateKey = "48870f28fd5665cf13539baa1e42937da5218891";
        String publicKey = "aa148065e0ea959233b3efa7bcac95b9";
        MarvelAPIClient marvelAPIClient = new MarvelAPIClient(privateKey, publicKey);
        String marvelContent = marvelAPIClient.getBody();

        System.out.println("Chamando API de Filmes...");
        String apiKey = "k_l4zt2oir";
        ImdbAPIClient ImdbAPIClient = new ImdbAPIClient(apiKey);
        String imdbContent = ImdbAPIClient.getBody();

        System.out.println("Parseando JSON...");
        List<? extends Content> movieList = new ImdbMovieJsonParser().parse(imdbContent);
        List<? extends Content> marvelList = new MarvelJsonParser().parse(marvelContent);

        System.out.println("Unificando conteúdos...");
        List<? extends Content> mixedList = Stream.of(marvelList, movieList)
                .flatMap(Collection::stream).sorted(Comparator.comparing(Content::year)).collect(Collectors.toList());

        System.out.println("Gerando HTML...");
        PrintWriter writer = new PrintWriter("mixed.html");
        HTMLGenerator generator = new HTMLGenerator(writer);
        generator.generate(mixedList);
        writer.close();

    }

}
