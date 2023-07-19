DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS pockets;
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
    user_id  VARCHAR(200) PRIMARY KEY,
    email    VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    name     VARCHAR(50) NOT NULL
);

CREATE TABLE pockets
(
    pocket_id     VARCHAR(200) PRIMARY KEY,
    user_id       VARCHAR(200) NOT NULL,
    content_id    VARCHAR(200) NOT NULL,
    content_title VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE
        CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (content_id) REFERENCES content (content_id) ON DELETE
        CASCADE ON UPDATE CASCADE
);

CREATE TABLE orders
(
    order_id  VARCHAR(200) PRIMARY KEY,
    user_id   VARCHAR(200) NOT NULL,
    price     BIGINT       NOT NULL,
    created_at DATETIME     NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE
        CASCADE ON UPDATE CASCADE
);

