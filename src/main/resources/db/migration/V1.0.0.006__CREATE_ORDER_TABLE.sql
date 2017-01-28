CREATE TABLE "order" (
  order_id   BIGINT,
  code       VARCHAR(255) NOT NULL,
  start_date TIMESTAMP    NOT NULL,
  end_date   TIMESTAMP,
  profile_id BIGINT,
  
  PRIMARY KEY (order_id),
  FOREIGN KEY (profile_id) REFERENCES profile (profile_id)
);

CREATE SEQUENCE order_id_sequence OWNED BY "order".order_id;