package com.centroweg.crud_pedido.mapper;

import com.centroweg.crud_pedido.dto.ItemPedidoRequestDto;
import com.centroweg.crud_pedido.dto.ItemPedidoResponseDto;
import com.centroweg.crud_pedido.model.ItemPedido;
import com.centroweg.crud_pedido.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class ItemPedidoMapper {

    public ItemPedido toEntity(ItemPedidoRequestDto requestDto, Pedido pedido){
        return new ItemPedido(
                requestDto.nomeProduto(),
                requestDto.quantidade(),
                requestDto.precoUnitario(),
                pedido
        );
    }

    public ItemPedidoResponseDto toDto(ItemPedido itemPedido){
        return new ItemPedidoResponseDto(
                itemPedido.getId(),
                itemPedido.getNomeProduto(),
                itemPedido.getQuantidade(),
                itemPedido.getPrecoUnitario(),
                itemPedido.getPedido()
        );
    }
}
