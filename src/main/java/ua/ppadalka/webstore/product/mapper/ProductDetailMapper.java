package ua.ppadalka.webstore.product.mapper;

import org.mapstruct.Mapper;
import ua.ppadalka.webstore.product.dto.ProductDetailDto;
import ua.ppadalka.webstore.product.model.ProductDetail;

@Mapper
public interface ProductDetailMapper {

    ProductDetail toModel(ProductDetailDto productDetailDto);

    ProductDetailDto toDto(ProductDetail productDetail);
}
