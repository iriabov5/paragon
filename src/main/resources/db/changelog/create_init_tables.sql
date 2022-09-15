--liquibase formatted sql
--changeset team:create_init_tables

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id                   bigserial   NOT NULL PRIMARY KEY,
    name                 varchar(80) NOT NULL,
    email                varchar(80) NOT NULL,
    phone_number         varchar(20) NOT NULL,
    status               varchar(10) NOT NULL,
    modified_status_date timestamp with time zone
)