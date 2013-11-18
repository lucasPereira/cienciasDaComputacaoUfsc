var ConjuntoDeAutomatosFinitos = {};

var AutomatoFinito = new Prototipo({
	/**
	 * Função: inicializar
	 * Descrição: inicializa as estruturas do autômato finito: estados, alfabeto, estadoInicial,
	 * estadosFinais e transicoes
	 */
	inicializar: function() {
		this.estados = {"!": new Estado("!")};
		this.alfabeto = {};
		this.estadosFinais = [];
		this.estadoInicial = this.estados["!"];
		this.transicoes = {"!": {}};
		this.estados["!"].serInicial();
	}
});

var TransicaoDeEstado = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros:
	 * 	- estadoDeOrigem: estado que o autômato está no momento da transição
	 * 	- estadoDeDestino: etado para o qual o autômato irá após a transição
	 * 	- símboloDeTransição: símbolo do alfabeto lido para executar a transição
	 * Descrição: inicializa uma transição de estado, fixando seu estado de origem,
	 * estado de destino e símbolo de transição
	 */
	inicializar: function(estadoDeOrigem, estadosDeDestino, simboloDeTransicao) {
		this.estadoDeOrigem = estadoDeOrigem;
		this.estadosDeDestino = estadosDeDestino.sort();
		this.simboloDeTransicao = simboloDeTransicao;
	},
	
	/**
	 * Função: toString
	 * Descrição: fornece um string que descreve a transição de estado
	 */
	toString: function() {
		return this.estadosDeDestino.join(", ");
	}
});

var Estado = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros:
	 * 	- simbolo: símbolo que representa o estado
	 * Descrição: inicializa um estado do autômato a partir do símbolo
	 * passado como parâmetro como não inicial e não final
	 */
	inicializar: function(simbolo) {
		this.simbolo = simbolo;
		this.inicial = false;
		this.final = false;
	},
	
	/**
	 * Função: toString
	 * Descrição: fornece um string que descreve o estado
	 */
	toString: function() {
		return this.simbolo;
	},
	
	/**
	 * Função: serInicial
	 * Descrição: fixa o estado como inicial
	 */
	serInicial: function() {
		this.inicial = true;
	},
	
	/**
	 * Função: serFinal
	 * Descrição: fixa o estado como final
	 */
	serFinal: function() {
		this.final = true;
	},
	
	/**
	 * Função: deixarDeSerInicial
	 * Descrição: fixa o estado como não inicial
	 */ 
	 deixarDeSerInicial: function() {
		 this.inicial = false;
	 },
	 
	 /**
	 * Função: deixarDeSerFinal
	 * Descrição: fixa o estado como não final
	 */
	 deixarDeSerFinal: function() {
		 this.final = false;
	 }
});

var Simbolo = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros:
	 * 	- simbolo: símbolo que será criado
	 * Descrição: inicializa um símbolo a partir do parâmetro passado
	 */
	inicializar: function(simbolo) {
		this.simbolo = simbolo;
	},
	
	/**
	 * Função: toString
	 * Descrição: fornece um string que descreve o símbolo
	 */
	toString: function() {
		return this.simbolo;
	}
});

var AutomatosFinitos = {
	/**
	 * Função: criar
	 * Parâmetros:
	 * 	- nome: nome do autômato a ser criado
	 * Descrição: cria um novo autômato e o adiciona no conjunto de autômatos,
	 * caso ele já não exista
	 */	
	criar: function(nome) {
		if (ConjuntoDeAutomatosFinitos[nome] === undefined) {
			ConjuntoDeAutomatosFinitos[nome] = new AutomatoFinito();
			return true;
		} 
		return false;
	},
	
	/**
	 * Função: fornecer
	 * Parâmetros:
	 * 	- nome: nome do autômato a ser fornecido
	 * Descrição: fornece o autômato com o nome pedido
	 */
	fornecer: function(nome) {
		return ConjuntoDeAutomatosFinitos[nome];
	},
	
	/**
	 * Função: adicionarEstado
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato em que será adicionado um novo estado
	 * 	- chaveDoEstado: chave identificadora do estado a ser adicionado
	 * Descrição: adiciona um novo estado no autômato de nome nomeDoAutomato
	 * com a chave especificada por chaveDoEstado e cria uma nova transição
	 * deste estado para cada símbolo do alfabeto
	 */
	adicionarEstado: function(nomeDoAutomato, chaveDoEstado) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		if (automato !== undefined) {
			var estadoAdicionado = this.adicionarEstadoOuSimbolo(automato.estados, /\[?[A-Z]+[0-9]?\]?|![0-9]/, chaveDoEstado, Estado, function() {
				var transicoesDoEstado = {};
				automato.transicoes[chaveDoEstado] = transicoesDoEstado;
				Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
					transicoesDoEstado[chaveDoSimbolo] = new TransicaoDeEstado(automato.estados[chaveDoEstado], [automato.estados["!"]], simbolo);
				});
			});
			return estadoAdicionado;
		}
		return false;
	},
	
	/**
	 * Função: adicionarSimbolo
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato em que será adicionado um novo símbolo
	 * 	- chaveDoSimbolo: chave identificadora do símbolo a ser adicionado
	 * Descrição: adiciona um novo símbolo ao alfabeto do autômato de nome nomeDoAutomato
	 * com a chave especificada por chaveDoSimbolo e cria uma nova transição
	 * de cada estado com este novo símbolo do alfabeto
	 */
	adicionarSimbolo: function(nomeDoAutomato, chaveDoSimbolo) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		if (automato !== undefined) {
			var simboloAdicionado = this.adicionarEstadoOuSimbolo(automato.alfabeto, /[a-z]|[0-9]|&/, chaveDoSimbolo, Simbolo, function() {
				Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
					automato.transicoes[chaveDoEstado][chaveDoSimbolo] = new TransicaoDeEstado(estado, [automato.estados["!"]], automato.alfabeto[chaveDoSimbolo]);
				});
			});
			return simboloAdicionado;
		}
		return false;
	},
	
	/**
	 * Função: adicionarEstadoOuSimbolo
	 * Parâmetros:
	 * 	- conjunto: Conjunto em que o item adicionado deve ser guardado
	 * 	- expressaoRegular: expressão regular usada para validar o item adicionado
	 * 	- simbolo: simbolo do item a ser adicionado
	 * 	- prototipo: prototipo que representa o item a ser adicionado
	 * 	- adicionarTransicao: função que será chamada para concluir a adição de estado ou símbolo
	 * Descrição: função utilizada pelas funções adicionarEstado e adicionarSimbolo. Adiciona no conjunto
	 * fornecido o item desejado caso ele seja validado pela expressão regular de validação
	 */
	adicionarEstadoOuSimbolo: function(conjunto, expressaoRegular, simbolo, prototipo, adicionarTransicao) {
		var avaliacaoDeExpressaoRegular = expressaoRegular.exec(simbolo);
		var estadoValido = (avaliacaoDeExpressaoRegular !== null && avaliacaoDeExpressaoRegular.length === 1);
		if (conjunto[simbolo] === undefined && estadoValido) {
			conjunto[simbolo] = new prototipo(simbolo);
			adicionarTransicao();
			return true;
		}
		return false;
	},
	
	/**
	 * Função: fixarTransicao
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato que terá a transição fixada
	 * 	- chaveDoEstado: chave identificadora do estado que terá a transição fixada
	 * 	- chaveDoSimbolo: chave identificadora do símbolo que terá a transição fixada
	 * 	- chavesDosEstadosDasTransicoes: chaves identificadoras dos estados
	 *  resultantes da transição 
	 * Descrição: fixa uma transição do estado identificado por chaveDoEstado com o símbolo
	 * identificado por chaveDoSimbolo como resultando nos estados identificados por
	 * chavesDosEstadosDaTransicao 
	 */
	fixarTransicao: function(nomeDoAutomato, chaveDoEstado, chaveDoSimbolo, chavesDosEstadosDaTransicao) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		if (automato === undefined || 
				automato.estados[chaveDoEstado] === undefined ||
				chaveDoEstado === "!" ||
				automato.alfabeto[chaveDoSimbolo] === undefined || 
				chavesDosEstadosDaTransicao.length === 0) {
			return false;
		}
		var transicaoValida = true;
		var estadosDaTransicao = [];
		Utilitarios.paraCada(chavesDosEstadosDaTransicao, function(chaveDoEstado, indice) {
			var estado = automato.estados[chaveDoEstado]; 
			if (estado === undefined || estadosDaTransicao.indexOf(estado) !== -1) {
				transicaoValida = false;
			} 
			estadosDaTransicao[indice] = estado;
		});
		if (transicaoValida) {
			automato.transicoes[chaveDoEstado][chaveDoSimbolo] = new TransicaoDeEstado(automato.estados[chaveDoEstado], estadosDaTransicao, automato.alfabeto[chaveDoSimbolo]);
		}
		return transicaoValida;
	},

	/**
	 * Função: fixarEstadoInicial
	 * Parâmetros: 
	 * 	- nomeDoAutomato: nome do autômato em que será fixado o estado inicial
	 * 	- chaveDoEstado: chave identificadora do estado que será fixado como inicial
	 * Descrição: fixa o estado identificado por chaveDoEstado como estado inicial do
	 * autômato de nome nomeDoAutomato
	 */
	fixarEstadoInicial: function(nomeDoAutomato, chaveDoEstado) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		if (automato === undefined || automato.estados[chaveDoEstado] === undefined) {
			return false;
		}
		automato.estadoInicial.deixarDeSerInicial();
		automato.estados[chaveDoEstado].serInicial();
		automato.estadoInicial = automato.estados[chaveDoEstado];
		return true;
	},

	/**
	 * Função: adicionarEstadoFinal
	 * Parâmetros: 
	 * 	- nomeDoAutomato: nome do autômato em que será adicionado um estado final
	 * 	- chaveDoEstado: chave identificadora do estado que será adicionado como final
	 * Descrição: adiciona o estado identificado por chaveDoEstado como estado final do
	 * autômato de nome nomeDoAutomato
	 */
	adicionarEstadoFinal: function(nomeDoAutomato, chaveDoEstado) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		if (automato === undefined || automato.estados[chaveDoEstado] === undefined) {
			return false;
		}
		automato.estados[chaveDoEstado].serFinal();
		if (automato.estadosFinais.indexOf(automato.estados[chaveDoEstado]) < 0) {
			automato.estadosFinais.push(automato.estados[chaveDoEstado]);
		}
		return true;
	},

	/**
	 * Função: removerEstadoFinal
	 * Parâmetros: 
	 * 	- nomeDoAutomato: nome do autômato em que será removido um estado final
	 * 	- chaveDoEstado: chave identificadora do estado que será removido do conjunto
	 *  de estados finais
	 * Descrição: remove o estado identificado por chaveDoEstado do conjunto de estados
	 * finais do autômato de nome nomeDoAutomato
	 */
	removerEstadoFinal: function(nomeDoAutomato, chaveDoEstado) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		if (automato === undefined || automato.estados[chaveDoEstado] === undefined) {
			return false;
		}
		automato.estados[chaveDoEstado].deixarDeSerFinal();
		var indice = automato.estadosFinais.indexOf(automato.estados[chaveDoEstado]);
		if (indice >= 0) {
			automato.estadosFinais.splice(indice, 1);
		}
		return true;
	},

	/**
	 * Função: determinizar
	 * Parâmetros: 
	 * 	- nomeDoAutomato: nome do autômato que será determinizado
	 * 	- estados: estados do autômato que será determinizado
	 * Descrição: determiniza o autômato especificado, gerando um autômato
	 * finito determinístico equivalente ao autômato inicial
	 */
	determinizar: function(nomeDoAutomato, estados, primeiro) {
		var novosEstadosCompostos = [];
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		if (automato === undefined) {
			return false;
		}
		if (estados === undefined) {
			estados = automato.estados;
		}
		Utilitarios.paraCada(estados, function(estado, chaveDoEstado) {
			Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
				if (automato.transicoes[chaveDoEstado][chaveDoSimbolo].estadosDeDestino.length > 1) {
					this.comporEstado(nomeDoAutomato, automato, chaveDoEstado, chaveDoSimbolo, novosEstadosCompostos);
				}
			}, this);
		}, this);
		if (novosEstadosCompostos.length > 0) {
			this.determinizar(nomeDoAutomato, estados, false);
		}
		if (primeiro !== undefined && primeiro === false) {
			this.juntarEstadosCompostos(nomeDoAutomato, automato);
		}
		return true;
	},

	/**
	 * Função: comporEstado
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato que está sendo modificado
	 * 	- automato: autômato que está sendo modificado
	 * 	- chaveDoEstadoDeDestino: chave identificadora do estado que possui transição
	 *  para dois ou mais estados
	 * 	- chaveDoSimboloDaTransicao: chave identificador do símbolo com o qual ocorre
	 *  uma transição para dois ou mais estados
	 * 	- novosEstadosCompostos: conjunto de estados resultante da operação
	 * Descrição: cria um novo estado composto pelos estados resultantes da transição
	 * do estado identificado por chaveDoEstadoDeDestino com o símbolo identificado
	 * por chaveDoSimboloDaTransicao
	 */
	comporEstado: function(nomeDoAutomato, automato, chaveDoEstadoDeDestino, chaveDoSimboloDaTransicao, novosEstadosCompostos) {
		var transicao = automato.transicoes[chaveDoEstadoDeDestino][chaveDoSimboloDaTransicao];
		var chaveDoEstadoComposto = "[" + transicao.estadosDeDestino.join("") + "]";
		if (automato.estados[chaveDoEstadoComposto] === undefined){ 
			this.adicionarEstado(nomeDoAutomato, chaveDoEstadoComposto);
			novosEstadosCompostos.push(automato.estados[chaveDoEstadoComposto]);
		}
		Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
			var estadosDeDestinoDoEstadoComposto = [];
			Utilitarios.paraCada(transicao.estadosDeDestino, function(estado, indiceDoEstado) {
				if (estado.final) {
					this.adicionarEstadoFinal(nomeDoAutomato, chaveDoEstadoComposto);
				}
				Utilitarios.paraCada(automato.transicoes[estado.simbolo][chaveDoSimbolo].estadosDeDestino, function(estadoDeDestinoDoEstadoComposto, indiceDoEstadoDeDestinoDoEstadoComposto) {
					if (estadosDeDestinoDoEstadoComposto.indexOf(estadoDeDestinoDoEstadoComposto) === -1 && estadoDeDestinoDoEstadoComposto.simbolo !== "!") {
						estadosDeDestinoDoEstadoComposto.push(estadoDeDestinoDoEstadoComposto);
					}
				});
			}, this);
			if (estadosDeDestinoDoEstadoComposto.length === 0) {
				estadosDeDestinoDoEstadoComposto.push(automato.estados["!"]);
			}
			this.fixarTransicao(nomeDoAutomato, chaveDoEstadoComposto, chaveDoSimbolo, estadosDeDestinoDoEstadoComposto);
		}, this);
	},
	
	/**
	 * Função: juntarEstadosCompostos
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato que está sendo modificado
	 * 	- automato: autômato que está sendo modificado
	 * Descrição: transforma um estado composto por dois ou mais estados
	 * em um único estado
	 */
	juntarEstadosCompostos: function(nomeDoAutomato, automato) {
		Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
			Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
				var transicao = automato.transicoes[chaveDoEstado][chaveDoSimbolo];
				if (transicao.estadosDeDestino.length > 1) {
					var chaveDoEstadoComposto = "[" + transicao.estadosDeDestino.join("") + "]";
					this.fixarTransicao(nomeDoAutomato, chaveDoEstado, chaveDoSimbolo, [automato.estados[chaveDoEstadoComposto]]);
				}
			}, this);
		}, this);
	},

	/**
	 * Função: minimizar
	 * Parâmetros: 
	 * 	- nomeDoAutomato: nome do autômato que será minimizado
	 * Descrição: minimiza o autômato especificado, removendo estados inacessiveis,
	 * mortos e equivalentes
	 */
	minimizar: function(nomeDoAutomato) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		if (automato !== undefined) {
			if (this.removerEstadosInacessiveis(automato, nomeDoAutomato) && 
					this.removerEstadosMortos(automato, nomeDoAutomato) && 
					this.removerEstadosEquivalentes(automato, nomeDoAutomato)) {
				return true;
			}
		}
		return false;
	},
	
	/**
	 * Função: removerEstadosInacessiveis
	 * Parâmetros:
	 * 	- automato: autômato que será removido os estados inacessíveis
	 * 	- nomeDoAutomato: nome do autômato que será removido os estados inacessíveis
	 * Descrição: remove os estados inacessíveis do automato especificado
	 */
	removerEstadosInacessiveis: function(automato, nomeDoAutomato) {
		var estadosAcessiveis = {};
		var automatoDeterministico = true;
		/**
		 * Função: obterEstadosAcessiveis
		 * Parâmetros:
		 * 	- estadoDePartida: estado à partir do qual serão procurados os estados
		 *  acessíveis
		 * Descrição: obtém o conjunto de estados acessíveis à partir do estado
		 * especificado por estadoDePartida
		 */
		var obterEstadosAcessiveis = function(estadoDePartida) {
			Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
				var transicao = automato.transicoes[estadoDePartida.simbolo][chaveDoSimbolo];
				if (transicao.estadosDeDestino.length > 1) {
					automatoDeterministico = false;
				}
				var estadoAcessivel = transicao.estadosDeDestino[0];
				if (estadosAcessiveis[estadoAcessivel.simbolo] === undefined) {
					estadosAcessiveis[estadoAcessivel.simbolo] = estadoAcessivel;
					obterEstadosAcessiveis(estadoAcessivel);
				}
			});
		};
		estadosAcessiveis[automato.estadoInicial.simbolo] = automato.estadoInicial;
		obterEstadosAcessiveis(automato.estadoInicial);
		if (!automatoDeterministico) {
			return false;
		}
		Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
			if (estadosAcessiveis[chaveDoEstado] === undefined && chaveDoEstado !== "!") {
				this.removerEstado(nomeDoAutomato, automato, estado);
			}
		}, this);
		return true;
	},
	
	/**
	 * Função: removerEstadosMortos
	 * Parâmetros:
	 * 	- automato: autômato que será removido os estados mortos
	 * 	- nomeDoAutomato: nome do autômato que será removido os estados mortos
	 * Descrição: remove os estados mortos do automato especificado
	 */
	removerEstadosMortos: function(automato, nomeDoAutomato) {
		var estadosVivos = {};
		var automatoDeterministico = true;
		/**
		 * Função: obterEstadosVivos
		 * Parâmetros:
		 * 	- estadoDeChegada: estado à partir do qual serão procurados os estados
		 *  vivos
		 * Descrição: obtém o conjunto de estados vivos à partir do estado
		 * especificado por estadoDeChegada
		 */
		var obterEstadosVivos = function(estadoDeChegada) {
			Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
				Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
					if (estadosVivos[chaveDoEstado] === undefined) {
						var transicao = automato.transicoes[chaveDoEstado][chaveDoSimbolo];
						if (transicao.estadosDeDestino > 1) {
							automatoDeterministico = false;
						}
						if (transicao.estadosDeDestino[0].simbolo === estadoDeChegada.simbolo) {
							estadosVivos[chaveDoEstado] = estado;
							obterEstadosVivos(estado);
						}
					}
				});
			});
		};
		Utilitarios.paraCada(automato.estadosFinais, function(estadoVivo, indiceDoEstadoVivo) {
			estadosVivos[estadoVivo.simbolo] = estadoVivo;
			obterEstadosVivos(estadoVivo);
		});
		if (!automatoDeterministico) {
			return false;
		}
		Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
			if (estadosVivos[chaveDoEstado] === undefined && chaveDoEstado !== "!") {
				this.removerEstado(nomeDoAutomato, automato, estado);
			}
		}, this);
		return true;
	},
	
	/**
	 * Função: removerEstadosEquivalentes
	 * Parâmetros:
	 * 	- automato: autômato que será removido os estados equivalentes
	 * 	- nomeDoAutomato: nome do autômato que será removido os estados equivalentes
	 * Descrição: remove os estados equivalentes do automato especificado
	 */
	removerEstadosEquivalentes: function(automato, nomeDoAutomato) {
		var automatoDeterministico = true;
		var classeDeEquivalenciaDeFinais = [];
		var classeDeEquivalenciaDeNaoFinais = [];
		var classesDeEquivalencia = [classeDeEquivalenciaDeFinais, classeDeEquivalenciaDeNaoFinais];
		var classesDeEquivalenciaAnterior = classesDeEquivalencia; 
		Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
			if (estado.final) {
				classeDeEquivalenciaDeFinais.push(estado);
			} else {
				classeDeEquivalenciaDeNaoFinais.push(estado);
			}
		});
		/**
		 * Função: obterClasseDeEquivalenciaDoEstado
		 * Parâmetros:
		 * 	- estado: estado para o qual se deseja obter a classe de equivalência
		 * 	- classesDeEquivalencia: conjunto de classes de equivalência já encontrados
		 * Descrição: obtém a classe de equivalência do estado especificado dentro do
		 * conjunto de classes de equivalência fornecido
		 */
		var obterClasseDeEquivalenciaDoEstado = function(estado, classesDeEquivalencia) {
			var classeDeEquivalenciaDoEstado = undefined;
			Utilitarios.paraCada(classesDeEquivalencia, function(classeDeEquivalencia) {
				if (classeDeEquivalencia.indexOf(estado) >= 0) {
					classeDeEquivalenciaDoEstado = classeDeEquivalencia;
					return;
				}
			});
			return classeDeEquivalenciaDoEstado;
		};
		/**
		 * Função: verificarSeEstadosSaoEquivalentes
		 * Parâmetros:
		 * 	- estado: primeiro estado que será testada equivalência
		 * 	- estadoEquivalente: segundo estado que será testada equivalência
		 * 	- classesDeEquivalencia: conjunto de classes de equivalência já encontrados
		 * Descrição: verifica se os dois estados especificados são equivalentes
		 * de acordo com as classes de equivalência fornecidas
		 */
		var verificarSeEstadosSaoEquivalentes = function(estado, estadoEquivalente, classesDeEquivalencia) {
			var saoEquivalentes = true;
			Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
				var estadosDeDestinoDoEstado = automato.transicoes[estado.simbolo][chaveDoSimbolo].estadosDeDestino;
				var estadosDeDestinoDoEstadoEquivalente = automato.transicoes[estadoEquivalente.simbolo][chaveDoSimbolo].estadosDeDestino;
				if (estadosDeDestinoDoEstado.length > 1 || estadosDeDestinoDoEstadoEquivalente.length > 1) {
					automatoDeterministico = true;
				}
				var classeDeEquivalenciaDoEstado = obterClasseDeEquivalenciaDoEstado(estadosDeDestinoDoEstado[0], classesDeEquivalencia);
				var classeDeEquivalenciaDoEstadoEquivalente = obterClasseDeEquivalenciaDoEstado(estadosDeDestinoDoEstadoEquivalente[0], classesDeEquivalencia);
				if (classeDeEquivalenciaDoEstado !== classeDeEquivalenciaDoEstadoEquivalente) {
					saoEquivalentes = false;
					return;
				}
			});
			return saoEquivalentes;
		};
		/**
		 * Função: formarClasseDeEquivalencia
		 * Parâmetros:
		 * 	- estado: estado que será adicionado a uma classe de equivalência
		 * 	- novasClassesDeEquivalencia: classes de equivalência da iteração atual
		 * 	- classesDeEquivalencia: classes de equivalência da iteração anterior
		 * Descrição: adiciona o estado a uma classe de equivalência, caso ele pertença a uma
		 * e caso contrário cria um nova classe de equivalência para o estado
		 */
		var formarClasseDeEquivalencia = function(estado, novasClassesDeEquivalencia, classesDeEquivalencia) {
			var classeDeEquivalenciaDoEstado = undefined;
			Utilitarios.paraCada(novasClassesDeEquivalencia, function(novaClasseDeEquivalencia) {
				var estadoEquivalente = novaClasseDeEquivalencia[0];
				var estadosEquivalentes = verificarSeEstadosSaoEquivalentes(estado, estadoEquivalente, classesDeEquivalencia);
				if (estadosEquivalentes) {
					classeDeEquivalenciaDoEstado = novaClasseDeEquivalencia;
					return;
				}
			});
			if (classeDeEquivalenciaDoEstado === undefined) {
				classeDeEquivalenciaDoEstado = [];
				novasClassesDeEquivalencia.push(classeDeEquivalenciaDoEstado);
			}
			classeDeEquivalenciaDoEstado.push(estado);
		};
		/**
		 * Função: formarClassesDeEquivalencia
		 * Parâmetros:
		 * 	- classeDeEquivalencia: classe de equivalência que será decomposta em novas classes de
		 *  equivalência caso existam
		 * 	- classesDeEquivalencia: classes de equivalência da iteração atual
		 * 	- classesDeEquivalenciaPosterior: classes de equivalência da iteração anterior
		 * Descrição: decompõe a classe de equivalência em novas classes de equivalência
		 */
		var formarClassesDeEquivalencia = function(classeDeEquivalencia, classesDeEquivalencia, classesDeEquivalenciaPosterior) {
			var novasClassesDeEquivalencia = [];
			Utilitarios.paraCada(classeDeEquivalencia, function(estado) {
				formarClasseDeEquivalencia(estado, novasClassesDeEquivalencia, classesDeEquivalencia);
			});
			classesDeEquivalenciaPosterior.push.apply(classesDeEquivalenciaPosterior, novasClassesDeEquivalencia);
		};
		do {
			var classesDeEquivalenciaPosterior = [];
			Utilitarios.paraCada(classesDeEquivalencia, function(classeDeEquivalencia) {
				formarClassesDeEquivalencia(classeDeEquivalencia, classesDeEquivalencia, classesDeEquivalenciaPosterior);
			});
			classesDeEquivalenciaAnterior = classesDeEquivalencia;
			classesDeEquivalencia = classesDeEquivalenciaPosterior;
		} while (classesDeEquivalencia.length !== classesDeEquivalenciaAnterior.length);
		if (!automatoDeterministico) {
			return false;
		}
		Utilitarios.paraCada(classesDeEquivalencia, function(classeDeEquivalencia) {
			var indice;
			for (indice = 1; indice < classeDeEquivalencia.length; indice++) {
				var estado = classeDeEquivalencia[indice];
				if (estado.inicial) {
					this.fixarEstadoInicial(nomeDoAutomato, classeDeEquivalencia[0].simbolo);
				}
				this.removerEstado(nomeDoAutomato, automato, estado, classeDeEquivalencia[0]);
			}
		}, this);
		return true;
	},
	
	/**
	 * Função: removerEstado
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato que terá um estado removido
	 * 	- automato: autômato que terá um estado removido
	 * 	- estado: estado que será removido
	 * 	- estadoSubstituto: estado que irá substituir o estado removido
	 * Descrição: remove o estado especificado do autômato, substituindo as transições
	 * para o estado removido por transições para o estado substituto 
	 */
	removerEstado: function(nomeDoAutomato, automato, estado, estadoSubstituto) {
		if (estadoSubstituto === undefined) {
			estadoSubstituto = automato.estados["!"];
		}
		if (automato.estadoInicial === estado) {
			automato.estadoInicial = automato.estados["!"];
		}
		Utilitarios.paraCada(automato.transicoes, function(estadoDaTransicao, chaveDoEstadoDaTransicao) {
			Utilitarios.paraCada(automato.transicoes[chaveDoEstadoDaTransicao], function(transicao, chaveDoSimboloDaTransicao) {
				var indice = transicao.estadosDeDestino.indexOf(estado);
				if (indice >= 0) {
					transicao.estadosDeDestino[indice] = estadoSubstituto;
				}
			});
		});
		if (estado.simbolo !== "!") {
			this.removerEstadoFinal(nomeDoAutomato, estado.simbolo);
			delete automato.estados[estado.simbolo];
			delete automato.transicoes[estado.simbolo];
		}
	},

	/**
	 * Função: clonar
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato que será clonado
	 * 	- nomeDoClone: nome do clone do autômato 
	 * Descrição: cria um novo autômato igual ao autômato de nome nomeDoAutomato
	 */
	clonar: function(nomeDoAutomato, nomeDoClone) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		var automatoClone = new AutomatoFinito();
		if (automato === undefined || ConjuntoDeAutomatosFinitos[nomeDoClone] !== undefined) {
			return false;
		}
		this.clonarEstados(automato, automatoClone);
		this.clonarSimbolos(automato, automatoClone);
		this.clonarTransicoesDeEstado(automato, automatoClone);
		if (nomeDoClone === undefined) {
			return automatoClone;
		}
		ConjuntoDeAutomatosFinitos[nomeDoClone] = automatoClone;
		return true;
	},
	
	/**
	 * Função: clonarEstados
	 * Parâmetros:
	 * 	- automato: autômato que terá seus estados clonados
	 * 	- automatoClone: autômato que receberá os estados clonados 
	 * Descrição: copia todos os estados do autômato especificado para um novo
	 * autômato clone
	 */
	clonarEstados: function(automato, automatoClone) {
		Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
			automatoClone.estados[chaveDoEstado] = this.clonarEstado(estado);
		}, this);
		automatoClone.estadoInicial = automatoClone.estados[automato.estadoInicial];
		automatoClone.estadosFinais = [];
		Utilitarios.paraCada(automato.estadosFinais, function(estado, indice) {
			automatoClone.estadosFinais[indice] = automatoClone.estados[estado.simbolo];
		});
	},
	
	/**
	 * Função: clonarSimbolos
	 * Parâmetros:
	 * 	- automato: autômato que terá seus estados símbolos
	 * 	- automatoClone: autômato que receberá os símbolos clonados 
	 * Descrição: copia todos os símbolos do autômato especificado para um novo
	 * autômato clone
	 */
	clonarSimbolos: function(automato, automatoClone) {
		Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
			automatoClone.alfabeto[chaveDoSimbolo] = this.clonarSimbolo(simbolo);
		}, this);
	},
	
	/**
	 * Função: clonarTransicoesDeEstado
	 * Parâmetros:
	 * 	- automato: autômato que terá suas transições clonadas
	 * 	- automatoClone: autômato que receberá as transições clonados 
	 * Descrição: copia todas as transições do autômato especificado para um novo
	 * autômato clone
	 */
	clonarTransicoesDeEstado: function(automato, automatoClone) {
		Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
			automatoClone.transicoes[chaveDoEstado] = {};
			Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
				automatoClone.transicoes[chaveDoEstado][chaveDoSimbolo] = this.clonarTransicaoDeEstado(automato.transicoes[chaveDoEstado][chaveDoSimbolo], automatoClone);
			}, this);
		}, this);
	},
	
	/**
	 * Função: clonarEstado
	 * Parâmetros:
	 * 	- estado: estado que será clonado 
	 * Descrição: cria uma cópia do estado especificado
	 */
	clonarEstado: function(estado) {
		var novoEstado = new Estado(estado.simbolo);
		novoEstado.inicial = estado.inicial;
		novoEstado.final = estado.final;
		return novoEstado;
	},
	
	/**
	 * Função: clonarSimbolo
	 * Parâmetros:
	 * 	- simbolo: símbolo que será clonado 
	 * Descrição: cria uma cópia do símbolo especificado
	 */
	clonarSimbolo: function (simbolo) {
		return new Simbolo(simbolo.simbolo);
	},
	
	/**
	 * Função: clonarTransicaoDeEstado
	 * Parâmetros:
	 * 	- transicaoDeEstado: transição que será clonada
	 * 	- automatoClonado: autômato que possui a transição que será clonada 
	 * Descrição: cria uma cópia da transição especificado pertencente ao
	 * autômato identificado por automatoClonado
	 */
	clonarTransicaoDeEstado: function(transicaoDeEstado, automatoClonado) {
		var estadoDeOrigemClonado = automatoClonado.estados[transicaoDeEstado.estadoDeOrigem.simbolo];
		var estadosDeDestinoClonado = [];
		Utilitarios.paraCada(transicaoDeEstado.estadosDeDestino, function(estadoDeDestino, chaveDoEstadoDeDestino) {
			estadosDeDestinoClonado.push(automatoClonado.estados[estadoDeDestino.simbolo]);
		});
		var simboloDeTransicaoClonado = automatoClonado.alfabeto[transicaoDeEstado.simboloDeTransicao.simbolo];
		var transicaoClonada = new TransicaoDeEstado(estadoDeOrigemClonado, estadosDeDestinoClonado, simboloDeTransicaoClonado);
		return transicaoClonada;
	},
	
	/**
	 * Função: reconhecerSentenca
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato que será verificado o reconhecimento
	 *  da sentença
	 * 	- sentenca: sentença que será verificada se é reconhecida pelo autômato
	 * Descrição: verifica se a sentença é especificada é reconhecida pelo autômato
	 */
	reconhecerSentenca: function(nomeDoAutomato, sentenca) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		if (automato !== undefined) {
			var sentencaComoObjeto = new String(sentenca);
			var estadoAtual = automato.estadoInicial;
			Utilitarios.paraCada(sentencaComoObjeto, function(simbolo, indiceDoSimbolo) {
				var transicao = automato.transicoes[estadoAtual.simbolo][simbolo];
				if (transicao !== undefined) {
					estadoAtual = transicao.estadosDeDestino[0];
				} else {
					estadoAtual = automato.estados["!"];
					return;
				}
			});
			if (estadoAtual !== automato.estados["!"] && estadoAtual.final) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	},
	
	/**
	 * Função: enumerarSentencas
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato que terá suas sentenças enumeradas
	 * 	- tamanhoDasSentencas: tamanho de sentenças a serem enumeradas
	 * Descrição: enumera as sentenças de tamanho tamanhoDasSentencas do autômato
	 * identificado por nomeDoAutomato
	 */
	enumerarSentencas: function(nomeDoAutomato, tamanhoDasSentencas) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		var enumeracoes = [];
		if (automato !== undefined) {
			var enumerar = function(estadoDePartida, tamanhoRestante, enumeracoes, enumeracaoParcial) {
				if (tamanhoRestante > 0) {
					tamanhoRestante--;
					Utilitarios.paraCada(automato.transicoes[estadoDePartida.simbolo], function(transicao, simboloDaTransicao) {
						Utilitarios.paraCada(transicao.estadosDeDestino, function(estadoDeDestino, indiceDoEstadoDeDestino) {
							enumerar(estadoDeDestino, tamanhoRestante, enumeracoes, enumeracaoParcial + simboloDaTransicao);
						});
					});
				} else {
					if (tamanhoRestante === 0 && estadoDePartida.final) {
						enumeracoes.push(enumeracaoParcial);
					}
				}
			};
			enumerar(automato.estadoInicial, tamanhoDasSentencas, enumeracoes, "");
		}
		return enumeracoes;
	},
	
	/**
	 * Função: verificarEquivalencia
	 * Parâmetros:
	 * 	- nomeDoAutomatoFinitoA: nome do autômato finito a ser verificado
	 * 	- nomeDoAutomatoFinitoB: nome do autômato finito a ser verificado
	 * Descrição: verifica a equivalência entre dois autômatos finitos através de operações
	 * de complemento, união, determinização e minimização
	 */
	verificarEquivalencia: function(nomeDoAutomatoFinitoA, nomeDoAutomatoFinitoB) {
		var nomeDoAutomatoAComplementado = nomeDoAutomatoFinitoA + "Complemento";
		var nomeDoAutomatoBComplementado = nomeDoAutomatoFinitoB + "Complemento";
		var nomeDoAutomatoAUniaoBComplementado = nomeDoAutomatoFinitoA + "Uniao" + nomeDoAutomatoFinitoB + "Complemento";
		var nomeDoAutomatoAComplementadoUniaoB = nomeDoAutomatoFinitoA + "ComplementoUniao" + nomeDoAutomatoFinitoB;
		this.clonar(nomeDoAutomatoFinitoA, nomeDoAutomatoAComplementado);
		this.clonar(nomeDoAutomatoFinitoB, nomeDoAutomatoBComplementado);
		this.complementar(nomeDoAutomatoAComplementado);
		this.complementar(nomeDoAutomatoBComplementado);
		var automatoA = ConjuntoDeAutomatosFinitos[nomeDoAutomatoFinitoA];
		var automatoB = ConjuntoDeAutomatosFinitos[nomeDoAutomatoFinitoB];
		var automatoAComplementado = ConjuntoDeAutomatosFinitos[nomeDoAutomatoAComplementado];
		var automatoBComplementado = ConjuntoDeAutomatosFinitos[nomeDoAutomatoBComplementado];
		var automatoABComplemento = this.unir(automatoA, automatoBComplementado, nomeDoAutomatoAUniaoBComplementado);
		var automatoAComplementoB = this.unir(automatoAComplementado, automatoB, nomeDoAutomatoAComplementadoUniaoB);
		this.determinizar(nomeDoAutomatoAUniaoBComplementado);
		this.determinizar(nomeDoAutomatoAComplementadoUniaoB);
		this.fixarEstadoInicial(nomeDoAutomatoAUniaoBComplementado, automatoABComplemento.transicoes[automatoABComplemento.estadoInicial.simbolo]["&"].estadosDeDestino[0].simbolo);
		this.fixarEstadoInicial(nomeDoAutomatoAComplementadoUniaoB, automatoAComplementoB.transicoes[automatoAComplementoB.estadoInicial.simbolo]["&"].estadosDeDestino[0].simbolo);
		this.complementar(nomeDoAutomatoAUniaoBComplementado);
		this.complementar(nomeDoAutomatoAComplementadoUniaoB);
		this.minimizar(nomeDoAutomatoAUniaoBComplementado);
		this.minimizar(nomeDoAutomatoAComplementadoUniaoB);
		var equivalentes = automatoABComplemento.estadosFinais.length <= 1 && automatoABComplemento.estadosFinais[0].simbolo === "!" && automatoAComplementoB.estadosFinais.length <= 1 && automatoAComplementoB.estadosFinais[0].simbolo === "!"; 
		this.remover(nomeDoAutomatoAComplementado);
		this.remover(nomeDoAutomatoBComplementado);
		this.remover(nomeDoAutomatoAUniaoBComplementado);
		this.remover(nomeDoAutomatoAComplementadoUniaoB);
		this.remover(nomeDoAutomatoFinitoA);
		this.remover(nomeDoAutomatoFinitoB);
		return equivalentes;	
	},
	
	/**
	 * Função: complementa
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato finito a ser complementado
	 * Descrição: realiza o complemento do autômato finito desejado
	 */
	complementar: function(nomeDoAutomato) {
		var automato = ConjuntoDeAutomatosFinitos[nomeDoAutomato];
		Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
			if (estado.final) {
				this.removerEstadoFinal(nomeDoAutomato, chaveDoEstado);
			} else {
				this.adicionarEstadoFinal(nomeDoAutomato, chaveDoEstado);
			}
		}, this);
	},
	
	/**
	 * Função: unir
	 * Parâmetros:
	 * 	- automatoA: autômato a ser unido
	 * 	- automatoB: autômato a ser unido
	 * 	- nomeDoAutomatoUnido: nome do autômato finito resultante da união unido
	 * Descrição: uni dois automatos finitos fornecidos, formando um terceiro autômato finito
	 */
	unir: function(automatoA, automatoB, nomeDoAutomatoUnido) {
		this.criar(nomeDoAutomatoUnido);
		var automatoUnido = ConjuntoDeAutomatosFinitos[nomeDoAutomatoUnido];
		/**
		 * Função: fundirAutomato
		 * Parâmetros:
		 * 	- automato: autômato a ser fundido ao novo autômato
		 * 	- número: número que de renomeação dos estados
		 * Descrição: renomeia os estados do autômato fornecido para realizar a união
		 * dos dois autômatos sem que ocorram conflitos de nomes
		 */
		var fundirAutomato = function(automato, numero) {
			Utilitarios.paraCada(automato.alfabeto, function(simbolo, chaveDoSimbolo) {
				if (automatoUnido.alfabeto[chaveDoSimbolo] === undefined) {
					this.adicionarSimbolo(nomeDoAutomatoUnido, chaveDoSimbolo);
				}
			}, AutomatosFinitos);
			Utilitarios.paraCada(automato.estados, function(estado, chaveDoEstado) {
				this.adicionarEstado(nomeDoAutomatoUnido, chaveDoEstado + numero);
				if (estado.final) {
					this.adicionarEstadoFinal(nomeDoAutomatoUnido, chaveDoEstado + numero);
				}
			}, AutomatosFinitos);
			Utilitarios.paraCada(automato.transicoes, function(transicoesDoEstado, chaveDoEstado) {
				var chaveDoEstadoDePartida = chaveDoEstado + numero;
				Utilitarios.paraCada(transicoesDoEstado, function(transicao, chaveDoSimboloDaTransicao) {
					var chaveDosEstadosDeDestino = [];
					Utilitarios.paraCada(transicao.estadosDeDestino, function(estadoDeDestino, indiceDoEstadoDeDestino) {
						chaveDosEstadosDeDestino.push(estadoDeDestino.simbolo + numero);
					}, AutomatosFinitos);
					this.fixarTransicao(nomeDoAutomatoUnido, chaveDoEstadoDePartida, chaveDoSimboloDaTransicao, chaveDosEstadosDeDestino);
				}, AutomatosFinitos);
			}, AutomatosFinitos);
			
		};
		fundirAutomato(automatoA, 0);
		fundirAutomato(automatoB, 1);
		if (automatoUnido.alfabeto["&"] === undefined) {
			this.adicionarSimbolo(nomeDoAutomatoUnido, "&");
		}
		this.adicionarEstado(nomeDoAutomatoUnido, "S");
		this.fixarEstadoInicial(nomeDoAutomatoUnido, "S");
		this.fixarTransicao(nomeDoAutomatoUnido, "S", "&", [automatoA.estadoInicial.simbolo + 0, automatoB.estadoInicial.simbolo + 1]);
		return automatoUnido;
	},
	
	/**
	 * Função: remover
	 * Parâmetros:
	 * 	- nomeDoAutomato: nome do autômato finito a ser removido
	 * Descrição: remove o autômato finito desejado do ConjuntoDeAutomatosFinitos
	 */
	remover: function(nomeDoAutomato) {
		delete ConjuntoDeAutomatosFinitos[nomeDoAutomato];
	}
};