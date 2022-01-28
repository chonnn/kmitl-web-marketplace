create table product
(
	id varchar(10) not null
		primary key,
	name varchar(60) null,
	description varchar(200) null,
	price DOUBLE(10,2) null
);

create table orders
(
	id varchar(32) not null
		primary key,
	name varchar(60) null,
	address1 varchar(200) null,
	address2 varchar(200) null,
	address3 varchar(200) null,
	total_amount DOUBLE(10,2) null
);

create table order_detail
(
	id varchar(32) not null
		primary key,
	order_id varchar(32) not null,
	product_id varchar(10) not null,
	quantity INT null,
	price DOUBLE(10,2) null,
	total DOUBLE(10,2) null
);

create table user_token
(
    id varchar(32) not null
        primary key,
    user_id varchar(32) not null,
    token varchar(250) not null,
    status varchar(1) not null
);

create table users
(
    id varchar(32) not null
        primary key,
    username varchar(250) not null,
    password varchar(250) not null,
    status varchar(1) not null,
    constraint users_username_uindex
        unique (username)
);

INSERT INTO users (id, username, password, status)
VALUES ('ab3df87394914a278a682409f69aa76d', 'admin', '1234', 'A');


