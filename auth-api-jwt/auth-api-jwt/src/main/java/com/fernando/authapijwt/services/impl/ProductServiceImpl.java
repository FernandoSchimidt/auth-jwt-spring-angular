package com.fernando.authapijwt.services.impl;

import com.fernando.authapijwt.dtos.ProductDto;
import com.fernando.authapijwt.models.Product;
import com.fernando.authapijwt.repositories.ProductRepository;
import com.fernando.authapijwt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getll() {
        List<Product> products = productRepository.findAll();
        return  products;
    }

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = new Product(productDto.name(),productDto.price());
        Product newProduct = productRepository.save(product);
        return new ProductDto(newProduct.getName(),newProduct.getPrice());
    }
}
