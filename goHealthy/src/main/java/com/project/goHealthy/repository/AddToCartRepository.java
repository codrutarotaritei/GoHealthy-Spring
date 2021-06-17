package com.project.goHealthy.repository;

import com.project.goHealthy.entity.AddToCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AddToCartRepository extends JpaRepository<AddToCart, Integer> {


    @Query("SELECT addToCart FROM AddToCart addToCart WHERE addToCart.userId=:userId")
    List<AddToCart> getFromCartByUserId(@Param("userId") int userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM AddToCart addToCart WHERE addToCart.userId=:userId")
    void deleteFromCartByUserId(@Param("userId") int userId);

}
