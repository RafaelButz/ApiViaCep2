package br.curso.desafio.apiviacep.com.cadastros;
import br.curso.desafio.apiviacep.com.apiviacep.InterfaceChave;
import br.curso.desafio.apiviacep.com.fluxoregistro.InterFaceGeraLista;

import java.security.SecureRandom;
import java.util.ArrayList;

public class CadastroCliente implements InterfaceChave, InterFaceGeraLista{
    private String nome;
    private String cpf;
    private String telefone;
    private int chaveCadastro;

    SecureRandom secureRandom = new SecureRandom();
    ArrayList<CadastroCliente> listaCliente = new ArrayList<>();

    public CadastroCliente(String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.chaveCadastro = secureRandom.nextInt(1000000);

    }

    public void listaCliente(CadastroCliente cliente){
        listaCliente.add(cliente);
    }

    public ArrayList<CadastroCliente> getListaCliente() {
        return listaCliente;
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

    @Override
    public Object getGeralista() {
        return getListaCliente();
    }
}
