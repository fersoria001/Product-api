package com.emerald.blue.models;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Product {
    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    private String imgUrl;
    private Integer price;
    private Boolean inStock = true;

    private Product(){}

    public Product(String name, String description, String imgUrl, Integer price){
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
        Objects.equals(name, product.name);
    }
    @Override 
    public int hashCode(){
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", imgUrl='" + imgUrl + '\'' +
        ", price='" + price + '\'' +
        ", inStock='" + inStock + '\'' +
        '}';

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }


}

