package br.ufjf.trabalho.aber.model;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    public static List<Usuario> logins;

    static {
        logins = new ArrayList<>();
        logins.add(new Administrador( "Mariana Lopes", "mari@gmail.com", "mariana", "mari"));
        logins.add(new Administrador( "Delio Amaro", "delio@gmail.com", "delio", "delio"));
        logins.add(new Piloto( "Delio Amaro", "delio@gmail.com", "delio", "delio"));
    }

    public static boolean validaLogin(String login, String senha){
        for (Usuario dado : logins) {
            if(dado.getLogin().equals(login) && dado.getSenha().equals(senha)){
                return true;
            }
        }

        return false;
    }
}
