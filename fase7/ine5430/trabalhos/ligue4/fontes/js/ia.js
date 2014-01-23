/*global Classe*/
/*global Ligue4Modelo*/

(function (global) {
	"use strict";

	var Ligue4Ia = Classe.criarSingleton({
		inicializar: function () {
			EstrategiaMinimax.fixarEstrategia(MinimaxComHeuristicaA);
			EstrategiaMinimax.fixarVencedorDesejado(Ligue4Modelo.instancia.jogadores.computador);
			EstrategiaMinimax.fixarPerdedorDesejado(Ligue4Modelo.instancia.jogadores.humano);
			this.profundidade = 9;
		},

		receberJogada: function (ordemDeJogadores) {
			if (Ligue4Modelo.instancia.computadorPodeJogar()) {
				EstrategiaMinimax.reiniciarNodosProcessados();
				var tabuleiro = Ligue4Modelo.instancia.tabuleiro;
				var minimax = new EstrategiaMinimax(tabuleiro, ordemDeJogadores, this.profundidade);
				var jogada = minimax.jogar();
				Ligue4Modelo.instancia.jogarComputador(jogada);
			}
		}
	});

	var Minimax = Classe.criar({
		inicializar: function (tabuleiro, ordemDeJogadores, profundidadeMaxima) {
			this.profundidadeMaxima = profundidadeMaxima;
			this.melhorJogada = this.calcularMaximoRaiz(tabuleiro, ordemDeJogadores, 1);
		},

		calcularMaximoRaiz: function (tabuleiro, ordemDeJogadores, profundidade) {
			EstrategiaMinimax.processarNodo();
			var jogadasPossiveis = this.ordenarJogadasPelaHeuristica(tabuleiro.fornecerJogadasPossiveis());
			var novaOrdemDeJogadores = ordemDeJogadores.clonar();
			var novaProfundidade = (profundidade + 1);
			var jogador = ordemDeJogadores.primeiro;
			var alfa = Number.menosInfinito;
			var beta = Number.maisInfinito;
			var melhorJogada;
			novaOrdemDeJogadores.push(novaOrdemDeJogadores.shift());
			for (var indice = 0, tamanho = jogadasPossiveis.length; indice < tamanho; indice++) {
				var jogada = jogadasPossiveis[indice];
				var novoTabuleiro = tabuleiro.clonar();
				novoTabuleiro.receberJogada(jogada.coluna, jogador);
				var minimo = this.calcularMinimo(alfa, beta, novoTabuleiro, novaOrdemDeJogadores, novaProfundidade);
				if (minimo > alfa) {
					alfa = minimo;
					melhorJogada = jogada;
				}
			}
			return melhorJogada;
		},

		calcularMaximo: function (alfa, beta, tabuleiro, ordemDeJogadores, profundidade) {
			EstrategiaMinimax.processarNodo();
			var jogadasPossiveis = tabuleiro.fornecerJogadasPossiveis();
			if (profundidade >= this.profundidadeMaxima || jogadasPossiveis.vazio()) {
				EstrategiaMinimax.processarNodoFolha();
				return this.calcularFuncaoDeUtilidade(tabuleiro, profundidade);
			}
			var novaOrdemDeJogadores = ordemDeJogadores.clonar();
			var novaProfundidade = (profundidade + 1);
			var jogador = ordemDeJogadores.primeiro;
			novaOrdemDeJogadores.push(novaOrdemDeJogadores.shift());
			for (var indice = 0, tamanho = jogadasPossiveis.length; indice < tamanho; indice++) {
				var novoTabuleiro = tabuleiro.clonar();
				novoTabuleiro.receberJogada(jogadasPossiveis[indice].coluna, jogador);
				var minimo = this.calcularMinimo(alfa, beta, novoTabuleiro, novaOrdemDeJogadores, novaProfundidade);
				if (minimo > alfa) {
					alfa = minimo;
				}
				if (this.podar(alfa, beta)) {
					EstrategiaMinimax.podarNodo();
					return alfa;
				}
			}
			return alfa;
		},

		calcularMinimo: function (alfa, beta, tabuleiro, ordemDeJogadores, profundidade) {
			EstrategiaMinimax.processarNodo();
			var jogadasPossiveis = tabuleiro.fornecerJogadasPossiveis();
			if (profundidade >= this.profundidadeMaxima || jogadasPossiveis.vazio()) {
				EstrategiaMinimax.processarNodoFolha();
				return this.calcularFuncaoDeUtilidade(tabuleiro, profundidade);
			}
			var novaOrdemDeJogadores = ordemDeJogadores.clonar();
			var novaProfundidade = (profundidade + 1);
			var jogador = ordemDeJogadores.primeiro;
			novaOrdemDeJogadores.push(novaOrdemDeJogadores.shift());
			for (var indice = 0, tamanho = jogadasPossiveis.length; indice < tamanho; indice++) {
				var novoTabuleiro = tabuleiro.clonar();
				novoTabuleiro.receberJogada(jogadasPossiveis[indice].coluna, jogador);
				var maximo = this.calcularMaximo(alfa, beta, novoTabuleiro, novaOrdemDeJogadores, novaProfundidade);
				if (maximo < beta) {
					beta = maximo;
				}
				if (this.podar(alfa, beta)) {
					EstrategiaMinimax.podarNodo();
					return beta;
				}
			}
			return beta;
		},

		calcularFuncaoDeUtilidade: function (tabuleiro, profundidade) {
			if (tabuleiro.possuiSequenciaVencedora()) {
				var jogadorDesejadoVenceu = tabuleiro.fornecerSequenciasVencedoras().primeiro.primeiro.ocupanteIgual(EstrategiaMinimax.vencedorDesejado);
				return ((this.profundidadeMaxima - profundidade + 1) * ((jogadorDesejadoVenceu) ? 1 : -1));
			} else {
				return 0;
			}
		},

		calcularHeuristica: function () {
			return Number.menosInfinito;
		},

		ordenarJogadasPelaHeuristica: function(jogadas) {
			return jogadas.sort(this.ordenarJogadaPelaHeuristica.vincularEscopo(this));
		},

		ordenarJogadaPelaHeuristica: function (jogadaA, jogadaB) {
			var heuristicaA = this.calcularHeuristica(jogadaA);
			var heuristicaB = this.calcularHeuristica(jogadaB);
			if (heuristicaA > heuristicaB) {
				return -1;
			}
			if (heuristicaA < heuristicaB) {
				return 1;
			}
			return 0;
		},

		podar: function () {
			return false;
		},

		jogar: function () {
			return this.melhorJogada.coluna;
		}
	});

	var MinimaxComPoda = Classe.criar({
		estende: Minimax,

		inicializar: function (tabuleiro, ordemDeJogadores, profundidade) {
			Minimax.prototipo.inicializar.chamarComEscopo(this, tabuleiro, ordemDeJogadores, profundidade);
		},

		podar: function (alfa, beta) {
			return (alfa >= beta);
		}
	});

	var MinimaxComHeuristica = Classe.criar({
		estende: MinimaxComPoda,

		inicializar: function (tabuleiro, ordemDeJogadores, profundidade) {
			MinimaxComPoda.prototipo.inicializar.chamarComEscopo(this, tabuleiro, ordemDeJogadores, profundidade);
		},

		calcularHeuristica: function (jogada, jogador) {
			var heuristica = 0;
			var sequenciasDeVitoria = jogada.selecionarSequenciasPossiveisDeVitoria(jogador);
			for (var indiceDaSequenciaDeVitoria = 0, tamanhoDasSequenciasDeVitoria = sequenciasDeVitoria.length; indiceDaSequenciaDeVitoria < tamanhoDasSequenciasDeVitoria; indiceDaSequenciaDeVitoria++) {
				var heuristicaDaSequenciaDeVitoria = 1;
				var sequenciaDeVitoria = sequenciasDeVitoria[indiceDaSequenciaDeVitoria];
				for (var indiceDaCelula = 0, tamanhoDaSequenciaDeVitoria = sequenciaDeVitoria.length; indiceDaCelula < tamanhoDaSequenciaDeVitoria; indiceDaCelula++) {
					if (sequenciaDeVitoria[indiceDaCelula].ocupada()) {
						heuristicaDaSequenciaDeVitoria++;
					}
				}
				heuristica += heuristicaDaSequenciaDeVitoria;
			}
			return heuristica;
		}
	});

	var MinimaxComHeuristicaA = Classe.criar({
		estende: MinimaxComHeuristica,

		inicializar: function (tabuleiro, ordemDeJogadores, profundidade) {
			MinimaxComHeuristica.prototipo.inicializar.chamarComEscopo(this, tabuleiro, ordemDeJogadores, profundidade);
		},

		calcularHeuristica: function (jogada) {
			return MinimaxComHeuristica.prototipo.calcularHeuristica.chamarComEscopo(this, jogada, EstrategiaMinimax.vencedorDesejado);
		}
	});

	var MinimaxComHeuristicaB = Classe.criar({
		estende: MinimaxComHeuristica,

		inicializar: function (tabuleiro, ordemDeJogadores, profundidade) {
			MinimaxComHeuristica.prototipo.inicializar.chamarComEscopo(this, tabuleiro, ordemDeJogadores, profundidade);
		},

		calcularHeuristica: function (jogada) {
			return MinimaxComHeuristica.prototipo.calcularHeuristica.chamarComEscopo(this, jogada, EstrategiaMinimax.perdedorDesejado);
		}
	});

	var MinimaxComHeuristicaC = Classe.criar({
		estende: MinimaxComHeuristica,

		inicializar: function (tabuleiro, ordemDeJogadores, profundidade) {
			MinimaxComHeuristica.prototipo.inicializar.chamarComEscopo(this, tabuleiro, ordemDeJogadores, profundidade);
		},

		calcularHeuristica: function (jogada) {
			var heuristicaA = MinimaxComHeuristica.prototipo.calcularHeuristica.chamarComEscopo(this, jogada, EstrategiaMinimax.vencedorDesejado);
			var heuristicaB = MinimaxComHeuristica.prototipo.calcularHeuristica.chamarComEscopo(this, jogada, EstrategiaMinimax.perdedorDesejado);
			return (heuristicaA + heuristicaB);
		}
	});

	var EstrategiaMinimax = Classe.criar({});

	EstrategiaMinimax.estender({
		nodosFolhasProcessados: 0,
		nodosProcessados: 0,
		nodosPodados: 0,
		totalDeNodosFolhasProcessados: 0,
		totalDeNodosProcessados: 0,
		totalDeNodosPodados: 0,
		vencedorDesejado: null,
		perdedorDesejado: null,

		fixarEstrategia: function (estrategia) {
			this.prototype = estrategia.prototipo;
			this.prototipo = estrategia.prototipo;
		},

		fixarVencedorDesejado: function (vencedorDesejado) {
			this.vencedorDesejado = vencedorDesejado;
		},

		fixarPerdedorDesejado: function (perdedorDesejado) {
			this.perdedorDesejado = perdedorDesejado;
		},

		reiniciarNodosProcessados: function () {
			this.nodosFolhasProcessados = 0;
			this.nodosProcessados = 0;
			this.nodosPodados = 0;
		},

		processarNodo: function () {
			this.nodosProcessados++;
			this.totalDeNodosProcessados++;
		},

		processarNodoFolha: function () {
			this.nodosFolhasProcessados++;
			this.totalDeNodosFolhasProcessados++;
		},

		podarNodo: function () {
			this.nodosPodados++;
			this.totalDeNodosPodados++;
		}
	});

	global.EstrategiaMinimax = EstrategiaMinimax;
	global.Ligue4Ia = Ligue4Ia;
	global.Minimax = Minimax;
	global.MinimaxComPoda = MinimaxComPoda;
	global.MinimaxComHeuristicaA = MinimaxComHeuristicaA;
	global.MinimaxComHeuristicaB = MinimaxComHeuristicaB;
	global.MinimaxComHeuristicaC = MinimaxComHeuristicaC;
}(this));
