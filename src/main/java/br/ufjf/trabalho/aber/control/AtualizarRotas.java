package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.arquivo.Arquivo;
import br.ufjf.trabalho.aber.arquivo.JSONRotas;
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
        ListModel<Rotas> model = this.tela.getLista().getModel();
        Rotas rota = model.getElementAt(tela.getLastIndex());
        rota.setCodigo(tela.getCodigo().getText());
        rota.setOrigem(tela.getOrigem().getText());
        rota.setDestino(tela.getDestino().getText());
        rota.setData(tela.getData().getText());
        rota.setHora(tela.getHora().getText());
        rota.setPreco(tela.getPreco().getText());
        rota.setAviao(tela.getAviao().getText(), tela.getId().getText());


        for (int i = 0; i < model.getSize(); i++) {
            rotas.add(model.getElementAt(i));
        }

        String toJSON = JSONRotas.toJSON(rotas);

        System.out.println(toJSON);

        Arquivo.escreverArquivo("dadosRotas", toJSON);

        tela.getLista().setModel(model);

        tela.repaint();
    }
}
