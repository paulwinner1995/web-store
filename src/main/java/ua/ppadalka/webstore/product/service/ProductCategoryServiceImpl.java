package ua.ppadalka.webstore.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.dto.ProductDetailDto;
import ua.ppadalka.webstore.product.model.ProductCategory;
import ua.ppadalka.webstore.product.repository.ProductCategoryRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategoryDto> findBasicCategories() {
        // TODO: Temporary implementation should be refactored
        return StreamSupport.stream(productCategoryRepository.findAll().spliterator(), false)
                .map(ProductCategory::getName)
                .map(ProductCategoryDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductCategoryDto> findSubCategories(String category) {
        return Collections.emptyList();
    }

    @Override
    public ProductCategoryDto create(ProductCategoryDto category) {
        // TODO: Temporary implementation should be refactored
        ProductCategory productCategory = new ProductCategory(category.getName());
        productCategory.setVersion(LocalDateTime.now());

        return new ProductCategoryDto(productCategoryRepository.save(productCategory).getName());
    }
}
