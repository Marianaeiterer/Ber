package br.ufjf.trabalho.aber.arquivo;

import br.ufjf.trabalho.aber.model.Rotas;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONRotas {

    public static String toJSON(Rotas rota) {
        Gson gson = new Gson();
        String json = gson.toJson(rota);
        return json;
    }

    public static String toJSON(List<Rotas> contatos) {
        Gson gson = new Gson();
        String json = gson.toJson(contatos);
        return json;
    }

    public static Rotas toContato(String conteudo) {
        Gson gson = new Gson();
       Rotas rota = gson.fromJson(conteudo, Rotas.class);

        return rota;
    }

    public static List<Rotas> toRotas(String conteudo) {
        Gson gson = new Gson();
        Type rotasTipo = new TypeToken<ArrayList<Rotas>>() {
        }.getType();
        List<Rotas> rotas = gson.fromJson(conteudo, rotasTipo);

        return rotas;
    }
}
