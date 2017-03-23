# --- Sample dataset

# --- !Ups

insert into hotel (id,name) values ( 1,'The Ripley Court Hotel' );
insert into hotel (id,name) values ( 2,'Jurys Inn' );
insert into hotel (id,name) values ( 3,'Clayton Hotel' );
insert into hotel (id,name) values ( 4,'Temple Bar Inn' );
insert into hotel (id,name) values ( 5,'Hillton Garden Inn' );

insert into room (id,hotel_id,description,price) values ( 1,1,'Free Wifi, Flat Screen',15 );
insert into room (id,hotel_id,description,price) values ( 2,1,'Free Wifi, Flat Screen',15 );
insert into room (id,hotel_id,description,price) values ( 3,1,'Free Wifi, Flat Screen',15 );
insert into room (id,hotel_id,description,price) values ( 4,2,'Free Wifi, Flat Screen',15 );
insert into room (id,hotel_id,description,price) values ( 5,3,'Free Wifi, Flat Screen',15 );
insert into room (id,hotel_id,description,price) values ( 6,4,'Free Wifi, Flat Screen',15 );
insert into room (id,hotel_id,description,price) values ( 7,4,'Free Wifi, Flat Screen',15 );
insert into room (id,hotel_id,description,price) values ( 8,5,'Free Wifi, Flat Screen',15 );


insert into User (email,name,password,role) values ( 'admin@products.com', 'Alice Admin', 'password', 'admin' );

insert into User (email,name,password,role) values ( 'manager@products.com', 'Bob Manager', 'password', 'manager' );

insert into User (email,name,password,role) values ( 'customer@products.com', 'Charlie Customer', 'password', 'customer'); 
