create database if not exists  to_do_list ;

use to_do_list;

create table `action`(
id int auto_increment primary key,
title varchar(50),
content varchar(50),
time_begin datetime default CURRENT_TIMESTAMP,
`status` varchar(50) DEFAULT "incomplete"
);
