create database if not exists ims_test;
create table ims_test.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table ims_test.items(productid int primary key auto_increment, productName varchar(40), price int);
