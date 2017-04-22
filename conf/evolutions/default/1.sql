# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table filter (
  id                            bigint not null,
  name                          varchar(255),
  constraint pk_filter primary key (id)
);
create sequence filter_seq;

create table filter_hotel (
  filter_id                     bigint not null,
  hotel_id                      bigint not null,
  constraint pk_filter_hotel primary key (filter_id,hotel_id)
);

create table hotel (
  id                            bigint not null,
  name                          varchar(255),
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

create table feedback(
  id      bigint not null,
  name    varchar(255),
  email   varchar(255),
  subject varchar(255),
  message varchar(255),
  constraint pk_feedback primary key (id)
);
create sequence feedback_seq;




alter table filter_hotel add constraint fk_filter_hotel_filter foreign key (filter_id) references filter (id) on delete restrict on update restrict;
create index ix_filter_hotel_filter on filter_hotel (filter_id);

alter table filter_hotel add constraint fk_filter_hotel_hotel foreign key (hotel_id) references hotel (id) on delete restrict on update restrict;
create index ix_filter_hotel_hotel on filter_hotel (hotel_id);

alter table room add constraint fk_room_hotel_id foreign key (hotel_id) references hotel (id) on delete restrict on update restrict;
create index ix_room_hotel_id on room (hotel_id);


# --- !Downs

alter table filter_hotel drop constraint if exists fk_filter_hotel_filter;
drop index if exists ix_filter_hotel_filter;

alter table filter_hotel drop constraint if exists fk_filter_hotel_hotel;
drop index if exists ix_filter_hotel_hotel;

alter table room drop constraint if exists fk_room_hotel_id;
drop index if exists ix_room_hotel_id;

drop table if exists filter;
drop sequence if exists filter_seq;

drop table if exists filter_hotel;

drop table if exists hotel;
drop sequence if exists hotel_seq;

drop table if exists login;

drop table if exists room;
drop sequence if exists room_seq;

drop table if exists user;

drop table if exists feedback;
drop sequence if exists feedback_seq;

