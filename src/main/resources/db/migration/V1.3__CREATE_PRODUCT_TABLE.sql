CREATE TABLE product (
  product_id          BIGINT,
  name                VARCHAR(255) NOT NULL,
  code                VARCHAR(255) NOT NULL,
  price               DECIMAL      NOT NULL,
  amount              INT4         NOT NULL,
  version             TIMESTAMP    NOT NULL,
  description         VARCHAR(255),
  
  product_category_id BIGINT       NOT NULL,
  
  PRIMARY KEY (product_id),
  FOREIGN KEY (product_category_id) REFERENCES product_category (product_category_id)
);

CREATE SEQUENCE product_id_sequence OWNED BY product.product_id;