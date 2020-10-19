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
    franquia_de_internet int,
    valor decimal(8,2),
    operadora varchar(32),
    id_tipo int,
    foreign key(idTipo) references tipo(id),
    primary key(id)
);



alter table plano add constraint FKgr1lwc9rh5ig7lg3cbmn2nne foreign key (id_tipo) references tipo (id);

CREATE USER 'api_teleplan'@'localhost' IDENTIFIED BY 'T&l&Pl@N';

GRANT ALL PRIVILEGES ON db_teleplan.* TO 'api_teleplan'@'localhost';
/*Na primeira subida do servidor da API coloco grant como all privileges para que as sequences sejam criadas, mas revoko depois e só coloco para INSERT,UPDATE,DELETE e SELECT */
/*
REVOKE privileges ON db_teleplan.* FROM 'api_teleplan'@'localhost';
GRANT INSERT,UPDATE,DELETE, SELECT ON db_teleplan.* TO 'api_teleplan'@'localhost';*/

FLUSH PRIVILEGES;