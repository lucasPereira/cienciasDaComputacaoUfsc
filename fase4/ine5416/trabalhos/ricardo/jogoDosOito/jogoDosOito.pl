cima([A, B, C, 0, E, F, G, H, I], [0, B, C, D, E, F, G, H, I]).
cima([A, B, C, D, 0, F, G, H, I], [A, 0, C, D, E, F, G, H, I]).
cima([A, B, C, D, E, 0, G, H, I], [A, B, 0, D, E, F, G, H, I]).
cima([A, B, C, D, E, F, 0, H, I], [A, B, C, 0, E, F, G, H, I]).
cima([A, B, C, D, E, F, G, 0, I], [A, B, C, D, 0, F, G, H, I]).
cima([A, B, C, D, E, F, G, H, 0], [A, B, C, D, E, 0, G, H, I]).

direita([0, B, C, D, E, F, G, H, I], [A, 0, C, D, E, F, G, H, I]).
direita([A, 0, C, D, E, F, G, H, I], [A, B, 0, D, E, F, G, H, I]).
direita([A, B, C, 0, E, F, G, H, I], [A, B, C, D, 0, F, G, H, I]).
direita([A, B, C, D, 0, F, G, H, I], [A, B, C, D, E, 0, G, H, I]).
direita([A, B, C, D, E, F, 0, H, I], [A, B, C, D, E, F, G, 0, I]).
direita([A, B, C, D, E, F, G, 0, I], [A, B, C, D, E, F, G, H, 0]).

baixo([A, B, C, 0, E, F, G, H, I], [A, B, C, D, E, F, 0, H, I]).
baixo([A, B, C, D, 0, F, G, H, I], [A, B, C, D, E, F, G, 0, I]).
baixo([A, B, C, D, E, 0, G, H, I], [A, B, C, D, E, F, G, H, 0]).
baixo([0, B, C, D, E, F, G, H, I], [A, B, C, 0, E, F, G, H, I]).
baixo([A, 0, C, D, E, F, G, H, I], [A, B, C, D, 0, F, G, H, I]).
baixo([A, B, 0, D, E, F, G, H, I], [A, B, C, D, E, 0, G, H, I]).

esquerda([A, 0, C, D, E, F, G, H, I], [0, B, C, D, E, F, G, H, I]).
esquerda([A, B, 0, D, E, F, G, H, I], [A, 0, C, D, E, F, G, H, I]).
esquerda([A, B, C, D, 0, F, G, H, I], [A, B, C, 0, E, F, G, H, I]).
esquerda([A, B, C, D, E, 0, G, H, I], [A, B, C, D, 0, F, G, H, I]).
esquerda([A, B, C, D, E, F, G, 0, I], [A, B, C, D, E, F, 0, H, I]).
esquerda([A, B, C, D, E, F, G, H, 0], [A, B, C, D, E, F, G, 0, I]).

configuracaoDesejada([1, 2, 3, 8, 0, 4, 7, 6, 5]).
operadores([esquerda, direita, cima, baixo]).

movimentar(esquerda, C, D) :- esquerda(C, D).
movimentar(direita, C, D) :- direita(C, D).
movimentar(cima, C, D) :- cima(C, D).
movimentar(baixo, C, D) :- baixo(C, D).

buscarEmLargura(Inicio,Caminho) :- buscarCaminhoEmLargura([node(Inicio, [])], Caminho).
buscarCaminhoEmLargura([node(Configuracao, Caminho) | _], Caminho) :- configuracaoDesejada(Configuracao).
buscarCaminhoEmLargura([node(Configuracao, Caminho) | Fila], CaminhoDesejado) :-
	findall(node(Filho, CaminhoDoVerticeFilho), (movimentar(Operador, Configuracao, Filho), append(Caminho, [Operador], CaminhoDoVerticeFilho)), VerticesFilhos),
	append(Fila, VerticesFilhos, NovaFila),
	buscarCaminhoEmLargura(NovaFila, CaminhoDesejado),!.

buscarSolucao(ConfiguracaoInicial) :- 
	buscarEmLargura(ConfiguracaoInicial, Movimentos),
	nl,
	write('Solução Encontrada.'), nl,
	write('* Configuração inicial: '),
	exibirNaTela(ConfiguracaoInicial), nl,
	write('* Configuração final: '),
	configuracaoDesejada(ConfiguracaoFinal), 
	exibirNaTela(ConfiguracaoFinal), nl,
	write('* Movimentos necessários: '), 
	write(Movimentos), nl, nl, nl.

exibirNaTela(NovaFila) :- write(NovaFila).

exibirMenu :-
	nl,
	write('É necessário informar a configuração inicial das peças:'), nl, 
	write('* A configuração inicial deve ser fornecida como uma lista.'), nl,
	write('* Liste a matriz das peças linha a linha, de cima para baixo e da esquerda para direita.'), nl,
	write('* Além disso, no lugar do espaço em branco deve-se colocar um 0.'), nl, nl,
	write('Informe a configuração inicial: '),
	read(ConfiguracaoInicial),
	buscarSolucao(ConfiguracaoInicial).	

:- exibirMenu.
