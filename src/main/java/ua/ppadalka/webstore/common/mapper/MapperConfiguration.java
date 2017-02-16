package ua.ppadalka.webstore.common.mapper;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ppadalka.webstore.product.mapper.ProductCategoryMapper;
import ua.ppadalka.webstore.product.mapper.ProductDetailMapper;
import ua.ppadalka.webstore.product.mapper.ProductMapper;

@Configuration
public class MapperConfiguration {

    @Bean
    public ProductCategoryMapper productCategoryMapper() {
        return Mappers.getMapper(ProductCategoryMapper.class);
    }

    @Bean
    public ProductDetailMapper productDetailMapper() {
        return Mappers.getMapper(ProductDetailMapper.class);
    }

    public ProductMapper productMapper() {
        return Mappers.getMapper(ProductMapper.class);
    }
}
