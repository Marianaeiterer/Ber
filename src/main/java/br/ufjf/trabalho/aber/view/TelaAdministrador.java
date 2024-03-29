package br.ufjf.trabalho.aber.view;
import br.ufjf.trabalho.aber.arquivo.Arquivo;
import br.ufjf.trabalho.aber.arquivo.JSONRotas;
import br.ufjf.trabalho.aber.control.*;
import br.ufjf.trabalho.aber.model.Rotas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.*;

public class TelaAdministrador extends JFrame implements Tela{
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
    private int lastIndex;

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public TelaAdministrador(){

        configuracaoAdiministrador();
        configuracaoListaRotas();
        configuracaoOpcaoRotas();
        mostrarTela();


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
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.telaAdministrador = new JPanel();
        this.telaAdministrador.setLayout(new BorderLayout());

    }

    private void configuracaoListaRotas() {
        JPanel jRotas = new JPanel();
        jRotas.setBorder(BorderFactory.createTitledBorder("Rotas Cadastradas Sem Confirmacao"));
        jRotas.setLayout(new BorderLayout());
        jRotas.setPreferredSize(new Dimension(500, 300));

        DefaultListModel<Rotas> model = new DefaultListModel<>();

        lista = new JList<>(model);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(new Lista(this));
        jRotas.add(new JScrollPane(lista), BorderLayout.CENTER);

        telaAdministrador.add(jRotas, BorderLayout.EAST);

    }

    private void configuracaoOpcaoRotas() {
        int size = 15;
        JPanel jpFormulario = new JPanel();

        jpFormulario.setBorder(BorderFactory.createTitledBorder("Rotas"));

        jpFormulario.add(new JLabel("Codigo Viagem:"));
        this.codigo = new JTextField(size);
        jpFormulario.add(this.codigo);

        jpFormulario.add(new JLabel("Origem:"));
        this.origem = new JTextField(size);
        jpFormulario.add(this.origem);

        jpFormulario.add(new JLabel("Destino:"));
        this.destino = new JTextField(size);
        jpFormulario.add(this.destino);

        jpFormulario.add(new JLabel("Data:"));
        this.data = new JTextField(size);
        jpFormulario.add(this.data);

        jpFormulario.add(new JLabel("Hora:"));
        this.hora = new JTextField(size);
        jpFormulario.add(this.hora);

        jpFormulario.add(new JLabel("Preço:"));
        this.preco = new JTextField(size);
        jpFormulario.add(this.preco);

        jpFormulario.add(new JLabel("Tipo do Aviao:"));
        this.aviao = new JTextField(size);
        jpFormulario.add(this.aviao);

        jpFormulario.add(new JLabel("Id Aviao:"));
        this.id = new JTextField(size);
        jpFormulario.add(this.id);

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

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new RetornaInicial(this));
        jpFormulario.add(btnSair);

        telaAdministrador.add(jpFormulario, BorderLayout.CENTER);

    }

    public void mostrarTela() {
        this.add(telaAdministrador);
        this.setVisible(true);
    }


}
