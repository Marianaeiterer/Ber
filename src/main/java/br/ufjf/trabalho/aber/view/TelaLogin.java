package br.ufjf.trabalho.aber.view;

import br.ufjf.trabalho.aber.control.LoginConfirmado;
import br.ufjf.trabalho.aber.control.RetornaInicial;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame implements Tela{

    JTextField tfNomeUsuario;
    JPasswordField tfSenha;

    public TelaLogin(){

        this.tfNomeUsuario = new JTextField(50);
        this.tfSenha = new JPasswordField(50);
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
        caixaTexto.add(new JLabel("Nome do Usuario:"));
        caixaTexto.add(this.tfNomeUsuario);
        caixaTexto.add(new JLabel("Senha:"));
        caixaTexto.add(this.tfSenha);
        return caixaTexto;
    }

    private JPanel painelBotoes(){

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(0, 2));
        JButton btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(new LoginConfirmado(this));
        botoes.add(btConfirmar);
        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(new RetornaInicial(this));
        botoes.add(btCancelar);
        return botoes;
    }

}
