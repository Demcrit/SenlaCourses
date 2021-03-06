Drop database if exists shop;
Create database shop;
USE shop;

create table product(
maker varchar(10) not null,
model varchar(50) not null,
type varchar(50) not null,
primary key (model)
);

create table pc (
code int not null auto_increment,
model varchar(50) not null,
speed smallint not null,
ram smallint not null,
hd real not null,
cd varchar(10) not null,
price float,
primary key(code),
foreign key(model) references product(model) on delete cascade on update cascade
);

create table laptop(
code int not null auto_increment,
model varchar(50) not null,
speed smallint not null,
ram smallint not null,
hd real not null,
price float,
screen tinyint not null,
primary key(code),
foreign key(model) references product(model) on delete cascade on update cascade
); 

create table printer(
code int not null auto_increment,
model varchar(50) not null,
color char(1) not null,
type varchar(10) not null,
price float,
primary key(code),
foreign key(model) references product(model) on delete cascade on update cascade
);
