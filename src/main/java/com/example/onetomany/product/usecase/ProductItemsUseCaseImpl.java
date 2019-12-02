package com.example.onetomany.product.usecase;

import com.example.onetomany.product.dao.ProductItems;
import com.example.onetomany.product.repo.ProductItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemsUseCaseImpl implements ProductItemsUseCase {
    @Autowired
    ProductItemsRepo productItemsRepo;

    @Override
    public List<ProductItems> findAllProductItems() {
        return productItemsRepo.findAll();
    }
}
