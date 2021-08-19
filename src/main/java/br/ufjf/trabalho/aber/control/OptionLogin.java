package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.view.TelaCadastro;
import br.ufjf.trabalho.aber.view.TelaInicial;
import br.ufjf.trabalho.aber.view.TelaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionLogin implements ActionListener {

    TelaInicial tela;

    public OptionLogin(TelaInicial tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaLogin();
        tela.setVisible(false);


    }
}
