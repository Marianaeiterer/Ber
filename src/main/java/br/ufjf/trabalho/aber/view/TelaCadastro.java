package br.ufjf.trabalho.aber.view;

import br.ufjf.trabalho.aber.control.CadastrarLogin;
import br.ufjf.trabalho.aber.control.RetornaInicial;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame{

    JTextField login;
    JTextField tfEmail;
    JPasswordField senha;

    JPasswordField tfConfirSenha;

    public TelaCadastro(){

        this.login = new JTextField(50);
        this.tfEmail = new JTextField(50);
        this.senha = new JPasswordField(50);
        this.tfConfirSenha = new JPasswordField(50);
        this.setLayout(new BorderLayout());
        this.add(painelCaixaTexto(), BorderLayout.CENTER);
        this.add(painelBotoes(), BorderLayout.SOUTH);
        this.setSize(300, 150);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel painelCaixaTexto(){

        JPanel caixaTexto = new JPanel();
        caixaTexto.setLayout(new GridLayout(0, 2));
        caixaTexto.add(new JLabel("Nome:"));
        caixaTexto.add(this.login);
        caixaTexto.add(new JLabel("Email:"));
        caixaTexto.add(this.tfEmail);
        caixaTexto.add(new JLabel("Senha:"));
        caixaTexto.add(this.senha);
        caixaTexto.add(new JLabel("Confirmar senha:"));
        caixaTexto.add(this.tfConfirSenha);
        return caixaTexto;
    }

    private JPanel painelBotoes(){

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        JButton btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(new CadastrarLogin(login, senha));
        botoes.add(btConfirmar);
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(new RetornaInicial());
        this.setVisible(false);
        botoes.add(btCancelar);
        return botoes;
    }
}
