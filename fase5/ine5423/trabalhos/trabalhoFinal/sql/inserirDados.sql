-- ======================== Alunos ======================== -- 

-- Chrystian de Sousa Guth (10103131) --
-- Lucas Pereira da Silva (10100754) --



INSERT INTO cidade(nome) VALUES ('Florianópolis');
INSERT INTO cidade(nome, estado) VALUES ('São José', 'SC');
INSERT INTO cidade(nome, estado) VALUES ('Biguaçu', 'SC');
INSERT INTO cidade(nome, estado) VALUES ('Palhoça', 'SC');
INSERT INTO cidade(nome, estado) VALUES ('Balneário Camboriú', 'SC');
INSERT INTO cidade(nome, estado) VALUES ('Itajaí', 'SC');
INSERT INTO cidade(nome, estado) VALUES ('Blumenau', 'SC');
INSERT INTO cidade(nome, estado) VALUES ('Brusque', 'SC');
INSERT INTO cidade(nome, estado) VALUES ('Salvador', 'BA');

INSERT INTO enderecoComercial(identificador, cidade, logradouro, bairro, telefone)
	VALUES (1, 'Florianópolis', 'Avenida Rio Branco', 'Centro', '4833220011');
INSERT INTO enderecoComercial(identificador, cidade, logradouro, bairro, telefone)
	VALUES (2, 'Florianópolis', 'Professor Simão José Hess', 'Trindade', '4833223472');
INSERT INTO enderecoComercial(identificador, cidade, logradouro, bairro, telefone)
	VALUES (3, 'Blumenau', 'Avenida Lisboa', 'Itoupava Norte', '4733550011');
INSERT INTO enderecoComercial(identificador, cidade, logradouro, bairro, telefone)
	VALUES (4, 'Itajaí', 'Avenida Joca Brandão', 'Centro', '4732893736');
INSERT INTO enderecoComercial(identificador, cidade, logradouro, bairro, telefone)
	VALUES (5, 'Balneário Camboriú', 'Avenida Brasil', 'Centro', '4833448855');
INSERT INTO enderecoComercial(identificador, cidade, logradouro, bairro, telefone)
	VALUES (6, 'Florianópolis', 'Otávio Armando de Brito', 'Trindade', '4833229326');
INSERT INTO enderecoComercial(identificador, cidade, logradouro, bairro, telefone)
	VALUES (7, 'São José', 'Rua Frei Hilário', 'Kobrasol', '4832203425');

INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (1, 'Florianópolis', 'Rua Protenor Vidal', 'Pantanal', '4833221100', 2);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (2, 'São José', 'Rua Felipe Neves', 'Coloninha', '4832202344', 1);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (3, 'Blumenau', 'Rua Adolfo Karsten', 'Velha', '4733552342', 5);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (4, 'Biguaçu', 'Rua Eleutério dos Santos', 'Bom Viver', '4833241137', 3);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (5, 'Itajaí', 'Rua Hercílio Luz', 'Centro', '4732893477', 2);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (6, 'Brusque', 'Rua Paes Leme', 'São Luiz', '4732542376', 2);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (7, 'Blumenau', 'Rua Sete de Setembro', 'Centro', '4733557722', 4);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (8, 'São José', 'Rua Walter da Silva Koerich', 'Kobrasol', '4832202336', 3);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (9, 'Salvador', 'Rua Três de Maio', 'Centro', '7132413577', 7);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (10, 'Blumenau', 'Rua João Pessoa', 'Velha', '4733553015', 1);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (11, 'Florianópolis', 'Avenida das Nações', 'Canasvieiras', '4833220022', 4);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (12, 'São José', 'Rua Bernanrdinho Vaz', 'Estreito', '4832208529', 4);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (13, 'Florianópolis', 'Rua Moacyr Pereira Junior', 'Logoa da Conceição', '4833226644', 5);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (14, 'Palhoça', 'Jorge Corino da Luz', 'Ponte Imaruim', '4833233444', 1);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (15, 'Blumenau', 'Rua Bruno Roedel', 'Velha', '4733552619', 2);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (16, 'Brusque', 'Rua Hercílio Luz', 'São Luiz', '4732542342', 1);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (17, 'Biguaçu', 'Rua Rio Branco', 'Rio Caveiras', '4833242366', 3);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (18, 'Palhoça', 'Carlos Kirch', 'Ponte Imaruim', '4833232354', 6);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (19, 'Brusque', 'Rua José Pavesi', 'Limeira', '4732542204', 2);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (20, 'Blumenau', 'Avenida Berlim', 'Itoupava Norte', '4733557662', 3);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (21, 'Florianópolis', 'Oge Fortkamp', 'Trindade', '4833221234', 1);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (22, 'Itajaí', 'Rua José Bauer', 'São João', '4732893466', 3);
INSERT INTO enderecoResidencial(identificador, cidade, logradouro, bairro, telefone, quantidadeDeMoradores)
	VALUES (23, 'Balneário Camboriú', 'Avenida Brasil', 'Centro', '4833448865', 2);

INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678901', 'Mario Melo', 'mario@melo.com.br', 'C', 2);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678902', 'Eduardo Gonçalves', 'eduardo@goncalves.com.br', 'S', 13);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678903', 'Tiago Martins', 'tiago@martins.com.br', 'S', 12);	
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678904', 'Renata Souza', 'renata@souza.com.br', 'D', 1);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678905', 'Bianca Silveira', 'bianca@silveira.com.br', 'V', 20);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678906', 'Pedro Borba', 'pedro@borba.com.br', 'C', 21);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678907', 'Juliano Silva', 'juliano@silva.com.br', 'S', 7);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678908', 'Gillberto Prado', 'gilberto@prado.com.br', 'C', 16);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678909', 'Mateus Furlan', 'mateus@furlan.com.br', 'S', 18);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678910', 'Jaqueline Ventura', 'jaqueline@ventura.com.br', 'D', 10);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678911', 'Cristina Lopes', 'cristina@lopes.com.br', 'S', 15);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678912', 'Otavio Carvalho', 'otavio@carvalho.com.br', 'S', 17);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678913', 'Marcelo Vieira', 'marcelo@vieira.com.br', 'C', 8);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678914', 'Joana Amaral', 'joana@amaral.com.br', 'S', 5);	
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678915', 'Pedro Figueredo', 'pedro@figueredo.com.br', 'V', 9);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678916', 'Henrique Furtado', 'henrique@furtado.com.br', 'C', 14);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678917', 'Mariana Lima', 'mariana@lima.com.br', 'C', 19);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678918', 'Marta Machado', 'marta@machado.com.br', 'D', 3);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678919', 'Vanessa Pereira', 'vanessa@pereira.com.br', 'S', 22);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678920', 'João Rocha', 'joao@rocha.com.br', 'C', 11);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678921', 'Ana Lopes', 'ana@lopes.com.br', 'S', 4);	
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678922', 'Larisa Pacheco', 'larisa@pacheco.com.br', 'C', 3);	
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678923', 'Marcelo Pacheco', 'marcelo@cardoso.com.br', 'C', 3);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678924', 'Julia Andrade', 'julia@andrade.com.br', 'C', 23);
INSERT INTO pessoa(cpf, nome, enderecoEletronico, estadoCivil, enderecoResidencial) 
	VALUES ('12345678925', 'Paulo Andrade', 'paulo@andrade.com.br', 'C', 23);
	
INSERT INTO tipoDeCozinha(nome) VALUES ('Japonesa');
INSERT INTO tipoDeCozinha(nome) VALUES ('Francesa');
INSERT INTO tipoDeCozinha(nome) VALUES ('Brasileira');
INSERT INTO tipoDeCozinha(nome) VALUES ('Italiana');
INSERT INTO tipoDeCozinha(nome) VALUES ('Árabe');
INSERT INTO tipoDeCozinha(nome) VALUES ('Portuguesa');
INSERT INTO tipoDeCozinha(nome) VALUES ('Alemã');
INSERT INTO tipoDeCozinha(nome) VALUES ('Chinesa');
INSERT INTO tipoDeCozinha(nome) VALUES ('Mexicana');

INSERT INTO restaurante(identificador, nome, tipoDeCozinha, enderecoComercial) VALUES (1, 'Von Kessel', 'Alemã', 6);
INSERT INTO restaurante(identificador, nome, tipoDeCozinha, enderecoComercial) VALUES (2, 'Farabbud', 'Árabe', 3);
INSERT INTO restaurante(identificador, nome, tipoDeCozinha, enderecoComercial) VALUES (3, 'Cantina Gigio', 'Italiana', 2);
INSERT INTO restaurante(identificador, nome, tipoDeCozinha, enderecoComercial) VALUES (4, 'Jun Sakamoto', 'Japonesa', 7);
INSERT INTO restaurante(identificador, nome, tipoDeCozinha, enderecoComercial) VALUES (5, 'Brasil a Gosto', 'Brasileira', 4);
INSERT INTO restaurante(identificador, nome, tipoDeCozinha, enderecoComercial) VALUES (6, 'Da Terrinha', 'Portuguesa', 5);
INSERT INTO restaurante(identificador, nome, tipoDeCozinha, enderecoComercial) VALUES (7, 'Dona Benta', 'Brasileira', 1);

INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678922', 1, '2012-03-25', 1500.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678921', 2, '2010-12-12', 2675.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678920', 3, '2005-01-24', 1340.50);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678919', 4, '2009-06-05', 4500.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678918', 5, '2008-11-01', 2890.10);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678917', 6, '2011-12-14', 3217.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678916', 7, '2006-04-22', 1244.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678915', 1, '2006-08-23', 4000.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678914', 2, '2011-09-07', 2450.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678913', 3, '2010-02-18', 1270.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678912', 4, '2005-10-30', 5120.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678911', 5, '2009-10-10', 3629.80);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678910', 6, '2004-09-28', 3500.95);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678909', 7, '2012-07-09', 900.10);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678908', 1, '2011-01-10', 17000.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678907', 2, '2010-02-18', 2130.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678907', 6, '2010-02-18', 9000.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678906', 3, '2010-12-02', 3180.50);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678905', 4, '2008-11-18', 911.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678904', 5, '2006-10-15', 1022.70);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678903', 6, '2011-11-20', 2580.00);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678902', 7, '2007-04-22', 6320.05);
INSERT INTO trabalho(funcionario, restaurante, dataDeIngresso, salario) VALUES ('12345678901', 1, '2009-07-21', 3500.00);

INSERT INTO editor(cpf) VALUES ('12345678901');
INSERT INTO editor(cpf) VALUES ('12345678902');
INSERT INTO editor(cpf) VALUES ('12345678903');
INSERT INTO editor(cpf) VALUES ('12345678904');
INSERT INTO editor(cpf) VALUES ('12345678905');
INSERT INTO editor(cpf) VALUES ('12345678906');
INSERT INTO editor(cpf) VALUES ('12345678907');

INSERT INTO degustador(cpf) VALUES ('12345678904');
INSERT INTO degustador(cpf) VALUES ('12345678908');
INSERT INTO degustador(cpf) VALUES ('12345678909');
INSERT INTO degustador(cpf) VALUES ('12345678910');
INSERT INTO degustador(cpf) VALUES ('12345678911');
INSERT INTO degustador(cpf) VALUES ('12345678912');
INSERT INTO degustador(cpf) VALUES ('12345678913');
INSERT INTO degustador(cpf) VALUES ('12345678914');

INSERT INTO cozinheiro(cpf) VALUES ('12345678902');
INSERT INTO cozinheiro(cpf) VALUES ('12345678907');
INSERT INTO cozinheiro(cpf) VALUES ('12345678904');
INSERT INTO cozinheiro(cpf) VALUES ('12345678910');
INSERT INTO cozinheiro(cpf) VALUES ('12345678915');
INSERT INTO cozinheiro(cpf) VALUES ('12345678916');
INSERT INTO cozinheiro(cpf) VALUES ('12345678917');
INSERT INTO cozinheiro(cpf) VALUES ('12345678918');
INSERT INTO cozinheiro(cpf) VALUES ('12345678919');
INSERT INTO cozinheiro(cpf) VALUES ('12345678920');
INSERT INTO cozinheiro(cpf) VALUES ('12345678921');
INSERT INTO cozinheiro(cpf) VALUES ('12345678922');

INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678901', 3);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678903', 2);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678904', 1);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678904', 5);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678904', 6);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678904', 2);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678905', 7);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678907', 1);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678908', 7);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678910', 3);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678911', 2);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678911', 1);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678914', 5);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678915', 5);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678915', 2);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678915', 7);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678919', 3);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678920', 4);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678921', 2);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678921', 4);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678921', 7);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678921', 1);
INSERT INTO referenciaDeTrabalho(cozinheiro, restaurante) VALUES ('12345678922', 4);

INSERT INTO categoriaDeReceita(nome) VALUES ('Frutos do Mar');
INSERT INTO categoriaDeReceita(nome) VALUES ('Massas');
INSERT INTO categoriaDeReceita(nome) VALUES ('Carnes');
INSERT INTO categoriaDeReceita(nome) VALUES ('Doces');
INSERT INTO categoriaDeReceita(nome) VALUES ('Saladas');
INSERT INTO categoriaDeReceita(nome) VALUES ('Sopas');
INSERT INTO categoriaDeReceita(nome) VALUES ('Aves');
INSERT INTO categoriaDeReceita(nome) VALUES ('Bebidas');
INSERT INTO categoriaDeReceita(nome) VALUES ('Tortas');

INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Bolinho de Siri', '12345678922', 'Esquenta no micro-ondas e está pronto.', 10, '2010-04-21', 'Frutos do Mar');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Bolinho de Bacalhau', '12345678922', 'Esquenta no micro-ondas e está pronto.', 5, '2010-08-11', 'Frutos do Mar');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Camarão a Milanesa', '12345678922', 'Esquenta no micro-ondas e está pronto.', 1, '2010-09-20', 'Frutos do Mar');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Sopa de Palmito', '12345678921', 'Esquenta no micro-ondas e está pronto.', 20, '2011-02-13', 'Sopas');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Torta Alemã', '12345678920', 'Esquenta no micro-ondas e está pronto.', 30, '2006-04-21', 'Doces');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Carne ao Molho Madeira', '12345678919', 'Esquenta no micro-ondas e está pronto.', 6, '2007-12-01', 'Carnes');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria)
	VALUES ('Pernil com Molho de Salame', '12345678919', 'Esquenta no micro-ondas e está pronto.', 10, '2009-04-17', 'Carnes');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Costelinha no Shoyo', '12345678918', 'Esquenta no micro-ondas e está pronto.', 10, '2011-10-24', 'Carnes');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Mousse sem Ovos', '12345678917', 'Esquenta no micro-ondas e está pronto.', 15, '2005-09-01', 'Doces');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Nhoque de Maionese', '12345678916', 'Esquenta no micro-ondas e está pronto.', 2, '2010-07-01', 'Massas');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Pastel de Carne', '12345678915', 'Esquenta no micro-ondas e está pronto.', 1, '2006-08-07', 'Massas');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Salada de Macarrão', '12345678910', 'Esquenta no micro-ondas e está pronto.', 3, '2007-11-15', 'Saladas');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Chocolate Quente', '12345678907', 'Esquenta no micro-ondas e está pronto.', 1, '2005-05-12', 'Bebidas');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Fricassé de Frango', '12345678907', 'Esquenta no micro-ondas e está pronto.', 5, '2012-01-28', 'Aves');
INSERT INTO receita(nome, inventor, modoDePreparo, quantidadeDePorcoes, dataDeInvencao, categoria) 
	VALUES ('Rocambole de Carne Moída', '12345678902', 'Esquenta no micro-ondas e está pronto.', 6, '2008-07-10', 'Carnes');

INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Carne de Siri', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Bacalhau', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Camarão', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Palmito', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Cebola', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Açucar', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Manteiga', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Ovo', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Filé Mignon', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Molho Madeira', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Pernil', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Costela Bovina', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Molho Shoyo', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Nhoque', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Maionese', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Carne Moída', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Massa de Pastel', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Macarrão', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Alface', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Chocolate em Barra', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Leite', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Frango', NULL);
INSERT INTO tipoDeIngrediente(nome, descricao) VALUES ('Sal', NULL);

INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (1, 'Carne de Siri', 400.0, 'grama', 'Bolinho de Siri', '12345678922');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (2, 'Bacalhau', 600, 'grama', 'Bolinho de Bacalhau', '12345678922');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (3, 'Camarão', 500, 'grama', 'Camarão a Milanesa', '12345678922');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (4, 'Palmito', 100, 'grama', 'Sopa de Palmito', '12345678921');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (5, 'Cebola', 30, 'grama', 'Sopa de Palmito', '12345678921');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (6, 'Manteiga', 100, 'grama', 'Torta Alemã', '12345678920');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (7, 'Ovo', 4, 'unidade', 'Torta Alemã', '12345678920');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (8, 'Leite', 50, 'mililitro', 'Torta Alemã', '12345678920');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (9, 'Filé Mignon', 1.5, 'quilograma', 'Carne ao Molho Madeira', '12345678919');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (10, 'Molho Madeira', 100, 'mililitro', 'Carne ao Molho Madeira', '12345678919');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (11, 'Pernil', 1, 'unidade', 'Pernil com Molho de Salame', '12345678919');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (12, 'Costela Bovina', 2, 'quilograma', 'Costelinha no Shoyo', '12345678918');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (14, 'Leite', 500, 'mililitro', 'Mousse sem Ovos', '12345678917');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (15, 'Açucar', 100, 'grama', 'Mousse sem Ovos', '12345678917');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (16, 'Manteiga', 50, 'grama', 'Mousse sem Ovos', '12345678917');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (17, 'Nhoque', 50, 'grama', 'Nhoque de Maionese', '12345678916');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (18, 'Carne Moída', 100, 'grama', 'Pastel de Carne', '12345678915');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (19, 'Massa de Pastel', 200, 'grama', 'Pastel de Carne', '12345678915');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (20, 'Alface', 100, 'grama', 'Salada de Macarrão', '12345678910');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (21, 'Sal', 2, 'colher de sopa', 'Salada de Macarrão', '12345678910');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (22, 'Macarrão', 175, 'grama', 'Salada de Macarrão', '12345678910');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (23, 'Chocolate em Barra', 200, 'grama', 'Chocolate Quente', '12345678907');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (24, 'Leite', 500, 'mililitro', 'Chocolate Quente', '12345678907');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (25, 'Frango', 1.25, 'quilograma', 'Fricassé de Frango', '12345678907');
INSERT INTO ingrediente(identificador, tipoDeIngrediente, quantidade, medida, receita, inventor) 
	VALUES (26, 'Carne Moída', 900, 'grama', 'Rocambole de Carne Moída', '12345678902');

INSERT INTO livroDeReceitas(isbn, titulo, editor) VALUES ('1234567890001', 'O Maravilhoso Mundo da Culinária', '12345678907');
INSERT INTO livroDeReceitas(isbn, titulo, editor) VALUES ('1234567890002', 'Pratos Rápidos de A a Z', '12345678902');
INSERT INTO livroDeReceitas(isbn, titulo, editor) VALUES ('1234567890003', 'O Sabor da Cozinha', '12345678905');
INSERT INTO livroDeReceitas(isbn, titulo, editor) VALUES ('1234567890004', 'Comidas Caseiras', '12345678901');
INSERT INTO livroDeReceitas(isbn, titulo, editor) VALUES ('1234567890005', 'Cozinha Moderna e Saudável', '12345678904');

INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Bolinho de Siri', '12345678922', '1234567890001');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Bolinho de Bacalhau', '12345678922', '1234567890002');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Camarão a Milanesa', '12345678922', '1234567890003');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Sopa de Palmito', '12345678921', '1234567890004');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Torta Alemã', '12345678920', '1234567890005');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Carne ao Molho Madeira', '12345678919', '1234567890001');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Carne ao Molho Madeira', '12345678919', '1234567890002');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Pernil com Molho de Salame', '12345678919', '1234567890003');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Costelinha no Shoyo', '12345678918', '1234567890004');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Mousse sem Ovos', '12345678917', '1234567890005');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Nhoque de Maionese', '12345678916', '1234567890001');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Nhoque de Maionese', '12345678916', '1234567890002');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Pastel de Carne', '12345678915', '1234567890003');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Salada de Macarrão', '12345678910', '1234567890004');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Chocolate Quente', '12345678907', '1234567890005');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Fricassé de Frango', '12345678907', '1234567890001');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Fricassé de Frango', '12345678907', '1234567890002');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Fricassé de Frango', '12345678907', '1234567890003');
INSERT INTO receitaEmLivro(receita, inventorDaReceita, livroDeReceitas) VALUES ('Rocambole de Carne Moída', '12345678902', '1234567890004');

INSERT INTO campeonatoDeReceitas(identificador, data, hora, local) VALUES (1, '2012-04-01', '13:20:00', 'Centro de Culinária Sabor Brasil');
INSERT INTO campeonatoDeReceitas(identificador, data, hora, local) VALUES (2, '2011-10-20', '14:45:00', 'Bistrô Floripa');

INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota) 
	VALUES ('Bolinho de Siri', '12345678922', '12345678904', 1, 5.64);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Bolinho de Bacalhau', '12345678922', '12345678908', 2, 9.3);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Camarão a Milanesa', '12345678922', '12345678908', 2, 3.54);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Sopa de Palmito', '12345678921', '12345678908', 2, 7.53);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Torta Alemã', '12345678920', '12345678909', 1, 6.67);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Carne ao Molho Madeira', '12345678919', '12345678909', 1, 8.88);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Carne ao Molho Madeira', '12345678919', '12345678910', 2, 9.23);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Pernil com Molho de Salame', '12345678919', '12345678911', 1, 9.79);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Costelinha no Shoyo', '12345678918', '12345678911', 1, 5.75);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Mousse sem Ovos', '12345678917', '12345678912', 2, 7.7);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Nhoque de Maionese', '12345678916', '12345678912', 2, 8);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Pastel de Carne', '12345678915', '12345678912', 2, 9);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Pastel de Carne', '12345678915', '12345678910', 2, 7.89);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Pastel de Carne', '12345678915', '12345678914', 2, 8.3);		
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Salada de Macarrão', '12345678910', '12345678913', 1, 6.23);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Chocolate Quente', '12345678907', '12345678913', 1, 8.53);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Fricassé de Frango', '12345678907', '12345678914', 2, 6.53);
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota)
	VALUES ('Rocambole de Carne Moída', '12345678902', '12345678914', 2, 6.76);

INSERT INTO participacaoEmCampeonatoDeReceitas(participante, campeonato) VALUES ('12345678923', 1);
INSERT INTO participacaoEmCampeonatoDeReceitas(participante, campeonato) VALUES ('12345678924', 1);
INSERT INTO participacaoEmCampeonatoDeReceitas(participante, campeonato) VALUES ('12345678925', 1);
INSERT INTO participacaoEmCampeonatoDeReceitas(participante, campeonato) VALUES ('12345678924', 2);
INSERT INTO participacaoEmCampeonatoDeReceitas(participante, campeonato) VALUES ('12345678925', 2);

/*
DELETE FROM cidade;
DELETE FROM enderecoComercial;
DELETE FROM enderecoResidencial;
DELETE FROM pessoa;
DELETE FROM funcionario;
DELETE FROM tipoDeCozinha;
DELETE FROM restaurante;
DELETE FROM trabalho;
DELETE FROM editor;
DELETE FROM degustador;
DELETE FROM cozinheiro;
DELETE FROM referenciaDeTrabalho;
DELETE FROM categoriaDeReceita;
DELETE FROM receita;
DELETE FROM tipoDeIngrediente;
DELETE FROM ingrediente;
DELETE FROM livroDeReceitas;
DELETE FROM receitaEmLivro;
DELETE FROM campeonaroDeReceitas;
DELETE FROM testeDeReceita;
DELETE FROM participacaoEmCampeonatoDeReceita;
*/
