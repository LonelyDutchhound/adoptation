CREATE TABLE IF NOT EXISTS users
(
    id       uuid primary key DEFAULT uuid_generate_v1(),
    roles    varchar(2048) NOT NULL,
    username varchar(256)  NOT NULL,
    email    varchar(256)  NOT NULL,
    password varchar(256)  NOT NULL
);
