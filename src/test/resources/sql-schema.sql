create database if not exists ims_test;
create table if not exists ims_test.customers(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims_test.items(productid int primary key auto_increment, productName varchar(40), price int);
create table if not exists ims_test.basket(orderitemsid int primary key auto_increment, orderid int, customerid int, productid int, quantity int, price float);
