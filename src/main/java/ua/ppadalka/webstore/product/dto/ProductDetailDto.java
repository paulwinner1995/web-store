package ua.ppadalka.webstore.product.dto;

public class ProductDetailDto {
    private String property;
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
