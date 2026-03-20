package com.centroweg.crud_pedido.service;

import com.centroweg.crud_pedido.dto.ItemPedidoRequestDto;
import com.centroweg.crud_pedido.dto.ItemPedidoResponseDto;
import com.centroweg.crud_pedido.mapper.ItemPedidoMapper;
import com.centroweg.crud_pedido.model.ItemPedido;
import com.centroweg.crud_pedido.model.Pedido;
import com.centroweg.crud_pedido.repository.ItemPedidoRepository;
import com.centroweg.crud_pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoMapper itemPedidoMapper;

    public ItemPedidoResponseDto criarItem(
            ItemPedidoRequestDto itemPedidoRequestDto
    ){
        Pedido pedido = pedidoRepository.findById(itemPedidoRequestDto.idPedido())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));

        ItemPedido itemPedido = itemPedidoMapper.toEntity(itemPedidoRequestDto, pedido);

        return itemPedidoMapper.toDto(itemPedidoRepository.save(itemPedido));

    }
}
