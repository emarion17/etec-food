Create database G6_Pedido;

Use G6_Pedido;

create table TBL_PEDIDO (
    ID_PEDIDO bigint primary key identity,
    DT_CRIACAO datetime2 not null, 
    TP_STATUS varchar(9) not null, 
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