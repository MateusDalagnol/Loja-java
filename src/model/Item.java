package model;

import enums.UnidadeMedida;

public class Item {
    private String tipo;
    private String nome;
    private UnidadeMedida unidadeMedida;
    private int id;

    public Item(String tipo, String nome, UnidadeMedida unidadeMedida, int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero.");
        }
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

    public int getId() {
        return id;
    }
}
