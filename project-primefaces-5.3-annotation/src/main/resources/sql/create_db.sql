-- on system
CREATE USER pduleba IDENTIFIED BY pduleba;
GRANT ALL PRIVILEGE TO pduleba;

-- on pduleba
CREATE TABLE users (
  id              	NUMBER(15),
  name            	VARCHAR2(100 CHAR) NOT NULL,
  password_hash     VARCHAR2(100 CHAR),
  creation_date	  	TIMESTAMP,
  CONSTRAINT name_unique UNIQUE (name),
  CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE SEQUENCE users_seq START WITH     1 INCREMENT BY   1 NOCACHE NOCYCLE;
