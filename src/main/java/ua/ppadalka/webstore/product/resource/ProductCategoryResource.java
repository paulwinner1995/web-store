package ua.ppadalka.webstore.product.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.ppadalka.webstore.product.dto.ProductCategoryDto;
import ua.ppadalka.webstore.product.mapper.ProductCategoryMapper;
import ua.ppadalka.webstore.product.service.ProductCategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/category",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class ProductCategoryResource {

    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper categoryMapper;

    @Autowired
    public ProductCategoryResource(ProductCategoryService categoryService,
                                   ProductCategoryMapper categoryMapper) {
        this.productCategoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryDto>> findCategories() {
        return ResponseEntity.ok(productCategoryService.findCategories());
    }

    @GetMapping(path = "/names")
    public ResponseEntity<List<String>> findCategoryNames(@RequestParam(name = "example") String example) {
        return ResponseEntity.ok(productCategoryService.findCategoryNamesByExample(example));
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<ProductCategoryDto> findCategory(@PathVariable("name") String name) {
        Optional<ProductCategoryDto> productCategoryDto = productCategoryService.findCategoryByName(name)
                .map(categoryMapper::toDto);

        if (!productCategoryDto.isPresent()) {
            return ResponseEntity.status(HttpStatus.GONE).body(new ProductCategoryDto());
        }

        return ResponseEntity.ok(productCategoryDto.get());
    }

    @PostMapping
    public ResponseEntity<ProductCategoryDto> createCategory(@Valid @RequestBody ProductCategoryDto category) {
        return ResponseEntity.ok(productCategoryService.save(category));
    }

    @PutMapping
    public ResponseEntity<ProductCategoryDto> updateCategory(@Valid @RequestBody ProductCategoryDto category) {
        return ResponseEntity.ok(productCategoryService.save(category));
    }
}
