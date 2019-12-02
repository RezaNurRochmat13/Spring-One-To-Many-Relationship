package com.example.onetomany.product.usecase;

import com.example.onetomany.product.dao.ProductDao;
import com.example.onetomany.product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductUseCaseImpl implements ProductUseCase {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<ProductDao> findAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Optional<ProductDao> findProductById(Integer productId) {
        return productRepo.findById(productId);
    }

    @Override
    public ProductDao createNewProduct(ProductDao productPayload) {
        return productRepo.save(productPayload);
    }

    @Override
    public ProductDao updateProduct(ProductDao productPayload) {
        return productRepo.save(productPayload);
    }

    @Override
    public void deleteProduct(ProductDao productPayload) {
        productRepo.delete(productPayload);
    }
}
