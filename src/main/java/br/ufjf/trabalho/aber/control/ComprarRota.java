package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.arquivo.Arquivo;
import br.ufjf.trabalho.aber.arquivo.JSONRotas;
import br.ufjf.trabalho.aber.model.Rotas;
import br.ufjf.trabalho.aber.model.Usuario;
import br.ufjf.trabalho.aber.view.TelaCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ComprarRota implements ActionListener {

    TelaCliente tela;
    Rotas elementSelecionado;
    Usuario usuario;

    public ComprarRota(TelaCliente tela, Usuario usuario, Rotas elementSelecionado) {
        this.tela = tela;
        this.usuario = usuario;
        this.elementSelecionado = elementSelecionado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DefaultListModel<Rotas> rotas = (DefaultListModel<Rotas>) tela.getLista().getModel();
        DefaultListModel<Rotas> rotasCompradas = (DefaultListModel<Rotas>) tela.getListaCompradas().getModel();

        int indice = tela.getLista().getSelectedIndex();


        List<Rotas> disponiveis = new ArrayList<>();

        for (int i = 0; i < rotas.size();i++){
            disponiveis.add(rotas.get(i));
            if(indice == i){
                this.elementSelecionado = rotas.getElementAt(i);

                rotas.remove(i);
                disponiveis.remove(i);

                String toJSON = JSONRotas.toJSON(disponiveis);

                System.out.println(toJSON);

                Arquivo.escreverArquivo("rotasConfirmadas", toJSON);

            }
        }
        String nomePasta = "ticketComprado" + usuario.getLogin();

        if(rotasCompradas == null){
            System.out.println("dentro null");
            List<Rotas> rotasArquivo = new ArrayList<>();
            rotasArquivo.add(this.elementSelecionado);
            rotasCompradas.addElement(this.elementSelecionado);

            String toJSON = JSONRotas.toJSON(rotasArquivo);

            System.out.println(toJSON);

            Arquivo.escreverArquivo(nomePasta, toJSON);
        }else{
            System.out.println("dentro else");
            try {
                String lerArquivo = Arquivo.lerArquivo(nomePasta);
                List<Rotas> rotasArquivo = new ArrayList<>();

                if (!lerArquivo.equals("")) {
                    rotasArquivo = JSONRotas.toRotas(lerArquivo);
                }

                rotasArquivo.add(this.elementSelecionado);

                rotasCompradas.addElement(this.elementSelecionado);


                String toJSON = JSONRotas.toJSON(rotasArquivo);

                System.out.println(toJSON);

                Arquivo.escreverArquivo(nomePasta, toJSON);


            } catch (FileNotFoundException ex) {
                System.out.println("File Not Found Exception");
            }
        }


        tela.getLista().setModel(rotas);
        tela.getListaCompradas().setModel(rotasCompradas);
        tela.repaint();
    }


}
