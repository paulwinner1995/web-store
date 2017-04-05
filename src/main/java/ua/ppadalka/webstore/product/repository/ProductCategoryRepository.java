package ua.ppadalka.webstore.product.repository;

import org.springframework.data.repository.CrudRepository;
import ua.ppadalka.webstore.product.model.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {

    ProductCategory findByName(String name);

    List<ProductCategory> findByParentName(String name);
}
