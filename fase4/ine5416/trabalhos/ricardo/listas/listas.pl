/* 01 =====================
* Predicado: primeiro(L,P)
* Definição: L é uma lista e P é o primeiro dado de L.
*/
primeiro([P|_], P).

/* 02 ====================
* Predicado: segundo(L,S)
* Definição: L é uma lista e S é o segundo dado de L.
*/
segundo([_|L], S) :- primeiro(L, S).

/* 03 ===================
* Predicado: ultimo(L,U)
* Definição: L é uma lista e U é o último dado de L.
*/
ultimo([U], U).
ultimo([C|L], U) :- ultimo(L, U).

/* 04 ======================
* Predicado: penultimo(L,P)
* Definição: L é uma lista e P é o penúltimo de L.
*/
penultimo([P|[U]], P).
penultimo([_|L], P) :- penultimo(L, P).

/* 05 ====================
* Predicado: tamanho(L,T)
* Definição: L é uma lista e T é o número de dados de L.
*/
tamanho([], 0).
tamanho([C|L], T) :- tamanho(L, T1), T is T1+1.

/* 06 =====================
* Predicado: pertence(D,L)
* Definição: L é uma lista e D é um dos dados de L
*/
pertence(D, [D|_]). 
pertence(D, [_|L]) :- pertence(D, L).

/* 07 ========================
* Predicado: posicao(D,L,Pos)
* Definição: L é uma lista e Pos é a posição (iniciando com 1)
* do dado D na lista L. Pos = 0 caso dado não esteja em L.
*/
posicao(D, [D|L], 1).
posicao(D, [], 0).
posicao(D, [_|L], P) :- posicao(D, L, P1), P1 > 0, P is P1+1; posicao(D, L, P1), P1 = 0, P is P1.

/* 08 ==============================
* Predicado: removidoPrimeiro(L,LR)
* Definição: L é uma lista e LR é uma lista com os mesmos dados de L
* menos o primeiro.
*/
removidoPrimeiro([], []).
removidoPrimeiro([C|L], L).

/* 09 ============================
* Predicado: removidoUltimo(L,LR)
* Definição: L é uma lista e LR é uma lista com os mesmos dados de L
* menos o último.
*/
removidoUltimo([C], []).
removidoUltimo([C|L], [C|LR]) :- removidoUltimo(L, LR).

/* 10 =================================
* Predicado: substituidoUltimo(D,L,LM)
* Definição: L é uma lista e LM é uma lista com os mesmos dados de L
* com exceção do último que é D.
*/
substituidoUltimo(D, [D], []).
substituidoUltimo(D, [C|L], [C|LM]) :- substituidoUltimo(D, L, LM).

/* 11 ==================================
* Predicado: inseridoNoInicio(D, L, LM)
* Definição: D é um dado, L é uma lista e LM é a lista L mais o dado D no início.
*/
inseridoNoInicio(D, L, [D|L]).

/* 12 =================================
* Predicado: inseridoNoFinal(D, L, LM)
* Definição: D é um dado, L é uma lista e LM é a lista L mais o dado D no final.
*/
inseridoNoFinal(D, [], [D]).
inseridoNoFinal(D, [C|L], [C|LM]) :- inseridoNoFinal(D, L, LM).

/* 13 ====================================
* Predicado: inseridoNaPos(D, Pos, L, LM)
* Definição: D é um dado, Pos é a posição onde D deve ser inserido na lista L
* e LM é a lista L mais o dado D na posição Pos.
*/
inseridoNaPos(D,0,L,[D|L]).
inseridoNaPos(D,Pos,[X|Y],[X|O]):- inseridoNaPos(D,PosTemp,Y,O), Pos is PosTemp + 1.

/* 14 ==================================
* Predicado: removidoDoInicio(L, D, LM)
* Definição: L é uma lista, D é o primeiro dado de L e LM é a lista L sem o primeiro dado.
*/
removidoDoInicio([D|L], D, L).

/* 15 =================================
* Predicado: removidoDoFinal(L, D, LM)
* Definição: L é uma lista, D é o último dado de L e LM é a lista L sem o último dado.
*/
removidoDoFinal([D], D, []).
removidoDoFinal([C|L], D, [C|LM]) :- removidoDoFinal(L, D, LM).

/* 16 =====================================
* Predicado: removidoDaPos(L, Pos, D, LM)
* Definição: L é uma lista, Pos é a posição do dado a ser removido,
* D é o dado removido e LM é a lista L sem o dado removido.
*/
removidoDaPos(D,0,[D|L],L).
removidoDaPos(D,Pos,[X|Y],[X|O]) :- removidoDaPos(D,PosTemp,Y,O), Pos is PosTemp + 1.

/* 17 =====================================
* Predicado: substituidoDoInicio(D, L, LM)
* Definição: D é um dado, L é uma lista e LM é a lista L com D no lugar do primeiro dado de L.
*/
substituidoDoInicio(D, [_|T], [D|T]).

/* 18 ====================================
* Predicado: substituidoDoFinal(D, L, LM)
* Definição: D é um dado, L é uma lista e LM é a lista L com D no lugar do último dado de L.
*/
substituidoDoFinal(D,L,LM) :- substituidoUltimo(D,L,LM).

/* 19 =======================================
* Predicado: substituidoDaPos(D, Pos, L, LM)
* Definição: D é um dado, Pos é a posição do dado a ser substituído,
* L é uma lista e LM é a lista L com D no lugar do dado de L que está na posição Pos.
*/
substituidoDaPos(D, 1, L, X) :- substituidoDoInicio(D,L,X).
substituidoDaPos(D, N, [H|T], [H|TS]) :- substituidoDaPos(D, N1, T, TS), N is N1 + 1.

/* 20 ========================
* Predicado: invertida(L, LM)
* Definição: L é uma lista e LM é a lista L com os dados
* invertidos (o primeriro de L será o último de LM,
* o segundo de L será o penúltimo de LM e assim por diante).
*/
invertida([E],[E]).
invertida([H|T], LI) :- invertida(T,TI), inseridoNoFinal(H, TI, LI).

/* 21 =============================
* Predicado: temOcorrencias(D,L,O)
* Definição: D é um dado, L é uma lista e O é um número que indica quantas
* vezes D aparece na lista L.
*/
temOcorrencias(_,[],0).
temOcorrencias(D,[D|T],N) :- temOcorrencias(D,T,N1), N is N1 + 1.
temOcorrencias(D,[_|T],N) :- temOcorrencias(D,T,N).

/* 22 ==============================
* Predicado: semOcorrencias(D,L,LM)
* Definição: D é um dado, L é uma lista e LM é a lista L sem a
* presença do dado D. A ordem dos dados em LM tem que ser a mesma de L.
*/
semOcorrencias(_,[],[]).
semOcorrencias(D,[D|R],RM) :- semOcorrencias(D,R,RM).
semOcorrencias(D,[H|T],[H|T1]) :- semOcorrencias(D,T,T1).

/* 23 ================================
* Predicado: concatenadas(L1, L2, LC)
* Definição: L1 e L2 são listas e LC é a lista contendo todos os dados de L1
* seguidos de todos os dados de L2.
*/
concatenadas(L,[],L).
concatenadas([],L,L).
concatenadas([H|T],L, [H|T1]) :- concatenadas(T,L,T1).

/* 24 ====================
* Predicado: ehMaior(L,M)
* Definição: L é uma lista de números e M é o maior dos números.
*/
ehMaior([D],D).
ehMaior([H|T], H) :- ehMaior(T,X), H > X.
ehMaior([_|T], M) :- ehMaior(T,M).

/* 25 ===============================
* Predicado: primeiroEUltimo(L, LPU)
* Definição: L é uma lista e LPU é uma lista contendo o primeiro
* e o último dados de L.
*/
primeiroEUltimo([H|T], [H,X]) :- ultimo(T,X).

/* 26 ======================
* Predicado: nivelada(L,LN)
* Definição: L é uma lista que pode conter outras listas e LN é uma lista
* formada pelos dados de L com uma diferença: quando um dado de L for uma lista
* então os dados desta lista são incluídos na lista LN.

Exemplo: ? nivelada([a,b, [c, d], e], LN).
LN = [a, b, c, d, e]
*/
nivelada([],[]).
nivelada([H|T], [H|TN]) :- not(is_list(H)), nivelada(T,TN).
nivelada([H|T], LN) :- nivelada(H,L1), nivelada(T,L2), concatenadas(L1,L2,LN).

/* 27 ========================
* Predicado: invertida2(L,LI)
* Definição: L é uma lista e LI é uma lista formada pelos membros de L só
* que na ordem inversa. A implementação não deve usar o predicado concatenadas.
*/
invertida2(L,LI) :- invertida(L,LI).

/* 28 ======================
* Predicado: impares(L, LI)
* Definição: L é uma lista e LI é uma lista que contém os dados de L nas posições
* ímpares.
*/
pares([],[]).
pares([_],[]).
pares([_|T], L) :- impares(T,L).
impares([],[]).
impares([E],[E]).
impares([H|T],[H|TP]) :- pares(T,TP).

/* 29 ==================================
* Predicado: maioresQue(L1, Limite, L2)
* Definição: L1 é uma lista de números, L2 é uma lista que contém dados de L1
* que são maiores que Limite.
*/
maioresQue([], _, []).
maioresQue([H|T], Lim, [H|TM]) :- maioresQue(T,Lim,TM), H > Lim.
maioresQue([_|T], Lim, TM) :- maioresQue(T,Lim,TM). 

/* 30 ============================
* Predicado: conteIguais(L, D, C)
* Definição: L é uma lista, C é a quantidade de dados em L que são iguais a D.
*/
conteIguais(L, D, C) :- temOcorrencias(D,L,C).

/* 31 ===========================
* Predicado: monteLista(D, C, L)
* Definição: L é uma lista formada por C dados iguais a D.
*/
monteLista(_,0,[]).
monteLista(D,N,[D|T]) :- monteLista(D,N1,T), N is N1 + 1. 
