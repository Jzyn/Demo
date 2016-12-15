# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table genre (
  id                            bigint not null,
  name                          varchar(255),
  constraint pk_genre primary key (id)
);
create sequence genre_seq;

create table login (
  email                         varchar(255),
  password                      varchar(255)
);

create table movie (
  id                            bigint not null,
  name                          varchar(255),
  genre_id                      bigint,
  lead                          varchar(255),
  stock                         integer,
  price                         double,
  constraint pk_movie primary key (id)
);
create sequence movie_seq;

create table user (
  email                         varchar(255) not null,
  role                          varchar(255),
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (email)
);

alter table movie add constraint fk_movie_genre_id foreign key (genre_id) references genre (id) on delete restrict on update restrict;
create index ix_movie_genre_id on movie (genre_id);


# --- !Downs

alter table movie drop constraint if exists fk_movie_genre_id;
drop index if exists ix_movie_genre_id;

drop table if exists genre;
drop sequence if exists genre_seq;

drop table if exists login;

drop table if exists movie;
drop sequence if exists movie_seq;

drop table if exists user;

