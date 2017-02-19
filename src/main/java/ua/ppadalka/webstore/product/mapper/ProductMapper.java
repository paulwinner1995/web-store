package ua.ppadalka.webstore.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ua.ppadalka.webstore.product.dto.ProductDto;
import ua.ppadalka.webstore.product.dto.ProductInfoDto;
import ua.ppadalka.webstore.product.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toModel(ProductInfoDto productInfo);

    @Mappings({
            @Mapping(source = "code", target = "xref")
    })
    ProductDto toDto(Product product);

    ProductInfoDto toInfoDto(Product product);
}
