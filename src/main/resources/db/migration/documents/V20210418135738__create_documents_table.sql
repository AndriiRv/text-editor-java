CREATE TABLE documents
(
    id          UUID PRIMARY KEY,
    title       VARCHAR(100),
    content     TEXT,
    create_date TIMESTAMP,
    edit_date   TIMESTAMP
);