package br.curso.desafio.apiviacep.com.fluxoregistro;

import br.curso.desafio.apiviacep.com.cadastros.CadastroCliente;
import br.curso.desafio.apiviacep.com.cadastros.CadastroEndereco;
import br.curso.desafio.apiviacep.com.cadastros.GeraChave;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CriaArquivo {

    RandomAccessFile registroCliente;
    RandomAccessFile registros;
    RandomAccessFile registroEndereco;

    public void criaArquivoCliente(GeraChave chave, CadastroCliente cliente) throws IOException {
        this.registroCliente = new RandomAccessFile("CadastroCliente.txt", "rw");
        registroCliente.seek(registroCliente.length());
        registroCliente.write(chave.toString().getBytes());
        registroCliente.write(cliente.toString().getBytes());
        registroCliente.close();
    }

    public void criaArquivoEndereco(GeraChave chave, CadastroEndereco endereco) throws IOException {
        this.registroEndereco = new RandomAccessFile("CadastroEndereco.txt", "rw");
        registroEndereco.seek(registroEndereco.length());
        registroEndereco.write(chave.toString().getBytes());
        registroEndereco.write(endereco.toString().getBytes());
        registroEndereco.close();
    }

    public void criaArquivoRegistros(GeraChave chave, CadastroEndereco endereco, CadastroCliente cliente) throws IOException {
       this.registros = new RandomAccessFile("Registros.txt", "rw");
        registros.seek(registros.length());
        registros.write(chave.toString().getBytes());
        registros.write(cliente.toString().getBytes());
        registros.write(endereco.toString().getBytes());
        registros.close();

    }

}
