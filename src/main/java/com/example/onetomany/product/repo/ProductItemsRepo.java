package com.example.onetomany.product.repo;

import com.example.onetomany.product.dao.ProductItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemsRepo extends JpaRepository<ProductItems, Integer> {
}
