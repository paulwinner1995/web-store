package ua.ppadalka.webstore.product.dto;

import org.hibernate.validator.constraints.NotBlank;

public class ProductCategoryDto {

    @NotBlank
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
