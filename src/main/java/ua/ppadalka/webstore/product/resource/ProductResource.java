package ua.ppadalka.webstore.product.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ppadalka.webstore.product.dto.ProductDto;
import ua.ppadalka.webstore.product.dto.ProductInfoDto;
import ua.ppadalka.webstore.product.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/product")
public class ProductResource {

    private ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> findProductPage(Pageable pageable) {
        return ResponseEntity.ok(productService.findProductPage(pageable));
    }

    @PostMapping
    public ResponseEntity<ProductInfoDto> create(@Valid @RequestBody ProductInfoDto productInfo) {
        return ResponseEntity.ok(productService.create(productInfo));
    }

    @GetMapping(path = "/{xref}")
    public ResponseEntity<ProductInfoDto> findProductInfo(@PathVariable(name = "xref") String xref) {
        return ResponseEntity.ok(productService.findProductInfo(xref));
    }
}
