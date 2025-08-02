package model;

import enums.UnidadeMedida;

public class Item {
    private String tipo;
    private String nome;
    private UnidadeMedida unidadeMedida;
    private String id;

    public Item(String tipo, String nome, UnidadeMedida unidadeMedida, String id) {
        this.tipo = tipo;
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Tipo: " + getTipo() + 
        " || Nome: " + getNome() + 
        " || Unidade de medida: " + getUnidadeMedida() + 
        " || ID: " + getId();
    }
}
