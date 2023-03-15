create database ss2_ex2;
use ss2_ex2;
create table customer(
	cus_id int primary key,
    `name` varchar(50),
    age int
);
create table `order`(
	order_id int primary key,
    cus_id int,
    order_date date,
    total_price int,
	foreign key (cus_id) references customer(cus_id)
);
create table product(
	product_id int primary key,
    `name` varchar(50),
    price int
);
create table order_detail(
	order_id int,
    product_id int,
    foreign key (order_id) references `order`(order_id),
    foreign key (product_id) references product(product_id)	
)


