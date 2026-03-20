package com.centroweg.crud_pedido.dto;

import com.centroweg.crud_pedido.model.Pedido;

public record ItemPedidoResponseDto (
        Long id,
        String nomeProduto,
        int quantidade,
        double precoUnitario,
        Pedido pedido
){
}
