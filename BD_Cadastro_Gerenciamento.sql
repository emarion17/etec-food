create database CadastroGerenciamentoRestaurantes;
use CadastroGerenciamentoRestaurantes;

create table Restaurante(
	id_restaurante bigint not null primary key,
	cnpj char(14) not null,
	nome varchar(45) not null,
	descricao varchar(50) not null,
	Cep char(8) not null,
	endereco varchar(35) not null,
	taxaDeEntrega float not null,
	TempoDeEntregaMinimo int not null,
	TempoDeEntregaMaximo INT not null,
	aprovado bit not null,
	tipoCozinha varchar(20) not null,
	-- usuario: Usuario foreing key aq
);

create table TipoDeCozinha(
	TipoCozinhaId numeric(10) primary key not null,
	nome_TipoCozinha varchar(20) not null
);

create table HorarioFuncionamento(
	id_HF bigint primary key not null,
	diaSemana varchar(20),
	horarioAbertura time,
	horarioFechamento time,
	id_restaurante bigint not null references Restaurante
);

create table RestauranteFormaPagamentoId(
	id_formaPagamento bigint primary key not null,
	id_restaurante bigint not null references Restaurante
);

create table FormaPagamento(
	id_formaPagamento bigint primary key not null,
	nome_formaPagamento varchar(30),
	tipoFormaPagamento varchar(20)
);
