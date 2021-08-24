package br.ufjf.trabalho.aber.model;

import br.ufjf.trabalho.aber.arquivo.Arquivo;
import br.ufjf.trabalho.aber.arquivo.JSONLogins;
import br.ufjf.trabalho.aber.arquivo.JSONRotas;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Dados {

    public static List<Usuario> logins;

    static {
        logins = new ArrayList<>();
        recebeLogins();
    }

    public static void registraLogin(){
        String toJSON = JSONLogins.toJSON(logins);

        System.out.println(toJSON);

        Arquivo.escreverArquivo("dadosLogins", toJSON);
    }

    public static void recebeLogins(){
        try {
            String lerArquivo = Arquivo.lerArquivo("dadosLogins");
            logins = JSONLogins.toUsuarios(lerArquivo);


        } catch (FileNotFoundException ex) {
        }

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
