create database booksdb;

use booksdb;

create table books (
isbn varchar(12),
title varchar(60),
author varchar(60),
price float
);

select * from books;

truncate books;