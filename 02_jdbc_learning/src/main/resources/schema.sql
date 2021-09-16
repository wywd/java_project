use mysql;

show tables ;

grant all privileges on *.* to dbuser@localhost
identified by '1234'with grant option ;

use mysql;

select host, user from user;

drop database if exists storedb;
create database storedb;
use storedb;

show tables ;
show databases ;

create table if not exists customers(
    id bigint not null auto_increment primary key comment '用户ID',
    name varchar(16) not null comment '用户姓名',
    age int comment '用户年龄',
    address varchar(255) comment '用户地址'
) comment '用户信息';

describe customers;

show tables ;

drop table if exists orders;
create table if not exists orders(
    id bigint not null auto_increment primary key comment '订单ID',
    order_number varchar(16) not null comment '订单数量',
    price float comment '订单价格',
    customer_id bigint comment '此订单对应的用户ID',
    foreign key (customer_id) references customers(id)
) comment '订单信息';

describe orders;

show create table orders;

create table accounts (
    id bigint not null primary key comment '账户ID',
    name varchar(15) comment '账户姓名',
    balance decimal (10, 2) comment '账户余额'
) comment '银行账户信息';

show create table accounts;

show tables ;

insert into customers(id, name, age, address)
VALUES (1, '小张', 23, '北京'),
       (2, '小红', 29, '天津'),
       (3, '小丁', 33, '山东');

select * from customers;

insert into orders (id, order_number, price, customer_id)
values (1, '小张_001', 100.12, 1),
       (2, '小张_002', 200.32, 1),
       (3, '小红_001', 88.44, 2);

select * from orders;

show databases ;

use storedb;
















