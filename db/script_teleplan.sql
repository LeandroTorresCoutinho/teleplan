create database db_teleplan;
use db_teleplan;

create table tipo(
	id int AUTO_INCREMENT,
    descricao varchar(32),
    primary key(id)
);

create table plano(
	id int AUTO_INCREMENT,
	codigoDDD varchar(3),
    minutos int,
    franquiaDeInternet int,
    valor decimal(8,2),
    operadora varchar(32),
    idTipo int,
    foreign key(idTipo) references tipo(id),
    primary key(id)
);

CREATE USER 'api_teleplan'@'localhost' IDENTIFIED BY 'T&l&Pl@N';
GRANT INSERT,UPDATE,DELETE,SELECT ON db_teleplan.* TO 'api_teleplan'@'localhost';


FLUSH PRIVILEGES;