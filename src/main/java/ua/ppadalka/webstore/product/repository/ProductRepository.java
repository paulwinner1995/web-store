package ua.ppadalka.webstore.product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import ua.ppadalka.webstore.product.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, QueryByExampleExecutor<Product> {
}
