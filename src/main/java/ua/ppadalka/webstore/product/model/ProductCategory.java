package ua.ppadalka.webstore.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_CATEGORY")
@SequenceGenerator(
        name = "PRODUCT_CATEGORY_ID_SEQUENCE_GENERATOR",
        sequenceName = "PRODUCT_CATEGORY_ID_SEQUENCE",
        allocationSize = 1
)
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(
            generator = "PRODUCT_CATEGORY_ID_SEQUENCE_GENERATOR",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "PRODUCT_CATEGORY_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JoinColumn(
            name = "PARENT_ID",
            referencedColumnName = "PRODUCT_CATEGORY_ID"
    )
    private ProductCategory parent;


    public ProductCategory() {}

    public ProductCategory(String name) {
        this.name = name;
    }

    public ProductCategory(String name, ProductCategory parent) {
        this(name);
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof ProductCategory)) return false;

        ProductCategory category = (ProductCategory) obj;

        return Objects.equals(name, category.name) &&
                Objects.equals(parent, category.parent);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getParent() {
        return parent;
    }

    public void setParent(ProductCategory parent) {
        this.parent = parent;
    }
}