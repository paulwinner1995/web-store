package ua.ppadalka.webstore.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.ppadalka.webstore.product.dto.ProductInfoDto;
import ua.ppadalka.webstore.product.projection.ProductProj;

public interface ProductService {

    /**
     * Looking for page of {@link ProductProj} by given params
     *
     * @param pageable - page request
     * @return - page of {@link ProductProj}
     */
    Page<ProductProj> findPage(Pageable pageable);

    ProductInfoDto findProductInfo(String xref);

    ProductInfoDto create(ProductInfoDto productInfo);
}
