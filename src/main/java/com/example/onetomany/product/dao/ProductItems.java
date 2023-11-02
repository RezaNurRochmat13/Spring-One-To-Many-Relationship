package com.example.onetomany.product.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "product_items")
public class ProductItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_items_id")
    private Integer productItemsId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "count")
    private Integer countOrder;

    public Integer getProductItemsId() {
        return productItemsId;
    }

    public void setProductItemsId(Integer productItemsId) {
        this.productItemsId = productItemsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCountOrder() {
        return countOrder;
    }

    public void setCountOrder(Integer countOrder) {
        this.countOrder = countOrder;
    }
}
