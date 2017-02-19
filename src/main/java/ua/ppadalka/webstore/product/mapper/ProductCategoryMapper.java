package ua.ppadalka.webstore.product.mapper;

import org.mapstruct.Mapper;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.model.ProductCategory;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {

    ProductCategoryDto toDto(ProductCategory productCategory);

    ProductCategory toModel(ProductCategoryDto productCategoryDto);
}
