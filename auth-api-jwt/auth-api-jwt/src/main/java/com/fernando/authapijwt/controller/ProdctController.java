package com.fernando.authapijwt.controller;

import com.fernando.authapijwt.dtos.ProductDto;
import com.fernando.authapijwt.models.Product;
import com.fernando.authapijwt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdctController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    private ProductDto save(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @GetMapping()
    private List<Product> test() {
        return productService.getll();
    }

}
