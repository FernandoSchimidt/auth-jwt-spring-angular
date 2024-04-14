package com.fernando.authapijwt.services;

import com.fernando.authapijwt.dtos.ProductDto;
import com.fernando.authapijwt.models.Product;

import java.util.List;

public interface ProductService {
    public ProductDto save(ProductDto productDto);

    public List<Product> getll();
}
