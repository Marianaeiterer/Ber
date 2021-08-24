package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.arquivo.Arquivo;
import br.ufjf.trabalho.aber.arquivo.JSONLogins;
import br.ufjf.trabalho.aber.arquivo.JSONRotas;
import br.ufjf.trabalho.aber.model.Cliente;
import br.ufjf.trabalho.aber.model.Dados;
import br.ufjf.trabalho.aber.model.Rotas;
import br.ufjf.trabalho.aber.model.Usuario;
import br.ufjf.trabalho.aber.view.TelaCadastro;

import javax.crypto.spec.PSource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CadastrarLogin implements ActionListener {

    TelaCadastro tela;

    public CadastrarLogin(TelaCadastro tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Usuario dado: Dados.logins){
            if(dado.getLogin().equals(tela.getLogin().getText()) && dado.getSenha().equals(tela.getSenha().getText())){
                JOptionPane.showMessageDialog(null, "O Login requisitado ja existe");
            }
        }

        Dados.logins.add(new Cliente(tela.getNome().getText(), tela.getEmail().getText(), tela.getLogin().getText(), tela.getSenha().getText()));
        JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        Dados.registraLogin();
    }
}
