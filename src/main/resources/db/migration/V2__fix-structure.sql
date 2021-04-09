DROP TYPE IF EXISTS PET_SIZE;
CREATE TYPE PET_SIZE AS ENUM ( 'TINY', 'SMALL', 'MEDIUM', 'LARGE' );


alter table pets
    alter column id
        set maxvalue 2147483647;

alter table pets
    drop column size;

alter table pets
    add size PET_SIZE;
