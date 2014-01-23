/*global Classe*/
/*global Ligue4Controle*/
/*global Ligue4Ia*/
/*global Ligue4Modelo*/
/*global Ligue4Visao*/
/*global Linda*/
/*global TratadorDePagina*/

(function (global) {
	"use strict";

	var Ligue4 = Classe.criarSingleton({
		inicializar: function () {
			new TratadorDePagina().paraCarregamento(this.inicializarModulos.vincularEscopo(this));
		},

		inicializarModulos: function () {
			Ligue4Modelo.instancia();
			Ligue4Visao.instancia();
			Ligue4Ia.instancia();
			Ligue4Controle.instancia();
			Ligue4Visao.instancia.atualizarJogadorDaVez(Ligue4Modelo.instancia.ordemDeJogadores);
		},

		atualizarCelula: function (celula) {
			Ligue4Visao.instancia.atualizarCelula(celula);
		},

		atualizarJogador: function (ordemDeJogadores) {
			Ligue4Visao.instancia.atualizarJogadorDaVez(ordemDeJogadores);
			Ligue4Visao.instancia.atualizarContagemDosNodos();
			Linda.janela.setTimeout(function () {
				Ligue4Ia.instancia.receberJogada(ordemDeJogadores);
			}, 10);
		},

		declararVencedor: function (sequenciasVencedoras) {
			Ligue4Visao.instancia.declararVencedor(sequenciasVencedoras);
			Ligue4Controle.instancia.removerTratadores();
		},

		declararEmpate: function () {
			Ligue4Visao.instancia.declararEmpate();
			Ligue4Controle.instancia.removerTratadores();
		},

		declararColunaCheia: function () {
			Ligue4Visao.instancia.declararColunaCheia();
		}
	});
	Ligue4.instancia();

	global.Ligue4 = Ligue4;
}(this));
