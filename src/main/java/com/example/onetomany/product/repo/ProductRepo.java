package com.example.onetomany.product.repo;

import com.example.onetomany.product.dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductDao, Integer> {
}
