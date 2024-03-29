package br.ufjf.trabalho.aber.view;

import br.ufjf.trabalho.aber.control.Cadastro;
import br.ufjf.trabalho.aber.control.OpcaoLogin;
import br.ufjf.trabalho.aber.model.Dados;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame implements Tela{

    private TelaCadastro telaCadastro;

    public TelaInicial(){

        this.setLayout(new BorderLayout());
        this.add(painelBotoes(), BorderLayout.CENTER);
        this.setSize(300, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dados.recebeLogins();
    }

    private JPanel painelBotoes(){

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        JButton btLogin = new JButton("Login");
        btLogin.addActionListener(new OpcaoLogin(this));
        botoes.add(btLogin);
        JButton btCadastro = new JButton("Cadastro");
        btCadastro.addActionListener(new Cadastro(this));
        botoes.add(btCadastro);
        return botoes;
    }

    public static void main(String[] args) {
        TelaInicial telaInicial = new TelaInicial();
    }
}

