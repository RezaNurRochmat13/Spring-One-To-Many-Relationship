package com.example.onetomany.product.dao.dto.product_items;

import com.example.onetomany.product.dao.ProductDao;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Optional;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ListProductItemsDto {

    private Integer idProductItems;
    private Optional<ProductDao> listProduct;

    public Integer getIdProductItems() {
        return idProductItems;
    }

    public void setIdProductItems(Integer idProductItems) {
        this.idProductItems = idProductItems;
    }

    public Optional<ProductDao> getListProduct() {
        return listProduct;
    }

    public void setListProduct(Optional<ProductDao> listProduct) {
        this.listProduct = listProduct;
    }
}
