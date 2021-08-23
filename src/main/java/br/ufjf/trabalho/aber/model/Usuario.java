package br.ufjf.trabalho.aber.model;


public abstract class Usuario {

    private String nomeUsuario;
    private String login;
    private String senha;
    private String email;

    public Usuario(String nomeUsuario, String email, String login, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean verifLogin(String loginDigitado, String senhaDigitada){
        return this.senha.equals(senhaDigitada) && this.login.equals(loginDigitado);
    }
}
