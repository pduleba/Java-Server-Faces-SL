-- on system
CREATE USER pduleba IDENTIFIED BY pduleba;
GRANT ALL PRIVILEGE TO pduleba;

-- on pduleba
CREATE TABLE users (
  id              NUMBER(15),
  name            VARCHAR2(100 CHAR),
  CONSTRAINT user_pk
    PRIMARY KEY (id)
);

CREATE SEQUENCE users_seq START WITH     1 INCREMENT BY   1 NOCACHE NOCYCLE;
