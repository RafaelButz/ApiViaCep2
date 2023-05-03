package br.curso.desafio.apiviacep.com.cadastros;

import br.curso.desafio.apiviacep.com.cadastros.CadastroCliente;
import br.curso.desafio.apiviacep.com.cadastros.CadastroEndereco;

public class GeraChave {

    private int chaveDeLocalizacao;

    public GeraChave(CadastroCliente cadastroCliente, CadastroEndereco novoEndereco) {
        this.chaveDeLocalizacao = cadastroCliente.getGeraChave() + novoEndereco.getGeraChave();
    }

    public int getChaveDeLocalizacao() {
        return chaveDeLocalizacao;
    }

    @Override
    public String toString() {
        return "\n\nChave: " + getChaveDeLocalizacao() + "\n";
    }
}
