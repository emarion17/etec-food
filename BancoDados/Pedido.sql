Create database G6_Pedido;

Use G6_Pedido;

create table TBL_RESTAURANTE (
	ID_RESTAURANTE bigint primary key identity
);

create table TBL_ITEM_CARDAPIO (
	ID_ITEM_CARDAPIO bigint primary key identity
);

create table TBL_PEDIDO (
    ID_PEDIDO bigint primary key identity,
    DT_CRIACAO datetime not null, 
    TP_STATUS varchar(17) not null, 
	ID_RESTAURANTE bigint not null,
    foreign key (ID_RESTAURANTE) references TBL_RESTAURANTE(ID_RESTAURANTE)
);

create table TBL_AVALIACAO (
    ID_AVALIACAO bigint primary key identity,
    NR_NOTA int not null, 
    TP_COMENTARIO text,
	ID_PEDIDO BIGINT not null,
	foreign key (ID_PEDIDO) references TBL_PEDIDO(ID_PEDIDO)
);

create table TBL_ITEM_PEDIDO (
    ID_ITEM_PEDIDO bigint primary key identity,
    NR_QUANTIDADE int not null, 
    TP_OBSERVACAO text,
	ID_PEDIDO bigint not null,
	ID_ITEM_CARDAPIO bigint not null,
	foreign key (ID_PEDIDO) references TBL_PEDIDO(ID_PEDIDO),
	foreign key (ID_ITEM_CARDAPIO) references TBL_ITEM_CARDAPIO(ID_ITEM_CARDAPIO)
);

insert into TBL_PEDIDO(DT_CRIACAO, TP_STATUS, ID_RESTAURANTE) values
('2025-09-14 16:45:00', 'REALIZADO', 41),
('2025-09-15 21:37:40', 'PAGO', 67),
('2025-08-31 23:59:59', 'ENTREGUE', 10),
('2025-09-16 07:50:20', 'SAIU_PARA_ENTREGA', 24),
('2025-09-16 04:00:00', 'PRONTO', 75);

insert into TBL_AVALIACAO(NR_NOTA, TP_COMENTARIO, ID_PEDIDO) values
(10, 'Muito bom', 8),
(0, 'Péssimo', 9),
(6, 'Medíocre', 10),
(8, 'Gostei do lanche', 11),
(5, 'Mais ou menos', 12);

insert into TBL_ITEM_PEDIDO(NR_QUANTIDADE, TP_OBSERVACAO, ID_PEDIDO, ID_ITEM_CARDAPIO) values
(4, NULL, 8, 03),
(1, 'O lanche é sem picles', 9, 05),
(10, NULL, 10, 01),
(3, NULL, 11, 02),
(2, 'O frango é com molho', 12, 04);

