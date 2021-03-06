package ua.ppadalka.webstore.order.model;

import ua.ppadalka.webstore.common.converter.LocalDateTimeConverter;
import ua.ppadalka.webstore.profile.model.Profile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "ORDER")
@SequenceGenerator(
        name = "ORDER_ID_SEQUENCE_GENERATOR",
        sequenceName = "ORDER_ID_SEQUENCE",
        allocationSize = 1
)
public class Order implements Serializable {

    @Id
    @GeneratedValue(
            generator = "ORDER_ID_SEQUENCE_GENERATOR",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "START_DATE", nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime endDate;

    @ManyToOne()
    @JoinColumn(
            name = "PROFILE_ID",
            referencedColumnName = "PROFILE_ID"
    )
    private Profile owner;

    public Order() {}

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Order)) return false;

        Order order = (Order) obj;

        return Objects.equals(code, order.code);
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Profile getOwner() {
        return owner;
    }
}
