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
	constraint Restaurante_tipoCozinha check (tipoCozinha in ('Chinesa', 'Japonesa', 'Mexicana', 
	'Mineira', 'Baiana', 'Lanches','Hamburguer','Árabe','Italiana', 'Variada'))
	-- usuario: Usuario foreing key aq
);


create table HorarioFuncionamento(
	id_HF bigint primary key not null,
	diaSemana varchar(20),
	horarioAbertura time,
	horarioFechamento time,
	id_restaurante bigint not null references Restaurante,
	CONSTRAINT CK_HorarioFuncionamento_horarioAbertura_horarioFechamento CHECK (
        (horarioAbertura = '10:00:00' AND horarioFechamento = '20:00:00') OR
        (horarioAbertura = '08:00:00' AND horarioFechamento = '22:00:00') OR
        (horarioAbertura = '11:30:00' AND horarioFechamento = '23:00:00') OR
        (horarioAbertura = '06:00:00' AND horarioFechamento = '17:00:00') OR
        (horarioAbertura = '06:00:00' AND horarioFechamento = '20:00:00')
    )
);


create table RestauranteFormaPagamento(
	id_restaurante bigint not null,
	--id_formaPagamento int(ou qual seja a que eles colocarem) aqui é para estar quando tivermos que relacionar a outra tabela.
	primary key (id_restaurante, id_formaPagamento),
	FOREIGN KEY (id_restaurante) REFERENCES Restaurante(id_restaurante), 
	--FOREIGN KEY (id_formaPagamento) REFERENCES FormaPagamento(id_formaPagamento), 
);

insert into Restaurante(id_restaurante, cnpj, nome, descricao, Cep, endereco, taxaDeEntrega, TempoDeEntregaMinimo, TempoDeEntregaMaximo, aprovado, tipoCozinha) values
	(1, '12345678000191', 'China Express', 'Comida chinesa r�pida', '12345678', 'Rua Jos� Buono, 123', 5.99, 30, 45, 1, 'Chinesa'),
	(2, '22345678000192', 'Sushi Place', 'Sushi e sashimi frescos', '22345678', 'Rua Tucuruvi, 456', 7.50, 40, 60, 1, 'Japonesa'),
	(3, '32345678000193', 'Taco MexMix', 'Tacos e burritos', '32345678', 'Av. do Estado, 789', 6.00, 35, 50, 0, 'Mexicana'),
	(4, '42345678000194', 'Mineiro Sabor', 'Comida caseira mineira', '42345678', 'Rua Guilherme, 321', 4.00, 25, 40, 1, 'Mineira'),
	(5, '52345678000195', 'Bahia Gourmet', 'Acaraj� e moqueca', '52345678', 'Av. Paulista, 654', 8.00, 45, 70, 1, 'Baiana');

insert into HorarioFuncionamento(id_HF, diaSemana,horarioAbertura, horarioFechamento, id_restaurante) values
	(1, 'Domingo', '10:00:00', '20:00:00', 1),
	(2, 'Segunda-Feira', '08:00:00', '22:00:00', 3),
	(3, 'Ter�a-Feira', '11:30:00', '23:00:00', 5),
	(4, 'S�bado', '06:00:00', '17:00:00', 2),
	(5, 'Sexta-Feira', '06:00:00', '20:00:00', 4);

insert into RestauranteFormaPagamento(id_restaurante, id_formaPagamento) values
	(2, 1),
	(1, 3),
	(5, 1),
	(2, 2),
	(3, 2);
