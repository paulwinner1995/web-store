package ua.ppadalka.webstore.product.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ppadalka.webstore.product.dto.ProductDetailDto;
import ua.ppadalka.webstore.product.model.ProductDetail;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductDetailMapperTest {

    @Autowired
    private ProductDetailMapper mapper;

    @Test
    public void shouldMapModelToDto() {
        // given
        ProductDetail productDetail = new ProductDetail();

        productDetail.setProperty("brand");
        productDetail.setValue("Apple");
        // when
        ProductDetailDto productDetailDto = mapper.toDto(productDetail);

        // then
        assertEquals("brand", productDetailDto.getProperty());
        assertEquals("Apple", productDetailDto.getValue());
    }

    @Test
    public void shouldMapDtoToModel() {
        // given
        ProductDetailDto productDetailDto = new ProductDetailDto();

        productDetailDto.setProperty("model");
        productDetailDto.setValue("iPhone SE");

        // when
        ProductDetail productDetail = mapper.toModel(productDetailDto);

        // then
        assertEquals("model", productDetail.getProperty());
        assertEquals("iPhone SE", productDetail.getValue());
    }
}