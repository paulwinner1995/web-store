package ua.ppadalka.webstore.product.exception;

public class ProductCategoryNotFoundException extends RuntimeException {

    public ProductCategoryNotFoundException(String message) {
        super(message);
    }
}
