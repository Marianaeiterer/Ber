package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.view.TelaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetornaInicial implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        new TelaInicial();

    }
}
