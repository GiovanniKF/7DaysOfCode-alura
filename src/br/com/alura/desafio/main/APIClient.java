package br.com.alura.desafio.main;

import java.io.IOException;

public interface APIClient {

    String getBody() throws IOException, InterruptedException;
}
