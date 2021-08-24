package br.ufjf.trabalho.aber.model;

public class Cliente extends Usuario{

    public Cliente(String nomeUsuario, String email, String login, String senha) {
        super(nomeUsuario, email, login, senha, "Cliente");
    }

    @Override
    public boolean verifLogin(String loginDigitado, String senhaDigitada) {
        return super.verifLogin(loginDigitado, senhaDigitada);
    }

    @Override
    public String toString() {
        return "Cliente";
    }
}
