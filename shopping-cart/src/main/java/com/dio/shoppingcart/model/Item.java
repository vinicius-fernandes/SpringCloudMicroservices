package com.dio.shoppingcart.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Item")
public class Item {

    private Long productId;
    private Integer amount;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
