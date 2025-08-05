package model;

import enums.UnidadeMedida;

public class Item {
    private int id;
    private static int nextId = 0;
    private String tipo;
    private String nome;
    private UnidadeMedida unidadeMedida;
    private String codigoBarras;
    private double preco;


    public Item(String tipo, String nome, UnidadeMedida unidadeMedida, String codigoBarras, double preco) {
        this.tipo = tipo;
        this.nome = nome;
        this.unidadeMedida = unidadeMedida;
        id = nextId++;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                " || Tipo: " + getTipo() +
                " || Nome: " + getNome() +
                " || Unidade de medida: " + getUnidadeMedida() +
                " || ID: " + getCodigoBarras();
    }
}
