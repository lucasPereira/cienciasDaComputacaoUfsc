-- ======================== Alunos ======================== -- 

-- Chrystian de Sousa Guth (10103131) --
-- Lucas Pereira da Silva (10100754) --



DROP DATABASE livroDeReceitas;
CREATE DATABASE livroDeReceitas;
USE livroDeReceitas;

CREATE TABLE cidade (
	nome VARCHAR(32) NOT NULL,
	estado CHAR(2) NOT NULL DEFAULT 'SC',
	CONSTRAINT chavePrimariaCidade PRIMARY KEY (nome)
);

CREATE TABLE enderecoComercial (
	identificador INT NOT NULL,
	cidade VARCHAR(32) NOT NULL,
	logradouro VARCHAR(64) NOT NULL,
	bairro VARCHAR(32) NOT NULL,
	telefone CHAR(10),
	CONSTRAINT chavePrimariaEndereco PRIMARY KEY (identificador),
	FOREIGN KEY (cidade) REFERENCES cidade(nome)
);

CREATE TABLE enderecoResidencial (
	identificador INT NOT NULL,
	cidade VARCHAR(32) NOT NULL,
	logradouro VARCHAR(64) NOT NULL,
	bairro VARCHAR(32) NOT NULL,
	telefone CHAR(10),
	quantidadeDeMoradores SMALLINT DEFAULT 1,
	CONSTRAINT chavePrimariaEndereco PRIMARY KEY (identificador),
	FOREIGN KEY (cidade) REFERENCES cidade(nome)
);

CREATE TABLE pessoa (
	cpf CHAR(11) NOT NULL,
	nome VARCHAR(32) NOT NULL,
	enderecoEletronico VARCHAR(64),
	estadoCivil CHAR(1) CHECK(estadoCivil in ('S', 'C', 'D', 'V')),
	enderecoResidencial INT NOT NULL,
	CONSTRAINT chavePrimariaPessoa PRIMARY KEY (cpf),
	FOREIGN KEY (enderecoResidencial) REFERENCES enderecoResidencial(identificador)
);

CREATE TABLE tipoDeCozinha (
	nome VARCHAR(32) NOT NULL,
	CONSTRAINT chavePrimariaTipoDeCozinha PRIMARY KEY (nome)
);

CREATE TABLE restaurante (
	identificador INT NOT NULL,
	nome VARCHAR(32) NOT NULL,
	tipoDeCozinha VARCHAR(32) NOT NULL,
	enderecoComercial INT NOT NULL,
	CONSTRAINT chavePrimariaRestaurante PRIMARY KEY (identificador),
	FOREIGN KEY (tipoDeCozinha) REFERENCES tipoDeCozinha(nome),
	FOREIGN KEY (enderecoComercial) REFERENCES enderecoComercial(identificador)
);

CREATE TABLE trabalho (
	funcionario CHAR(11) NOT NULL,
	restaurante INT NOT NULL,
	dataDeIngresso DATE NOT NULL,
	salario DECIMAL(8, 2) NOT NULL CHECK(salario >= 0),
	CONSTRAINT chavePrimariaTrabalho PRIMARY KEY (funcionario, restaurante),
	FOREIGN KEY (funcionario) REFERENCES pessoa(cpf),
	FOREIGN KEY (restaurante) REFERENCES restaurante(identificador)
);

CREATE TABLE editor (
	cpf CHAR(11) NOT NULL,
	CONSTRAINT chavePrimariaEditor PRIMARY KEY (cpf),
	FOREIGN KEY (cpf) REFERENCES pessoa(cpf)
);

CREATE TABLE degustador (
	cpf CHAR(11) NOT NULL,
	CONSTRAINT chavePrimariaEditor PRIMARY KEY (cpf),
	FOREIGN KEY (cpf) REFERENCES pessoa(cpf)
);

CREATE TABLE cozinheiro (
	cpf CHAR(11) NOT NULL,
	CONSTRAINT chavePrimariaEditor PRIMARY KEY (cpf),
	FOREIGN KEY (cpf) REFERENCES pessoa(cpf)
);

CREATE TABLE referenciaDeTrabalho (
	cozinheiro CHAR(11) NOT NULL,
	restaurante INT NOT NULL,
	CONSTRAINT chavePrimariaReferenciaDeTrabalho PRIMARY KEY (cozinheiro, restaurante),
	FOREIGN KEY (cozinheiro) REFERENCES cozinheiro(cpf),
	FOREIGN KEY (restaurante) REFERENCES restaurante(identificador)
);

CREATE TABLE categoriaDeReceita (
	nome VARCHAR(32) NOT NULL,
	CONSTRAINT chavePrimariaCategoriaDeReceita PRIMARY KEY (nome)
);

CREATE TABLE receita (
	nome VARCHAR(64) NOT NULL,
	inventor CHAR(11) NOT NULL,
	modoDePreparo VARCHAR(2048) NOT NULL,
	quantidadeDePorcoes SMALLINT NOT NULL CHECK(quantidadeDePorcoes > 0),
	dataDeInvencao DATE NOT NULL,
	categoria VARCHAR(32) NOT NULL,
	CONSTRAINT chavePrimariaReceita PRIMARY KEY (nome, inventor),
	FOREIGN KEY (inventor) REFERENCES cozinheiro(cpf),
	FOREIGN KEY (categoria) REFERENCES categoria(nome)
);

CREATE TABLE tipoDeIngrediente (
	nome VARCHAR(32) NOT NULL,
	descricao VARCHAR(256),
	CONSTRAINT chavePrimariaTipoDeIngrediente PRIMARY KEY (nome)
);

CREATE TABLE ingrediente (
	identificador INT NOT NULL,
	tipoDeIngrediente VARCHAR(32) NOT NULL,
	quantidade DECIMAL(8, 3) DEFAULT 1 CHECK(quantidade > 0),
	medida VARCHAR(16) DEFAULT 'unidade',
	receita VARCHAR(32) NOT NULL,
	inventor CHAR(11) NOT NULL,
	CONSTRAINT chavePrimariaIngrediente PRIMARY KEY (identificador),
	FOREIGN KEY (tipoDeIngrediente) REFERENCES tipoDeIngrediente(nome),
	FOREIGN KEY (receita, inventor) REFERENCES receita(nome, inventor)
);

CREATE TABLE livroDeReceitas (
	isbn CHAR(13) NOT NULL,
	titulo VARCHAR(64) NOT NULL,
	editor CHAR(11) NOT NULL,
	CONSTRAINT chavePrimariaLivroDeReceitas PRIMARY KEY (isbn),
	FOREIGN KEY (editor) REFERENCES edito(cpf),
	UNIQUE (titulo)
);

CREATE TABLE receitaEmLivro (
	receita VARCHAR(32) NOT NULL,
	inventorDaReceita CHAR(11) NOT NULL,
	livroDeReceitas CHAR(13) NOT NULL,
	CONSTRAINT chavePrimariaReceitaEmLivro PRIMARY KEY (receita, inventorDaReceita, livroDeReceitas),
	FOREIGN KEY (receita, inventorDaReceita) REFERENCES receita(nome, inventor),
	FOREIGN KEY (livroDeReceitas) REFERENCES livroDeReceitas(isbn)
);

CREATE TABLE campeonatoDeReceitas (
	identificador INT NOT NULL,
	data DATE NOT NULL,
	hora TIME NOT NULL,
	local VARCHAR(64) NOT NULL,
	CONSTRAINT chavePrimariaCampeonatoDeReceitas PRIMARY KEY (identificador)
);

CREATE TABLE testeDeReceita (
	receita VARCHAR(32) NOT NULL,
	inventorDaReceita CHAR (11) NOT NULL,
	degustador CHAR(11) NOT NULL,
	campeonatoDeReceitas INT NOT NULL,
	nota DECIMAL(4, 2) NOT NULL CHECK(nota >= 0),
	CONSTRAINT chavePrimariaTesteDeReceita PRIMARY KEY (receita, inventorDaReceita, degustador),
	FOREIGN KEY (receita, inventorDAReceita) REFERENCES receita(nome, inventor),
	FOREIGN KEY (degustador) REFERENCES degustador(cpf),
	FOREIGN KEY (campeonatoDeReceitas) REFERENCES campeonatoDeReceitas(identificador)
);

CREATE TABLE participacaoEmCampeonatoDeReceitas (
	participante CHAR(11) NOT NULL,
	campeonato INT NOT NULL,
	CONSTRAINT chavePrimariaPariticipacaoEmCampeonatoDeReceitas PRIMARY KEY (participante, campeonato),
	FOREIGN KEY (participante) REFERENCES pessoa(cpf),
	FOREIGN KEY (campeonato) REFERENCES campeonatoDeReceitas(identificador)
);

/*
DROP TABLE cidade;
DROP TABLE enderecoComercial;
DROP TABLE enderecoResidencial;
DROP TABLE pessoa;
DROP TABLE funcionario;
DROP TABLE tipoDeCozinha;
DROP TABLE restaurante;
DROP TABLE trabalho;
DROP TABLE editor;
DROP TABLE degustador;
DROP TABLE cozinheiro;
DROP TABLE referenciaDeTrabalho;
DROP TABLE categoriaDeReceita;
DROP TABLE receita;
DROP TABLE tipoDeIngrediente;
DROP TABLE ingrediente;
DROP TABLE livroDeReceitas;
DROP TABLE receitaEmLivro;
DROP TABLE campeonaroDeReceitas;
DROP TABLE testeDeReceita;
DROP TABLE participacaoEmCampeonatoDeReceita;
*/
