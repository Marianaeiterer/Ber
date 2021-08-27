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

public class CadastroRotas implements ActionListener {


    TelaAdministrador tela;

    public CadastroRotas(TelaAdministrador telaAdministrador) {
        this.tela = telaAdministrador;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<Rotas> rotas = (DefaultListModel<Rotas>) tela.getLista().getModel();

        rotas.addElement(new Rotas(
                tela.getCodigo().getText(),
                tela.getOrigem().getText(),
                tela.getDestino().getText(),
                tela.getData().getText(),
                tela.getPreco().getText(),
                tela.getHora().getText(),
                tela.getAviao().getText(),
                tela.getId().getText()));


        ListModel<Rotas> model = tela.getLista().getModel();
        List<Rotas> rota = new ArrayList<>();


        for (int i = 0; i < model.getSize(); i++) {
            rota.add(model.getElementAt(i));
        }

        String toJSON = JSONRotas.toJSON(rota);

        System.out.println(toJSON);

        Arquivo.escreverArquivo("dadosRotas", toJSON);

        JOptionPane.showMessageDialog(null, "Rota adicionada com sucesso!");
        tela.getLista().setModel(rotas);
        tela.repaint();
    }
}
