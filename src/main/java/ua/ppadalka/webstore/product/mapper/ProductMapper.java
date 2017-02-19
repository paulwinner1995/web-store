package ua.ppadalka.webstore.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ua.ppadalka.webstore.product.dto.ProductDto;
import ua.ppadalka.webstore.product.dto.ProductInfoDto;
import ua.ppadalka.webstore.product.model.Product;

@Mapper(
        componentModel = "spring",
        uses = {ProductCategoryMapper.class, ProductDetailMapper.class}
)
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "productCategory", ignore = true),
            @Mapping(target = "productDetails", ignore = true)
    })
    Product toModel(ProductInfoDto productInfo);

    @Mappings({
            @Mapping(source = "code", target = "xref")
    })
    ProductDto toDto(Product product);

    @Mappings({
            @Mapping(source = "productCategory", target = "category"),
            @Mapping(source = "productDetails", target = "details")
    })
    ProductInfoDto toInfoDto(Product product);
}
