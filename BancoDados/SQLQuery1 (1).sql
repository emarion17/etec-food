CREATE DATABASE etecfood
USE etecfood

create table TBL_FORMA_PAGAMENTO(
	ID_FORMA_PAGAMENTO bigint primary key identity not null,
	TX_NOME varchar(100) not null,
	TP_TIPO varchar(100) not null,
);

create table TBL_PAGAMENTO(
	ID_PAGAMENTO bigint primary key identity,
	NR_VALOR decimal(10,2) not null,
	TX_NOME varchar(100) not null,	
	NR_NUMERO varchar(100) not null,
	TX_EXPIRACAO varchar(100) not null,
	TX_CODIGO varchar (19) not null,
	TP_STATUS varchar(100) not null,
	ID_FORMA_PAGAMENTO bigint not null,
	foreign key (ID_FORMA_PAGAMENTO) references TBL_FORMA_PAGAMENTO(ID_FORMA_PAGAMENTO)
);


insert into TBL_FORMA_PAGAMENTO	values
('NUbank',       'CARTAO_CREDITO'),
('Inter',        'CARTAO_DEBITO'),
('VR',           'VALE_REFEICAO'),
('TricolorCard', 'CARTAO_DEBITO'),
('Itaú',         'CARTAO_CREDITO');

insert into TBL_PAGAMENTO values
(50.00,  'João Lima',        1, '16-09-2025', '1234 5678 9101 1121', 'CRIADO',     1),
(159.58, 'Giovanna França',  2, '21-06-2007', '1111 1111 1111 1111', 'CONFIRMADO', 2),
(248.34, 'Gustavo Ribeiro',  3, '19-01-2009', '4002 8922 4002 8922', 'CANCELADO',  3),
(587.11, 'Milene Gini',      4, '05-12-2010', '2222 2222 2222 2222', 'CONFIRMADO', 4),
(12.05,  'Gabrielly Leite' , 5, '19-10-2019', '5224 4517 8002 5748', 'CANCELADO',  5); 

alter table TBL_PAGAMENTO
add column ID_PEDIDO bigint;

alter table TBL_PAGAMENTO
add constraint FK_PEDIDOID
foreign key (ID_PEDIDO)
references PEDIDO (ID_PEDIDO);

