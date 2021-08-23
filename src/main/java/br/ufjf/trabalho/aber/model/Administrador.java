package br.ufjf.trabalho.aber.model;

public class Administrador extends Usuario {

    public Administrador(String nomeUsuario, String email, String login, String senha) {
        super(nomeUsuario, email, login, senha);
    }

    @Override
    public String getNomeUsuario() {
        return super.getNomeUsuario();
    }

    @Override
    public void setNomeUsuario(String nomeUsuario) {
        super.setNomeUsuario(nomeUsuario);
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public boolean verifLogin(String loginDigitado, String senhaDigitada) {
        return super.verifLogin(loginDigitado, senhaDigitada);
    }

    @Override
    public String toString() {
        return "Administrador";
    }
}
