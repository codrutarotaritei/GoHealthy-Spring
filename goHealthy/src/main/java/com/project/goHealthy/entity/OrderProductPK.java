//package com.project.goHealthy.entity;
//
//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerator;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Embeddable
//@JsonIdentityInfo(generator = ObjectIdGenerator.PropertyGenerator.class, property = "order")
//public class OrderProductPK implements Serializable {
//
//    private static final long serialVersionUID = 476151177562655457L;
//
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//
//        result = prime * result + ((order.getId()) ? 0 : pk.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        OrderProduct other = (OrderProduct) obj;
//        if (pk == null) {
//            if (other.pk != null) {
//                return false;
//            }
//        }else if (!pk.equals(other.pk)) {
//            return false;
//        }
//
//        return true;
//    }
//}
