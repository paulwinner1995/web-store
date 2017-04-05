package ua.ppadalka.webstore.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.model.ProductCategory;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {

    @Mappings({
            @Mapping(target = "parentName", source = "parent.name")
    })
    ProductCategoryDto toDto(ProductCategory productCategory);

    ProductCategory toModel(ProductCategoryDto productCategoryDto);
}
