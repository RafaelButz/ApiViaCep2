package br.curso.desafio.apiviacep.com.cadastros;

import br.curso.desafio.apiviacep.com.apiviacep.InterfaceChave;

import java.security.SecureRandom;

public class CadastroEndereco implements InterfaceChave {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String numero;
    private int chaveCadastro;

    SecureRandom secureRandom = new SecureRandom();
    public CadastroEndereco(CadastroEnderecoViaCep enderecoViaCep){
        this.cep = enderecoViaCep.cep();
        this.logradouro = enderecoViaCep.logradouro();
        this.bairro = enderecoViaCep.bairro();
        this.localidade = enderecoViaCep.localidade();
        this.uf = enderecoViaCep.uf();
        this.chaveCadastro = secureRandom.nextInt(1000000);
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return  "Rua: " + getLogradouro() + "\n" +
                "Bairro: " + getBairro() + "\n" +
                "Cidade: " + getLocalidade() + "\n" +
                "UF: " + getUf() + "\n" +
                "CEP: " + getCep();
    }

    public int getChaveCadastro() {
        return chaveCadastro;
    }

    @Override
    public int getGeraChave() {
        return getChaveCadastro();
    }
}
