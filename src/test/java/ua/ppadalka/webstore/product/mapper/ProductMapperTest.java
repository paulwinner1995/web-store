package ua.ppadalka.webstore.product.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.dto.ProductDto;
import ua.ppadalka.webstore.product.dto.ProductInfoDto;
import ua.ppadalka.webstore.product.model.Product;
import ua.ppadalka.webstore.product.model.ProductCategory;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductMapperTest {

    @Autowired
    private ProductMapper mapper;

    @Test
    public void shouldMapModelToDto() {
        // given
        final Double price = 150.99;

        Product product = new Product();

        product.setName("Lenovo s660");
        product.setCode("p7634294");
        product.setPrice(new BigDecimal(price));

        // when
        ProductDto productDto = mapper.toDto(product);

        // then
        assertEquals("Lenovo s660", productDto.getName());
        assertEquals("p7634294", productDto.getXref());
        assertEquals(price, productDto.getPrice());
    }

    @Test
    public void shouldMapInfoDtoToModel() {
        // given
        final Double price = 999.99;
        final ProductCategoryDto categoryDto = new ProductCategoryDto("PC and Laptop");

        ProductInfoDto productInfoDto = new ProductInfoDto();

        productInfoDto.setName("MacBook Air");
        productInfoDto.setPrice(price);
        productInfoDto.setCategory(categoryDto);
        productInfoDto.setDescription("Make big things happen. All day long.");

        // when
        Product product = mapper.toModel(productInfoDto);

        // then
        assertEquals("MacBook Air", product.getName());
        // TODO: Should investigate how MapStruct converts to BigDesimal
        assertEquals(price, (Double) product.getPrice().doubleValue());
        assertEquals(new ProductCategory("PC and Laptop"), product.getProductCategory());
        assertEquals("Make big things happen. All day long.", product.getDescription());
    }
}