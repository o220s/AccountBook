create table accountbook(
	seq int auto_increment primary key,
	date varchar(30),
	money int,
	title varchar(30),
	memo varchar(50),
	classify varchar(30)
);

select * from accountbook;