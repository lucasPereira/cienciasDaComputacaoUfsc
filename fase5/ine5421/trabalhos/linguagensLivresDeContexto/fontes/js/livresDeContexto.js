"use strict";

/**
* Classe: Gramatica
* Descrição: Classe responsável pelo gerenciamento da gramática. 
* Cria a tabela de parsing e reconhece sentenças. 
**/
var Gramatica = new Prototipo({
	/**
	* Função: inicializar
	* Parâmetros:
	* - nome: nome da gramática que será inicializada.
	* Descrição: inicializa uma nova gramática utilizando o nome especificado.
	*/
	inicializar: function(nome) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(nome, String));
		this.nome = nome;
		this.codigo = "";
		this.naoTerminais = {};
		this.terminais = {};
		this.simboloInicial = null;
		this.firsts = {};
		this.follows = {};
		this.tabelaDeParsing = {};
		this.tabelaDeParsingComIndices = {};
		this.fatorada = false;
		this.recursivaAEsquerda = true;
		this.interseccaoDosFirstsEFollowsVazia = false;
		this.adicionarTerminal("$");
	},
	
	/**
	* Função: fixarCodigo
	* Parâmetros:
	* - codigo: código que será atribuído à gramática.
	* Descrição: atribui o código especificado à gramática.
	**/
	fixarCodigo: function(codigo) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(codigo, String));
		this.codigo = codigo;
	},
	
	/**
	* Função: fornecerCodigo
	* Descrição: retorna o código da gramática.
	**/
	fornecerCodigo: function() {
		return this.codigo;
	},
	
	/**
	* Função: codigoVazio
	* Descrição: verifica se o código da gramática é vazio.
	**/
	codigoVazio: function() {
		return this.codigo === "";
	},
	
	/**
	* Função: fornecerNome
	* Descrição: retorna o nome da gramática.
	**/
	fornecerNome: function() {
		return this.nome;
	},
	
	/**
	* Função: fornecerFirsts
	* Descrição: retorna o conjunto de firsts da gramática.
	**/
	fornecerFirsts: function() {
		return this.firsts;
	},
	
	/**
	* Função: fornecerFollows
	* Descrição: retorna o conjunto de follows da gramática.
	**/
	fornecerFollows: function() {
		return this.follows;
	},
	
	/**
	* Função: fornecerTabelaDeParsing
	* Descrição: retorna a tabela de parsing da gramática.
	**/
	fornecerTabelaDeParsing: function() {
		return this.tabelaDeParsing;
	},
	
	/**
	* Função: fornecerTabelaDeParsingComIndices
	* Descrição: retorna a tabela de parsing da gramática.
	**/
	fornecerTabelaDeParsingComIndices: function() {
		return this.tabelaDeParsingComIndices;
	},
	
	/**
	* Função: fixarSimboloInicial
	* Parâmetros:
	* - simbolo: símbolo inicial que será atribuído à gramática
	* Descrição: atribui o símbolo inicial especificado à gramática
	**/
	fixarSimboloInicial: function(simbolo) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(simbolo, String));
		var naoTerminal = this.naoTerminais[simbolo];
		Utilitarios.assegureQueNao(Utilitarios.nuloOuIndefinido(naoTerminal));
		this.simboloInicial = naoTerminal;
	},
	
	/**
	* Função: fornecerNaoTerminal
	* Parâmetros:
	* - simbolo: símbolo que se deseja obter o objeto correspondente.
	* Descrição: retorna o objeto do não terminal com nome = simbolo.
	**/
	fornecerNaoTerminal: function(simbolo) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(simbolo, String));
		return this.naoTerminais[simbolo];
	},
	
	/**
	* Função: adicionarTerminal
	* Parâmetros:
	* - simbolo: símbolo identificador do terminal que se deseja adicionar.
	* Descrição: adiciona um novo símbolo terminal à gramática.
	**/
	adicionarTerminal: function(simbolo) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(simbolo, String));
		Utilitarios.assegureQue(Utilitarios.nuloOuIndefinido(this.naoTerminais[simbolo]));
		var adicionou = false;
		if (Utilitarios.nuloOuIndefinido(this.terminais[simbolo])) {
			this.terminais[simbolo] = new Terminal(simbolo);
			adicionou = true;
		}
		return adicionou;
	},
	
	/**
	* Função: adicionarNaoTerminal
	* Parâmetros:
	* - simbolo: símbolo identificador do não terminal que se deseja adicionar.
	* Descrição: adiciona um novo símbolo não terminal à gramática.
	**/
	adicionarNaoTerminal: function(simbolo) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(simbolo, String));
		Utilitarios.assegureQue(Utilitarios.nuloOuIndefinido(this.terminais[simbolo]));
		var adicionou = false;
		if (Utilitarios.nuloOuIndefinido(this.naoTerminais[simbolo])) {
			var naoTerminal = new NaoTerminal(simbolo);
			this.naoTerminais[simbolo] = naoTerminal;
			if (Utilitarios.nulo(this.simboloInicial)) {
				this.simboloInicial = naoTerminal;
			}
			adicionou = true;
		}
		return adicionou;
	},
	
	/**
	* Função: adicionarProducao
	* Parâmetros:
	*  - simboloNaoTerminal: símbolo identificador do não terminal que deriva a produção.
	*  - simbolosDaProducao: símbolos que serão derivados na produção. 
	* Descrição: adiciona uma nova produção do não terminal especificado por
	* simboloNaoTerminal derivando os símbolos especificados por
	* simbolosDaProducao.
	**/
	adicionarProducao: function(simboloNaoTerminal, simbolosDaProducao) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(simboloNaoTerminal, String));
		Utilitarios.assegureQue(Utilitarios.instanciaDe(simbolosDaProducao, Array));
		var naoTerminal = this.naoTerminais[simboloNaoTerminal];
		Utilitarios.assegureQueNao(Utilitarios.nuloOuIndefinido(naoTerminal));
		var producao = [];
		simbolosDaProducao.paraCada(function(simbolo, indice) {
			var simboloDaProducao = this.naoTerminais[simbolo];
			if (Utilitarios.nuloOuIndefinido(simboloDaProducao)) {
				simboloDaProducao = this.terminais[simbolo];
			}
			Utilitarios.assegureQueNao(Utilitarios.nuloOuIndefinido(simboloDaProducao));
			producao.push(simboloDaProducao);
		}, this);
		if (producao.length > 0) {
			return naoTerminal.adicionarProducao(producao);
		}
		return false;
	},
	
	/**
	* Função: analisar
	* Descrição: verifica se a gramática é LL(1).
	**/
	analisar: function() {
		this.calcularFirsts();
		this.calcularFollows();
		this.construirTabelaDeParsing();
		this.construirTabelaDeParsingComIndices();
		this.possuiRecursaoAEsquerda();
		this.estaFatorada();
		this.possuiIntersecaoDosFirstsEFollowsVaiza();
	},
	
	/**
	* Função: calcularFirsts
	* Descrição: calcula os firsts da gramática, calculando os firsts de cada não terminal.
	**/
	calcularFirsts: function() {
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			this.firsts[simboloDoNaoTerminal] = naoTerminal.fornecerFirsts();
		}, this);
		this.terminais.paraCada(function(terminal, simboloDoTerminal) {
			this.firsts[simboloDoTerminal] = terminal.fornecerFirsts();
		}, this);
	},
	
	/**
	* Função: calcularFollows
	* Descrição: calcula os follows da gramática, calculando os follows de cada não terminal.
	**/
	calcularFollows: function() {
		this.simboloInicial.adicionarFollows({"$": this.terminais["$"]});
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			naoTerminal.fornecerProducoes().paraCada(function(producao, indiceDaProducao) {
				var indiceDoSimboloDaProducao = 0;
				while (indiceDoSimboloDaProducao < producao.length) {
					var simboloAtualDaProducao = producao[indiceDoSimboloDaProducao];
					if (++indiceDoSimboloDaProducao < producao.length && Utilitarios.instanciaDe(simboloAtualDaProducao, NaoTerminal)) {
						var indiceDoSimboloDaProducaoSalvo = indiceDoSimboloDaProducao;
						do {
							var proximoSimboloDaProducao = producao[indiceDoSimboloDaProducao];
							if (!proximoSimboloDaProducao.epsilon()) {
								simboloAtualDaProducao.adicionarFollows(proximoSimboloDaProducao.fornecerFirsts());
							}
						} while (++indiceDoSimboloDaProducao < producao.length && Utilitarios.instanciaDe(simboloAtualDaProducao, NaoTerminal) && proximoSimboloDaProducao.derivaEpsilonEmZeroOuMaisPassos());
						indiceDoSimboloDaProducao = indiceDoSimboloDaProducaoSalvo;
					}
				}
			}, this);
		}, this);
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			this.follows[simboloDoNaoTerminal] = naoTerminal.fornecerFollows();
		}, this);
	},
	
	/**
	* Função: construirTabelaDeParsing
	* Descrição: constrói a tabela de parsing LL(1) da gramática.
	**/
	construirTabelaDeParsing: function() {
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			this.tabelaDeParsing[simboloDoNaoTerminal] = {};
			this.terminais.paraCada(function(terminal, simboloDoTerminal) {
				if (!terminal.epsilon()) {
					this.tabelaDeParsing[simboloDoNaoTerminal][simboloDoTerminal] = [];
				}
			}, this);
		}, this);
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			naoTerminal.fornecerProducoes().paraCada(function(producao, indiceDaProducao) {
				var indice = 0;
				var firstsAvaliados = [];
				do {
					producao[indice].fornecerFirsts().paraCada(function(firstDaProducao, simboloDoFirstDaProducao) {
						if (!firstDaProducao.epsilon() && !firstsAvaliados.contem(simboloDoFirstDaProducao)) {
							firstsAvaliados.push(simboloDoFirstDaProducao);
							this.tabelaDeParsing[simboloDoNaoTerminal][simboloDoFirstDaProducao].push(producao); 
						} 
					}, this);
				} while (producao[indice++].derivaEpsilonEmZeroOuMaisPassos() && indice < producao.length);
				if (indice === producao.length && producao[--indice].derivaEpsilonEmZeroOuMaisPassos()) {
					naoTerminal.fornecerFollows().paraCada(function(followDoNaoTerminal, simboloDoFollowDoNaoTerminal) {
						this.tabelaDeParsing[simboloDoNaoTerminal][simboloDoFollowDoNaoTerminal].push(producao);
					}, this);
				}
			}, this);
		}, this);
	},
	
	/**
	* Função: construirTabelaDeParsingComIndices
	* Descrição: constrói a tabela de parsing LL(1) da gramática com o indíces das produções
	* ao invés das produções.
	**/
	construirTabelaDeParsingComIndices: function() {
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			this.tabelaDeParsingComIndices[simboloDoNaoTerminal] = {};
			this.terminais.paraCada(function(terminal, simboloDoTerminal) {
				if (!terminal.epsilon()) {
					this.tabelaDeParsingComIndices[simboloDoNaoTerminal][simboloDoTerminal] = [];
				}
			}, this);
		}, this);
		var indiceDaProducaoNaGramatica = 1;
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			naoTerminal.fornecerProducoes().paraCada(function(producao, indiceDaProducao) {
				var indice = 0;
				var firstsAvaliados = [];
				do {
					producao[indice].fornecerFirsts().paraCada(function(firstDaProducao, simboloDoFirstDaProducao) {
						if (!firstDaProducao.epsilon() && !firstsAvaliados.contem(simboloDoFirstDaProducao)) {
							firstsAvaliados.push(simboloDoFirstDaProducao);
							this.tabelaDeParsingComIndices[simboloDoNaoTerminal][simboloDoFirstDaProducao].push(indiceDaProducaoNaGramatica); 
						} 
					}, this);
				} while (producao[indice++].derivaEpsilonEmZeroOuMaisPassos() && indice < producao.length);
				if (indice === producao.length && producao[--indice].derivaEpsilonEmZeroOuMaisPassos()) {
					naoTerminal.fornecerFollows().paraCada(function(followDoNaoTerminal, simboloDoFollowDoNaoTerminal) {
						this.tabelaDeParsingComIndices[simboloDoNaoTerminal][simboloDoFollowDoNaoTerminal].push(indiceDaProducaoNaGramatica);
					}, this);
				}
				indiceDaProducaoNaGramatica++;
			}, this);
		}, this);
	},
	
	/**
	* Função: estaFatorada
	* Descrição: verifica se a gramática está fatorada, verificando se cada símbolo 
	* não terminal está fatorado.
	**/
	estaFatorada: function() {
		this.fatorada = true;
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			if (!naoTerminal.estaFatorado()) {
				this.fatorada = false;
				return
			}
		}, this);
		return this.fatorada;
	},
	
	/**
	* Função: possuiRecursaoAEsquerda
	* Descrição: verifica se a gramática possui recursão à esquerda, 
	* verificando se cada símbolo não terminal possui recursão à esquerda
	**/
	possuiRecursaoAEsquerda: function() {
		this.recursivaAEsquerda = false;
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			if (naoTerminal.possuiRecursaoAEsquerda()) {
				this.recursivaAEsquerda = true;
				return;
			}
		}, this);
		return this.recursivaAEsquerda;
	},
	
	/**
	* Função: possuiIntersecaoDosFirstsEFollowsVazia
	* Descrição: verifica se First(A) ^ Follow(A) = & para todo A | A =>* &
	**/
	possuiIntersecaoDosFirstsEFollowsVaiza: function() {
		this.interseccaoDosFirstsEFollowsVazia = true;
		this.naoTerminais.paraCada(function(naoTerminal, simboloDoNaoTerminal) {
			if (!naoTerminal.possuiInterseccaoDoFirstEFollowVazia()) {
				this.interseccaoDosFirstsEFollowsVazia = false;
				return;
			}
		}, this);
		return this.interseccaoDosFirstsEFollowsVazia;
	},
	
	
	/**
	* Funcao: reconhecer
	* Descrição: verifica se uma dada sentença é faz parte da linguagem 
	* especificada pela gramática. 
	**/
	reconhecer: function(sentenca) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(sentenca, String));
		var resposta = new RespostaDeReconhecimento(sentenca);
		if (this.fatorada && !this.recursivaAEsquerda && this.interseccaoDosFirstsEFollowsVazia) {
			var estadoDeErro = false;
			var pilha = [];
			var topoDaPilha = null; 
			var simboloAtual = null;
			pilha.push(this.terminais["$"], this.simboloInicial);
			if (sentenca === "") {
				sentenca = [];
			} else {
				sentenca = sentenca.split(" ");
			}
			sentenca.push("$");
			simboloAtual = sentenca[0];
			while (pilha.length > 0 && sentenca.length > 0 && !estadoDeErro) {
				topoDaPilha = pilha.pop();
				if (Utilitarios.instanciaDe(topoDaPilha, NaoTerminal)) {
					var novoTopo = this.tabelaDeParsing[topoDaPilha.simbolo][simboloAtual];
					if (!Utilitarios.nuloOuIndefinido(novoTopo) && novoTopo.length === 1) {
						novoTopo = novoTopo[0].reverse();
						pilha.push.apply(pilha, novoTopo);
						novoTopo.reverse();
					} else {
						estadoDeErro = true;
					}
				} else {
					if (!topoDaPilha.epsilon()) {
						if (topoDaPilha.simbolo === simboloAtual) {
							sentenca.shift();
							simboloAtual = sentenca[0];
						} else {
							estadoDeErro = true;
						}
					}
				}
			}
			if (!estadoDeErro && pilha.length === 0 && sentenca.length === 0) {
				resposta.reconhecer();
			} else {
				resposta.naoReconhecer(true, topoDaPilha, simboloAtual);
			}
		} else {
			resposta.naoReconhecer(false);
		}
		return resposta;
	}
});

/**
* Classe: ResopostaDeReconhecimento
* Descrição: classe que agrega o resultado do reconhecimento 
* de uma sentença em uma determinada gramática.
**/
var RespostaDeReconhecimento = new Prototipo({
	/**
	* Funcao: inicializar
	* Parâmetros:
	* - sentenca: sentenca que foi submetida ao reconhecimento.
	* Descrição: inicializa os dados a resposta.
	**/
	inicializar: function(sentenca) {
		this.sentenca = sentenca;
		this.reconheceu = false;
		this.tabelaDeParsingDeterministica = true;
		this.simboloEsperado = null;
		this.simboloRecebido = null;
	},
	
	/**
	* Função: reconhecer
	* Descrição: resposta de uma sentença que foi reconhecida por uma gramática.
	**/
	reconhecer: function() {
		this.reconheceu = true;
		this.tabelaDeParsingDeterministica = true;
		this.simboloEsperado = null;
	},
	
	/**
	* Função: reconhecer
	* Parâmetros:
	* - tabelaDeParsingDeterministica: indica se a gramática é LL(1).
	* - simboloEsperado: o símbolo que era esperado no momento em que a sentença foi invalidada.
	* - simboloRecebido: o símbolo fez a sentença ser inválidada.
	* Descrição: resposta de uma sentença não foi reconhecida por uma gramática, ou
	* porque a gramática não é LL(1) ou porque a sentença não faz parte da linguagem
	* especificada pela gramática.
	**/
	naoReconhecer: function(tabelaDeParsingDeterministica, simboloEsperado, simboloRecebido) {
		this.reconheceu = false;
		this.tabelaDeParsingDeterministica = tabelaDeParsingDeterministica;
		if (tabelaDeParsingDeterministica) {
			this.simboloEsperado = simboloEsperado;
			this.simboloRecebido = simboloRecebido;
		} else {
			this.simboloEsperado = null;
			this.simboloRecebido = null;
		}
	},
});

/**
* Classe: NaoTerminal
* Descrição: classe responsável por representar um símbolo não terminal de uma gramática. 
**/
var NaoTerminal = new Prototipo({
	/**
	* Função: inicializar
	* Parâmetros:
	* - simbolo: simbolo do não terminal que será inicializado.
	* Descrição: inicializa um novo símbolo não terminal utilizando o símbolo especificado.
	**/
	inicializar: function(simbolo) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(simbolo, String));
		this.simbolo = simbolo;
		this.producoes = [];
		this.firsts = null;
		this.follows = null;
		this.recursivoAEsquerda = false;
		this.receptoresDosFirsts = {};
		this.verificandoSeDerivaEpsilon = false;
		this.calculandoFirsts = false;
	},
	
	/**
	* Função: fornecerProducoes
	* Descrição: retorna o conjunto de produções do não terminal.
	**/	
	fornecerProducoes: function() {
		return this.producoes;
	},
	
	/**
	* Função: adicionarProducao.
	* Parâmetros:
	* - simbolos: símbolos que serão derivados na producão.
	* Descrição: adiciona uma produção derivando os símbolos especificados por simbolos
	* ao não terminal.
	**/
	adicionarProducao: function(simbolos) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(simbolos, Array));
		var combinou = false;
		this.producoes.paraCada(function(producao, indiceDaProducao) {
			if (simbolos.length === producao.length) {
				var combinouUmaProducao = true;
				producao.paraCada(function(simbolo, indiceDoSimbolo) {
					var simboloDaNovaProducao = simbolos[indiceDoSimbolo];
					if (simbolo !== simboloDaNovaProducao) {
						combinouUmaProducao = false;
					}
				});
				if (combinouUmaProducao) {
					combinou = true;
				}
			}
		}, this);
		if (!combinou) {
			simbolos.toString = function() {
				return this.join(" ");
			};
			this.producoes.push(simbolos);
		}
		return !combinou;
	},
	
	/**
	* Função: fornecerFirsts
	* Descrição: retorna o conjunto first do não terminal.
	**/
	fornecerFirsts: function() {
		if (Utilitarios.nulo(this.firsts)) {
			this.calcularFirsts(this);
		}
		return this.firsts;
	},
	
	/**
	* Função: fornecerFollows
	* Descrição: retorna o conjunto follow do não terminal.
	**/
	fornecerFollows: function() {
		if (Utilitarios.nulo(this.follows)) {
			return {};
		}
		return this.follows;
	},
	
	/**
	* Função: calcularFirsts
	* Parâmetros:
	* - receptorDosFirsts: conjunto que armazenará os símbolos first calculados.
	* Descrição: calcula o conjunto first do não terminal, já fazendo a verificação
	* se existe recursão à esquerda.
	**/
	calcularFirsts: function(receptorDosFirsts) {
		if (Utilitarios.nulo(this.firsts)) {
			this.calculandoFirsts = true;
			this.firsts = {};
			this.producoes.paraCada(function(producao, indiceDaProducao) {
				var indiceDoSimbolo = 0;
				var proximoSimbolo = producao[indiceDoSimbolo];
					var anteriorDerivaEpsilon = false;
					var firstsDoProximoSimbolo = {};
					do {
						firstsDoProximoSimbolo = proximoSimbolo.calcularFirsts(this);
						anteriorDerivaEpsilon = proximoSimbolo.derivaEpsilonEmZeroOuMaisPassos();
						firstsDoProximoSimbolo.paraCada(function(novoFirst, chaveDoNovoFirst) {
							if (!novoFirst.epsilon() || proximoSimbolo.epsilon()) {
								this.firsts[chaveDoNovoFirst] = novoFirst;
							}
						}, this);
						proximoSimbolo = producao[++indiceDoSimbolo];
					} while (anteriorDerivaEpsilon && indiceDoSimbolo < producao.length);
					if (anteriorDerivaEpsilon && indiceDoSimbolo === producao.length) {
						this.firsts["&"] = firstsDoProximoSimbolo["&"];
					}
			}, this);
			this.propagarFirsts();
			this.calculandoFirsts = false;
		} else {
			this.receptoresDosFirsts[receptorDosFirsts.simbolo] = receptorDosFirsts;
			if (this.calculandoFirsts) {
				this.recursivoAEsquerda = true;
			}
		}
		return this.firsts;
	},

	/**
	* Função: propagarFirsts
	* Descrição: caso o símbolo tenha o seu conjunto de firsts atualizado, então
	* ele propagará os seus firsts para os símbolos que possuem como firsts os firsts desse NaoTerminal.
	* Essa função será usada sempre quando houver recursão à esquerda ou um ciclo na gramática.
	**/
	propagarFirsts: function() {
		this.receptoresDosFirsts.paraCada(function(receptorDosFirsts, simboloDoReceptorDosFirsts) {
			receptorDosFirsts.adicionarFirsts(this.firsts);
		}, this);
	},

	/**
	* Função: adicionarFirsts
	* Parâmetros:
	* - novosFirsts: conjunto com os novos firts a serem adicionados
	* Descrição: adiciona ao conjunto first os símbolos de novosFirsts
	**/
	adicionarFirsts: function(novosFirsts) {
		var adicionouNovosFirsts = false;
		novosFirsts.paraCada(function(novoFirst, simboloDoNovoFirst) {
			if (Utilitarios.nuloOuIndefinido(this.firsts[simboloDoNovoFirst])) {
				adicionouNovosFirsts = true;
				this.firsts[simboloDoNovoFirst] = novoFirst;
			}
		}, this);
		if (adicionouNovosFirsts) {
			this.propagarFirsts();
		}
	},
	
	/**
	* Função: propagarFirsts
	* Descrição: caso o símbolo tenha o seu conjunto de follows atualizado, então
	* ele propagará os seus follows para os símbolos que possuem como follows os follows desse NaoTerminal.
	**/
	propagarFollows: function() {
		this.producoes.paraCada(function(producao, indiceDaProducao) {
			var encontrouOUltimoNaoTerminalReceptor = false;
			var encontrouUmTerminal = false;
			var indiceDoSimboloDaProducao = producao.length - 1;
			while (indiceDoSimboloDaProducao >= 0 && !encontrouOUltimoNaoTerminalReceptor && !encontrouUmTerminal) {
				var simboloDaProducao = producao[indiceDoSimboloDaProducao--];
				if (Utilitarios.instanciaDe(simboloDaProducao, Terminal)) {
					encontrouUmTerminal = true;
				} else {
					simboloDaProducao.adicionarFollows(this.follows);
					if (!simboloDaProducao.derivaEpsilonEmZeroOuMaisPassos()) {
						encontrouOUltimoNaoTerminalReceptor = true;
					}
				}
			}
		}, this);
	},

	/**
	* Função: adicionarFollows
	* Parâmetros:
	*  - novosFollows: conjunto com os novos follows a serem adicionados.
	* Descrição: adiciona ao conjunto follow os símbolos de novosFollows.
	**/
	adicionarFollows: function(novosFollows) {
		if (Utilitarios.nulo(this.follows)) {
			this.follows = {};
		}
		var adicionouNovosFollows = false;
		novosFollows.paraCada(function(novoFollow, simboloDoNovoFollow) {
			if (Utilitarios.nuloOuIndefinido(this.follows[simboloDoNovoFollow]) && !novoFollow.epsilon()) {
				adicionouNovosFollows = true;
				this.follows[simboloDoNovoFollow] = novoFollow;
			}
		}, this);
		if (adicionouNovosFollows) {
			this.propagarFollows();
		}
	},
	
	/**
	* Função: estaFatorado
	* Descrição: verifica se o símbolo não terminal está fatorado.
	**/
	estaFatorado: function() {
		this.fornecerFirsts();
		var firstsDasProducoes = {};
		var fatorado = true;
		this.producoes.paraCada(function(producao, indiceDaProducao) {
			producao[0].fornecerFirsts().paraCada(function(firstDaProducao, simboloDoFirstDaProducao) {
				if (Utilitarios.nuloOuIndefinido(firstsDasProducoes[simboloDoFirstDaProducao])) {
					if (!firstDaProducao.epsilon()) {
						firstsDasProducoes[simboloDoFirstDaProducao] = firstDaProducao;
					}
				} else {
					fatorado = false;
					return
				}
			});
		});
		return fatorado;
	},
	
	/**
	* Função: possuiRecursaoAEsquerda
	* Descrição: verifica se o símbolo não terminal possui recursão à esquerda
	**/
	possuiRecursaoAEsquerda: function() {
		if (!this.recursivoAEsquerda) {
			this.producoes.paraCada(function(producao, indiceDaProducao) {
				var indiceDoSimboloDaProducao = 0;
				var antecessoresDerivamEpsilon = true;
				while (indiceDoSimboloDaProducao < producao.length && antecessoresDerivamEpsilon && !this.recursivoAEsquerda) {
					var simboloDaProducao = producao[indiceDoSimboloDaProducao++];
					if (simboloDaProducao !== this) {
						antecessoresDerivamEpsilon = simboloDaProducao.derivaEpsilonEmZeroOuMaisPassos();
					} else {
						this.recursivoAEsquerda = true;
						return;
					}
				}
			}, this);
		}
		return this.recursivoAEsquerda;
	},
	
	/**
	* Função: possuiIntersecaoDosFirstsEFollowsVazia
	* Descrição: verifica se First(A) ^ Follow(A) = & para o não terminal.
	**/
	possuiInterseccaoDoFirstEFollowVazia: function() {
		var interseccaoDoFirstEFollowVazia = true;
		if (this.derivaEpsilonEmZeroOuMaisPassos()) {
			this.fornecerFirsts().paraCada(function(first, simboloDoFirst) {
				if (!Utilitarios.nuloOuIndefinido(this.fornecerFollows()[simboloDoFirst])) {
					interseccaoDoFirstEFollowVazia = false;
					return;
				}
			}, this);
			this.fornecerFollows().paraCada(function(follow, simboloDoFollow) {
				if (!Utilitarios.nuloOuIndefinido(this.fornecerFirsts()[simboloDoFollow])) {
					interseccaoDoFirstEFollowVazia = false;
					return;
				}
			}, this);
		}
		return interseccaoDoFirstEFollowVazia;
	},
	
	/**
	* Função: derivaEpsilonEmZeroOuMaisPassos
	* Descrição: verifica se o não terminal deriva & em zero ou mais passos.
	**/
	derivaEpsilonEmZeroOuMaisPassos: function() {
		var derivaEpsilon = !Utilitarios.nuloOuIndefinido(this.fornecerFirsts()["&"]);
		if (!derivaEpsilon) {
			this.producoes.paraCada(function(producao, indiceDaProducao) {
				if (producao.length === 1 && producao[0].epsilon()) {
					derivaEpsilon = true;
					return;
				}
			});
		}
		if (!derivaEpsilon && !this.verificandoSeDerivaEpsilon) {
			this.verificandoSeDerivaEpsilon = true;
			this.producoes.paraCada(function(producao, indiceDaProducao) {
				var producaoDerivaEpsilon = true;
				producao.paraCada(function(simboloDaProducao, indiceDoSimboloDaProducao) {
					if (!simboloDaProducao.derivaEpsilonEmZeroOuMaisPassos()) {
						producaoDerivaEpsilon = false;
						return;
					}
				});
				if (producaoDerivaEpsilon) {
					derivaEpsilon = true;
					return;
				}
			});
			this.verificandoSeDerivaEpsilon = false;
		}
		return derivaEpsilon;
	},
	
	/**
	* Função: epsilon
	* Descrição: verifica se o símbolo é o terminal epsilpon. Como este símbo é um NaoTerminal, 
	* então essa função sempre retornará falso.
	**/
	epsilon: function() {
		return false;
	},
	
	/**
	* Função: toString
	* Descrição: retorna o string correspondente ao não terminal.
	**/
	toString: function() {
		return this.simbolo;
	}
});

/**
* Classe: NaoTerminal
* Descrição: classe responsável por representar um símbolo terminal de uma gramática. 
**/
var Terminal = new Prototipo({
	/**
	* Função: inicializar
	* Parâmetros:
	*  - simbolo: simbolo do terminal que será inicializado.
	* Descrição: inicializa um novo símbolo terminal utilizando o símbolo especificado.
	**/
	inicializar: function(simbolo) {
		Utilitarios.assegureQue(Utilitarios.instanciaDe(simbolo, String));
		this.simbolo = simbolo;
	},
	
	/**
	* Função: fornecerFirsts
	* Descrição: retorna o conjunto first do terminal.
	**/
	fornecerFirsts: function() {
		return this.calcularFirsts();
	},
	
	/**
	* Função: calcularFirsts
	* Descrição: calcula o conjunto first do terminal.
	**/
	calcularFirsts: function() {
		var firsts = {};
		firsts[this.simbolo] = this;
		return firsts;
	},
	
	/**
	* Função: derivaEpsilonEmZeroOuMaisPassos
	* Descrição: verifica se o terminal deriva & em zero ou mais passos.
	**/
	derivaEpsilonEmZeroOuMaisPassos: function() {
		return this.epsilon();
	},
	
	/**
	* Função: epsilon
	* Descrição: verifica se o símbolo não terminal é &.
	**/
	epsilon: function() {
		return (this.simbolo === "&");
	},
	
	/**
	* Função: toString
	* Descrição: retorna o string correspondente ao terminal.
	**/
	toString: function() {	
		return this.simbolo;
	}
});
