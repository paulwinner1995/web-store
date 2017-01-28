CREATE TABLE product_detail (
  product_detail_id BIGINT,
  property          VARCHAR(255) NOT NULL,
  value             VARCHAR(255) NOT NULL,
  product_id        BIGINT       NOT NULL,
  
  PRIMARY KEY (product_detail_id),
  FOREIGN KEY (product_id) REFERENCES product (product_id)
);

CREATE SEQUENCE product_detail_id_sequence OWNED BY product_detail.product_detail_id;