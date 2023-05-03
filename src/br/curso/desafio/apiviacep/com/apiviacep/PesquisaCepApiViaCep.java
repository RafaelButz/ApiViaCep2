package br.curso.desafio.apiviacep.com.apiviacep;

import br.curso.desafio.apiviacep.com.cadastros.CadastroEnderecoViaCep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PesquisaCepApiViaCep {
    private String json;
    private String cep;
    private String endereco;

    CadastroEnderecoViaCep novoViaCep;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void criaJson(String cep) throws IOException, InterruptedException {

        this.cep = cep;

        if(this.cep.length() != 8 ){
        this.endereco = "https://viacep.com.br/ws/01001000/json/";
        }else {
        this.cep = cep;
        this.endereco = "https://viacep.com.br/ws/" + cep + "/json/";
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        this.json = response.body();

        novoViaCep = gson.fromJson(json, CadastroEnderecoViaCep.class);

    }

    public CadastroEnderecoViaCep getNovoViaCep() {
        return novoViaCep;
    }

    public String getJson() {
        return json;
    }

}
