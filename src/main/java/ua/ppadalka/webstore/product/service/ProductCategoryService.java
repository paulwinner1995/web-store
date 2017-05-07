package ua.ppadalka.webstore.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.model.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * Provides methods for working with product categories
 */
public interface ProductCategoryService {

    /**
     * Looking for page of categories
     *
     * @param  - {@link Pageable} page request
     * @return - {@link List} of categories
     */
    Page<ProductCategoryDto> findCategories(Pageable pageable);

    List<String> findCategoryNamesByExample(String example);

    Optional<ProductCategory> findCategoryByName(String name);

    ProductCategoryDto save(ProductCategoryDto category);
}
