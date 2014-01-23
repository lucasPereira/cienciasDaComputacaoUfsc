/*global Classe*/
/*global EstrategiaMinimax*/
/*global Ligue4Controle*/
/*global Ligue4Modelo*/
/*global Linda*/

(function (global) {
	"use strict";

	var Ligue4Visao = Classe.criarSingleton({
		inicializar: function () {
			this.construirTabuleiro();
		},

		construirTabuleiro: function () {
			var tabuleiro = Linda.selecionar("table.tabuleiro");
			var templateLinhaDoTabuleiro = Linda.selecionar("template.linhaDoTabuleiro").content;
			var linhaDoTabuleiro = templateLinhaDoTabuleiro.selecionar("tr.linhaDoTabuleiro");
			var templateCelulaDoTabuleiro = linhaDoTabuleiro.selecionar("template.celulaDoTabuleiro").content;
			var quantidadeDeLinhas = Ligue4Modelo.instancia.quantidadeDeLinhas;
			var quantidadeDeColunas = Ligue4Modelo.instancia.quantidadeDeColunas;
			for (var indiceDaLinha = 0; indiceDaLinha < quantidadeDeLinhas; indiceDaLinha++) {
				for (var indiceDaColuna = 0; indiceDaColuna < quantidadeDeColunas; indiceDaColuna++) {
					linhaDoTabuleiro.appendChild(templateCelulaDoTabuleiro.cloneNode(true));
				}
				tabuleiro.appendChild(templateLinhaDoTabuleiro.cloneNode(true));
				linhaDoTabuleiro.limpar();
			}
		},

		atualizarContagemDosNodos: function () {
			Linda.selecionar("section.estatisticas > ul > li > span.nodosProcessados").textContent = EstrategiaMinimax.nodosProcessados;
			Linda.selecionar("section.estatisticas > ul > li > span.nodosFolhasProcessados").textContent = EstrategiaMinimax.nodosFolhasProcessados;
			Linda.selecionar("section.estatisticas > ul > li > span.nodosPodados").textContent = EstrategiaMinimax.nodosPodados;
			Linda.selecionar("section.estatisticas > ul > li > span.totalDeNodosProcessados").textContent = EstrategiaMinimax.totalDeNodosProcessados;
			Linda.selecionar("section.estatisticas > ul > li > span.totalDeNodosFolhasProcessados").textContent = EstrategiaMinimax.totalDeNodosFolhasProcessados;
			Linda.selecionar("section.estatisticas > ul > li > span.totalDeNodosPodados").textContent = EstrategiaMinimax.totalDeNodosPodados;
		},

		atualizarCelula: function (celula) {
			var elementoCelula = Linda.selecionar("table.tabuleiro").rows[celula.linha].cells[celula.coluna];
			var textoUltimaJogada = Linda.selecionar("section.informacoesDoJogo > p.ultimaJogada > span.ultimaJogada");
			elementoCelula.classList.add(celula.ocupante.identificador);
			textoUltimaJogada.textContent = String.formatar("coluna %@, linha %@", celula.coluna + 1, celula.linha + 1);
		},

		atualizarJogadorDaVez: function (ordemDeJogadores) {
			var jogadorDaVez = ordemDeJogadores.primeiro;
			var itensJogadores = Linda.selecionarTodos("ul.jogadores > li");
			for (var indice = 0, tamanho = itensJogadores.length; indice < tamanho; indice++) {
				itensJogadores[indice].classList.remove("jogadorDaVez");
			}
			Linda.selecionar(String.formatar("ul.jogadores > li.%@", jogadorDaVez.identificador)).classList.add("jogadorDaVez");
		},

		declararVencedor: function (sequenciasVencedoras) {
			this.mostrarMensagem(String.formatar("O jogador %@ venceu.", sequenciasVencedoras.primeiro.primeiro.ocupante.nome));
		},

		declararEmpate: function () {
			this.mostrarMensagem("O jogo empatou. Ninguém venceu :-(");
		},

		declararColunaCheia: function () {
			this.mostrarMensagem("A coluna está cheia. Escolha outra.");
		},

		limparMensagem: function (secaoMensagem) {
			secaoMensagem = secaoMensagem || Linda.selecionar("section.mensagem");
			var mensagens = secaoMensagem.selecionarTodos("p.mensagem");
			mensagens.paraCada(function (mensagem) {
				mensagem.remove();
			});
		},

		mostrarMensagem: function (mensagem) {
			var secaoMensagem = Linda.selecionar("section.mensagem");
			var templateMensagem = Linda.selecionar("template.mensagem").content;
			this.limparMensagem(secaoMensagem);
			templateMensagem.selecionar("p.mensagem").textContent = mensagem;
			secaoMensagem.appendChild(templateMensagem.cloneNode(true));
			Ligue4Controle.instancia.adicionarTratadorDeMensagem();
		}
	});

	global.Ligue4Visao = Ligue4Visao;
}(this));
