package com.example.keola.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Categoria implements Persistable<Integer> {
    @Id
    private Integer id;
    @Column
    private String categoria;

    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }
}