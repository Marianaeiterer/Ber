package br.ufjf.trabalho.aber.control;

import br.ufjf.trabalho.aber.model.Administrador;
import br.ufjf.trabalho.aber.model.Cliente;
import br.ufjf.trabalho.aber.model.Piloto;
import br.ufjf.trabalho.aber.model.Usuario;
import br.ufjf.trabalho.aber.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginConfirmado implements ActionListener {

    Tela tela;
    Usuario usuario;

    public LoginConfirmado(Tela tela) {
        this.tela = tela;

    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if(usuario instanceof Administrador){
            new TelaAdministrador();
            tela.setVisible(false);
        }else if(usuario instanceof Piloto){
            new TelaPiloto();
            tela.setVisible(false);
        }else if(usuario instanceof Cliente){
            new TelaCliente();
            tela.setVisible(false);
        }
    }
}
