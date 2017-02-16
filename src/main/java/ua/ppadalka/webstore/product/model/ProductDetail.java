package ua.ppadalka.webstore.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_DETAIL")
@SequenceGenerator(
        name = "PRODUCT_DETAIL_ID_SEQUENCE_GENERATOR",
        sequenceName = "PRODUCT_DETAIL_ID_SEQUENCE",
        allocationSize = 1
)
public class ProductDetail implements Serializable {

    @Id
    @GeneratedValue(
            generator = "PRODUCT_DETAIL_ID_SEQUENCE_GENERATOR",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "PRODUCT_DETAIL_ID")
    private Long id;

    @Column(name = "PROPERTY", nullable = false)
    private String property;

    @Column(name = "VALUE", nullable = false)
    private String value;

    public ProductDetail() {
    }

    public ProductDetail(String property, String value) {
        this.property = property;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(property, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof ProductDetail)) return false;

        ProductDetail detail = (ProductDetail) obj;

        return Objects.equals(property, detail.property) &&
                Objects.equals(value, detail.value);
    }

    public Long getId() {
        return id;
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
