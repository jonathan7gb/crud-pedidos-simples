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

import java.util.List;

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

    public List<ItemPedidoResponseDto> findAll(){
        List<ItemPedido> itens = itemPedidoRepository.findAll();
        return itens.stream()
                .map(itemPedidoMapper::toDto)
                .toList();
    }

    public ItemPedidoResponseDto findById(Long id){
        ItemPedido itemPedido = itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum item com esse id encontrado"));

        return itemPedidoMapper.toDto(itemPedido);
    }

    public ItemPedidoResponseDto update(Long id, ItemPedidoRequestDto itemPedidoRequestDto){
        ItemPedido itemPedido = itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum item com esse id encontrado"));

        itemPedido.setNomeProduto(itemPedidoRequestDto.nomeProduto());
        itemPedido.setQuantidade(itemPedidoRequestDto.quantidade());
        itemPedido.setPrecoUnitario(itemPedidoRequestDto.precoUnitario());
        itemPedido.getPedido().setId(itemPedidoRequestDto.idPedido());

        return itemPedidoMapper.toDto(itemPedidoRepository.save(itemPedido));
    }

    public void deleteById(Long id){
        itemPedidoRepository.deleteById(id);
    }
}
