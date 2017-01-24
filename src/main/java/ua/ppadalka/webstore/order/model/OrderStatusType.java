package ua.ppadalka.webstore.order.model;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 */
public enum OrderStatusType {

    /**
     *
     */
    SUBMITTED(1),

    /**
     *
     */
    IN_PROGRESS(2),

    /**
     *
     */
    CONFIRMED(3),

    /**
     *
     */
    SENT(4),

    /**
     *
     */
    IN_STOCK(5),

    /**
     *
     */
    DONE(6),

    /**
     *
     */
    REJECTED(-1);

    private Integer code;

    public OrderStatusType valueOf(Integer code) {
        return Arrays.stream(values())
                .filter(status -> Objects.equals(code, status.code))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    OrderStatusType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
