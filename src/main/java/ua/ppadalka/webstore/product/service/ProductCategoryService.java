package ua.ppadalka.webstore.product.service;

import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.model.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * Provides methods for working with product categories
 */
public interface ProductCategoryService {

    /**
     * Looking for basic categories
     *
     * @return - {@link List} of basic categories (which do not have parent category)
     */
    List<ProductCategoryDto> findBasicCategories();

    /**
     * Looking for sub categories
     *
     * @param category - parent category
     * @return - {@link List} of categories which are subcategories of given category
     */
    List<ProductCategoryDto> findSubCategories(String category);

    Optional<ProductCategory> findCategoryByName(String name);

    ProductCategoryDto create(ProductCategoryDto category);

    ProductCategoryDto createSub(String parentName, ProductCategoryDto category);
}
