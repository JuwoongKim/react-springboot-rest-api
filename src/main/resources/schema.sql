DROP TABLE IF EXISTS content;

CREATE TABLE content
(
    content_id   VARCHAR(200) PRIMARY KEY,
    title       VARCHAR(1000) NOT NULL,
    text        TEXT NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    price       BIGINT NOT NULL,
    created_at   DATETIME NOT NULL
);
