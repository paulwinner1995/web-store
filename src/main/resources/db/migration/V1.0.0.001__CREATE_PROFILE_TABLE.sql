CREATE TABLE profile (
  profile_id   BIGINT,
  first_name   VARCHAR(255) NOT NULL,
  last_name    VARCHAR(255) NOT NULL,
  address      VARCHAR(255) NOT NULL,
  phone_number VARCHAR(255) NOT NULL,
  
  account_id   BIGINT,
  
  PRIMARY KEY (profile_id),
  FOREIGN KEY (account_id) REFERENCES account (account_id)
);

CREATE SEQUENCE profile_id_sequence OWNED BY profile.profile_id;