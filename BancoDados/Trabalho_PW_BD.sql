create database trabalho
use trabalho

create table TBL_Usuario(
	id_usuario bigint primary key identity,
	nome varchar(100),
	senha varchar(25),
	tentativasAcesso int,
	dataBloqueio DateTime,
	dataInativacao DateTime,
	status_usuario varchar(50)
);


create table TBL_Permissao(
    id_permissao bigint primary key identity,
	authority varchar(50) not null
);

create table TBL_Usuario_Permissao(
	id_usuario bigint,
	id_permissao bigint,
	foreign key(id_usuario) references TBL_Usuario(id_usuario),
	foreign key(id_permissao) references TBL_Permissao(id_permissao)
);

insert into TBL_Usuario values
('Julia', 'matt0ss0', 4, '2019-06-07', '2019-06-09', 'INATIVO'),
('Marina', 'm2IRNA', 0, '2025-06-07', '2020-06-09T12:09:10.00', 'INATIVO'),
('Heitor', 'Hait0r', 0, '2025-07-07', '2020-07-09T12:10:10.00', 'ATIVO'),
('Enzo', 'ENZOOO', 0, '2025-07-07', '2020-07-09T12:10:50.00', 'ATIVO'),
('Gustavo', 'gusta123', 0, '2018-07-07', '2018-07-09T12:10:10.00', 'ATIVO');



select * from TBL_Usuario
