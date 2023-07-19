DROP TABLE IF EXISTS content;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS pockets;

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
    name     VARCHAR(50) NOT NULL,

);

CREATE TABLE pockets
(
    pocketId     VARCHAR(200) PRIMARY KEY,
    userId       VARCHAR(200),
    contentId    VARCHAR(200),
    contentTitle VARCHAR(255),
    FOREIGN KEY (userId) REFERENCES users (userId) ON DELETE
    CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (contentId) REFERENCES content (contentId) ON DELETE
    CASCADE ON UPDATE CASCADE
);
