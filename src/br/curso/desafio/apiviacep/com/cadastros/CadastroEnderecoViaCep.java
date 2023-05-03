package br.curso.desafio.apiviacep.com.cadastros;

public record CadastroEnderecoViaCep(String cep, String logradouro, String bairro,
                                     String localidade, String uf) {

    @Override
    public String toString() {
        return  "Cep: " + cep + "\n" +
                "Rua: " + logradouro + "\n" +
                "Bairro: " + bairro + "\n" +
                "Localidade: " + localidade + "\n" +
                "UF: " + uf;
    }

}
