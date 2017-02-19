CREATE TABLE product_category (
  product_category_id BIGINT,
  name                VARCHAR(255) NOT NULL UNIQUE,
  version             TIMESTAMP    NOT NULL,
  parent_id BIGINT,
  
  PRIMARY KEY (product_category_id),
  FOREIGN KEY (parent_id) REFERENCES product_category (product_category_id)
);

CREATE SEQUENCE product_category_id_sequence OWNED BY product_category.product_category_id;