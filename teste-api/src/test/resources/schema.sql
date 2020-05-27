drop schema if exists dbo;
create schema if not exists dbo;

drop table if exists dbo.contatos;
drop table if exists dbo.endereco;

create table dbo.contatos (
	id int not null identity,
	nome varchar(255) not null,
	idade int not null,
	endereco varchar(255),
	data_criacao datetime not null,
	data_alteracao datetime,
	constraint pk_contatos primary key (id)
);

create table dbo.endereco(
	id int not null identity,
	bairro varchar(255),
	cidade varchar(255),
	uf char(2),
	complemento varchar(255),
	email varchar(255),
	data_criacao datetime not null,
	data_alteracao datetime,
	id_contato int,
	constraint pk_endereco primary key(id),
	constraint fk_end_contato foreign key (id_contato) references dbo.contatos (id)
);

