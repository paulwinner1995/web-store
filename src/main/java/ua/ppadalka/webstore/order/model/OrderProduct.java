package ua.ppadalka.webstore.order.model;

import ua.ppadalka.webstore.product.model.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ORDER_PRODUCT")
@SequenceGenerator(
        name = "ORDER_PRODUCT_ID_SEQUENCE_GENERATOR",
        sequenceName = "ORDER_PRODUCT_ID_SEQUENCE",
        allocationSize = 1
)
public class OrderProduct {

    @Id
    @GeneratedValue(
            generator = "ORDER_PRODUCT_ID_SEQUENCE_GENERATOR",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "ORDER_PRODUCT_ID")
    private Long id;

    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;

    @ManyToOne
    @JoinColumn(
            name = "ORDER_ID",
            referencedColumnName = "ORDER_ID"
    )
    private Order order;

    @ManyToOne
    @JoinColumn(
            name = "PRODUCT_ID",
            referencedColumnName = "PRODUCT_ID"
    )
    private Product product;

    public OrderProduct() {}

    public OrderProduct(Order order, Product product, Integer amount) {
        this.order = order;
        this.product = product;
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof OrderProduct)) return false;

        OrderProduct orderProduct = (OrderProduct) obj;

        return Objects.equals(order, orderProduct.order) &&
                Objects.equals(product, orderProduct.product);
    }

    public Long getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }
}
