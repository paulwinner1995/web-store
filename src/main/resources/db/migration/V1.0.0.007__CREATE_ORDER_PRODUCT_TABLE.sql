CREATE TABLE order_product (
  order_product_id BIGINT,
  amount           INT4   NOT NULL,
  order_id         BIGINT NOT NULL,
  product_id       BIGINT NOT NULL,
  
  PRIMARY KEY (order_product_id),
  FOREIGN KEY (order_id)   REFERENCES "order" (order_id),
  FOREIGN KEY (product_id) REFERENCES product (product_id)
);

CREATE SEQUENCE order_product_id_sequence OWNED BY order_product.order_product_id;