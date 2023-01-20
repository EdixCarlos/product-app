package com.example.keola.service;

import com.example.keola.domain.AtributosJSON;
import com.example.keola.domain.ObjetoAtributoJSON;
import com.example.keola.domain.ProductoTienda;
import com.example.keola.dto.ComboDTO;
import com.example.keola.dto.ProductoResponseDTO;
import com.example.keola.repository.ProductoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;
    public Flux<ProductoResponseDTO> obtenerTodos(){
        Flux<ProductoTienda> productoTiendaFlux = productoRepository.findAll();
        Flux<ProductoResponseDTO> response = productoTiendaFlux.flatMap(ProductoService::productoTiendaToProductoResponseDTO);

        return response;
    }
    private static Mono<ProductoResponseDTO> productoTiendaToProductoResponseDTO(ProductoTienda producto){
        ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO();

        productoResponseDTO.setTienda(producto.getIdtienda().toString());
        productoResponseDTO.setId(producto.getId());
        productoResponseDTO.setNombre(producto.getIdproducto().toString());
        productoResponseDTO.setImagen(producto.getImagen());
        productoResponseDTO.setCategoria(producto.getIdcategoria().toString());
        productoResponseDTO.setSubCategoria(producto.getIdsubcategoria().toString());
        productoResponseDTO.setPrecio(producto.getPrecio());
        System.out.println("==========================AQUI===============");
        System.out.println(producto.getAtributos().toString());
        //JSONPObject json = new JSONPObject(producto.getAtributos());
        return Mono.just(productoResponseDTO);
    }
    final ObjectMapper objectMapper = new ObjectMapper();
    private List<ComboDTO> atributosJSONToAtributosDTO(String json){
        List<ComboDTO> comboDTOList = new ArrayList<>();
        try {
            ObjetoAtributoJSON objetoAtributo = objectMapper.readValue(json, ObjetoAtributoJSON.class);
            //objetoAtributo.getAtributos().stream()
        }catch (Exception e){
            comboDTOList = new ArrayList<>();
            System.out.println(e.getMessage());
        }


        return comboDTOList;
    }
    public Flux<ProductoResponseDTO> obtenerPorTienda(Integer id){
        return null;
    }
}
