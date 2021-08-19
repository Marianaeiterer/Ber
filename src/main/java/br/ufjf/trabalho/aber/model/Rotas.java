package br.ufjf.trabalho.aber.model;

import java.util.Date;

public class Rotas {

    private String codigo;
    private String origem;
    private String destino;
    private String data;
    private String preco;
    private String Hora;
    private Aviao aviao;

    public Rotas(String codigo,String origem, String destino, String data, String preco, String Hora, String tipo, String id) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.preco = preco;
        this.Hora = Hora;
        this.aviao = new Aviao(tipo, id);
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

    public String getCodigo() {
        return codigo;
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
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    @Override
    public String toString() {
        return "Rotas{" +
                "codigo='" + codigo + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", data='" + data + '\'' +
                ", preco='" + preco + '\'' +
                ", Hora='" + Hora + '\'' +
                 aviao +
                '}';
    }
}
