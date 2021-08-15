package com.dio.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShoppingCartNotFoundException extends Exception{
    public ShoppingCartNotFoundException(Long id){
        super("Shopping cart not found with id: "+ id);
    }

}
