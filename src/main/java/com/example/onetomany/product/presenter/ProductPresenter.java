package com.example.onetomany.product.presenter;

import com.example.onetomany.exception.ResourceNotFound;
import com.example.onetomany.product.dao.ProductDao;
import com.example.onetomany.product.usecase.ProductUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ProductPresenter {
    @Autowired
    ProductUseCaseImpl productUseCase;

    @GetMapping("products")
    public Map<String, Object> getAllProducts() {
        Map<String, Object> map = new HashMap<>();
        List<ProductDao> productDaoList = productUseCase.findAllProduct();

        map.put("total", productDaoList.size());
        map.put("count", productDaoList.size());
        map.put("data", productDaoList);
        return map;
    }

    @GetMapping("product/{id}")
    public Map<String, Object> getAllProductBySeller(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        Optional<ProductDao> productDaoList = Optional.ofNullable(productUseCase.findProductById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found with id : " + id)));

        map.put("data", productDaoList);
        return map;
    }

    @PostMapping("product")
    public Map<String, Object> createNewProduct(@Valid @RequestBody ProductDao productDaoPayload) {
        Map<String, Object> map = new HashMap<>();

        productUseCase.createNewProduct(productDaoPayload);

        map.put("message", "Product created successfully");
        map.put("created_product", productDaoPayload);
        return map;
    }

    @PutMapping("product/{id}")
    public Map<String, Object> updateProduct(@PathVariable Integer id, @RequestBody ProductDao productDaoPayload) {
        Map<String, Object> map = new HashMap<>();
        ProductDao productDao = productUseCase.findProductById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found with id"));

        productDao.setProductName(productDaoPayload.getProductName());
        productDao.setProductDescription(productDaoPayload.getProductDescription());
        productUseCase.updateProduct(productDao);

        map.put("message", "Product updated successfully");
        map.put("updated_product", productDaoPayload);
        return map;
    }

    @DeleteMapping("product/{id}")
    public Map<String, Object> deleteProduct(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        ProductDao productDaoOptional = productUseCase.findProductById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found with id : " + id));

        productUseCase.deleteProduct(productDaoOptional);

        map.put("message", "Product deleted successfully");
        return map;

    }
}
