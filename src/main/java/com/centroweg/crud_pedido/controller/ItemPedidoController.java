package com.centroweg.crud_pedido.controller;

import com.centroweg.crud_pedido.dto.ItemPedidoRequestDto;
import com.centroweg.crud_pedido.dto.ItemPedidoResponseDto;
import com.centroweg.crud_pedido.service.ItemPedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> findAll(){
        return ResponseEntity.
                ok().
                body(itemPedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto> findById(@PathVariable Long id){
        return ResponseEntity
                .ok()
                .body(itemPedidoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ItemPedidoRequestDto itemPedidoRequestDto
    ){
        return ResponseEntity
                .ok()
                .body(itemPedidoService.update(id, itemPedidoRequestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        itemPedidoService.deleteById(id);
        return ResponseEntity
                .ok()
                .body("Pedido deletado com sucesso");
    }

}
