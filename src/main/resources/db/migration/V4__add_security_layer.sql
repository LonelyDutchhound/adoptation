create table if not exists role
(
    id uuid primary key default uuid_generate_v4(),
    authority varchar(1024) not null unique
);

create table if not exists principal
(
    id       uuid primary key default uuid_generate_v4(),
    username varchar(100)  not null unique,
    password varchar(1024) not null
);

create table if not exists principal_role (

    principal_id uuid NOT NULL,
    role_id uuid NOT NULL,

    PRIMARY KEY (principal_id, role_id),
    FOREIGN KEY (principal_id) REFERENCES principal (id),
    FOREIGN KEY (role_id) REFERENCES role (id)

);
