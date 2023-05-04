package br.curso.desafio.apiviacep.com.fluxoregistro;

import br.curso.desafio.apiviacep.com.apiviacep.PesquisaCepApiViaCep;
import br.curso.desafio.apiviacep.com.cadastros.CadastroCliente;
import br.curso.desafio.apiviacep.com.cadastros.CadastroEndereco;
import br.curso.desafio.apiviacep.com.cadastros.GeraChave;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario{
    private String entrada;
    private String cep;
    GeraChave chaveCadastral;
    FileWriter escreva;

    CriaLista novaLista = new CriaLista();
    CriaArquivo novoArquivo  = new CriaArquivo();
    Scanner scanner = new Scanner(System.in);
    PesquisaCepApiViaCep pesquisaCep = new PesquisaCepApiViaCep();

    GeraChave novaChave;
    CadastroEndereco novoEndereco;
    CadastroCliente cadastroCliente;

    public void textoCadastroEndereco() throws IOException, InterruptedException {

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

        novoArquivo.criaArquivoCliente(novaChave, cadastroCliente);
        novoArquivo.criaArquivoEndereco(novaChave, novoEndereco);
        novoArquivo.criaArquivoRegistros(novaChave, novoEndereco, cadastroCliente);

        novaLista.incluiLista(cadastroCliente, novoEndereco, novaChave);
        novaLista.getListasCadastro();

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
