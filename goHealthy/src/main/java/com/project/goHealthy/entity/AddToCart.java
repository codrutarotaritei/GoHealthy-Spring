package com.project.goHealthy.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "addToCart_tbl")
public class AddToCart {

    @Id
    private Integer id;

    @Column
    private Integer productId;

    @Column
    private Integer userId;

    @Column
    private String productName;

    @Column
    private Integer quantity;

    @Column
    private double price;

    @Column
    private String added_date;




}
