package br.ufjf.trabalho.aber.model;

public class Piloto extends Usuario {
    public Piloto(String nomeUsuario, String email, String login, String senha) {
        super(nomeUsuario, email, login, senha, "Piloto");
    }

    @Override
    public boolean verifLogin(String loginDigitado, String senhaDigitada) {
        return super.verifLogin(loginDigitado, senhaDigitada);
    }

    @Override
    public String toString() {
        return "Piloto";
    }
}
