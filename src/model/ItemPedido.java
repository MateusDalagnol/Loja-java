package model;

import enums.UnidadeMedida;

public class ItemPedido extends Item{

    private int quantidade;

    public ItemPedido(String tipo, String nome, UnidadeMedida unidadeMedida, String codigoBarras, double preco,
                      int quantidade) {
        super(tipo, nome, unidadeMedida, codigoBarras, preco);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                " || Tipo: " + getTipo() +
                " || Nome: " + getNome() +
                " || Preço " + getPreco() +
                " || Unidade de medida: " + getUnidadeMedida() +
                " || Quantidade: " + getQuantidade() +
                " || ID: " + getCodigoBarras();
    }
    
}
