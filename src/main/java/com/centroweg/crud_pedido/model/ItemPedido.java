package com.centroweg.crud_pedido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome_produto")
    private String nomeProduto;

    @Column(nullable = false)
    private int quantidade;

    @Column(name = "preco_unitario")
    private double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public ItemPedido(String nomeProduto, int quantidade, double precoUnitario, Pedido pedido) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.pedido = pedido;
    }
}
