DROP TABLE IF EXISTS content;

CREATE TABLE content
(
    contentId   VARCHAR(200) PRIMARY KEY,
    title       VARCHAR(1000) NOT NULL,
    text        TEXT NOT NULL,
    contentType VARCHAR(50) NOT NULL,
    price       BIGINT NOT NULL,
    createdAt   DATETIME NOT NULL
);
