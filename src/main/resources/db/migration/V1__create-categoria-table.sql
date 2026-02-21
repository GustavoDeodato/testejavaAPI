create table categoria(
	id serial default primary key,
	nome varchar(100) not null,
	descricao text not null
);