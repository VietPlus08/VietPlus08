create database ss5_bt1;
use ss5_bt1;
create table product(
	Id int primary key auto_increment,
	`code` varchar(50),
	`name` varchar(50),
	price varchar(50),
	amount varchar(50),
	`description` varchar(50),
	`status` varchar(50)
);

insert into product (`code`,`name`,price,amount,`description`,`status`) values 
('AB001','Ariblade 2021','35000','40000','xe may','het hang'),
('AB002','Ariblade 2022','36000','41000','xe may','co hang'),
('AB003','Ariblade 2023','37000','41000','xe may','co hang'),
('AB004','Ariblade 2024','38000','42000','xe may','het hang'),
('AB005','Ariblade 2025','39000','42000','xe may','het hang'),
('IP002','Iphone 2020','15000','20000','dien thoai','het hang'),
('IP003','Iphone 2021','25000','30000','dien thoai','co hang'),
('IP004','Iphone 2022','25000','30000','dien thoai','co hang'),
('IP005','Iphone 2024','35000','40000','dien thoai','het hang'),
('LA001','Laptop 2021','15000','20000','lap top','co hang'),
('LA002','Laptop 2022','25000','30000','lap top','co hang');

-- Buoc 3: tao index 
create unique index code_index on product(`code`);
explain select * from product where `code` = 'AB005';
create index name_price_index on product(`name`,price);
-- drop index name_price_index on product;
explain select * from product where `name` = 'Laptop 2022';
-- sau khi đánh index lên côt thì duyệt record theo cột đó nhanh hơn
-- Buoc 4: 
create or replace view code_name_price_statuc_view 
as select `code`, `name`, price, `status` from product;

select * from code_name_price_statuc_view;
update code_name_price_statuc_view set `name` = 'Ariblade new 2024' where `code` = 'AB004';
drop view code_name_price_statuc_view;
-- Buoc 5:
-- in product varchar(255)
DELIMITER $$
CREATE procedure findAll()
BEGIN
	select * from product;
END $$
DELIMITER ;
call findAll();

DELIMITER $$
create procedure add_new(
	in code_para varchar (50),
	in name_para varchar (50),
    in price_para varchar (50),
    in amount_para varchar (50),
    in description_para varchar (50),
    in status_para varchar (50))
BEGIN
	insert into product (`code`,`name`,price,amount,`description`,`status`) values
(code_para,name_para,price_para,amount_para,description_para,status_para);
END $$
DELIMITER ;

call add_new('LA003','Laptop DELL12','20000','28000','lap top','co hang');

DELIMITER $$
create procedure update_pro(
	in id_para int,
	in code_para varchar (50),
	in name_para varchar (50),
    in price_para varchar (50),
    in amount_para varchar (50),
    in description_para varchar (50),
    in status_para varchar (50))
BEGIN
	update product set `code` = code_para,
		`name` = name_para,
        price = price_para,
        amount = amount_para,
        `description` = description_para,
        `status` = status_para 
	where id = id_para;
END $$
DELIMITER ;
call update_pro(1,'LA004','Laptop DELL11','22000','29000','lap top','co hang');

DELIMITER $$
create procedure delete_product(in id_para int)
BEGIN
	delete from product where id = id_para;
END $$
DELIMITER ;
call delete_product(2);






