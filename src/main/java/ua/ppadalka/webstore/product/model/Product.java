package ua.ppadalka.webstore.product.model;

import ua.ppadalka.webstore.common.converter.LocalDateTimeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
@SequenceGenerator(
        name = "PRODUCT_ID_SEQUENCE_GENERATOR",
        sequenceName = "PRODUCT_ID_SEQUENCE",
        allocationSize = 1
)
public class Product implements Serializable {

    @Id
    @GeneratedValue(
            generator = "PRODUCT_ID_SEQUENCE_GENERATOR",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;

    @Column(name = "VERSION", nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime version;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "PRODUCT_CATEGORY_ID",
            referencedColumnName = "PRODUCT_CATEGORY_ID"
    )
    private ProductCategory productCategory;

    public Product() {}

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Product)) return false;

        Product product = (Product) obj;

        return Objects.equals(name, product.name) &&
                Objects.equals(code, product.code);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public LocalDateTime getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
