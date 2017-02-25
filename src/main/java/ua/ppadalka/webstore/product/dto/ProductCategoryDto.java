package ua.ppadalka.webstore.product.dto;

import org.hibernate.validator.constraints.NotBlank;
import ua.ppadalka.webstore.validator.constraints.UniqueCategory;

public class ProductCategoryDto {

    @NotBlank
    @UniqueCategory
    private String name;

    public ProductCategoryDto() {}

    public ProductCategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
