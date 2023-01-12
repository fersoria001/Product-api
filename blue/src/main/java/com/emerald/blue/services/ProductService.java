package com.emerald.blue.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emerald.blue.models.Product;
import com.emerald.blue.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    //get findall
    public List<Product> getAllProducts()
    {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach(products1->products.add(products1));
        return products;
    }
    //get findbyId
    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }
    //get byName revisar si anda luego
    public Product getProductByName(String name){
        return productRepository.findByNameIs(name);
    }
    //save product
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    //delete product
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
    //update or modify

}
