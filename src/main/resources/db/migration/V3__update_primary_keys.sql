CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop table if exists users CASCADE;

drop table if exists pet_images CASCADE;

drop table if exists pets CASCADE;

CREATE TABLE IF NOT EXISTS profile
(
    id         uuid primary key default uuid_generate_v4(),
    first_name varchar(100) NOT NULL,
    last_name  varchar(100),
    phone      varchar(20)  NOT NULL,
    email      varchar(20)
);

CREATE TABLE IF NOT EXISTS pets
(
    id         uuid primary key default uuid_generate_v4(),
    name       varchar(45)  NOT NULL,
    species    varchar(100) NOT NULL,
    size       int              default 0,
    breed      varchar(45),
    handler_id uuid,

    FOREIGN KEY (handler_id) REFERENCES profile (id)
);

CREATE TABLE IF NOT EXISTS pet_images
(
    id     uuid primary key default uuid_generate_v4(),
    url    varchar(1024) NOT NULL,
    pet_id uuid        NOT NULL,

    FOREIGN KEY (pet_id) REFERENCES pets (id)
);


