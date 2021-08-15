package com.dio.productcatalog.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

// Especificando como ele vai ser armazenado no elasticsearch, indexName é como se fosse o nome da "tabela"
@Document(indexName="product",type="catalog")
public class Product {
    @Id
    private Long id;
    private String name;
    private Integer amount;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
