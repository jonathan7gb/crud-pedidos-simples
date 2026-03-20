package com.centroweg.crud_pedido.service;

import com.centroweg.crud_pedido.dto.PedidoRequestDto;
import com.centroweg.crud_pedido.dto.PedidoResponseDTO;
import com.centroweg.crud_pedido.mapper.PedidoMapper;
import com.centroweg.crud_pedido.model.Pedido;
import com.centroweg.crud_pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoResponseDTO save(){
        Pedido pedido = new Pedido(LocalDateTime.now());
        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    public List<PedidoResponseDTO> findAll(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                .map(pedidoMapper::toDto)
                .toList();
    }

    public PedidoResponseDTO findById(Long id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum pedido com esse id encontrado"));

        return pedidoMapper.toDto(pedido);
    }

    public PedidoResponseDTO update(Long id, PedidoRequestDto pedidoRequestDto){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum pedido com esse id encontrado"));

        pedido.setDataPedido(pedidoRequestDto.dataPedido());


        return pedidoMapper.toDto(pedidoRepository.save(pedido));
    }

    public void deleteById(Long id){
        pedidoRepository.deleteById(id);
    }
}


