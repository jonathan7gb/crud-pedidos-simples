package com.centroweg.crud_pedido.dto;

import java.time.LocalDateTime;

public record PedidoResponseDTO (
        Long id,
        LocalDateTime dataPedido
) {
}
