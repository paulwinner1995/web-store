package ua.ppadalka.webstore.product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ua.ppadalka.webstore.product.model.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {

    ProductCategory findByName(String name);

    List<ProductCategory> findByNameContaining(String example);
}
