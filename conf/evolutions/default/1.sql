# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table hotel (
  id                            bigint not null,
  name                          varchar(255),
  filter                        varchar(255),
  constraint pk_hotel primary key (id)
);
create sequence hotel_seq;

create table login (
  email                         varchar(255),
  password                      varchar(255)
);

create table room (
  id                            bigint not null,
  description                   varchar(255),
  hotel_id                      bigint,
  price                         double,
  state                         varchar(255),
  constraint pk_room primary key (id)
);
create sequence room_seq;

create table user (
  email                         varchar(255) not null,
  role                          varchar(255),
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (email)
);

alter table room add constraint fk_room_hotel_id foreign key (hotel_id) references hotel (id) on delete restrict on update restrict;
create index ix_room_hotel_id on room (hotel_id);


# --- !Downs

alter table room drop constraint if exists fk_room_hotel_id;
drop index if exists ix_room_hotel_id;

drop table if exists hotel;
drop sequence if exists hotel_seq;

drop table if exists login;

drop table if exists room;
drop sequence if exists room_seq;

drop table if exists user;

