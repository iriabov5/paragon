--liquibase formatted sql
--changeset team:alter_table_users_table

alter table users
    add unique (email);