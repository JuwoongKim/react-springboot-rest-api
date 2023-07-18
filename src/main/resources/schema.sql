DROP TABLE IF EXISTS content;
DROP TABLE IF EXISTS users;

CREATE TABLE content
(
    content_id   VARCHAR(200) PRIMARY KEY,
    title        VARCHAR(1000) NOT NULL,
    text         TEXT          NOT NULL,
    content_type VARCHAR(50)   NOT NULL,
    price        BIGINT        NOT NULL,
    created_at   DATETIME      NOT NULL
);


CREATE TABLE users
(
    user_id VARCHAR(200) PRIMARY KEY,
    email     VARCHAR(50) NOT NULL,
    password  VARCHAR(50) NOT NULL,
    name      VARCHAR(50) NOT NULL
);
