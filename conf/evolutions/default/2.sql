# --- Sample dataset

# --- !Ups

insert into genre (id,name) values ( 1,'Comedy' );
insert into genre (id,name) values ( 2,'Drama' );
insert into genre (id,name) values ( 3,'Fantasy' );
insert into genre (id,name) values ( 4,'Animation' );
insert into genre (id,name) values ( 5,'Thriller' );

insert into movie (id,genre_id,name,lead,stock,price) values ( 1,2,'Jack Reacher','Tom Cruise',70,6.50 );
insert into movie (id,genre_id,name,lead,stock,price) values ( 2,2,'Arrival','Amy Adams',54,6.50 );
insert into movie (id,genre_id,name,lead,stock,price) values ( 3,3,'Fantastic Beasts and where to find them','Eddie Redmayne',43,6.50 );
insert into movie (id,genre_id,name,lead,stock,price) values ( 4,2,'Girl on the train','Emily Blunt',11,6.50 );
insert into movie (id,genre_id,name,lead,stock,price) values ( 5,5,'Inferno','Tom Hanks',49,6.50 );
insert into movie (id,genre_id,name,lead,stock,price) values ( 6,1,'Keeping up with the Joneses','Zach Galifianakis',63,6.50 );
insert into movie (id,genre_id,name,lead,stock,price) values ( 7,4,'Kubo and the two Strings','Matthew McConaughey',9,6.50 );
insert into movie (id,genre_id,name,lead,stock,price) values ( 8,4,'Trolls','Amy Adams',85,6.50 );


insert into User (email,name,password,role) values ( 'admin@products.com', 'Alice Admin', 'password', 'admin' );

insert into User (email,name,password,role) values ( 'manager@products.com', 'Bob Manager', 'password', 'manager' );

insert into User (email,name,password,role) values ( 'customer@products.com', 'Charlie Customer', 'password', 'customer'); 
