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
        this.elementSelecionado =  elementSelecionado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<Rotas> rotas = (DefaultListModel<Rotas>) tela.getLista().getModel();
        int indice = tela.getLista().getSelectedIndex();


        for (int i = 0; i< rotas.size();i++){
           if(indice == i){
               this.elementSelecionado = rotas.getElementAt(i);
               rotas.remove(i);
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



            for (int i = 0; i< rotas.size();i++){
                System.out.println(rotasArquivo.get(i));
            }


            String toJSON = JSONRotas.toJSON(rotasArquivo);

            System.out.println(toJSON);

            Arquivo.escreverArquivo("rotasConfirmadas", toJSON);


        } catch (FileNotFoundException ex) {

        }

        tela.getLista().setModel(rotas);
        tela.repaint();
    }

}
