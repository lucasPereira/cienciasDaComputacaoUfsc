carregarBaseDeDados :- 
	consult('Familia.pl'),
	write('Base de dados carregada.'), nl.

salvarNovoPredicadoNaBaseDeDados(X, Y, Z) :-
	open('Familia.pl', append, F, [alias(output)]),
	write(F, ':- dynamic '),
	write(F, X),
	write(F, '/2.\n'),
	write(F, X),
	write(F, '(A,B):- '), write(F, Y), write(F, '(A,X),'), write(F, Z),
	write(F, '(X,B).\n'),
	told,
	carregarBaseDeDados,
	principal.

principal :-
	write('---------------------'), nl,
	write('Selecione uma opção: '), nl,
	write('[0] Adicionar novo parentesco.'), nl,
	write('[1] Inserir pessoas.'), nl,
	write('[2] Consultar parentesco.'), nl,
	write('[3] Sair.'), nl,
	write('---------------------'), nl,
	read(X),
	principal(X).
	
principal(0) :- 
	write('Digite o nome do parentesco: '), nl,
	read(X),
	write('Uma pessoa é '), write(X), write(' se essa pessoa for: '), nl,
	read(Y),
	write('de :'), nl,
	read(Z),
	Term1 =..[X, A, B],
	Term2 =..[Y, A, J],
	Term3 =..[Z, J, B],
	assertz(Term1 :- (Term2, Term3)),
	salvarNovoPredicadoNaBaseDeDados(X, Y, Z).

principal(1) :- 
	write('Digite o nome do parentesco: '), nl,
	read(X),
	write('Digite o nome da primeira pessoa: '), nl,
	read(Y),
	write('Digite o nome da segunda pessoa: '), nl,
	read(Z),
	Term =.. [X, Y, Z],
	assert(Term),
	open('Familia.pl', append, FILE, [alias(output)]),
	write(FILE, Term),
	write(FILE, '.\n'),
	told,
	carregarBaseDeDados,
	principal.
	
principal(2) :- 
	write('Digite o nome do parentesco: '), nl,
	read(X),
	write('Digite o nome da primeira pessoa: '), nl,
	read(Y),
	write('Digite o nome da segunda pessoa: '), nl,
	read(Z),
	Term =.. [X,Y,Z],
	write('Consulta: '), nl,
	ifelse(Term, (write(Y), write(' é '), write(X), write(' de '), write(Z), nl ),(write(Y), write(' não é '), write(X), write(' de '), write(Z), nl )),
	principal.

principal(3) :- halt.

ifelse(X, Y, Z) :- call(X) -> Y; Z.

:- carregarBaseDeDados.
:- principal.
