CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS users
(
    id         uuid primary key DEFAULT uuid_generate_v1(),
    first_name varchar(100) NOT NULL,
    last_name  varchar(100),
    phone      varchar(20),
    email      varchar(20) NOT null,
    created_at date NOT NULL DEFAULT CURRENT_DATE
);

CREATE TYPE pet_size AS ENUM ('TINY', 'SMALL', 'MEDIUM', 'LARGE', 'HUGE');

CREATE TABLE IF NOT EXISTS species
(
    id         uuid PRIMARY KEY DEFAULT uuid_generate_v1(),
    species    varchar(25)
);

CREATE TABLE IF NOT EXISTS pets (
	id uuid PRIMARY KEY DEFAULT uuid_generate_v1(),
	"name" varchar(45) NULL DEFAULT 'pet'::character varying,
	breed varchar(45) NULL,
	handlers_id uuid REFERENCES users(id),
	adopted bool NOT NULL DEFAULT false,
	species_id uuid REFERENCES species(id),
	"size" pet_size NULL,
	created_at date NOT NULL DEFAULT CURRENT_DATE,
	deleted_at date null
);

