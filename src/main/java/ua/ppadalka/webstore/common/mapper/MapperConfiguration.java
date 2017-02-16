package ua.ppadalka.webstore.common.mapper;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ppadalka.webstore.product.mapper.ProductCategoryMapper;

@Configuration
public class MapperConfiguration {

    @Bean
    public ProductCategoryMapper productCategoryMapper() {
        return Mappers.getMapper(ProductCategoryMapper.class);
    }
}
