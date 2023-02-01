package com.example.keola.controller;

import com.example.keola.dto.ProductoResponseDTO;
import com.example.keola.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/keola")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping(value ="/getAll", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductoResponseDTO> getAll() {
        return productoService.obtenerTodos();


    }


}
