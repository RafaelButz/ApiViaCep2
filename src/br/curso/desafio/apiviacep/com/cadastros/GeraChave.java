package br.curso.desafio.apiviacep.com.cadastros;

import br.curso.desafio.apiviacep.com.fluxoregistro.InterFaceGeraLista;

import java.util.ArrayList;

public class GeraChave implements InterFaceGeraLista {

    private int chaveDeLocalizacao;

    ArrayList<GeraChave> listaChave = new ArrayList<>();

    public GeraChave(CadastroCliente cadastroCliente, CadastroEndereco novoEndereco) {
        this.chaveDeLocalizacao = cadastroCliente.getGeraChave() + novoEndereco.getGeraChave();
    }

    public void listaChave(GeraChave chave){
        listaChave.add(chave);
    }

    public ArrayList<GeraChave> getListaChave() {
        return listaChave;
    }

    public int getChaveDeLocalizacao() {
        return chaveDeLocalizacao;
    }

    @Override
    public String toString() {
        return "\n\nChave: " + getChaveDeLocalizacao() + "\n";
    }

    @Override
    public Object getGeralista() {
        return getListaChave();
    }
}
