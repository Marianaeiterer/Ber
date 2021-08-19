package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.model.Rotas;
import br.ufjf.trabalho.aber.view.TelaAdministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AtualizarRotas implements ActionListener {

    private final static List<Rotas> rotas = new ArrayList<>();

    TelaAdministrador tela;

    public AtualizarRotas(TelaAdministrador telaAdministrador) {
        this.tela = telaAdministrador;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
