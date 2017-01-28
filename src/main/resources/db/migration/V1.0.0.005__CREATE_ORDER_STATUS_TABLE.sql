CREATE TABLE order_status (
  order_status_id BIGINT,
  type            INT4      NOT NULL,
  start_date      TIMESTAMP NOT NULL,
  end_date        TIMESTAMP,
  
  PRIMARY KEY (order_status_id)
);

CREATE SEQUENCE order_status_id_sequence OWNED BY order_status.order_status_id;