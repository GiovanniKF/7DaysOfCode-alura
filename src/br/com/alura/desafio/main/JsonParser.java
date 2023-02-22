package br.com.alura.desafio.main;

import org.json.JSONArray;

import java.util.List;

public interface JsonParser {

    List<? extends Content> parse(JSONArray items);
}
