package br.curso.desafio.apiviacep.com.fluxoregistro;

import java.util.ArrayList;
import java.util.List;


public class CriaLista {

    ArrayList<Object> listasCadastro = new ArrayList<>();

    public void incluiLista(InterFaceGeraLista lista){
        listasCadastro.add(lista);

    }




    public ArrayList<Object> getListasCadastro() {
        return listasCadastro;
    }
}
