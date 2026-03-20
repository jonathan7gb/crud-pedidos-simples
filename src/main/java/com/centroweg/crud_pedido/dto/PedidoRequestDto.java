package com.centroweg.crud_pedido.dto;

import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public record PedidoRequestDto(
        @PastOrPresent(message = "A data do pedido não pode ser no futuro!")
        LocalDateTime dataPedido
) {
}
