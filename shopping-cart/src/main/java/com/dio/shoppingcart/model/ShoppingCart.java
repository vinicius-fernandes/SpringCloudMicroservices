package com.dio.shoppingcart.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

@RedisHash("cart")
public class ShoppingCart {
    @Id
    private Long id;
    private List<Item> itens;

    public ShoppingCart(){
    }

    public ShoppingCart(Long id) {this.id = id;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public List<Item> getItens(){
        if (itens == null){
            itens = new ArrayList<>();}
        return itens;
    }

    public void setItens(List<Item> itens){this.itens = itens;
    }
}