package ua.ppadalka.webstore.product.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ppadalka.webstore.product.dto.ProductDto;
import ua.ppadalka.webstore.product.model.Product;

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
}