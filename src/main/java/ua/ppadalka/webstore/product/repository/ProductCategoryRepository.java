package ua.ppadalka.webstore.product.repository;

import org.springframework.data.repository.CrudRepository;
import ua.ppadalka.webstore.product.model.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
}
