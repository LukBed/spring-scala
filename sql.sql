CREATE TABLE tanks (
    id SERIAL,
    text_id VARCHAR(30) UNIQUE DEFAULT NULL,
    name VARCHAR (50) DEFAULT NULL
);

INSERT INTO tanks (text_id, name) VALUES ('tank_1', 'Tank One');