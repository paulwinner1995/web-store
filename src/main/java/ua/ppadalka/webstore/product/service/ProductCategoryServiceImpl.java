package ua.ppadalka.webstore.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.mapper.ProductCategoryMapper;
import ua.ppadalka.webstore.product.model.ProductCategory;
import ua.ppadalka.webstore.product.repository.ProductCategoryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository,
                                      ProductCategoryMapper productCategoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public List<ProductCategoryDto> findCategories() {
        Iterable<ProductCategory> productCategories = productCategoryRepository.findAll();

        return StreamSupport.stream(productCategories.spliterator(), false)
                .map(productCategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductCategoryDto> findSubCategories(String category) {
        return productCategoryRepository.findByParentName(category).stream()
                .map(productCategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findCategoryNamesByExample(String example) {
        return productCategoryRepository.findByNameContaining(example).stream()
                .map(ProductCategory::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductCategory> findCategoryByName(String name) {
        return Optional.ofNullable(productCategoryRepository.findByName(name));
    }

    @Override
    public ProductCategoryDto create(ProductCategoryDto category) {
        ProductCategory productCategory = productCategoryMapper.toModel(category);

        String parentName = category.getParentName();
        ProductCategory parentCategory = productCategoryRepository.findByName(parentName);

        productCategory.setParent(parentCategory);
        productCategory.setVersion(LocalDateTime.now());

        return productCategoryMapper.toDto(productCategoryRepository.save(productCategory));
    }
}
