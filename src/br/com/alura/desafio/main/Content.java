package br.com.alura.desafio.main;

public interface Content extends Comparable<Content> {

    String title();
    String urlImage();
    String year();
    String rating();
    String type();

}
