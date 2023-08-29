CREATE TABLE postcard (
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(20),
    finish VARCHAR(20),
    thickness DOUBLE PRECISION,
    corners VARCHAR(20)
);