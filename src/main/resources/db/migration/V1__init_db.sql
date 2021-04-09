CREATE TABLE IF NOT EXISTS users
(
    id         bigint primary key generated always as identity,
    first_name varchar(100) NOT NULL,
    last_name  varchar(100),
    phone      varchar(20)  NOT NULL,
    email      varchar(20)
);

CREATE TABLE IF NOT EXISTS pets
(
    id         bigint primary key generated always as identity,
    name       varchar(45)  NOT NULL,
    species    varchar(100) NOT NULL,
    size       int default 0,
    breed      varchar(45),
    handler_id bigint,

    FOREIGN KEY (handler_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS pet_images
(
    id bigint primary key generated always as identity,
    url varchar(1024) NOT NULL,
    pet_id bigint NOT NULL,

    FOREIGN KEY (pet_id) REFERENCES pets (id)
)
