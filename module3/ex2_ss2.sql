create database ss2_ex2;
use ss2_ex2;
create table customer(
	id int primary key auto_increment,
    `name` varchar(50),
    age int
);
create table `order`(
	id int primary key auto_increment,
    cus_id int,
    order_date date,
    total_price int,
	foreign key (cus_id) references customer(id)
);
create table product(
	id int primary key auto_increment,
    `name` varchar(50),
    price int
);
create table order_detail(
	order_id int,
    product_id int,
    quantity int,
    foreign key (order_id) references `order`(id),
    foreign key (product_id) references product(id)
)


