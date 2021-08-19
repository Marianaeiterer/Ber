package br.ufjf.trabalho.aber.view;

import br.ufjf.trabalho.aber.control.AtualizarRotas;
import br.ufjf.trabalho.aber.control.CadastroRotas;
import br.ufjf.trabalho.aber.control.Limpar;
import br.ufjf.trabalho.aber.control.RemoverRota;
import br.ufjf.trabalho.aber.model.Rotas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class TelaAdministrador extends JFrame {
    private JPanel telaAdministrador;
    private JTextField origem;
    private JTextField destino;
    private JTextField data;
    private JTextField hora;
    private JTextField preco;
    private JTextField aviao;
    private JTextField id;
    private JTextField codigo;
    private JList<Rotas> lista;


    public JPanel getTelaAdministrador() {
        return telaAdministrador;
    }

    public void setTelaAdministrador(JPanel telaAdministrador) {
        this.telaAdministrador = telaAdministrador;
    }

    public JTextField getOrigem() {
        return origem;
    }

    public void setOrigem(JTextField origem) {
        this.origem = origem;
    }

    public JTextField getDestino() {
        return destino;
    }

    public void setDestino(JTextField destino) {
        this.destino = destino;
    }

    public JTextField getData() {
        return data;
    }

    public void setData(JTextField data) {
        this.data = data;
    }

    public JTextField getHora() {
        return hora;
    }

    public void setHora(JTextField hora) {
        this.hora = hora;
    }

    public JTextField getPreco() {
        return preco;
    }

    public void setPreco(JTextField preco) {
        this.preco = preco;
    }

    public JTextField getAviao() {
        return aviao;
    }

    public void setAviao(JTextField aviao) {
        this.aviao = aviao;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JTextField getCodigo() {
        return codigo;
    }

    public void setCodigo(JTextField codigo) {
        this.codigo = codigo;
    }

    public JList<Rotas> getLista() {
        return lista;
    }

    public void setLista(JList<Rotas> lista) {
        this.lista = lista;
    }

    private void configuracaoAdiministrador() {
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.telaAdministrador = new JPanel();
        this.telaAdministrador.setLayout(new BorderLayout());

    }

    private void configuracaoListaRotas() {
        JPanel jRotas = new JPanel();
        jRotas.setBorder(BorderFactory.createTitledBorder("Rotas Disponiveis"));
        jRotas.setLayout(new BorderLayout());
        jRotas.setPreferredSize(new Dimension(200, 300));

        DefaultListModel<Rotas> model = new DefaultListModel<>();

        lista = new JList<>(model);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        telaAdministrador.add(jRotas, BorderLayout.EAST);

    }

    private void configuracaoOpcaoRotas() {
        int size = 15;
        JPanel jpFormulario = new JPanel();

        jpFormulario.setBorder(BorderFactory.createTitledBorder("Rotas"));

        jpFormulario.add(new JLabel("Codigo Viagem:"));
        codigo = new JTextField(size);
        jpFormulario.add(codigo);

        jpFormulario.add(new JLabel("Origem:"));
        origem = new JTextField(size);
        jpFormulario.add(origem);

        jpFormulario.add(new JLabel("Destino:"));
        destino = new JTextField(size);
        jpFormulario.add(destino);

        jpFormulario.add(new JLabel("Data:"));
        data = new JTextField(size);
        jpFormulario.add(data);

        jpFormulario.add(new JLabel("Hora:"));
        hora = new JTextField(size);
        jpFormulario.add(hora);

        jpFormulario.add(new JLabel("Preço:"));
        preco = new JTextField(size);
        jpFormulario.add(preco);

        jpFormulario.add(new JLabel("Tipo do Aviao:"));
        aviao = new JTextField(size);
        jpFormulario.add(aviao);

        jpFormulario.add(new JLabel("Id Aviao:"));
        id = new JTextField(size);
        jpFormulario.add(id);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new CadastroRotas(this));
        jpFormulario.add(btnAdicionar);


        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new RemoverRota(this));
        jpFormulario.add(btnRemover);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new Limpar(this));
        jpFormulario.add(btnLimpar);

        JButton btnEditar = new JButton("Atulizar");
        btnEditar.addActionListener(new AtualizarRotas(this));
        jpFormulario.add(btnEditar);

        telaAdministrador.add(jpFormulario, BorderLayout.CENTER);

    }

    public void mostrarTela() {
        this.add(telaAdministrador);
        this.setVisible(true);
    }

    public void configurarTela() {
        configuracaoAdiministrador();
        configuracaoListaRotas();
        configuracaoOpcaoRotas();
        mostrarTela();
    }

    public static void main(String[] args) {
        TelaAdministrador tela = new TelaAdministrador();
        tela.configurarTela();
    }
}
