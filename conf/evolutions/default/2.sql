# --- Sample dataset

# --- !Ups

insert into hotel (id,name,filter) values ( 1,'The Ripley Court Hotel','Smoke Free' );
insert into hotel (id,name,filter) values ( 2,'Jurys Inn','IncludeMeals' );
insert into hotel (id,name,filter) values ( 3,'Clayton Hotel','IncludeMeals' );
insert into hotel (id,name,filter) values ( 4,'Temple Bar Inn','Smoke Free' );
insert into hotel (id,name,filter) values ( 5,'Hillton Garden Inn','Family Friendly' );

insert into room (id,hotel_id,description,price,state) values ( 1,1,'Free Wifi, Flat Screen',15,'Available' );
insert into room (id,hotel_id,description,price,state) values ( 2,1,'Free Wifi, Flat Screen',15,'Available' );
insert into room (id,hotel_id,description,price,state) values ( 3,1,'Free Wifi, Flat Screen',15,'Available' );
insert into room (id,hotel_id,description,price,state) values ( 4,2,'Free Wifi, Flat Screen',15,'Available' );
insert into room (id,hotel_id,description,price,state) values ( 5,3,'Free Wifi, Flat Screen',15,'Available' );
insert into room (id,hotel_id,description,price,state) values ( 6,4,'Free Wifi, Flat Screen',15,'Available' );
insert into room (id,hotel_id,description,price,state) values ( 7,4,'Free Wifi, Flat Screen',15,'Available' );
insert into room (id,hotel_id,description,price,state) values ( 8,5,'Free Wifi, Flat Screen',15,'Available' );


insert into User (email,name,password,role) values ( 'admin@products.com', 'Alice Admin', 'password', 'admin' );

insert into User (email,name,password,role) values ( 'manager@products.com', 'Bob Manager', 'password', 'manager' );

insert into User (email,name,password,role) values ( 'customer@products.com', 'Charlie Customer', 'password', 'customer'); 
