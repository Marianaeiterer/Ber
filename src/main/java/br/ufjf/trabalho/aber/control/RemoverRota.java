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

public class RemoverRota implements ActionListener {

    TelaAdministrador tela;

    public RemoverRota(TelaAdministrador tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DefaultListModel<Rotas> model = (DefaultListModel<Rotas>) tela.getLista().getModel();

        if(model.size() == 0){
            JOptionPane.showMessageDialog(null, "Nenhuma rota para ser removida!");
        }else {
            int selectedIndex = tela.getLista().getSelectedIndex();
            if (selectedIndex != -1) {

                model.removeElementAt(selectedIndex);
                List<Rotas> rotas = new ArrayList<>();

                for (int i = 0; i < model.getSize(); i++) {
                    rotas.add(model.getElementAt(i));
                }

                String toJSON = JSONRotas.toJSON(rotas);

                System.out.println(toJSON);

                Arquivo.escreverArquivo("dadosRotas", toJSON);


                tela.getLista().setModel(model);
                tela.repaint();
                JOptionPane.showMessageDialog(null, "Rota removida com sucesso!");
            }
        }
    }
}
