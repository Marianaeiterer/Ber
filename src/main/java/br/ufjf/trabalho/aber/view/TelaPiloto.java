package br.ufjf.trabalho.aber.view;

import br.ufjf.trabalho.aber.arquivo.Arquivo;
import br.ufjf.trabalho.aber.arquivo.JSONRotas;
import br.ufjf.trabalho.aber.control.ConfirmaRota;
import br.ufjf.trabalho.aber.control.Lista;
import br.ufjf.trabalho.aber.control.RetornaInicial;
import br.ufjf.trabalho.aber.model.Rotas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaPiloto extends JFrame implements Tela, ListSelectionListener {

    private JList<Rotas> lista;
    private Rotas elementSelecionado;

    public JList<Rotas> getLista() {
        return lista;
    }

    public void setLista(JList<Rotas> lista) {
        this.lista = lista;
    }

    public TelaPiloto(){

        this.setLayout(new BorderLayout());
        this.add(painelRotas(), BorderLayout.CENTER);
        this.add(painelBotoes(), BorderLayout.SOUTH);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            String lerArquivo = Arquivo.lerArquivo("dadosRotas");
            List<Rotas> rotas = JSONRotas.toRotas(lerArquivo);

            DefaultListModel<Rotas> modelo = new DefaultListModel<>();

            if(rotas != null){
                for (Rotas rota : rotas) {
                    modelo.addElement(rota);
                }
            }


            lista.setModel(modelo);
            this.repaint();

        } catch (FileNotFoundException ex) {
            System.out.println("Pasta nao encontrada!");
        }

    }

    private JPanel painelRotas(){

        JPanel rotas = new JPanel();
        rotas.setBorder(BorderFactory.createTitledBorder("Rotas Disponiveis"));
        rotas.setLayout(new BorderLayout());
        rotas.setPreferredSize(new Dimension(600, 500));
        DefaultListModel<Rotas> model = new DefaultListModel<>();

        lista = new JList<>(model);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        rotas.add(new JScrollPane(lista), BorderLayout.CENTER);

        return rotas;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {


        if (this.getLista().getSelectedValue() != null) {
            this.elementSelecionado = this.getLista().getSelectedValue();

        }

    }
    private JPanel painelBotoes(){
        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        JButton btConfirmarRota = new JButton("Confirmar Rota");
        botoes.add(btConfirmarRota);
        btConfirmarRota.addActionListener(new ConfirmaRota(this, this.elementSelecionado));
        JButton btSair = new JButton("Sair");
        btSair.addActionListener(new RetornaInicial(this));
        botoes.add(btSair);

        return botoes;
    }

    public static void main(String[] args){
        TelaPiloto telaPiloto = new TelaPiloto();
    }

}
