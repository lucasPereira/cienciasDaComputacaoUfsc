/*global Classe*/
/*global Ligue4*/
/*global Linda*/

(function (global) {
	"use strict";

	var Ligue4Modelo = Classe.criarSingleton({
		inicializar: function () {
			this.quantidadeDeLinhas = 6;
			this.quantidadeDeColunas = 7;
			this.jogadores = {
				humano: new Jogador("Humano", "humano"),
				computador: new Jogador("Computador", "computador")
			};
			this.tabuleiro = new Tabuleiro(this.quantidadeDeLinhas, this.quantidadeDeColunas);
			this.ordemDeJogadores = [this.jogadores.humano, this.jogadores.computador];
			this.ordemDeJogadores.embaralhar();
		},

		jogar: function (coluna) {
			var jogadorDaVez = this.ordemDeJogadores.primeiro;
			var jogadaRealizada = this.tabuleiro.receberJogada(coluna, jogadorDaVez);
			if (jogadaRealizada) {
				this.verificarFimDeJogo();
				this.ordemDeJogadores.push(this.ordemDeJogadores.shift());
				Ligue4.instancia.atualizarCelula(this.tabuleiro.ultimaJogada);
				Ligue4.instancia.atualizarJogador(this.ordemDeJogadores);
			} else {
				Ligue4.instancia.declararColunaCheia();
			}
			return jogadaRealizada;
		},

		verificarFimDeJogo: function () {
			if (this.tabuleiro.possuiSequenciaVencedora()) {
				Ligue4.instancia.declararVencedor(this.tabuleiro.fornecerSequenciasVencedoras());
			} else if (this.tabuleiro.fimDeCelulas()) {
				Ligue4.instancia.declararEmpate();
			}
		},

		jogarHumano: function (coluna) {
			if (this.humanoPodeJogar()) {
				this.jogar(coluna);
				return true;
			}
			return false;
		},

		jogarComputador: function (coluna) {
			if (this.computadorPodeJogar()) {
				this.jogar(coluna);
				return true;
			}
			return false;
		},

		humanoPodeJogar: function () {
			return (this.ordemDeJogadores.primeiro.igual(this.jogadores.humano) && this.podeJogar());
		},

		computadorPodeJogar: function () {
			return (this.ordemDeJogadores.primeiro.igual(this.jogadores.computador) && this.podeJogar());
		},

		podeJogar: function () {
			return !(this.tabuleiro.possuiSequenciaVencedora() || this.tabuleiro.fimDeCelulas());
		}
	});

	var Tabuleiro = Classe.criar({
		inicializar: function (quantidadeDeLinhas, quantidadeDeColunas, clonagem) {
			this.sequenciasVencedoras = [];
			this.celulas = new Array(this.quantidadeDeLinhas);
			this.quantidadeDeLinhas = quantidadeDeLinhas;
			this.quantidadeDeColunas = quantidadeDeColunas;
			this.quantidadeDeLigacoes = 3;
			this.celulasOcupadas = 0;
			if (Linda.nuloOuIndefinido(clonagem) || !clonagem) {
				this.construirTabuleiro();
			}
			this.ultimaJogada = null;
		},

		clonar: function () {
			var clone = new Tabuleiro(this.quantidadeDeLinhas, this.quantidadeDeColunas, true);
			clone.celulasOcupadas = this.celulasOcupadas;
			this.clonarCelulas(clone);
			this.clonarSequenciasVencedoras(clone);
			return clone;
		},

		clonarCelulas: function (clone) {
			this.celulas.paraCada(function (linha, indiceDaLinha) {
				clone.celulas[indiceDaLinha] = new Array(this.quantidadeDeColunas);
				linha.paraCada(function (celula, indiceDaColuna) {
					clone.celulas[indiceDaLinha][indiceDaColuna] = celula.clonar(clone);
				}, this);
			}, this);
		},

		clonarSequenciasVencedoras: function (clone) {
			this.sequenciasVencedoras.paraCada(function (sequencia) {
				var novaSequencia = [];
				sequencia.paraCada(function (celula) {
					novaSequencia.push(clone.celulas[celula.linha][celula.coluna]);
				});
				clone.sequenciasVencedoras.push(novaSequencia);
			});
		},

		construirTabuleiro: function () {
			for (var indiceDaLinha = 0; indiceDaLinha < this.quantidadeDeLinhas; indiceDaLinha++) {
				this.celulas[indiceDaLinha] = new Array(this.quantidadeDeColunas);
				for (var indiceDaColuna = 0; indiceDaColuna < this.quantidadeDeColunas; indiceDaColuna++) {
					this.celulas[indiceDaLinha][indiceDaColuna] = new Celula(indiceDaLinha, indiceDaColuna, this);
				}
			}
		},

		receberJogada: function (indiceDaColuna, jogador) {
			var celulaAtual = this.fornecerPrimeiraCelulaLivreNaColuna(indiceDaColuna);
			var jogadaPossivel = (celulaAtual.livre() && celulaAtual.dentroDoTabuleiro());
			if (jogadaPossivel) {
				celulaAtual.ocupar(jogador);
				this.celulasOcupadas++;
				this.verificarSequenciaVencedora(celulaAtual);
				this.ultimaJogada = celulaAtual;
			}
			return jogadaPossivel;
		},

		fornecerPrimeiraCelulaDeCimaNaColuna: function (coluna) {
			return this.celulas.primeiro[coluna];
		},

		fornecerPrimeiraCelulaDeBaixoNaColuna: function (coluna) {
			return this.celulas.ultimo[coluna];
		},

		fornecerPrimeiraCelulaLivreNaColuna: function (indiceDaColuna) {
			var celula = this.fornecerPrimeiraCelulaDeBaixoNaColuna(indiceDaColuna);
			while (celula.ocupada()) {
				celula = celula.fornecerAdjacenteTopo();
			}
			return celula;
		},

		fornecerCelula: function (linha, coluna) {
			if (this.celulas.dentroDosLimites(linha) && this.celulas[linha].dentroDosLimites(coluna)) {
				return this.celulas[linha][coluna];
			}
			return new CelulaForaDoTabuleiro(linha, coluna, this);
		},

		verificarSequenciaVencedora: function (celula) {
			this.sequenciasVencedoras.fundir(celula.selecionarSequenciasVencedoras());
		},

		possuiSequenciaVencedora: function () {
			return (!this.sequenciasVencedoras.vazio());
		},

		fornecerSequenciasVencedoras: function () {
			return this.sequenciasVencedoras;
		},

		fimDeCelulas: function () {
			return ((this.quantidadeDeLinhas * this.quantidadeDeColunas) === this.celulasOcupadas);
		},

		fornecerJogadasPossiveis: function () {
			var jogadasPossiveis = [];
			if (!this.possuiSequenciaVencedora()) {
				for (var indiceDaColuna = 0; indiceDaColuna < this.quantidadeDeColunas; indiceDaColuna++) {
					var celulaLivre = this.fornecerPrimeiraCelulaLivreNaColuna(indiceDaColuna);
					if (celulaLivre.dentroDoTabuleiro()) {
						jogadasPossiveis.push(celulaLivre);
					}
				}
			}
			return jogadasPossiveis;
		},

		ultimaJogadaFoi: function (outraCelula) {
			return this.ultimaJogada.igual(outraCelula);
		}
	});

	var Celula = Classe.criar({
		inicializar: function (linha, coluna, tabuleiro) {
			this.linha = linha;
			this.coluna = coluna;
			this.tabuleiro = tabuleiro;
			this.ocupante = null;
		},

		clonar: function (tabuleiro) {
			var clone = new Celula(this.linha, this.coluna, tabuleiro);
			clone.ocupante = this.ocupante;
			return clone;
		},

		igual: function (outra) {
			return (this.linha === outra.linha && this.coluna === outra.coluna);
		},

		livre: function () {
			return (Linda.nulo(this.ocupante));
		},

		liberar: function () {
			this.ocupante = null;
		},

		ocupada: function () {
			return (!Linda.nulo(this.ocupante));
		},

		ocupar: function (jogador) {
			this.ocupante = jogador;
		},

		mesmoOcupante: function (celula) {
			return (this.ocupada() && celula.ocupada() && this.ocupante.igual(celula.ocupante));
		},

		ocupanteIgual: function (ocupante) {
			return (this.ocupada() && this.ocupante.igual(ocupante));
		},

		selecionarSequencias: function (funcaoDeSelecao, argumento) {
			var quantidadeDeLigacoes = this.tabuleiro.quantidadeDeLigacoes;
			var sequencias = [];
			var sequenciasSelecionadas = [];
			sequencias.push(this.fornecerAdjacentesTopo(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacentesFundo(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacentesEsquerda(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacentesDireita(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacentesTopoEsquerda(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacentesTopoDireita(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacentesFundoEsquerda(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacentesFundoDireita(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacenteTopo().fornecerAdjacentesFundo(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacenteFundo().fornecerAdjacentesTopo(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacenteEsquerda().fornecerAdjacentesDireita(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacenteDireita().fornecerAdjacentesEsquerda(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacenteTopoEsquerda().fornecerAdjacentesFundoDireita(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacenteTopoDireita().fornecerAdjacentesFundoEsquerda(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacenteFundoEsquerda().fornecerAdjacentesTopoDireita(quantidadeDeLigacoes));
			sequencias.push(this.fornecerAdjacenteFundoDireita().fornecerAdjacentesTopoEsquerda(quantidadeDeLigacoes));
			sequencias.paraCada(function (sequencia) {
				if (funcaoDeSelecao(sequencia, argumento)) {
					sequenciasSelecionadas.push(sequencia);
				}
			}, this);
			return sequenciasSelecionadas;
		},

		selecionarSequenciasVencedoras: function () {
			return this.selecionarSequencias(this.selecionarSequenciaVencedora.vincularEscopo(this));
		},

		selecionarSequenciaVencedora: function (sequencia) {
			return sequencia.reduzir(function (possuiVencedora, celula) {
				if (celula.foraDoTabuleiro() || !this.mesmoOcupante(celula)) {
					return false;
				}
				return possuiVencedora;
			}, true, this);
		},

		selecionarSequenciasPossiveisDeVitoria: function (jogador) {
			return this.selecionarSequencias(this.selecionarSequenciaPossivelDeVitoria.vincularEscopo(this), jogador);
		},

		selecionarSequenciaPossivelDeVitoria: function (sequencia, jogador) {
			return sequencia.reduzir(function (vitoriaPossivel, celula) {
				if (celula.foraDoTabuleiro() || (celula.ocupada() && !celula.ocupanteIgual(jogador))) {
					return false;
				}
				return vitoriaPossivel;
			}, true, this);
		},

		fornecerAdjacenteTopo: function () {
			return this.fornecerAdjacentes(-1, 0 ,1, true).primeiro;
		},

		fornecerAdjacenteFundo: function () {
			return this.fornecerAdjacentes(1, 0 ,1, true).primeiro;
		},

		fornecerAdjacenteEsquerda: function () {
			return this.fornecerAdjacentes(0, -1 ,1, true).primeiro;
		},

		fornecerAdjacenteDireita: function () {
			return this.fornecerAdjacentes(0, 1 ,1, true).primeiro;
		},

		fornecerAdjacenteTopoEsquerda: function () {
			return this.fornecerAdjacentes(-1, -1 ,1, true).primeiro;
		},

		fornecerAdjacenteTopoDireita: function () {
			return this.fornecerAdjacentes(-1, 1 ,1, true).primeiro;
		},

		fornecerAdjacenteFundoEsquerda: function () {
			return this.fornecerAdjacentes(1, -1 ,1, true).primeiro;
		},

		fornecerAdjacenteFundoDireita: function () {
			return this.fornecerAdjacentes(1, 1 ,1, true).primeiro;
		},

		fornecerAdjacentesTopo: function (quantidade) {
			var adjacentes = this.fornecerAdjacentes(-1, 0, quantidade, true);
			adjacentes.unshift(this);
			return adjacentes;
		},

		fornecerAdjacentesFundo: function (quantidade) {
			var adjacentes = this.fornecerAdjacentes(1, 0, quantidade, true);
			adjacentes.unshift(this);
			return adjacentes;
		},

		fornecerAdjacentesEsquerda: function (quantidade) {
			var adjacentes = this.fornecerAdjacentes(0, -1, quantidade, true);
			adjacentes.unshift(this);
			return adjacentes;
		},

		fornecerAdjacentesDireita: function (quantidade) {
			var adjacentes = this.fornecerAdjacentes(0, 1, quantidade, true);
			adjacentes.unshift(this);
			return adjacentes;
		},

		fornecerAdjacentesTopoEsquerda: function (quantidade) {
			var adjacentes = this.fornecerAdjacentes(-1, -1, quantidade, true);
			adjacentes.unshift(this);
			return adjacentes;
		},

		fornecerAdjacentesTopoDireita: function (quantidade) {
			var adjacentes = this.fornecerAdjacentes(-1, 1, quantidade, true);
			adjacentes.unshift(this);
			return adjacentes;
		},

		fornecerAdjacentesFundoEsquerda: function (quantidade) {
			var adjacentes = this.fornecerAdjacentes(1, -1, quantidade, true);
			adjacentes.unshift(this);
			return adjacentes;
		},

		fornecerAdjacentesFundoDireita: function (quantidade) {
			var adjacentes = this.fornecerAdjacentes(1, 1, quantidade, true);
			adjacentes.unshift(this);
			return adjacentes;
		},

		fornecerAdjacentes: function (incrementoNaLinha, incrementoNaColuna, quantidade, incluirForaDoTabuleiro) {
			var adjacentes = [];
			var linhaAtual = this.linha;
			var colunaAtual = this.coluna;
			for (var contador = 0; contador < quantidade; contador++) {
				linhaAtual += incrementoNaLinha;
				colunaAtual += incrementoNaColuna;
				var adjacente = this.tabuleiro.fornecerCelula(linhaAtual, colunaAtual);
				if (adjacente.dentroDoTabuleiro() || incluirForaDoTabuleiro) {
					adjacentes.push(adjacente);
				}
			}
			return adjacentes;
		},

		foraDoTabuleiro: function () {
			return false;
		},

		dentroDoTabuleiro: function () {
			return true;
		}
	});

	var CelulaForaDoTabuleiro = Classe.criar({
		estende: Celula,

		inicializar: function (linha, coluna, tabuleiro) {
			Celula.prototipo.inicializar.chamarComEscopo(this, linha, coluna, tabuleiro);
		},

		foraDoTabuleiro: function () {
			return true;
		},

		dentroDoTabuleiro: function () {
			return false;
		}
	});

	var Jogador = Classe.criar({
		inicializar: function (nome, identificador) {
			this.nome = nome;
			this.identificador = identificador;
		},

		igual: function (outro) {
			return (this.identificador === outro.identificador);
		}
	});

	global.Ligue4Modelo = Ligue4Modelo;
}(this));
