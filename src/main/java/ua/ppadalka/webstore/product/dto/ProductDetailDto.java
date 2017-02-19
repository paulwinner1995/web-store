package ua.ppadalka.webstore.product.dto;

import org.hibernate.validator.constraints.NotBlank;

public class ProductDetailDto {

    @NotBlank
    private String property;
    @NotBlank
    private String value;

    public ProductDetailDto() {}

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
