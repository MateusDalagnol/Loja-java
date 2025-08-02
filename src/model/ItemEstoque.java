package model;

import enums.UnidadeMedida;

public class ItemEstoque extends Item {

    private int quantidade;

    public ItemEstoque(String tipo, String nome, UnidadeMedida unidadeMedida, String id, int quantidade) {
        super(tipo, nome, unidadeMedida, id);
        if (quantidade < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
        }
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
        }
        this.quantidade = quantidade;

    }

}
