//package com.project.goHealthy.entity;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.*;
//import javax.sql.DataSource;
//import javax.validation.Valid;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "ORDER_TBL")
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    @Column
//    private LocalDate dateCreated;
//
//    @Column
//    private String status;
//
//    @JsonManagedReference
//    @OneToMany(mappedBy = "pk.order")
//    @Valid
//    private List<OrderProduct> orderProducts = new ArrayList<>();
//
//    @Transient
//    public Double getTotalOrderPrice() {
//        double sum = 0D;
//        List<OrderProduct> orderProducts = getOrderProducts();
//        for (OrderProduct op : orderProducts) {
//            sum += op.getTotalPrice();
//        }
//        return sum;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public LocalDate getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(LocalDate dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public List<OrderProduct> getOrderProducts() {
//        return orderProducts;
//    }
//
//    public void setOrderProducts(List<OrderProduct> orderProducts) {
//        this.orderProducts = orderProducts;
//    }
//
//    @Transient
//    public int getNumberOfProducts() {
//        return this.orderProducts.size();
//    }
//}
