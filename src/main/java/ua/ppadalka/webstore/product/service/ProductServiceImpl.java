package ua.ppadalka.webstore.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.dto.ProductInfoDto;
import ua.ppadalka.webstore.product.exception.ProductNotFoundException;
import ua.ppadalka.webstore.product.mapper.ProductDetailMapper;
import ua.ppadalka.webstore.product.mapper.ProductMapper;
import ua.ppadalka.webstore.product.model.Product;
import ua.ppadalka.webstore.product.model.ProductCategory;
import ua.ppadalka.webstore.product.model.ProductDetail;
import ua.ppadalka.webstore.product.projection.ProductProj;
import ua.ppadalka.webstore.product.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCategoryService productCategoryService;
    private final ProductDetailMapper productDetailMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper,
                              ProductCategoryService productCategoryService,
                              ProductDetailMapper productDetailMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productCategoryService = productCategoryService;
        this.productDetailMapper = productDetailMapper;
    }

    @Override
    public Page<ProductProj> findPage(Pageable pageable) {
        return productRepository.findAllProjectedBy(pageable);
    }

    @Override
    public ProductInfoDto create(ProductInfoDto productInfo) {
        // TODO: Should investigate how I can refactor this method
        Product product = productMapper.toModel(productInfo);

        ProductCategoryDto categoryDto = productInfo.getCategory();
        ProductCategory category = productCategoryService.findCategoryByName(categoryDto.getName())
                .orElseThrow(RuntimeException::new);

        product.setProductCategory(category);
        product.setVersion(LocalDateTime.now());
        product.setAmount(0);

        UUID productCode = UUID.randomUUID();

        product.setCode(productCode.toString());

        productInfo.getDetails().stream()
                .map(productDetailMapper::toModel)
                .forEach(detail -> assignProductDetail(product, detail));

        return productMapper.toInfoDto(productRepository.save(product));
    }

    private void assignProductDetail(Product product, ProductDetail productDetail) {
        productDetail.setProduct(product);
        product.addProductDetail(productDetail);
    }

    @Override
    public ProductInfoDto findProductInfo(String code) {
        Product product = productRepository.findByCode(code)
                .orElseThrow(() -> new ProductNotFoundException(code));

        return productMapper.toInfoDto(product);
    }
}
