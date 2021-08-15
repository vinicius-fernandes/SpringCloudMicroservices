package com.dio.shoppingcart.repository;

import com.dio.shoppingcart.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
