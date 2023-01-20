package com.example.keola.domain;

import io.r2dbc.postgresql.codec.Json;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class ProductoTienda implements Persistable<Integer> {

    @Id
    private Integer id;
    @Column
    private Integer idtienda;
    @Column
    private Integer idproducto;
    @Column
    private Integer idcategoria;
    @Column
    private Integer idsubcategoria;
    @Column
    private String imagen;
    @Column
    private Double precio;
    @Column
    private Integer stock;
    @Column
    private Json atributos;


    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }
}
