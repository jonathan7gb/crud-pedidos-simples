package com.centroweg.crud_pedido.controller;

import com.centroweg.crud_pedido.dto.PedidoRequestDto;
import com.centroweg.crud_pedido.dto.PedidoResponseDTO;
import com.centroweg.crud_pedido.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> save(){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pedidoService.save());
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> findAll(){
        return ResponseEntity.
                ok().
                body(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity
                .ok()
                .body(pedidoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody PedidoRequestDto pedidoRequestDto
            ){
        return ResponseEntity
                .ok()
                .body(pedidoService.update(id, pedidoRequestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        pedidoService.deleteById(id);
        return ResponseEntity
                .ok()
                .body("Pedido deletado com sucesso");
    }
}
