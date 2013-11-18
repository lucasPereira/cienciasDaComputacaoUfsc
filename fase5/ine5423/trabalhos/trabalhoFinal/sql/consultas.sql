-- ======================== Alunos ======================== -- 

-- Chrystian de Sousa Guth (10103131) --
-- Lucas Pereira da Silva (10100754) --



-- ======================== Questão 1 ======================== -- 

-- Enunciado --
-- Crie uma consulta que teste duas colunas no WHERE, mas que selecione outras duas. A cláusula WHERE deve possuir o operador BETWEEN. --

-- Descrição --
-- Seleciona a cidade e o barrio do endereço residencial, onde os endereços residenciais possuem entre 3 e 5 moradores e o telefone do endereço incia com 47. --

-- Seleção --
SELECT cidade, bairro 
FROM enderecoResidencial 
WHERE quantidadeDeMoradores BETWEEN 3 AND 5 AND (telefone LIKE '47%');

-- Resultado --
-- +-----------+----------------+
-- | cidade    | bairro         |
-- +-----------+----------------+
-- | Blumenau  | Velha          |
-- | Blumenau  | Centro         |
-- | Blumenau  | Itoupava Norte |
-- | Itajaí ­   | São João       |
-- +-----------+----------------+



-- ======================== Questão 2 ======================== -- 

-- Enunciado --
-- Crie uma consulta que acesse duas tabelas. A cláusula SELECT deve possui mais de dois atributos. A cláusula WHERE deve possuir AND e OR. A consulta deve possuir duas variantes: (a) com operador de JOIN (b) com operador de produto cartesiano --

-- Descrição --
-- Seleciona o nome, o endereço eletrônico e a cidade da pessoa, onde a pessoa que possui estado civil igual a Solteira ('S') ou Divorciada ('D') e não mora sozinha. --

-- Seleção (JOIN) --
SELECT pessoa.nome, pessoa.enderecoEletronico, enderecoResidencial.cidade 
FROM pessoa JOIN enderecoResidencial ON pessoa.enderecoResidencial = enderecoResidencial.identificador 
WHERE (pessoa.estadoCivil = 'S' OR pessoa.estadoCivil = 'D') AND (enderecoResidencial.quantidadeDeMoradores > 1);

-- Seleção (PRODUTO CARTESIANO) --
SELECT pessoa.nome, pessoa.enderecoEletronico, enderecoResidencial.cidade 
FROM pessoa, enderecoResidencial
WHERE (pessoa.enderecoResidencial = enderecoResidencial.identificador) AND (pessoa.estadoCivil = 'S' OR pessoa.estadoCivil = 'D') AND (enderecoResidencial.quantidadeDeMoradores > 1);

-- Resultado --
-- +----------------------+--------------------------+------------------+
-- | nome                 | enderecoEletronico       | cidade           |
-- +----------------------+--------------------------+------------------+
-- | Eduardo Gonçalves    | eduardo@goncalves.com.br | Florianópolis    |
-- | Tiago Martins        | tiago@martins.com.br     | São José         |
-- | Renata Souza         | renata@souza.com.br      | Florianópolis    |
-- | Juliano Silva        | juliano@silva.com.br     | Blumenau         |
-- | Mateus Furlan        | mateus@furlan.com.br     | Palhoça          |
-- | Cristina Lopes       | cristina@lopes.com.br    | Blumenau         |
-- | Otavio Carvalho      | otavio@carvalho.com.br   | Biguaçu          |
-- | Joana Amaral         | joana@amaral.com.br      | Itajaí           |
-- | Marta Machado        | marta@machado.com.br     | Blumenau         |
-- | Vanessa Pereira      | vanessa@pereira.com.br   | Itajaí ­          |
-- | Ana Lopes            | ana@lopes.com.br         | Biguaçu          |
-- +----------------------+--------------------------+------------------+


	
-- ======================== Questão 3 ======================== -- 

-- Enunciado --
-- Crie uma consulta que use > ALL, e que envolva mais de uma tabela e mais de dois atributos na cláusula SELECT. --

-- Descrição --
-- Seleciona a pessoa que tem o salário maior que o salário de todos os cozinheiros. --

-- Seleção --
SELECT pessoa.nome, trabalho.salario 
FROM pessoa JOIN trabalho ON pessoa.cpf = trabalho.funcionario 
WHERE trabalho.salario > ALL (SELECT trabalho.salario FROM trabalho JOIN cozinheiro ON trabalho.funcionario = cozinheiro.cpf);

-- Resultado --
-- +-----------------+----------+
-- | nome            | salario  |
-- +-----------------+----------+
-- | Gillberto Prado | 17000.00 |
-- +-----------------+----------+



-- ======================== Questão 4 ======================== -- 

-- Enunciado --
-- Crie uma consulta que acesse três tabelas sendo que uma delas deve ter sido criada por causa de um relacionamento n_n do modelo conceitual. A cláusula SELECT deve possuir pelo menos um atributo de cada uma das tabelas relacionadas. A cláusula WHERE deve possuir pelo menos três filtros. A consulta deve ser feita com operador de JOIN e possuir alguma função de agregação. --
	
-- Descrição --
-- Seleciona o nome e o salário do funcionário, o nome do restaurante e agrega a quantidade de linhas agrupadas, onde o salário está entre R$ 2500,00 e R$ 5000, o funcionário é um cozinheiro e a pessoa não possui o estado civil de Viúva ('V'). --

-- Seleção --
SELECT pessoa.nome, restaurante.nome, trabalho.salario, COUNT(*) 
FROM pessoa JOIN trabalho ON pessoa.cpf = trabalho.funcionario JOIN restaurante ON restaurante.identificador = trabalho.restaurante 
WHERE (trabalho.salario BETWEEN 2500 AND 5000) AND (pessoa.cpf IN (SELECT cpf FROM cozinheiro)) AND (pessoa.estadoCivil <> 'V')
GROUP BY pessoa.nome, restaurante.nome, trabalho.salario;

-- Resultado --
-- +-------------------+----------------+---------+----------+
-- | nome              | nome           | salario | COUNT(*) |
-- +-------------------+----------------+---------+----------+
-- | Ana Lopes         | Farabbud       | 2675.00 |        1 |
-- | Jaqueline Ventura | Da Terrinha    | 3500.95 |        1 |
-- | Mariana Lima      | Da Terrinha    | 3217.00 |        1 |
-- | Marta Machado     | Brasil a Gosto | 2890.10 |        1 |
-- | Vanessa Pereira   | Jun Sakamoto   | 4500.00 |        1 |
-- +-------------------+----------------+---------+----------+



-- ======================== Questão 5 ======================== -- 

-- Enunciado --
-- Crie uma consulta, aninhada, com duas tabelas. (a) Usando o NOT IN (b) Usando o NOT EXISTS A consulta mais interna deve possuir a cláusula WHERE, que por sua vez deve possuir o operador IN. A consulta deve possuir alguma função de agregação. --

-- Descrição --
-- Seleciona os estados civis e agrega a quantidade de pessoas que existe em cada um dos estados civis, onde a pessoa não é cozinheiro e degustador ao mesmo tempo. --

-- Seleção (NOT IN) --
SELECT estadoCivil, COUNT(estadoCivil)
FROM pessoa 
WHERE pessoa.cpf NOT IN (SELECT cozinheiro.cpf FROM cozinheiro WHERE cozinheiro.cpf IN (SELECT degustador.cpf FROM degustador))
GROUP BY estadoCivil;

-- Seleção (NOT EXISTS) --
SELECT estadoCivil, COUNT(estadoCivil)
FROM pessoa
WHERE NOT EXISTS (SELECT cozinheiro.cpf FROM cozinheiro WHERE cozinheiro.cpf IN (SELECT degustador.cpf FROM degustador) AND pessoa.cpf = cozinheiro.cpf)
GROUP BY estadoCivil;

-- Resultado --
-- +-------------+--------------------+
-- | estadoCivil | COUNT(estadoCivil) |
-- +-------------+--------------------+
-- | C           |                 11 |
-- | D           |                  1 |
-- | S           |                  9 |
-- | V           |                  2 |
-- +-------------+--------------------+



-- ======================== Questão 6 ======================== -- 

-- Enunciado --
-- Crie uma consulta, que acesse três tabelas, selecionando dois atributos quaisquer e usando a função COUNT(). Utilize o ORDER BY e GROUP BY. A cláusula WHERE deve possuir pelo menos dois filtros. --

-- Descrição --
-- Seleciona o nome e o tipo de cozinha do restaurante e agrega a quantidade de referências de trabalho em que cada restaurante é apontado, onde o nome do restaurante não contém a palavra Brasil e o tipo de cozinha do restaurante não seja Brasileira. O resultado é ordenado pelo tipo de cozinha do restaurante. --

-- Seleção --
SELECT restaurante.nome, restaurante.tipoDeCozinha, COUNT(*)
FROM restaurante JOIN referenciaDeTrabalho ON restaurante.identificador = referenciaDeTrabalho.restaurante JOIN cozinheiro ON referenciaDeTrabalho.cozinheiro = cozinheiro.cpf
WHERE restaurante.nome NOT LIKE '%Brasil%' AND restaurante.tipoDeCozinha <> 'Brasileira'
GROUP BY restaurante.nome
ORDER BY restaurante.tipoDeCozinha;

-- Resultado --
-- +---------------+---------------+----------+
-- | nome          | tipoDeCozinha | COUNT(*) |
-- +---------------+---------------+----------+
-- | Cantina Gigio | Italiana      |        2 |
-- | Da Terrinha   | Portuguesa    |        1 |
-- | Farabbud      | Árabe         |        3 |
-- | Jun Sakamoto  | Japonesa      |        3 |
-- | Von Kessel    | Alemã         |        3 |
-- +---------------+---------------+----------+



-- ======================== Questão 7 ======================== -- 

-- Enunciado --
-- Crie uma consulta, que acesse três tabelas, que utilize o HAVING. A cláusula WHERE deve possuir pelo menos dois	filtros. O HAVING deve testar o valor de retorno de uma função de agregação escrita em uma cláusula SELECT. --

-- Descrição --
-- Seleciona o tipo e a medida de um ingrediente, agrega para cada par de tipo de ingrediente e medida, a média da quantidade total dos ingredientes e agreta a quantidade de receitas em que o par tipo de ingrediente e medida foram utilizados, onde a categoria da receita ao	qual o ingrediente pertence não é Doce e o CPF do cozinheiro que inventou a receita é diferente de 12345678921. Além disso, o par tipo de	ingrediente e medida deve ter sido usado em mais de uma receita. --

-- Seleção --
SELECT tipoDeIngrediente, medida, AVG(quantidade), COUNT(receita)
FROM ingrediente JOIN receita ON ingrediente.receita = receita.nome JOIN cozinheiro ON receita.inventor = cozinheiro.cpf
WHERE receita.categoria <> 'Doce' AND cozinheiro.cpf <> '12345678921'
GROUP BY tipoDeIngrediente, medida
HAVING COUNT(receita) > 1;

-- Resultado --
-- +-------------------+-----------+-----------------+----------------+
-- | tipoDeIngrediente | medida    | AVG(quantidade) | COUNT(receita) |
-- +-------------------+-----------+-----------------+----------------+
-- | Carne Moída       | grama     |     500.0000000 |              2 |
-- | Leite             | mililitro |     350.0000000 |              3 |
-- | Manteiga          | grama     |      75.0000000 |              2 |
-- +-------------------+-----------+-----------------+----------------+
