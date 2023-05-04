package br.curso.desafio.apiviacep.com.fluxoregistro;

import br.curso.desafio.apiviacep.com.cadastros.CadastroCliente;
import br.curso.desafio.apiviacep.com.cadastros.CadastroEndereco;
import br.curso.desafio.apiviacep.com.cadastros.GeraChave;

import java.util.ArrayList;

public class CriaLista {

    ArrayList<Object> listasCadastro = new ArrayList<>();
    private CadastroEndereco endereco;
    private CadastroCliente cliente;
    private GeraChave chave;

    public void incluiLista(CadastroCliente cliente, CadastroEndereco endereco, GeraChave chave){
        listasCadastro.add(this.endereco = endereco);
        listasCadastro.add(this.cliente = cliente);
        listasCadastro.add(this.chave = chave);
    }

    public ArrayList<Object> getListasCadastro() {
        return listasCadastro;
    }
}
