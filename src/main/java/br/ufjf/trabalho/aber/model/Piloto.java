package br.ufjf.trabalho.aber.model;

public class Piloto extends Usuario {
    public Piloto(String nomeUsuario, String email, String login, String senha) {
        super(nomeUsuario, email, login, senha);
    }

    @Override
    public boolean verifLogin(String loginDigitado, String senhaDigitada) {
        return super.verifLogin(loginDigitado, senhaDigitada);
    }
}
