package com.centroweg.crud_pedido.dto;

public record ItemPedidoRequestDto (
        String nomeProduto,
        int quantidade,
        double precoUnitario,
        Long idPedido
) {
}
