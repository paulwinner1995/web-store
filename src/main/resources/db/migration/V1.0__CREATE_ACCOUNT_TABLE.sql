CREATE TABLE account (
  account_id        BIGINT,
  username          VARCHAR(255) NOT NULL UNIQUE,
  password          VARCHAR(255) NOT NULL,
  role              INT4         NOT NULL,
  registration_date TIMESTAMP    NOT NULL,
  version           TIMESTAMP    NOT NULL,
  
  PRIMARY KEY (account_id)
);

CREATE SEQUENCE account_id_sequence OWNED BY account.account_id;