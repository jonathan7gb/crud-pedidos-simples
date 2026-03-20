package com.centroweg.crud_pedido.mapper;

import com.centroweg.crud_pedido.dto.PedidoResponseDTO;
import com.centroweg.crud_pedido.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public PedidoResponseDTO toDto(Pedido pedido){
        return new PedidoResponseDTO(pedido.getId(), pedido.getDataPedido());
    }
}
