package br.com.alura.desafio.main;

import java.util.List;

public interface JsonParse {

    List<? extends Content> parse(String json);
}
