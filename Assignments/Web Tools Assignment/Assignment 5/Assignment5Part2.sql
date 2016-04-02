create database Assignment5Part2;

use Assignment5Part2;

create table books (
isbn varchar(12) Primary key,
title varchar(60),
author varchar(60),
price float
);

truncate books;

drop table books;

desc books;

select * from books;
