package ua.ppadalka.webstore.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.ppadalka.webstore.product.dto.ProductDetailDto;
import ua.ppadalka.webstore.product.dto.ProductDto;

public interface ProductService {

    /**
     * Looking for page of {@link ProductDto} by given params
     *
     * @param pageable - page information
     * @return - page of {@link ProductDto}
     */
    Page<ProductDto> findProductPage(Pageable pageable);

    ProductDetailDto findProductDetail();
}
