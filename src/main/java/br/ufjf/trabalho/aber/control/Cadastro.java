package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.view.TelaCadastro;
import br.ufjf.trabalho.aber.view.TelaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro implements ActionListener {

    TelaInicial tela;

    public Cadastro(TelaInicial tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaCadastro();
        tela.setVisible(false);

    }
}
