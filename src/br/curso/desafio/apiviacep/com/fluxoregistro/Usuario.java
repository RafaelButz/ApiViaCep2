package br.curso.desafio.apiviacep.com.fluxoregistro;

import br.curso.desafio.apiviacep.com.apiviacep.PesquisaCepApiViaCep;
import br.curso.desafio.apiviacep.com.cadastros.CadastroCliente;
import br.curso.desafio.apiviacep.com.cadastros.CadastroEndereco;
import br.curso.desafio.apiviacep.com.cadastros.GeraChave;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Usuario{
    private String entrada;
    private String cep;
    GeraChave chaveCadastral;
    FileWriter escreva;


    CadastroEndereco novoEndereco;
    CadastroCliente cadastroCliente;
    Scanner scanner = new Scanner(System.in);
    PesquisaCepApiViaCep pesquisaCep = new PesquisaCepApiViaCep();
    GeraChave novaChave;

    public void textoCadastroEndereco() throws IOException, InterruptedException {

        RandomAccessFile registroCliente = new RandomAccessFile("Cadastro.txt", "rw");
        registroCliente.seek(registroCliente.length());

        RandomAccessFile registros = new RandomAccessFile("Registros.txt", "rw");
        registros.seek(registros.length());

        RandomAccessFile registroEndereco = new RandomAccessFile("CadastroEndereco.txt", "rw");
        registroEndereco.seek(registroEndereco.length());

        System.out.println("Pesquisar endereço por CEP:");
        cep = scanner.nextLine();
        pesquisaCep.criaJson(cep);

        System.out.println(pesquisaCep.getNovoViaCep());

        System.out.println("Confirma endereço?");
        System.out.println("Digite [1] sim    [2] não");
        entrada = scanner.nextLine();
        if(entrada.equalsIgnoreCase("1")){
            this.novoEndereco = new CadastroEndereco(pesquisaCep.getNovoViaCep());
        }else{
            textoCadastroEndereco();
        }

        System.out.println("Digite o numero: ");
        entrada = scanner.nextLine();
        novoEndereco.setNumero(entrada);

        textoCadastroCliente();

        System.out.println(cadastroCliente + "\n" + novoEndereco);
        novaChave = new GeraChave(cadastroCliente, novoEndereco);
        System.out.println(novaChave);

        registroCliente.write(novaChave.toString().getBytes());
        registroCliente.write(cadastroCliente.toString().getBytes());
        registroCliente.close();

        registroEndereco.write(novaChave.toString().getBytes());
        registroEndereco.write(novoEndereco.toString().getBytes());
        registroEndereco.close();

        registros.write(novaChave.toString().getBytes());
        registros.write(cadastroCliente.toString().getBytes());
        registros.write(novoEndereco.toString().getBytes());
        registros.close();

    }

    public void textoCadastroCliente(){
        String nome;
        String cpf;
        String telefone;


        System.out.println("Digite seu nome: ");
        nome = scanner.nextLine();

        System.out.println("Digite seu CPF: ");
        cpf = scanner.nextLine();

        System.out.println("Digite seu Telefone: ");
        telefone = scanner.nextLine();

        this.cadastroCliente = new CadastroCliente(nome, cpf, telefone);

       // System.out.println(cadastroCliente);


    }

}
