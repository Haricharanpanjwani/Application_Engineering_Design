create database moviedb;

use moviedb;

create table movies (
title varchar(80),
actor varchar(30),
actress varchar(30),
genre varchar(20),
year integer
);


insert into movies values ('Number 23', 'Jim Carrey', 'Virginia Madsen', 'Thriller', 2007);

select * from movies;

delete from movies where year = 2009;