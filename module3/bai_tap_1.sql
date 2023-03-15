create database bai_tap_1;
use bai_tap_1;
create table class(
	id_class int primary key auto_increment,
    name char(50) not null
);

create table student(
	id_student int primary key auto_increment,
    name varchar(50) not null,
	age int,
    country varchar(50)
);

insert into class (`name`) values('Math'),('Physics');
insert into student (`name`,age,country) values ('Nam',22,'DN'),('Dien',25,'DN');