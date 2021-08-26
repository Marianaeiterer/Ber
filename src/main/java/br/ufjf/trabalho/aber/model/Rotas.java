package br.ufjf.trabalho.aber.model;

import java.util.Date;

public class Rotas {

    private String codigo;
    private String origem;
    private String destino;
    private String data;
    private String preco;
    private String hora;
    private Aviao aviao;

    public Rotas(String codigo,String origem, String destino, String data, String preco, String hora, String tipo, String id) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.preco = preco;
        this.hora = hora;
        this.aviao = new Aviao(tipo, id);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(String tipo, String id) {
        this.aviao.setTipo(tipo);
        this.aviao.setId(id);
    }

    @Override
    public String toString() {
        return this.codigo + " - "+ this.origem + " para " + this.destino +
                " - Dia: " + this.data + " Horario: " + this.hora + " Preco: " + this.preco;
    }
}
