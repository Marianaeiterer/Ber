package br.ufjf.trabalho.aber.model;


public class Usuario {

    private String nomeUsuario;
    private String login;
    private String senha;
    private String email;
    private String tipoUsuario;

    public Usuario(String nomeUsuario, String email, String login, String senha, String tipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean verifLogin(String loginDigitado, String senhaDigitada){
        return this.senha.equals(senhaDigitada) && this.login.equals(loginDigitado);
    }
}
