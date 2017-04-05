package ua.ppadalka.webstore.product.dto;

import org.hibernate.validator.constraints.NotBlank;
import ua.ppadalka.webstore.validator.constraints.UniqueCategory;

import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class ProductCategoryDto {

    @NotBlank
    @UniqueCategory
    private String name;

    private String parentName;

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

    public String getParentName() {
        return Optional.ofNullable(parentName).orElse(EMPTY);
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
