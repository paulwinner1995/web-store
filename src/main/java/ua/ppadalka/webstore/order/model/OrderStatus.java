package ua.ppadalka.webstore.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "ORDER_STATUS")
@SequenceGenerator(
        name = "ORDER_STATUS_ID_SEQUENCE_GENERATOR",
        sequenceName = "ORDER_STATUS_ID_SEQUENCE",
        allocationSize = 1
)
public class OrderStatus implements Serializable {

    @Id
    @GeneratedValue(
            generator = "ORDER_STATUS_ID_SEQUENCE_GENERATOR",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "ORDER_STATUS_ID")
    private Long id;

    @Column(name = "TYPE")
    private OrderStatusType type;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    public OrderStatus() {
        this(OrderStatusType.SUBMITTED, LocalDateTime.now());
    }

    public OrderStatus(OrderStatusType type, LocalDateTime startDate) {
        this.type = type;
        this.startDate = startDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, startDate, endDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof OrderStatus)) return false;

        OrderStatus status = (OrderStatus) obj;

        return Objects.equals(type, status.type) &&
                Objects.equals(startDate, status.startDate) &&
                Objects.equals(endDate, status.endDate);
    }

    public Long getId() {
        return id;
    }

    public OrderStatusType getType() {
        return type;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
