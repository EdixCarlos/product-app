package com.example.keola.repository;

import com.example.keola.domain.ProductoTienda;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductoRepository extends ReactiveCrudRepository<ProductoTienda,Integer> {
}
