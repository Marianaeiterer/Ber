package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.model.*;
import br.ufjf.trabalho.aber.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginConfirmado implements ActionListener {


    private JTextField login;
    private JPasswordField senha;
    TelaLogin tela;
    Usuario usuario;

    public LoginConfirmado(TelaLogin tela, JTextField login, JPasswordField senha) {
        this.login = login;
        this.senha = senha;
        this.tela = tela;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        boolean validaLogin = Dados.validaLogin(login.getText(), senha.getText());

        if (validaLogin) {
            for (Usuario dado: Dados.logins) {
                if(dado.getLogin().equals(tela.getLogin().getText()) && dado.getSenha().equals(tela.getSenha().getText())){
                    this.usuario = dado;
                    System.out.println(usuario);

                    if(usuario.getTipoUsuario().equals("Administrador")){
                        new TelaAdministrador();
                        this.tela.setVisible(false);
                    }else if(usuario.getTipoUsuario().equals("Piloto")){
                        new TelaPiloto();
                        this.tela.setVisible(false);
                    }else if(usuario.getTipoUsuario().equals("Cliente")){
                        new TelaCliente(usuario);
                        this.tela.setVisible(false);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login inválido!");
        }

    }
}
