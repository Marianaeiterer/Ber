package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.arquivo.Arquivo;
import br.ufjf.trabalho.aber.arquivo.JSONRotas;
import br.ufjf.trabalho.aber.model.Rotas;
import br.ufjf.trabalho.aber.view.TelaPiloto;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ConfirmaRota implements ActionListener {

    TelaPiloto tela;
    Rotas elementSelecionado;

    public ConfirmaRota(TelaPiloto tela, Rotas elementSelecionado) {
        this.tela = tela;
        this.elementSelecionado = elementSelecionado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<Rotas> rotas = (DefaultListModel<Rotas>) tela.getLista().getModel();

        if(rotas.size() == 0){
            JOptionPane.showMessageDialog(null, "Nenhuma rota disponivel para confirmacao!");
        }else{
            int indice = tela.getLista().getSelectedIndex();

            List<Rotas> model = new ArrayList<>();

            for (int i = 0; i < rotas.size();i++){
                model.add(rotas.get(i));
                if(indice == i){
                    this.elementSelecionado = rotas.getElementAt(i);
                    rotas.remove(i);
                    model.remove(i);

                    String toJSON = JSONRotas.toJSON(model);

                    System.out.println(toJSON);

                    Arquivo.escreverArquivo("dadosRotas", toJSON);

                }
            }

            this.elementSelecionado.getAviao().encherTanque();

            try {
                String lerArquivo = Arquivo.lerArquivo("rotasConfirmadas");
                List<Rotas> rotasArquivo = new ArrayList<>();

                if(lerArquivo.equals("")){
                    rotasArquivo.add(this.elementSelecionado);
                }else{
                    rotasArquivo = JSONRotas.toRotas(lerArquivo);
                    rotasArquivo.add(this.elementSelecionado);
                }

                String toJSON = JSONRotas.toJSON(rotasArquivo);

                System.out.println(toJSON);

                Arquivo.escreverArquivo("rotasConfirmadas", toJSON);

            } catch (FileNotFoundException ex) {

                List<Rotas> rotasArquivo = new ArrayList<>();
                rotasArquivo.add(this.elementSelecionado);
                String toJSON = JSONRotas.toJSON(rotasArquivo);

                System.out.println(toJSON);

                Arquivo.escreverArquivo("rotasConfirmadas", toJSON);
            }

            JOptionPane.showMessageDialog(null, "Rota confirmada com sucesso!");
            tela.getLista().setModel(rotas);
            tela.repaint();
        }

    }

}
