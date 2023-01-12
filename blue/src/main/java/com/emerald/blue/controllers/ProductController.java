package com.emerald.blue.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emerald.blue.models.Product;
import com.emerald.blue.repositories.ProductRepository;
import com.emerald.blue.services.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    private List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //get by id mapp
    @GetMapping("/{id}")
    private Product getProduct(@PathVariable("id")Long id)
    {
        return productService.getProductById(id);
    }

    //delete mapp
    @DeleteMapping("/{id}")
    private void deleteProduct(@PathVariable("id") Long id)
    {
        productService.deleteProductById(id);
    }
    //save map
    @PostMapping("/")
    private Long saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return product.getId();
    }
    //put map for update
}
