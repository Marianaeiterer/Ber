package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.view.Tela;
import br.ufjf.trabalho.aber.view.TelaCadastro;
import br.ufjf.trabalho.aber.view.TelaInicial;
import br.ufjf.trabalho.aber.view.TelaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpcaoLogin implements ActionListener {

    Tela tela;

    public OpcaoLogin(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaLogin();
        tela.setVisible(false);


    }
}
