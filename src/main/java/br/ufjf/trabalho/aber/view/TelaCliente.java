package br.ufjf.trabalho.aber.view;

import br.ufjf.trabalho.aber.arquivo.Arquivo;
import br.ufjf.trabalho.aber.arquivo.JSONRotas;
import br.ufjf.trabalho.aber.control.RetornaInicial;
import br.ufjf.trabalho.aber.model.Rotas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.*;

public class TelaCliente extends JFrame implements Tela{

    private JList<Rotas> lista;

    public JList<Rotas> getLista() {
        return lista;
    }

    public void setLista(JList<Rotas> lista) {
        this.lista = lista;
    }

    public TelaCliente(){

        this.setLayout(new BorderLayout());
        this.add(painelRotasCompradas(), BorderLayout.EAST);
        this.add(painelRotas(), BorderLayout.WEST);
        this.add(painelBotoes(), BorderLayout.SOUTH);

        this.setSize(700, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            String lerArquivo = Arquivo.lerArquivo("rotasConfirmadas");
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

        }

    }

    private JPanel painelRotas(){

        JPanel rotas = new JPanel();
        rotas.setBorder(BorderFactory.createTitledBorder("Rotas Disponiveis"));
        rotas.setLayout(new BorderLayout());
        rotas.setPreferredSize(new Dimension(400, 300));
        DefaultListModel<Rotas> model = new DefaultListModel<>();

        lista = new JList<>(model);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //lista.addListSelectionListener(new Lista(this));

        rotas.add(new JScrollPane(lista), BorderLayout.CENTER);
        return rotas;

    }

    private JPanel painelRotasCompradas(){

        JPanel rotas = new JPanel();
        rotas.setBorder(BorderFactory.createTitledBorder("Rotas Compradas"));
        rotas.setLayout(new BorderLayout());
        rotas.setPreferredSize(new Dimension(300, 300));
        DefaultListModel<Rotas> model = new DefaultListModel<>();

        lista = new JList<>(model);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //lista.addListSelectionListener(new Lista(this));

        rotas.add(new JScrollPane(lista), BorderLayout.EAST);
        return rotas;

    }

    private JPanel painelBotoes(){
        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        JButton btConfirmarRota = new JButton("Comprar Rota");
        botoes.add(btConfirmarRota);
        JButton btCancelarRota = new JButton("Cancelar Rota");
        botoes.add(btCancelarRota);
        JButton btSair = new JButton("Sair");
        btSair.addActionListener(new RetornaInicial(this));
        botoes.add(btSair);
        return botoes;
    }

    public static void main(String[] args){
        TelaCliente telaCliente = new TelaCliente();
    }
    

}
