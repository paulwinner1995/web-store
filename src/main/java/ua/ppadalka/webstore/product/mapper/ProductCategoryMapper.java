package ua.ppadalka.webstore.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.model.ProductCategory;

@Mapper
public interface ProductCategoryMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
    })
    ProductCategoryDto toDto(ProductCategory productCategory);

    @Mappings({
            @Mapping(source = "name", target = "name")
    })
    ProductCategory toModel(ProductCategoryDto productCategoryDto);
}
