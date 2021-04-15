CREATE TABLE IF NOT EXISTS profile
(
    id         uuid primary key default uuid_generate_v4(),
    first_name varchar(100) NOT NULL,
    last_name  varchar(100),
    phone      varchar(20)  NOT NULL,
    email      varchar(20)
);

CREATE TABLE IF NOT EXISTS pet_images
(
    id     uuid primary key default uuid_generate_v4(),
    url    varchar(1024) NOT NULL,
    pet_id uuid REFERENCES pets (id) NOT NULL
);