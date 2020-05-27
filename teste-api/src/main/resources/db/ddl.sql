drop schema if exists dbo
create schema if not exists dbo

drop table if exists dbo.contatos;

create table dbo.contatos(
	id int not null identity,
	nome varchar(255) not null,
	idade int not null,
	endereco varchar(255),
	data_criacao datetime not null,
	data_alteracao datetime,
	constraint pk_contatos primary key (id)
);