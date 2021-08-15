package com.dio.shoppingcart.controller;

import com.dio.shoppingcart.exceptions.ShoppingCartNotFoundException;
import com.dio.shoppingcart.model.Item;
import com.dio.shoppingcart.model.ShoppingCart;
import com.dio.shoppingcart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepository cartRepository;

    @PostMapping(value = "/{id}")
    public ShoppingCart addItem(@PathVariable("id") Long id, @RequestBody Item item){
        Optional<ShoppingCart> savedCart = cartRepository.findById(id);
        ShoppingCart cart;
        if (savedCart.equals(Optional.empty())){
            cart = new ShoppingCart(id);
        }
        else{
            cart= savedCart.get();
        }
        cart.getItens().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping(value = "/{id}")
    public ShoppingCart findById(@PathVariable("id") Long id) throws ShoppingCartNotFoundException {
        return cartRepository.findById(id).orElseThrow(()->new ShoppingCartNotFoundException(id));
    }

    @DeleteMapping(value = "/{id}")
    public void clear(@PathVariable("id") Long id) {cartRepository.deleteById(id);}
}
