package br.ufjf.trabalho.aber.arquivo;

import br.ufjf.trabalho.aber.model.Rotas;
import br.ufjf.trabalho.aber.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONLogins {

    public static String toJSON(Usuario usuario) {
        Gson gson = new Gson();
        String json = gson.toJson(usuario);
        return json;
    }

    public static String toJSON(List<Rotas> contatos) {
        Gson gson = new Gson();
        String json = gson.toJson(contatos);
        return json;
    }

    public static Usuario toContato(String conteudo) {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(conteudo, Usuario.class);

        return usuario;
    }

    public static List<Usuario> toUsuarios(String conteudo) {
        Gson gson = new Gson();
        Type pessoasTipo = new TypeToken<ArrayList<Rotas>>() {
        }.getType();
        List<Usuario> usuario = gson.fromJson(conteudo, pessoasTipo);

        return usuario;
    }
}
