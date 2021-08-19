package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.view.TelaAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Limpar implements ActionListener{

    TelaAdministrador tela;

    public Limpar(TelaAdministrador tela) {
        this.tela = tela;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        tela.getOrigem().setText("");
        tela.getDestino().setText("");
        tela.getCodigo().setText("");
        tela.getData().setText("");
        tela.getPreco().setText("");
        tela.getHora().setText("");
        tela.getAviao().setText("");
        tela.getId().setText("");;

    }

}
