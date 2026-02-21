create table tbl_item(
	id serial primary key,
	nome varchar(100) not null,
	sku varchar(50) not null,
	quantidade int not null,
	preco decimal(10, 2) not null,
	status varchar(20),
	categoriaId int not null,
	constraint fk_categoria foreign key (categoriaId) references tbl_categoria(id)
	on delete cascade


);