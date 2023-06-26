create database book_management;

use book_management;

create table book(
id varchar(255) primary key,
book_name varchar(255),
author varchar(255),
`description` varchar(255),
quantity varchar(255)
);

create table student(
id varchar(255) primary key,
student_name varchar(255),
class_name varchar(255)
);

create table borrow(
id varchar(255) primary key,
book_id varchar(255),
student_id varchar(255),
`status` boolean default 1,
date_in date,
date_out date,
constraint fk_card_book foreign key (book_id) references book(id),
constraint fk_card_student foreign key (student_id) references student(id)
);

create table app_user(
user_id int primary key auto_increment,
user_name varchar(36) not null unique,
encryted_password varchar(128) not null,
enabled bit not null
);

create table app_role(
role_id int primary key auto_increment,
role_name varchar(36) not null unique
);

create table user_role(
id int primary key auto_increment,
user_id int not null,
role_id int not null,
constraint uk_role unique(user_id, role_id),
constraint fk1_role foreign key(user_id) references app_user(user_id),
constraint fk2_role foreign key(role_id) references app_role(role_id)
);

create table persistent_login(
user_name varchar(64) not null,
series_name varchar(64) primary key,
token varchar(64) not null,
last_used timestamp not null
);

insert into app_user value  
(1, 'admin', '$2a$10$u0Afe7zsuW/ZAMgqo0PZE.bEkk.X7rYqcmy6/WXJzLIsFv.4w1uDK', 1),
(2, 'user', '$2a$10$u0Afe7zsuW/ZAMgqo0PZE.bEkk.X7rYqcmy6/WXJzLIsFv.4w1uDK', 1);
-- (1, 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
-- (2, 'user', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into app_role (ROLE_ID, ROLE_NAME)
values (2, 'ROLE_USER'), (1, 'ROLE_ADMIN');

insert into user_role (ID, USER_ID, ROLE_ID)
values (1, 1, 1), (2, 1, 2), (3, 2, 2);

insert into book value
('S-0001','So do','Vu Trong Phung','Van hoc','10'),
('S-0002','Truyen kieu','Nguyen Du','Van hoc','1'),
('S-0003','Doraemmon T1','Fujiko F. Fujio','Truyen tranh','15'),
('S-0004','7 vien ngoc rong T1','Akira Toriyama','Truyen tranh','15'),
('S-0005','Lao Hac','Nam Cao','Van hoc','15'),
('S-0006','Muon kiep nhan sinh P1','Nguyen Phong','Ton giao','15'),
('S-0007','Chien tranh tien te P1','Song Hong Bin','Kinh te','10'),
('S-0008','Chien tranh tien te P2','Song Hong Bin','Kinh te','10'),
('S-0009','Doraemmon T2','Fujiko F. Fujio','Truyen tranh','15'),
('S-00010','Doraemmon T3','Fujiko F. Fujio','Truyen tranh','15'),
('S-00011','7 vien ngoc rong T2','Akira Toriyama','Truyen tranh','15'),
('S-00012','7 vien ngoc rong T3','Akira Toriyama','Truyen tranh','15'),
('S-00013','Muon kiep nhan sinh P2','Nguyen Phong','Ton giao','15'),
('S-00014','7 vien ngoc rong T4','Akira Toriyama','Truyen tranh','15'),
('S-00015','7 vien ngoc rong T5','Akira Toriyama','Truyen tranh','15');
insert into student value
('1', 'Hoai Nam', 'A09'),
('2', 'Duc Loi', 'A09'),
('3', 'Phuoc Hoc', 'A01'),
('4', 'Ngoc Tuan', 'A03'),
('5', 'Anh Quang', 'A02'),
('6', 'Xuan Na', 'A02');

insert into borrow(id,book_id,student_id,date_in,date_out) value 
('MS-0001','S-0001',1,'2023-10-12','2023-12-12'),
('MS-0002','S-0002',1,'2023-10-12','2023-12-12'),
('MS-0003','S-0003',2,'2023-10-12','2023-12-12'),
('MS-0004','S-0003',3,'2023-10-12','2023-12-12');

select borrow.id, book_id, book_name, author, student_id, student_name, class_name,date_in, date_out from borrow  
join book on borrow.book_id = book.id  
join student on borrow.student_id = student.id
where student.student_name like concat('%',"",'%') and book.book_name like concat('%',"",'%') and status = 1;

select borrow.id, book_id, book_name, author, student_id, student_name, class_name,date_in, date_out from borrow 
            join book on borrow.book_id = book.id 
            join student on borrow.student_id = student.id 
            where status = 1;

DELIMITER $$
CREATE PROCEDURE returnBook(in cid varchar(255))
BEGIN
update borrow set status = 0, date_out = date(now()) where id = cid;
set @bookId = (select book_id from borrow where id = cid);

set @newQuantity = (select quantity from book where id = @bookId) + 1;
update book set quantity = @newQuantity where id = @bookId;
END
$$ DELIMITER ;

DELIMITER $$
CREATE PROCEDURE createBorrowing(
	in _id varchar(255),
    in _bname varchar(255),
    in _sid varchar(255),
    in _dateIn date,
    in _dateOut date)
BEGIN
set @bid = (select id from book where book_name = _bname); 
insert into borrow(id,book_id,student_id,date_in,date_out) value(_id,@bid,_sid,_dateIn,_dateOut);
set @newQuantity = (select quantity from book where id = @bid) - 1;
update book set quantity = @newQuantity where id = @bid;
END
$$ DELIMITER ;

DELIMITER $$
CREATE PROCEDURE createBorrowingDto(
	in _id varchar(255),
    in _bid varchar(255),
    in _sid varchar(255),
    in _dateIn date,
    in _dateOut date)
BEGIN
insert into borrow(id,book_id,student_id,date_in,date_out) value(_id,_bid,_sid,_dateIn,_dateOut);
set @newQuantity = (select quantity from book where id = _bid) - 1;
update book set quantity = @newQuantity where id = _bid;
END
$$ DELIMITER ;

-- Call createBorrowingDto('MS-0005','S-0004','4','2023-5-5','2023-5-6');
-- Call returnBook('MS-0006');


-- DELIMITER $$
-- CREATE FUNCTION AUTO_IDBORROW()
-- RETURNS VARCHAR(255)
-- BEGIN
-- 	set @ID = convert((select MAX(RIGHT(id, 4)) FROM book) + 1,signed);
--     if (@ID < 9) then set @ID = concat('MS-000',@ID);
-- 		elseif (@ID < 99) then set @ID = concat('MS-00',@ID);
-- 		elseif (@ID < 999) then set @ID = concat('MS-0',@ID);
--         else set @ID = concat('MS-',@ID);
-- 	end if;
-- 	RETURN @ID;
-- END
-- $$ DELIMITER ;

