create database if not exists to_do_list;

use to_do_list;

create table `action`(
id bigint auto_increment primary key,
content varchar(255),
status varchar(50), 
time_begin datetime ,
title varchar(255) ,
time_finish datetime
); 