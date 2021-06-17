package com.project.goHealthy.service.CartService;

import com.project.goHealthy.entity.AddToCart;

import java.util.List;

public interface CartService {

    List<AddToCart> addToCartByUserIdAndProductId(int productId, int userId);
    List<AddToCart> getFromCartByUserId(int userId);
    List<AddToCart> removeFromCartByUserId(int cartId, long userId);
//    List<AddToCart> checkOutCart();

}
