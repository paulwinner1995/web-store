package ua.ppadalka.webstore.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.ppadalka.webstore.product.dto.ProductDto;
import ua.ppadalka.webstore.product.dto.ProductInfoDto;
import ua.ppadalka.webstore.product.mapper.ProductMapper;
import ua.ppadalka.webstore.product.model.Product;
import ua.ppadalka.webstore.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Page<ProductDto> findProductPage(Pageable pageable) {
        Example<Product> productExample = Example.of(new Product());
        return productRepository.findAll(productExample, pageable)
                .map(productMapper::toDto);
    }

    @Override
    public ProductInfoDto create(ProductInfoDto productInfo) {
        Product product = productMapper.toModel(productInfo);

        //TODO: Shoult implement creation logic here

        return productMapper.toInfoDto(productRepository.save(product));
    }
}
