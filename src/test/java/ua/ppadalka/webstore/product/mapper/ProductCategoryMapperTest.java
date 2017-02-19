package ua.ppadalka.webstore.product.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.model.ProductCategory;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void shouldMapModelToDto() {
        // given
        ProductCategory category = new ProductCategory();

        category.setName("Бытовая техника");

        // when
        ProductCategoryDto categoryDto = mapper.toDto(category);

        // then
        assertEquals("Бытовая техника", categoryDto.getName());
    }

    @Test
    public void shouldMapDtoToModel() {
        // given
        ProductCategoryDto categoryDto = new ProductCategoryDto();

        categoryDto.setName("Спортивные товары");

        // when
        ProductCategory category = mapper.toModel(categoryDto);

        // then
        assertEquals("Спортивные товары", category.getName());
    }
}