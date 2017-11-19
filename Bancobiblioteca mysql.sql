create database exercicio2Biblioteca;

use exercicio2Biblioteca;

create table login(
login varchar(10),
senha varchar(10)
);

create table livros(
id int primary key auto_increment,
titulo varchar(30),
autores varchar(30),
genero varchar(30),
ano int,
disponivel varchar(3)
);

create table usuarios(
matricula int primary key auto_increment,
nome varchar(40),
login varchar(30),
senha varchar(10),
dataNascimento varchar(10)
);

insert into usuarios (nome, login, senha) values('administrador', 'adm', 'adm');

select * from usuarios;
select * from livros;