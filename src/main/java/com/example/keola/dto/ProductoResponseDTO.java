package com.example.keola.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductoResponseDTO implements Serializable {

    private int id;
    private String nombre;
    private String tienda;
    private String categoria;
    private String subCategoria;
    private Double precio;
    private String imagen;
    private List<ComboDTO> atributos;


}
