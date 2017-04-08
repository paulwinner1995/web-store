package ua.ppadalka.webstore.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import ua.ppadalka.webstore.product.model.Product;
import ua.ppadalka.webstore.product.projection.ProductProj;

import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, QueryByExampleExecutor<Product> {

    Optional<Product> findByCode(String code);

    Page<ProductProj> findPage(Pageable pageable);
}
