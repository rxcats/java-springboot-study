create table tb_user_currency
(
	user_id bigint not null
		primary key,
	gold bigint default 0 null,
	cash bigint default 0 null,
	paid_cash bigint default 0 null
);

create table tb_user_info
(
	user_id bigint auto_increment
		primary key,
	platform_id bigint null,
	state varchar(10) null,
	user_name varchar(30) null,
	last_login_ts bigint null,
	join_ts bigint null,
	constraint ix_platform_id
		unique (platform_id),
	constraint ix_user_name
		unique (user_name)
);

create table tb_user_inventory
(
	user_id bigint not null,
	item_id bigint not null,
	item_qty int default 0 null,
	item_opt varchar(30) null,
	primary key (user_id, item_id)
);

