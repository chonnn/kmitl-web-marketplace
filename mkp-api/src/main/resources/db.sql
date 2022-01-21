create table product
(
	id varchar(10) not null
		primary key,
	name varchar(60) null,
	description varchar(200) null,
	price DOUBLE(10,2) null
);

drop table orders;
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

