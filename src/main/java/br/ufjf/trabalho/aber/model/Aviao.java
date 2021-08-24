package br.ufjf.trabalho.aber.model;

public class Aviao {

    private String tipo;
    private String tanque;
    private String id;


    public Aviao(String tipo, String id) {
        this.tipo = tipo;
        this.id = id;
        this.tanque = "vazio";
    }

    public void encherTanque(){
        this.tanque = "Cheio";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTanque() {
        return tanque;
    }

    public void setTanque(String tanque) {
        this.tanque = tanque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Aviao tipo: " + tipo + '\'' +
                "Id:" + id + '\'' +
                "Situacao do tanque: " + tanque + '\'';
    }
}
