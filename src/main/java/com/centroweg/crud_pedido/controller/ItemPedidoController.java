package com.centroweg.crud_pedido.controller;

import com.centroweg.crud_pedido.dto.ItemPedidoRequestDto;
import com.centroweg.crud_pedido.dto.ItemPedidoResponseDto;
import com.centroweg.crud_pedido.service.ItemPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDto> criarItem(
            @RequestBody ItemPedidoRequestDto requestDto
            ){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoService.criarItem(requestDto));
    }

}
