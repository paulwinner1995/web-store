package ua.ppadalka.webstore.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.repository.ProductCategoryRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategoryDto> findBasicCategories() {
        return Collections.emptyList();
    }

    @Override
    public List<ProductCategoryDto> findSubCategories(String category) {
        return Collections.emptyList();
    }
}
