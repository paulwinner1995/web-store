package ua.ppadalka.webstore.product.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

public class ProductInfoDto {

    @NotBlank
    private String name;
    private Double price;
    private String description;
    private ProductCategoryDto category;
    private List<ProductDetailDto> details;

    public ProductInfoDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategoryDto getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryDto category) {
        this.category = category;
    }

    public List<ProductDetailDto> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetailDto> details) {
        this.details = details;
    }
}
