package com.fernando.authapijwt.repositories;

import com.fernando.authapijwt.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
