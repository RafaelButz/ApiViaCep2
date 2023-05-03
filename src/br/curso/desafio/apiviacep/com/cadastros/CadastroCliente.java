package br.curso.desafio.apiviacep.com.cadastros;

import br.curso.desafio.apiviacep.com.apiviacep.InterfaceChave;

import java.security.SecureRandom;

public class CadastroCliente implements InterfaceChave {
    private String nome;
    private String cpf;
    private String telefone;
    private int chaveCadastro;

    SecureRandom secureRandom = new SecureRandom();
    public CadastroCliente(String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.chaveCadastro = secureRandom.nextInt(1000000);
    }
    public String getTelefone() {
        return telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    public int getChaveCadastro() {
        return chaveCadastro;
    }

    public String toString() {
        return "\nNome: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Telefone: " + getTelefone() + "\n";

    }

    @Override
    public int getGeraChave() {
        return getChaveCadastro();
    }
}
