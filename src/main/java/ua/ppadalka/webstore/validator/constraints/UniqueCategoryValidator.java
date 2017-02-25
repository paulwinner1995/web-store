package ua.ppadalka.webstore.validator.constraints;

import org.springframework.beans.factory.annotation.Autowired;
import ua.ppadalka.webstore.product.service.ProductCategoryService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryValidator implements ConstraintValidator<UniqueCategory, String> {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public void initialize(UniqueCategory constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || !productCategoryService.findCategoryByName(value).isPresent();
    }
}
