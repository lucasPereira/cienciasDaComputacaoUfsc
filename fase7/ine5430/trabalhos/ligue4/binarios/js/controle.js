/*global Classe*/
/*global EstrategiaMinimax*/
/*global Ligue4Ia*/
/*global Ligue4Modelo*/
/*global Ligue4Visao*/
/*global Linda*/
/*global Minimax*/
/*global MinimaxComHeuristicaA*/
/*global MinimaxComHeuristicaB*/
/*global MinimaxComHeuristicaC*/
/*global MinimaxComPoda*/

(function (global) {
	"use strict";

	var Ligue4Controle = Classe.criarSingleton({
		inicializar: function () {
			this.tratadoresDeCelula = [];
			this.adicionarTratadores();
		},

		adicionarTratadores: function () {
			var tabuleiro = Linda.selecionar("table.tabuleiro");
			tabuleiro.rows.paraCada(function (linha) {
				linha.cells.paraCada(function (celula) {
					var tratador = celula.tratadorDeClique(this.jogar.vincularEscopo(this));
					this.tratadoresDeCelula.push(tratador);
				}, this);
			}, this);
			Linda.selecionar("section.configuracoes button.iniciarIa").tratadorDeClique(this.iniciarIa.vincularEscopo(this));
		},

		adicionarTratadorDeMensagem: function () {
			Linda.selecionar("section.mensagem > p.mensagem").tratadorDeClique(this.fecharMensagem.vincularEscopo(this));
		},

		removerTratadores: function () {
			this.tratadoresDeCelula.paraCada(function (tratador) {
				tratador.remover();
			});
		},

		iniciarIa: function () {
			Linda.selecionar("section.configuracoes button.iniciarIa").disabled = true;
			EstrategiaMinimax.fixarEstrategia(this.obterEstrategia());
			Ligue4Ia.instancia.profundidade = this.obterProfundidade();
			Ligue4Ia.instancia.receberJogada(Ligue4Modelo.instancia.ordemDeJogadores);
		},

		obterProfundidade: function() {
			return Linda.obterPeloNome("profundidade").value.paraInteiro();
		},

		obterEstrategia: function () {
			var estrategias = Linda.obterTodosPeloNome("estrategiaMinimax");
			var estrategiaEscolhida;
			for (var indice = 0, tamanho = estrategias.length; indice < tamanho; indice++) {
				var estrategiaAtual = estrategias[indice];
				if (estrategiaAtual.checked) {
					estrategiaEscolhida = estrategiaAtual;
				}
			}
			estrategiaEscolhida = estrategiaEscolhida.value;
			if (estrategiaEscolhida === "minimax") {
				return Minimax;
			} else if (estrategiaEscolhida === "minimaxComPoda") {
				return MinimaxComPoda;
			} else if (estrategiaEscolhida === "minimaxComHeuristicaA") {
				return MinimaxComHeuristicaA;
			} else if (estrategiaEscolhida === "minimaxComHeuristicaB") {
				return MinimaxComHeuristicaB;
			} else if (estrategiaEscolhida === "minimaxComHeuristicaC") {
				return MinimaxComHeuristicaC;
			}
		},

		jogar: function (evento) {
			Ligue4Modelo.instancia.jogarHumano(evento.target.cellIndex);
		},

		fecharMensagem: function () {
			Ligue4Visao.instancia.limparMensagem();
		}
	});

	global.Ligue4Controle = Ligue4Controle;
}(this));
