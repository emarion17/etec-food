CREATE DATABASE etec_food;
Use etec_food;


--Grupo 1: Usuario, Permissao, StatusUsuarioEnum
--Integrantes: 


CREATE TABLE TBL_Usuario (
    id_usuario BIGINT PRIMARY KEY IDENTITY,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(200) NOT NULL,
    tentativasAcesso INT DEFAULT 0,
    dataBloqueio DATETIME NULL,
    dataInativacao DATETIME NULL,
    status_usuario VARCHAR(20) NOT NULL,
    CONSTRAINT CK_Usuario_Status CHECK (status IN ('ATIVO','INATIVO','BLOQUEADO'))
);

CREATE TABLE Permissao (
    id BIGINT PRIMARY KEY IDENTITY,
    authority VARCHAR(100) PRIMARY KEY
);

-- Tabela de relacionamento Usuario x Permissao (N:N)
CREATE TABLE Usuario_Permissao (
    usuario_id BIGINT NOT NULL,
    permissao_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, permissao_id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id_usuario),
    FOREIGN KEY (permissao_id) REFERENCES Permissao(id)
);

--Grupo 2 - Restaurante, HorarioFuncionamento, RestauranteFormaPagamento
--Integrantes: 
CREATE TABLE Restaurante (
    id_restaurante BIGINT PRIMARY KEY IDENTITY,
    cnpj VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(150) NOT NULL,
    descricao VARCHAR(500),
    cep CHAR(8) not null,
    endereco VARCHAR(200) not null,
    taxaDeEntrega float not null,
    tempoDeEntregaMinimo INT not null,
    tempoDeEntregaMaximo INT not null,
    aprovado BIT DEFAULT 0 not null,
    tipoDeCozinha VARCHAR(20) NOT NULL,
    usuario_id BIGINT NOT NULL,
	FOREIGN KEY (usuario_id) REFERENCES Usuario(id_usuario),
    CONSTRAINT CK_Restaurante_TipoCozinha CHECK (
        tipoDeCozinha IN ('CHINESA','JAPONESA','MEXICANA','MINEIRA','BAIANA',
                          'LANCHES','HAMBURGER','ARABE','ITALIANA','VARIADA')
    )
);

CREATE TABLE HorarioFuncionamento (
    id_HF BIGINT PRIMARY KEY IDENTITY,
    diaSemana VARCHAR(10) NOT NULL,
    horarioAbertura TIME NOT NULL,
    horarioFechamento TIME NOT NULL,
    id_restaurante BIGINT NOT NULL,
    FOREIGN KEY (id_restaurante) REFERENCES Restaurante(id_restaurante)
);


CREATE TABLE RestauranteFormaPagamento (
    id_restaurante BIGINT NOT NULL,
    id_formaPagamento BIGINT NOT NULL,
    PRIMARY KEY (id_restaurante, id_formaPagamento),
    FOREIGN KEY (id_restaurante) REFERENCES Restaurante(id_restaurante),
    FOREIGN KEY (id_formaPagamento) REFERENCES TBL_FORMA_PAGAMENTO(ID_FORMA_PAGAMENTO)
);

--Grupo 3: Pagamento, FormaPagamento
--Integrantes: 

CREATE TABLE TBL_FORMA_PAGAMENTO (
    ID_FORMA_PAGAMENTO BIGINT PRIMARY KEY IDENTITY,
    TX_NOME VARCHAR(100) NOT NULL,
    TP_TIPO VARCHAR(100) NOT NULL,
    CONSTRAINT CK_FormaPagamento_Tipo CHECK (TP_TIPO IN ('CARTAO_CREDITO','CARTAO_DEBITO','VALE_REFEICAO'))
);

CREATE TABLE TBL_PAGAMENTO (
    ID_PAGAMENTO bigint primary key identity,
	NR_VALOR decimal(10,2) not null,
	TX_NOME varchar(100) not null,	
	NR_NUMERO varchar(100) not null,
	TX_EXPIRACAO varchar(100) not null,
	TX_CODIGO varchar (19) not null,
	TP_STATUS varchar(100) not null,
	ID_FORMA_PAGAMENTO bigint not null,
	foreign key (ID_FORMA_PAGAMENTO) references TBL_FORMA_PAGAMENTO(ID_FORMA_PAGAMENTO)
    CONSTRAINT CK_Pagamento_Status CHECK (TP_STATUS IN ('CRIADO','CONFIRMADO','CANCELADO'))
);

--Grupo 4: Cardapio, ItemCardapio
--Integrantes: GustavoAlberico, Luigih Ragauske, Miguel, Bianca, Giulia

CREATE TABLE Cardapio (
    id_cardapio BIGINT PRIMARY KEY IDENTITY,
    id_restaurante BIGINT NOT NULL
);

CREATE TABLE ITEM_CARDAPIOO (
    id_item_cardapio BIGINT PRIMARY KEY IDENTITY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    tipo VARCHAR(100) NOT NULL,
    preco FLOAT not null,
	preco_promocional FLOAT not null,
	cardapio BIGINT not null,
    CONSTRAINT CK_ItemCardapio_Tipo CHECK (tipo IN ('ENTRADA','PRATO_PRINCIPAL','BEBIDA'))
);

ALTER TABLE ITEM_CARDAPIOO ADD CONSTRAINT FK_ITEM_CARDAPIOO
FOREIGN KEY (cardapio) REFERENCES CARDAPIO(id_cardapio);
--Grupo 5: Cliente, Entrega
--Integrantes: 

CREATE TABLE TBL_CLIENTE (
  ID_CPF varchar(11) primary key not null,
	TX_NOME varchar(100) not null,
	TX_EMAIL varchar(100),
	TX_TELEFONE varchar(11),
	IN_VALIDADO bit
);


CREATE TABLE TBL_ENTREGA (
    ID_ENTREGA bigint primary key identity,
	TX_CEP varchar(100),
	TX_ENDERECO varchar(100) not null,
	TX_COMPLEMENTO varchar(100),
	ID_CPF varchar(11) not null,
	foreign key (ID_CPF) references TBL_CLIENTE(ID_CPF)

);

--Grupo 6: Pedido, ItemPedido, Avaliação
--Integrantes: 
CREATE TABLE TBL_PEDIDO (
    ID_PEDIDO BIGINT PRIMARY KEY IDENTITY,
    DT_CRIACAO DATETIME NOT NULL,
    TP_STATUS VARCHAR(20) NOT NULL,
    id_restaurante BIGINT NOT NULL,
    FOREIGN KEY (id_restaurante) REFERENCES Restaurante(id_restaurante),
    CONSTRAINT CK_Pedido_Status CHECK (
        TP_STATUS IN ('REALIZADO','PAGO','CONFIRMADO','PRONTO','SAIU_PARA_ENTREGA','ENTREGUE')
    )
);

CREATE TABLE TBL_ITEM_PEDIDO (
    ID_ITEM_PEDIDO bigint primary key identity,
    NR_QUANTIDADE int not null, 
    TP_OBSERVACAO text,
	ID_PEDIDO bigint not null,
	ID_ITEM_CARDAPIO bigint not null,
	foreign key (ID_PEDIDO) references TBL_PEDIDO(ID_PEDIDO),
	foreign key (ID_ITEM_CARDAPIO) references TBL_ITEM_CARDAPIO(ID_ITEM_CARDAPIO)
);


CREATE TABLE TBL_AVALIACAO (
    ID_AVALIACAO bigint primary key identity,
    NR_NOTA int not null, 
    TP_COMENTARIO text,
	ID_PEDIDO BIGINT not null,
	foreign key (ID_PEDIDO) references TBL_PEDIDO(ID_PEDIDO)
);

--Grupo 7: Entregador, Veículo

CREATE TABLE TBL_ENTREGADOR (
    ID_ENTREGADOR BIGINT PRIMARY KEY IDENTITY,
	NOME VARCHAR(50) NOT NULL,
	TELEFONE VARCHAR(50) NOT NULL,
	ATIVO BIT DEFAULT 1
);

CREATE TABLE TBL_VEICULO (
ID_VEICULO BIGINT PRIMARY KEY IDENTITY,
	PLACA VARCHAR(50) NOT NULL,
	TP_VEICULO VARCHAR(50) NOT NULL,
	ID_ENTREGADOR BIGINT NOT NULL,
	FOREIGN KEY (ID_ENTREGADOR) REFERENCES TBL_ENTREGADOR(ID_ENTREGADOR),
    CONSTRAINT CK_Veiculo_Tipo CHECK (TP_VEICULO IN ('MOTO','CARRO','BICICLETA','OUTRO'))
);


--Alteração do grupo 3
alter table TBL_PAGAMENTO add column ID_PEDIDO bigint;

alter table TBL_PAGAMENTO add constraint FK_PEDIDOID
foreign key (ID_PEDIDO) references PEDIDO (ID_PEDIDO);


--Alteração do grupo 5
alter table TBL_CLIENTE add ID_PEDIDO bigint not null
alter table TBL_CLIENTE add constraint ID_PEDIDO foreign key (ID_PEDIDO) references TBL_PEDIDO(ID_PEDIDO)

