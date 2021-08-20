package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.model.Cliente;
import br.ufjf.trabalho.aber.model.Dados;
import br.ufjf.trabalho.aber.model.Usuario;
import br.ufjf.trabalho.aber.view.TelaCadastro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarLogin implements ActionListener {

    TelaCadastro tela;

    public CadastrarLogin(TelaCadastro tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Usuario log: Dados.logins){
            System.out.println(log);
            JOptionPane.showMessageDialog(null, "O Login requisitado ja existe");
            return;
        }


        //Dados.logins.add(new Cliente(tela.getName(), tela.getEmail().getText(), tela.getLogin().getText(), tela.getSenha().getUIClassID()));
        JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");

        for (Usuario log: Dados.logins){
            System.out.println(log);
        }

    }
}
