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

public class CancelarRota implements ActionListener {

    TelaCliente tela;
    Rotas elementSelecionado;
    Usuario usuario;

    public CancelarRota(TelaCliente tela, Rotas elementSelecionado, Usuario usuario) {
        this.tela = tela;
        this.elementSelecionado = elementSelecionado;
        this.usuario = usuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DefaultListModel<Rotas> rotas = (DefaultListModel<Rotas>) tela.getLista().getModel();
        DefaultListModel<Rotas> rotasCompradas = (DefaultListModel<Rotas>) tela.getListaCompradas().getModel();


        if(rotasCompradas.size() == 0){
            JOptionPane.showMessageDialog(null, "Desculpe! Todas as rotas ja foram canceladas!");
        }else{

            int indice = tela.getListaCompradas().getSelectedIndex();
            String nomePasta = "ticketComprado" + usuario.getLogin();

            List<Rotas> compradas = new ArrayList<>();

            for (int i = 0; i < rotasCompradas.size();i++){
                compradas.add(rotasCompradas.get(i));
                if(indice == i){
                    this.elementSelecionado = rotasCompradas.getElementAt(i);

                    rotasCompradas.remove(i);
                    compradas.remove(i);

                    String toJSON = JSONRotas.toJSON(compradas);

                    System.out.println(toJSON);

                    Arquivo.escreverArquivo(nomePasta, toJSON);

                }
            }


            if(rotas == null){
                List<Rotas> rotasArquivo = new ArrayList<>();
                rotasArquivo.add(this.elementSelecionado);
                rotas.addElement(this.elementSelecionado);

                String toJSON = JSONRotas.toJSON(rotasArquivo);

                System.out.println(toJSON);

                Arquivo.escreverArquivo("rotasConfirmadas", toJSON);
            }else{
                try {
                    String lerArquivo = Arquivo.lerArquivo("rotasConfirmadas");
                    List<Rotas> rotasArquivo = new ArrayList<>();

                    if (!lerArquivo.equals("")) {
                        rotasArquivo = JSONRotas.toRotas(lerArquivo);
                    }

                    rotasArquivo.add(this.elementSelecionado);

                    rotas.addElement(this.elementSelecionado);


                    String toJSON = JSONRotas.toJSON(rotasArquivo);

                    System.out.println(toJSON);

                    Arquivo.escreverArquivo("rotasConfirmadas", toJSON);


                } catch (FileNotFoundException ex) {
                    System.out.println("Pasta nao encontrada!");
                }
            }

            JOptionPane.showMessageDialog(null, "Rota cancelada com sucesso!");
            tela.getLista().setModel(rotas);
            tela.getListaCompradas().setModel(rotasCompradas);
            tela.repaint();

        }


    }


}

