                       # --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table feedback (
  name             VARCHAR(255),
  email            VARCHAR(255),
  subject          varchar(255),
  message          VARCHAR(255),
);

create sequence feedback_seq;

create table basket (
  id                            bigint not null,
  user_email                    varchar(255),
  constraint uq_basket_user_email unique (user_email),
  constraint pk_basket primary key (id)
);
create sequence basket_seq;

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

create table order_item (
  id                            bigint not null,
  order_id                      bigint,
  basket_id                     bigint,
  room_id                       bigint,
  price                         double,
  constraint pk_order_item primary key (id)
);
create sequence order_item_seq;

create table room (
  id                            bigint not null,
  number                        bigint,
  description                   varchar(255),
  hotel_id                      bigint,
  price                         double,
  state                        varchar(255),
  constraint pk_room primary key (id)
);
create sequence room_seq;

create table shop_order (
  id                            bigint not null,
  order_date                    timestamp,
  user_email                    varchar(255),
  constraint pk_shop_order primary key (id)
);
create sequence shop_order_seq;

create table user (
  email                         varchar(255) not null,
  role                          varchar(255),
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_user primary key (email)
);


alter table basket add constraint fk_basket_user_email foreign key (user_email) references user (email) on delete restrict on update restrict;

alter table order_item add constraint fk_order_item_order_id foreign key (order_id) references shop_order (id) on delete restrict on update restrict;
create index ix_order_item_order_id on order_item (order_id);

alter table order_item add constraint fk_order_item_basket_id foreign key (basket_id) references basket (id) on delete restrict on update restrict;
create index ix_order_item_basket_id on order_item (basket_id);

alter table order_item add constraint fk_order_item_room_id foreign key (room_id) references room (id) on delete restrict on update restrict;
create index ix_order_item_room_id on order_item (room_id);

alter table room add constraint fk_room_hotel_id foreign key (hotel_id) references hotel (id) on delete restrict on update restrict;
create index ix_room_hotel_id on room (hotel_id);

alter table shop_order add constraint fk_shop_order_user_email foreign key (user_email) references user (email) on delete restrict on update restrict;
create index ix_shop_order_user_email on shop_order (user_email);


# --- !Downs

alter table basket drop constraint if exists fk_basket_user_email;

alter table order_item drop constraint if exists fk_order_item_order_id;
drop index if exists ix_order_item_order_id;

alter table order_item drop constraint if exists fk_order_item_basket_id;
drop index if exists ix_order_item_basket_id;

alter table order_item drop constraint if exists fk_order_item_room_id;
drop index if exists ix_order_item_room_id;

alter table room drop constraint if exists fk_room_hotel_id;
drop index if exists ix_room_hotel_id;

alter table shop_order drop constraint if exists fk_shop_order_user_email;
drop index if exists ix_shop_order_user_email;

drop table if exists basket;
drop sequence if exists basket_seq;

drop table if exists hotel;
drop sequence if exists hotel_seq;

drop table if exists login;

drop table if exists order_item;
drop sequence if exists order_item_seq;

drop table if exists room;
drop sequence if exists room_seq;

drop table if exists shop_order;
drop sequence if exists shop_order_seq;

drop table if exists feedback;
drop sequence if exists feedback_seq;

drop table if exists user;


