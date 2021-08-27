package br.ufjf.trabalho.aber.view;

import br.ufjf.trabalho.aber.arquivo.Arquivo;
import br.ufjf.trabalho.aber.arquivo.JSONRotas;
import br.ufjf.trabalho.aber.control.CancelarRota;
import br.ufjf.trabalho.aber.control.ComprarRota;
import br.ufjf.trabalho.aber.control.RetornaInicial;
import br.ufjf.trabalho.aber.model.Rotas;
import br.ufjf.trabalho.aber.model.Usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaCliente extends JFrame implements Tela, ListSelectionListener {

    private JList<Rotas> lista;
    private JList<Rotas> listaCompradas;
    private Usuario usuario;
    private Rotas elementSelecionado;

    public JList<Rotas> getLista() {
        return lista;
    }

    public void setLista(JList<Rotas> lista) {
        this.lista = lista;
    }

    public JList<Rotas> getListaCompradas() {
        return listaCompradas;
    }

    public void setListaCompradas(JList<Rotas> listaCompradas) {
        this.listaCompradas = listaCompradas;
    }

    public TelaCliente(Usuario usuario){

        this.usuario = usuario;

        this.setLayout(new BorderLayout());
        this.add(painelRotasCompradas(), BorderLayout.EAST);
        this.add(painelRotas(), BorderLayout.WEST);
        this.add(painelBotoes(), BorderLayout.SOUTH);

        this.setSize(800, 400);
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
            System.out.println("Pasta nao encontrada!");
        }

        try {
            String nomePasta = "ticketComprado" + usuario.getLogin();
            String lerArquivo = Arquivo.lerArquivo(nomePasta);
            List<Rotas> rotas = JSONRotas.toRotas(lerArquivo);

            DefaultListModel<Rotas> model = new DefaultListModel<>();

            if(rotas != null){
                for (Rotas rota : rotas) {
                    model.addElement(rota);
                }
            }


            listaCompradas.setModel(model);
            this.repaint();

        } catch (FileNotFoundException ex) {

        }


    }

    private JPanel painelRotas(){

        JPanel rotas = new JPanel();
        rotas.setBorder(BorderFactory.createTitledBorder("Rotas Disponiveis"));
        rotas.setLayout(new BorderLayout());
        rotas.setPreferredSize(new Dimension(400, 300));
        DefaultListModel<Rotas> modelo = new DefaultListModel<>();

        lista = new JList<>(modelo);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        rotas.add(new JScrollPane(lista), BorderLayout.CENTER);
        return rotas;

    }

    private JPanel painelRotasCompradas(){

        JPanel rotasCompradas = new JPanel();
        rotasCompradas.setBorder(BorderFactory.createTitledBorder("Rotas Compradas"));
        rotasCompradas.setLayout(new BorderLayout());
        rotasCompradas.setPreferredSize(new Dimension(400, 300));
        DefaultListModel<Rotas> model = new DefaultListModel<>();

        listaCompradas = new JList<>(model);
        listaCompradas.setVisible(true);
        listaCompradas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        rotasCompradas.add(new JScrollPane(listaCompradas), BorderLayout.CENTER);
        return rotasCompradas;

    }

    private JPanel painelBotoes(){
        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 3));
        JButton btConfirmarRota = new JButton("Comprar Rota");
        botoes.add(btConfirmarRota);
        btConfirmarRota.addActionListener(new ComprarRota(this, this.usuario, this.elementSelecionado));
        JButton btCancelarRota = new JButton("Cancelar Rota");
        botoes.add(btCancelarRota);
        btCancelarRota.addActionListener(new CancelarRota(this, this.elementSelecionado, this.usuario));
        JButton btSair = new JButton("Sair");
        btSair.addActionListener(new RetornaInicial(this));
        botoes.add(btSair);
        return botoes;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {


        if (this.getLista().getSelectedValue() != null) {
            this.elementSelecionado = this.getLista().getSelectedValue();

        }

    }


}
