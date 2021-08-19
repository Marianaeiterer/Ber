package br.ufjf.trabalho.aber.control;

import java.util.Date;

public abstract class Usuario {


    private String numUsuario;
    private String senha;
    private String estadLogin;
    private String dataCadastr;

    public Usuario(String numUsuario, String senha, String estadLogin, String dataCadastr) {
        this.numUsuario = numUsuario;
        this.senha = senha;
        this.estadLogin = estadLogin;
        this.dataCadastr = dataCadastr;
    }

    public boolean verifLogin(String numUsuarioDigitado, String senhaDigitada){
        return this.senha.equals(senhaDigitada) && this.numUsuario.equals(numUsuarioDigitado);
    }
}
