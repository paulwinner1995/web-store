package ua.ppadalka.webstore.product.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.service.ProductCategoryService;

import javax.validation.Valid;
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
        return ResponseEntity.ok(productCategoryService.findBasicCategories());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductCategoryDto> createCategory(@RequestBody ProductCategoryDto category) {
        return ResponseEntity.ok(productCategoryService.create(category));
    }

    @GetMapping(path = "/{category}")
    public ResponseEntity<List<ProductCategoryDto>> findSubCategories(@PathVariable(name = "category") String category) {
        return ResponseEntity.ok(productCategoryService.findSubCategories(category));
    }

    @PostMapping(path = "/{category}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProductCategoryDto> createSubCategory(@PathVariable(name = "category") String parentName,
                                                                @RequestBody ProductCategoryDto categoryDto) {
        return ResponseEntity.ok(productCategoryService.createSub(parentName, categoryDto));
    }
}
