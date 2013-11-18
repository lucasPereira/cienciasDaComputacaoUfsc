-- ======================== Alunos ======================== -- 

-- Chrystian de Sousa Guth (10103131) --
-- Lucas Pereira da Silva (10100754) --



-- ======================== 1 ======================== -- 

-- Domínio --
-- "Podem existir receitas sem teste, mas todo degustador já executou pelo menos um teste." --

-- Função --
-- Se após adicionar um novo teste de receita houver algum degustador sem nenhum teste, então lança uma exceção. Ou seja, sempre que um novo degustador for inserido no banco de dados, então o próximo teste de receita inserido deverá ser do novo degustador. --
CREATE FUNCTION degustadorPossuiPeloMenosUmTeste()
RETURNS trigger AS $degustadorPossuiPeloMenosUmTeste$
DECLARE cpfDoDegustadorSemTeste INT;
BEGIN
	SELECT degustador.cpf INTO cpfDoDegustadorSemTeste
	FROM degustador
	WHERE degustador.cpf NOT IN (SELECT testeDeReceita.degustador FROM testeDeReceita);
	
	IF (cpfDoDegustadorSemTeste IS NOT NULL AND cpfDoDegustadorSemTeste <> NEW.degustador) THEN
		RAISE EXCEPTION 'O degustador (%) deve ter pelo menos um teste de receita.', NEW.degustador;
	END IF;
	return NEW;
END;
$degustadorPossuiPeloMenosUmTeste$ LANGUAGE plpgsql;

-- Trigger --
-- Usada para garantir que ao inserir, editar ou remover um teste de receita, caso exista um degustador sem teste de receita, então não será possível realizar a ação a menos que o degustador sem teste de receita seja associado com um teste de receita. --
CREATE TRIGGER degustadorPossuiPeloMenosUmTeste 
AFTER INSERT OR UPDATE OR DELETE 
ON testeDeReceita
	FOR EACH ROW EXECUTE PROCEDURE degustadorPossuiPeloMenosUmTeste();

-- Execução --
-- Será lançada a excerção, pois o teste de receita deverá ser associado com o degustador recém inserido (12345678914) para que este não fique sem nenhum teste de receita. --	
INSERT INTO degustador(cpf) VALUES ('12345678914');
INSERT INTO testeDeReceita(receita, inventorDaReceita, degustador, campeonatoDeReceitas, nota) 
	VALUES ('Bolinho de Siri', '12345678922', '12345678904', 1, 5.64);
	


-- ======================== 2 ======================== -- 

-- Domínio --
-- "Todo cozinheiro deve produzir um certo número de receitas por mês." --

-- Função --
-- Verifica se um cozinheiro produziu um determinado número de receitas em um mês e se não produziu, lança uma exceção. --
CREATE FUNCTION verificarProducaoDoCozinheiro(cpfDoCozinheiro INT, quantidaDeReceitasMinimo INT, inicioDoPeriodo DATE, fimDoPeriodo DATE)
RETURNS BOOLEAN AS $verificarProducaoDoCozinheiro$
DECLARE quantidadeDeReceitasNoPeriodo INT;
BEGIN
	SELECT COUNT(*) 
	INTO quantidadeDeReceitasNoPeriodo 
	FROM receita 
	WHERE (receita.inventor = cpfDoCozinheiro) AND (receita.dataDeInvencao BETWEEN inicioDoPeriodo AND fimDoPeriodo);
	
	IF (quantidadeDeReceitasNoPeriodo < quantidaDeReceitasMinimo) THEN
		RAISE EXCEPTION 'Cozinheiro (%) não está com a produção em dia.', cpfDoCozinheiro;
	END IF;
	RETURN 1;
END;
$verificarProducaoDoCozinheiro$ LANGUAGE plpgsql;

-- Execução --
SELECT verificarProducaoDoCozinheiro(12345678922, 2, 2010-09-01, 2010-10-01);



-- ======================== 3 ======================== -- 

-- Domínio --
-- "Os cozinheiros recém-contratados têm um prazo de até 45 dias para entregar suas primeiras receitas." --

-- Função --
-- Verifica se um cozinheiro entregou suas primeiras receitas até 45 dias depois de ser contratado e se não entregou, lança uma exceçao. --
CREATE FUNCTION verificarProducaoInicialDoCozinheiro(cpfDoCozinheiro INT)
RETURNS BOOLEAN AS $verificarProducaoInicialDoCozinheiro$
DECLARE quantidadeDeReceitasNoPeriodo INT;
DECLARE dataDeIngressoDoCozinheiro DATE;
BEGIN
	SELECT dataDeIngresso
	INTO dataDeIngressoDoCozinheiro
	FROM trabalho 
	WHERE (trabalho.funcionario = cpfDoCozinheiro);
	
	SELECT COUNT(*)
	INTO quantidadeDeReceitasNoPeriodo
	FROM receita
	WHERE (receita.inventor = cpfDoCozinheiro) AND (receita.dataDeInvencao BETWEEN dataDeIngresso AND SELECT ADDDATE(dataDeIngresso, 45));

	IF (quantidadeDeReceitasNoPeriodo = 0) THEN
		RAISE EXCEPTION 'Cozinheiro (%) não entregou suas primeiras receitas.', cpfDoCozinheiro;
	END IF;
	RETURN 1;
END;
$verificarProducaoInicialDoCozinheiro$ LANGUAGE plpgsql;

-- Execução --
SELECT verificarProducaoInicialDoCozinheiro(12345678920);
