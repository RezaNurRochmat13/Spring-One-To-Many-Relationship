package com.example.onetomany.product.usecase;

import com.example.onetomany.product.dao.ProductDao;

import java.util.List;
import java.util.Optional;

public interface ProductUseCase {
    List<ProductDao> findAllProduct();
    Optional<ProductDao> findProductById(Integer productId);
    ProductDao createNewProduct(ProductDao productPayload);
    ProductDao updateProduct(ProductDao productPayload);
    void deleteProduct(ProductDao productPayload);
}
