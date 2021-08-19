package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.model.Rotas;
import br.ufjf.trabalho.aber.view.TelaAdministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastroRotas implements ActionListener {

    public static List<Rotas> rotas;

    static {
        rotas = new ArrayList<>();
    }

    TelaAdministrador tela;

    public CadastroRotas(TelaAdministrador telaAdministrador) {
        this.tela = telaAdministrador;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        rotas.add(new Rotas(
                tela.getCodigo().getText(),
                tela.getOrigem().getText(),
                tela.getDestino().getText(),
                tela.getData().getText(),
                tela.getPreco().getText(),
                tela.getHora().getText(),
                tela.getAviao().getText(),
                tela.getId().getText()));


        for(Rotas r: rotas){
            System.out.println(r);
        }
    }
}
