package model;

import enums.UnidadeMedida;

public class ItemEstoque extends Item {

    private int quantidade;

    public ItemEstoque(String tipo, String nome, UnidadeMedida unidadeMedida, String id,double preco, int quantidade) {
        super(tipo, nome, unidadeMedida, id, preco);
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

    @Override
    public String toString(){
        return "Tipo: " + getTipo() + 
        " || Nome: " + getNome() + 
        " || Preço " + getPreco() +
        " || Unidade de medida: " + getUnidadeMedida() + 
        " || Quantidade: " + getQuantidade() +
        " || ID: " + getId();
    }
}
