CREATE TABLE users (
user_id     number(8) NOT NULL,
user_name   VARCHAR(30) NOT NULL,
user_pass   VARCHAR(255) NOT NULL,
user_email  VARCHAR(255) NOT NULL,
user_creation_date   TIMESTAMP NOT NULL,
user_type  number(8) NOT NULL,
PRIMARY KEY (user_id)
);


CREATE TABLE topics (
topic_id        number(8) NOT NULL,
topic_subject       VARCHAR(255) NOT NULL,
topic_message       CLOB NOT NULL,
topic_date      TIMESTAMP NOT NULL,
topic_cat       number(8) NOT NULL,
topic_by        number(8) NOT NULL,
PRIMARY KEY (topic_id),
FOREIGN KEY(topic_by) REFERENCES users(user_id)
);

CREATE TABLE posts (
post_id         number(8) NOT NULL,
post_content        CLOB NOT NULL,
post_date       TIMESTAMP NOT NULL,
post_topic      number(8) NOT NULL,
post_by     NUMBER(8) NOT NULL,
PRIMARY KEY (post_id),
FOREIGN KEY(post_topic) REFERENCES topics(topic_id),
FOREIGN KEY(post_by) REFERENCES users(user_id)
);

DROP SEQUENCE USER_SEQ;
CREATE SEQUENCE USER_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

DROP SEQUENCE TOPIC_SEQ;
CREATE SEQUENCE TOPIC_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;

DROP SEQUENCE POSTS_SEQ;
CREATE SEQUENCE POSTS_SEQ
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
