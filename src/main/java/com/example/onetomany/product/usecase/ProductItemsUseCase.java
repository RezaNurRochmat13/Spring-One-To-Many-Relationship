package com.example.onetomany.product.usecase;

import com.example.onetomany.product.dao.ProductItems;

import java.util.List;

public interface ProductItemsUseCase {
    List<ProductItems> findAllProductItems();
}
