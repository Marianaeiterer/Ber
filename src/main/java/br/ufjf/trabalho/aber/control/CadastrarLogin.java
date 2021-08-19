package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.model.Dados;
import br.ufjf.trabalho.aber.model.Login;
import br.ufjf.trabalho.aber.view.TelaCadastro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarLogin implements ActionListener {

    JTextField login;
    JPasswordField senha;

    public CadastrarLogin(JTextField login, JPasswordField senha) {
        this.login = login;
        this.senha = senha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Login log: Dados.logins){
            System.out.println(log);
            JOptionPane.showMessageDialog(null, "O Login requisitado ja existe");
            return;
        }


        Dados.logins.add(new Login(login.getText(), senha.getText()));
        JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");

        for (Login log: Dados.logins){
            System.out.println(log);
        }

    }
}
