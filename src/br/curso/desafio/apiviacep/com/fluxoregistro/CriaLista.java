package br.curso.desafio.apiviacep.com.fluxoregistro;

import br.curso.desafio.apiviacep.com.cadastros.CadastroCliente;
import br.curso.desafio.apiviacep.com.cadastros.CadastroEndereco;
import br.curso.desafio.apiviacep.com.cadastros.GeraChave;

import java.util.ArrayList;
import java.util.Collection;

public class CriaLista {

    ArrayList<Object> listasCadastro = new ArrayList<>();

    public void incluiListaCliente(InterFaceGeraLista lista){
        listasCadastro.add(lista);

    }

    public ArrayList<Object> getListasCadastro() {
        return listasCadastro;
    }
}
