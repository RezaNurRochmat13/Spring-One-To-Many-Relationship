package com.example.onetomany.product.presenter.product_items;

import com.example.onetomany.employee.dto.DetailEmployeeDto;
import com.example.onetomany.product.dao.ProductDao;
import com.example.onetomany.product.dao.ProductItems;
import com.example.onetomany.product.dao.dto.product_items.ListProductItemsDto;
import com.example.onetomany.product.usecase.ProductItemsUseCaseImpl;
import com.example.onetomany.product.usecase.ProductUseCaseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class ProductItemsPresenter {
    @Autowired
    ProductItemsUseCaseImpl productItemsUseCase;

    @Autowired
    ProductUseCaseImpl productUseCase;

    @GetMapping("product-items")
    public Map<String, Object> getAllProductItems() {
        Map<String, Object> map = new HashMap<>();
        List<ProductItems> productItems = productItemsUseCase.findAllProductItems();
        List<ListProductItemsDto> productItemsArrays = mapperToListProductDtos(productItems);

        map.put("total", productItemsArrays.size());
        map.put("count", productItemsArrays.size());
        map.put("data", productItemsArrays);
        return map;
    }

    // Mapper ListProductItems DTO
    private List<ListProductItemsDto> mapperToListProductDtos(List<ProductItems> productItems) {
        ModelMapper modelMapper = new ModelMapper();
        List<ListProductItemsDto> listProductItemsDtoList = new ArrayList<>();

        for(ProductItems value: productItems) {
            ListProductItemsDto listProductItemsDtos = modelMapper.map(value, ListProductItemsDto.class);
            listProductItemsDtos.setIdProductItems(value.getProductItemsId());
            Optional<ProductDao> productDao = productUseCase.findProductById(value.getProductId());
            listProductItemsDtos.setListProduct(productDao);

            listProductItemsDtoList.add(listProductItemsDtos);
        }

        return listProductItemsDtoList;
    }
}
