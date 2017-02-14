package ua.ppadalka.webstore.product.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.service.ProductCategoryService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/category",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class ProductCategoryResource {

    private ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryResource(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryDto>> findBasicCategories() {
        List<ProductCategoryDto> categories = productCategoryService.findBasicCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping(path = "/{category}")
    public ResponseEntity<List<ProductCategoryDto>> findSubCategories(@PathVariable(name = "category") String category) {
        List<ProductCategoryDto> subCategories = productCategoryService.findSubCategories(category);
        return ResponseEntity.ok(subCategories);
    }
}
