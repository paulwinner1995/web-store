CREATE TABLE "order" (
  order_id   BIGINT,
  code       VARCHAR(255) NOT NULL,
  start_date VARCHAR(255) NOT NULL,
  end_date   VARCHAR(255),
  profile_id BIGINT,
  
  PRIMARY KEY (order_id),
  FOREIGN KEY (profile_id) REFERENCES profile (profile_id)
);

CREATE SEQUENCE order_id_sequence OWNED BY "order".order_id;