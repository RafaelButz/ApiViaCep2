import br.curso.desafio.apiviacep.com.fluxoregistro.CriaLista;
import br.curso.desafio.apiviacep.com.fluxoregistro.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Usuario novoUsuario = new Usuario();
        CriaLista novaLista = new CriaLista();
        FileWriter escrita = new FileWriter("Cadastros.json");
        Gson gson = new GsonBuilder().create();

        novoUsuario.textoCadastroEndereco();




//        novaLista.incluiLista(novoUsuario);
//        System.out.println(novaLista.getListasCadastro().toString());
//        escrita.write(gson.toJson(novaLista.getListasCadastro().toString()));
//        escrita.close();

    }
}



