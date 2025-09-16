Create database trabalho_integrado;
use trabalho_integrado;

create table TBL_CLIENTE(
	ID_CPF varchar(11) primary key not null,
	TX_NOME varchar(100) not null,
	TX_EMAIL varchar(100),
	TX_TELEFONE varchar(11),
	IN_VALIDADO bit,
);

create table TBL_ENTREGA(
	ID_ENTREGA bigint primary key identity,
	TX_CEP varchar(100),
	TX_ENDERECO varchar(100) not null,
	TX_COMPLEMENTO varchar(100),
	ID_CPF varchar(11) not null,
	foreign key (ID_CPF) references TBL_CLIENTE(ID_CPF),
);

insert into TBL_CLIENTE values 
('48161990808', 'Enzo', 'drenzoholanda@gmail.com', '11945124072', 1),
('42930245672', 'Gabriel', 'gabrielobituario@gmail.com', '11954887760', 1),
('89087689087', 'Joao', 'robloxgamer@gmail.com', '11658732488', 0),
('86732145633','Victor', 'victorninja@gmail.com', '11098566234', 1),
('79886754423', 'Catarino','enzogamer123@gmail.com','11909087654',0);

insert into TBL_ENTREGA values
('0998877', 'Rua Papagaio, 237', 'apto 237', '48161990808'),
('8096776', 'Rua Tuiuti, 890', NULL, '42930245672'),
('8904534', 'Rua Laranjeira, 123', NULL, '89087689087'),
('5763458', 'Rua Corinthians, 234', NULL, '86732145633'),
('2345645', 'Rua Brasil, 141', 'Apto 171', '79886754423')

alter table TBL_CLIENTE
add ID_PEDIDO bigint not null
alter table TBL_CLIENTE
add constraint ID_PEDIDO foreign key (ID_PEDIDO) references TBL_PEDIDO(ID_PEDIDO)

