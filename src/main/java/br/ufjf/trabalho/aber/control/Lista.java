package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.model.Rotas;
import br.ufjf.trabalho.aber.view.Tela;
import br.ufjf.trabalho.aber.view.TelaAdministrador;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Lista implements ListSelectionListener {


    TelaAdministrador tela;

    public Lista(TelaAdministrador tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = tela.getLista().getSelectedIndex();

        if (firstIndex != -1) {


            Rotas elementAt = tela.getLista().getModel().getElementAt(firstIndex);
            tela.getCodigo().setText(elementAt.getCodigo());
            tela.getOrigem().setText(elementAt.getOrigem());
            tela.getDestino().setText(elementAt.getDestino());
            tela.getData().setText(elementAt.getData());
            tela.getHora().setText(elementAt.getHora());
            tela.getPreco().setText(elementAt.getPreco());
            tela.getAviao().setText(elementAt.getAviao().getTipo());
            tela.getId().setText(elementAt.getAviao().getId());


            tela.setLastIndex(firstIndex);
        }
    }

}

