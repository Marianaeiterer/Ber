package br.ufjf.trabalho.aber.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaPiloto extends JFrame implements Tela {

    public TelaPiloto(){

        this.setLayout(new BorderLayout());
        this.add(painelRotas(), BorderLayout.CENTER);
        this.add(painelBotoes(), BorderLayout.SOUTH);
        this.setSize(300, 150);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel painelRotas(){

        JPanel rotas = new JPanel();
        rotas.setBorder(BorderFactory.createTitledBorder("Rotas Disponiveis"));
        rotas.setLayout(new BorderLayout());
        rotas.setPreferredSize(new Dimension(200, 300));
        return rotas;
    }

    private JPanel painelBotoes(){
        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        JButton btConfirmarRota = new JButton("Confirmar Rota");
        botoes.add(btConfirmarRota);
        JButton btSair = new JButton("Sair");
        botoes.add(btSair);

        return botoes;
    }

    public static void main(String[] args){
        TelaPiloto telaPiloto = new TelaPiloto();
    }

}
