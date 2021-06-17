package com.project.goHealthy.service.CartService;

import com.project.goHealthy.entity.AddToCart;

import java.util.List;

public class CartServiceImpl implements CartService {

    @Override
    public List<AddToCart> addToCartByUserIdAndProductId(int productId, int userId) {
        return null;
    }

    @Override
    public List<AddToCart> getFromCartByUserId(int userId) {
        return null;
    }

    @Override
    public List<AddToCart> removeFromCartByUserId(int cartId, long userId) {
        return null;
    }
}
