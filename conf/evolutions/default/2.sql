# --- Sample dataset

# --- !Ups

insert into hotel (id,name,filter) values ( 1,'The Ripley Court Hotel','Smoke Free, Include Meals');
insert into hotel (id,name,filter) values ( 2,'Jurys Inn','Family Friendly, Free Wifi,Smoke Free' );
insert into hotel (id,name,filter) values ( 3,'Clayton Hotel','Include Meals, Free Wifi' );
insert into hotel (id,name,filter) values ( 4,'Temple Bar Inn',' Include Meals,Free Wifi' );
insert into hotel (id,name,filter) values ( 5,'Hillton Garden Inn','Family Friendly');


insert into room (id,number,hotel_id,description,price,state) values ( 1,1,1,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 2,2,1,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 3,3,1,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 4,4,1,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 5,5,1,'Free Wifi, Flat Screen',15,'Available');

insert into room (id,number,hotel_id,description,price,state) values ( 6,1,2,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 7,2,2,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 8,3,2,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 9,4,2,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 10,5,2,'Free Wifi, Flat Screen',15,'Available');

insert into room (id,number,hotel_id,description,price,state) values ( 11,1,3,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 12,2,3,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 13,3,3,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 14,4,3,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 15,5,3,'Free Wifi, Flat Screen',15,'Available');

insert into room (id,number,hotel_id,description,price,state) values ( 16,1,4,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 17,2,4,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 18,3,4,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 19,4,4,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 20,5,4,'Free Wifi, Flat Screen',15,'Available');

insert into room (id,number,hotel_id,description,price,state) values ( 21,1,5,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 22,2,5,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 23,3,5,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 24,4,5,'Free Wifi, Flat Screen',15,'Available');
insert into room (id,number,hotel_id,description,price,state) values ( 25,5,5,'Free Wifi, Flat Screen',15,'Available');



insert into User (email,name,password,role) values ( 'admin@products.com', 'Alice Admin', 'password', 'admin' );

insert into User (email,name,password,role) values ( 'customer@products.com', 'Charlie Customer', 'password', 'customer');


