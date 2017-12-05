drop database if exists autoservice;
create database autoservice;
use autoservice;

create table mechanic(
id_mechanic int not null auto_increment,
full_name varchar(40) not null,
id_order int,
primary key (id_mechanic)
);

create table task(
id_task int not null auto_increment,
to_do varchar(255) not null,
request_date date not null,
start_date date,
complete_date date,
price double,
primary key(id_task)
);

create table `order`(
id_order int not null auto_increment,
id_mechanic int not null,
id_workplace int not null,
id_task int not null,
status enum('inprogress','ready','deleted','cancelled') not null,
primary key(id_order),
foreign key (id_mechanic) references mechanic(id_mechanic) on update cascade on delete cascade,
foreign key (id_task) references task(id_task)
);

create table workplace(
id_workplace int not null auto_increment,
id_order int,
primary key (id_workplace),
foreign key(id_order) references `order`(id_order)
);

alter table mechanic add constraint foreign key (id_order) references `order`(id_order);
alter table `order` add constraint foreign key (id_workplace) references workplace(id_workplace);