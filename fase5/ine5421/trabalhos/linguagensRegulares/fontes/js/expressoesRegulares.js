var ConjuntoDeExpressoesRegulares = {};

var ExpressaoRegular = new Prototipo({
	/**
	 * Função: inicializar
	 * Descrição: inicializa as estruturas da expressão regular: expressão regular textual e árvore
	 * de construção da expressão regular
	 */
	inicializar: function() {
		this.expressaoRegularTextual = "";
		this.arvoreDeConstrucao = null;
	}
}); 

var ArvoreBinaria = new Prototipo({
	/**
	 * Função: inicializar
	 * Descrição: inicializa as estruturas da árvore binária: elemento raiz
	 */
	inicializar: function() {
		this.raiz = null;
	},
	
	/**
	 * Função: adicionarRaiz
	 * Parâmetros:
	 * 	- elemento: elemento a ser adicionado como raiz
	 * Descrição: adiciona um novo elemento como raiz da árvore
	 */
	adicionarRaiz: function(elemento) {
		var nodoRaiz = new Nodo(elemento);
		if (this.raiz !== null) {
			this.raiz.pai = nodoRaiz;
			nodoRaiz.filhoDaEsquerda = this.raiz;
		}
		this.raiz = nodoRaiz;
		return nodoRaiz;
	},
	
	/**
	 * Função: adicionarPai
	 * Parâmetros:
	 * 	- nodoFilho: nodo que existe na árvore e será filho do novo nodo a ser criado
	 * 	- elemento: elemento a ser adicionado como pai
	 * Descrição: adiciona um novo elemento como pai do nodo fornecido
	 */
	adicionarPai: function(nodoFilho, elemento) {
		if (nodoFilho.pai === null) {
			return this.adicionarRaiz(elemento);
		} else {
			var nodoPai = new Nodo(elemento);
			nodoPai.pai = nodoFilho.pai;
			if (nodoFilho.pai.filhoDaEsqueda === nodoFilho) {
				nodoPai.pai.filhoDaEsquerda = nodoPai;
			} else {
				nodoPai.pai.filhoDaDireita = nodoPai;
			}
			nodoPai.filhoDaEsquerda = nodoFilho;
			nodoFilho.pai = nodoPai;
			return nodoPai;
		}
	},
	
	/**
	 * Função: adicionarFilhoNaEsquerda
	 * Parâmetros:
	 * 	- nodoPai: nodo que existe na árvore e será pai do novo nodo a ser criado
	 * 	- elemento: elemento a ser adicionado como filho
	 * Descrição: adiciona um novo elemento como filho da esquerda do nodo fornecido
	 */
	adicionarFilhoNaEsquerda: function(nodoPai, elemento) {
		var nodoFilho = new Nodo(elemento);
		return this.adicionarNodoFilhoNaEsquerda(nodoPai, nodoFilho);
	},
	
	/**
	 * Função: adicionarFilhoNaDireita
	 * Parâmetros:
	 * 	- nodoPai: nodo que existe na árvore e será pai do novo nodo a ser criado
	 * 	- elemento: elemento a ser adicionado como filho
	 * Descrição: adiciona um novo elemento como filho da direita do nodo fornecido
	 */
	adicionarFilhoNaDireita: function(nodoPai, elemento) {
		var nodoFilho = new Nodo(elemento);
		return this.adicionarNodoFilhoNaDireita(nodoPai, nodoFilho);
	},
	
	/**
	 * Função: adicionarNodoFilhoNaEsquerda
	 * Parâmetros:
	 * 	- nodoPai: nodo que existe na árvore e será pai do novo nodo a ser criado
	 * 	- nodoFilho: nodo que não existe na árvore a ser adicionado como filho
	 * Descrição: adiciona um novo nodo como filho da esquerda do nodo fornecido
	 */
	adicionarNodoFilhoNaEsquerda: function(nodoPai, nodoFilho) {
		nodoFilho.pai = nodoPai;
		nodoPai.filhoDaEsquerda = nodoFilho;
		return nodoFilho;
	},
	
	/**
	 * Função: adicionarNodoFilhoNaDireita
	 * Parâmetros:
	 * 	- nodoPai: nodo que existe na árvore e será pai do novo nodo a ser criado
	 * 	- nodoFilho: nodo que não existe na árvore a ser adicionado como filho
	 * Descrição: adiciona um novo nodo como filho da direita do nodo fornecido
	 */
	adicionarNodoFilhoNaDireita: function(nodoPai, nodoFilho) {
		nodoFilho.pai = nodoPai;
		nodoPai.filhoDaDireita = nodoFilho;
		return nodoFilho;
	},
	
	/**
	 * Função: fornecerNodos
	 * Parâmetros:
	 * Descrição: fornece uma lista com todos nodos na árvore através de uma busca em largura
	 */
	fornecerNodos: function() {
		var fila = [];
		var indice = 0;
		if (this.raiz !== null) {
			fila.push(this.raiz);
			while (indice < fila.length) {
				var nodoAtual = fila[indice];
				if (nodoAtual.filhoDaEsquerda !== null) {
					fila.push(nodoAtual.filhoDaEsquerda);
				} 
				if (nodoAtual.filhoDaDireita !== null) {
					fila.push(nodoAtual.filhoDaDireita);
				}
				indice++;
			}
		}
		return fila;
	},
	
	/**
	 * Função: comoTexto
	 * Descrição: fornece um texto com todos nodos da árvore buscados em largura
	 */
	comoTexto: function() {
		var fila = [];
		var texto = "";
		fila.push(this.raiz);
		if (this.raiz !== null) {
			while (fila.length > 0) {
				var nodoAtual = fila.shift();
				texto += nodoAtual.comoTexto();
				if (!Utilitarios.instanciaDe(nodoAtual, SimboloDoAlfabeto)) {
					if (nodoAtual.filhoDaEsquerda !== null) {
						fila.push(nodoAtual.filhoDaEsquerda);
					} else {
						fila.push(new SimboloDoAlfabeto("E"));
					}
					if (nodoAtual.filhoDaDireita !== null) {
						fila.push(nodoAtual.filhoDaDireita);
					} else {
						fila.push(new SimboloDoAlfabeto("D"));
					}
				}
			}
			return texto;
		}
		return "Árvore vazia.";
	}
});

var Nodo = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros:
	 * 	- elemento: elemento que será representado pelo nodo
	 * Descrição: inicializa as estruturas do nodo: elemento, filhoDaEsquerda, filhoDaDireita e pai
	 */
	inicializar: function(elemento) {
		this.elemento = elemento;
		this.filhoDaEsquerda = null;
		this.filhoDaDireita = null;
		this.pai = null;
	},
	
	/**
	 * Função: comoTexto
	 * Descrição: fornece a representação textual do nodo
	 */
	comoTexto: function() {
		return this.elemento.comoTexto();
	}
});

var TabelaDeSimbolosConstrutora = new Prototipo({
	/**
	 * Função: inicializar
	 * Descrição: inicializa as estruturas da tabela de símbolos construtora: arvore, pilha,
	 * excecaoDeExpressaoREgularInvalida, nodosFolha
	 */
	inicializar: function() {
		this.arvore = new ArvoreBinaria();
		this.pilha = [];
		this.excecaoDeExpressaoRegularInvalida = new ExcecaoUtilitarios("Expressão regular inválida.");
		this.nodosFolha = 0;
	},
	
	/**
	 * Função: costurarArvore
	 * Descrição: costura a arvore gerada através da função constuir
	 */
	costurarArvore: function() {
		var nodos = this.arvore.fornecerNodos();
		Utilitarios.paraCada(nodos, function(nodo, indiceDoNodo) {
			var elemento = nodo.elemento;
			elemento.nodo = nodo;
			if (Utilitarios.instanciaDe(elemento, OperacaoBinaria) && elemento.simbolo === ".") {
				elemento.costura = nodo.filhoDaDireita;
			} else if (Utilitarios.instanciaDe(elemento, OperacaoUnaria) || 
					Utilitarios.instanciaDe(elemento, SimboloDoAlfabeto) ||
					(Utilitarios.instanciaDe(elemento, OperacaoBinaria) && elemento.simbolo === "|")) {
				var costura = nodo.pai;
				var nodoAtual = nodo;
				while (costura !== null && costura.filhoDaEsquerda !== nodoAtual) {
					nodoAtual = costura;
					costura = costura.pai;
				}
				elemento.costura = costura;
			}
		});
	},
	
	/**
	 * Função: construir
	 * Parâmetros:
	 * 	- expressaoRegular: expressão regular a partir do qual será construído a árvore
	 * Descrição: constrói a árvore que representará a expressão regular fornecida
	 */
	construir: function(expressaoRegular) {
		try {
			expressaoRegular = new String(expressaoRegular);
			Utilitarios.paraCada(expressaoRegular, function(simbolo, indiceDoSimbolo) {
				var operacao = simbolo;
				if (/[a-z]|[0-9]|&/.exec(simbolo) !== null) {
					operacao = "simboloDoAlfabeto";
				}
				if (this[operacao] === undefined) {
					throw this.excecaoDeExpressaoRegularInvalida;
				}
				this[operacao](simbolo);
			}, this);
			var topoDaPilha = this.pilha.pop();
			if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
				this.arvore.adicionarRaiz(topoDaPilha);
			} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && !Utilitarios.instanciaDe(topoDaPilha.elemento, SimboloDeAgrupamento)) {
				
			} else {
				throw this.excecaoDeExpressaoRegularInvalida;
			}
			if (this.pilha.length > 0) {
				return false;
			}
			this.costurarArvore();
		} catch (excecao) {
			if (excecao.mensagem === "Expressão regular inválida.") {
				return false;
			}
			throw excecao;
		}
		return true;
	},
	
	/**
	 * Função: simboloDoAlfabeto
	 * Parâmetros:
	 * 	- simbolo: simbolo que será representado por um nodo folha na árvore
	 * Descrição: empilha o novo símbolo caso não exista nenhuma operação pendente e adiciona o símbolo
	 * como nodo folha de uma operação pendente caso exista
	 */
	"simboloDoAlfabeto": function(simbolo) { 
		var topoDaPilha = this.pilha.pop();
		if (topoDaPilha !== undefined && (Utilitarios.instanciaDe(topoDaPilha, OperacaoBinaria) && topoDaPilha.simbolo === ".")) {
			topoDaPilha = this.pilha.pop();
		}
		this.nodosFolha++;
		var simboloDoAlfabeto = new SimboloDoAlfabeto(simbolo);
		simboloDoAlfabeto.indiceNaArvore = this.nodosFolha;
		if (topoDaPilha === undefined) {
			this.pilha.push(simboloDoAlfabeto);
		} else if (Utilitarios.instanciaDe(topoDaPilha, SimboloDeAgrupamento) && topoDaPilha.simbolo === "(") {
			this.pilha.push(topoDaPilha);
			this.pilha.push(simboloDoAlfabeto);
		} else if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
			var nodoDaOperacao = this.arvore.adicionarRaiz(new OperacaoBinaria("."));
			this.arvore.adicionarFilhoNaEsquerda(nodoDaOperacao, topoDaPilha);
			this.arvore.adicionarFilhoNaDireita(nodoDaOperacao, simboloDoAlfabeto);
			this.pilha.push(nodoDaOperacao);
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && ((Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria) && topoDaPilha.elemento.simbolo === ".") || Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoUnaria) || topoDaPilha.elemento.inicioDeAgrupamento)) {
			var nodoDaOperacao = this.arvore.adicionarPai(topoDaPilha, new OperacaoBinaria("."));
			this.arvore.adicionarFilhoNaDireita(nodoDaOperacao, simboloDoAlfabeto);
			this.pilha.push(nodoDaOperacao);
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria) && topoDaPilha.elemento.simbolo === "|") {
			var nodoDaOperacao = this.arvore.adicionarPai(topoDaPilha.filhoDaDireita, new OperacaoBinaria("."));
			this.arvore.adicionarFilhoNaDireita(nodoDaOperacao, simboloDoAlfabeto);
			this.pilha.push(topoDaPilha);
		} else if (Utilitarios.instanciaDe(topoDaPilha, OperacaoBinaria) && topoDaPilha.simbolo === "|") {
			topoDaPilha = this.pilha.pop();
			if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
				var nodoDaOperacao = this.arvore.adicionarRaiz(new OperacaoBinaria("|"));
				this.arvore.adicionarFilhoNaEsquerda(nodoDaOperacao, topoDaPilha);
				this.arvore.adicionarFilhoNaDireita(nodoDaOperacao, simboloDoAlfabeto);
				this.pilha.push(nodoDaOperacao);
			} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && (Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria) || Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoUnaria))) {
				var nodoDaOperacao = this.arvore.adicionarPai(topoDaPilha, new OperacaoBinaria("|"));
				this.arvore.adicionarFilhoNaDireita(nodoDaOperacao, simboloDoAlfabeto);
				this.pilha.push(nodoDaOperacao);
			} else {
				throw this.excecaoDeExpressaoRegularInvalida;
			}
		} else {
			throw this.excecaoDeExpressaoRegularInvalida;
		}
	},
	
	/**
	 * Função: agrupamento
	 * Parâmetros:
	 * 	- nodoRaizDoAgrupamento: nodo que seŕa o ponto de partida para um novo ramo na árvore
	 * Descrição: empilha o novo agrupamento caso não exista nenhuma operação pendente e adiciona o agrupamento
	 * como filho da operação pendente caso exista. Entende-se por agrupamento uma expressão regular
	 * contida entre parêntenses
	 */
	"agrupamento": function(nodoRaizDoAgrupamento) {
		nodoRaizDoAgrupamento.elemento.inicioDeAgrupamento = true;
		var topoDaPilha = this.pilha.pop();
		if (topoDaPilha !== undefined && (Utilitarios.instanciaDe(topoDaPilha, OperacaoBinaria) && topoDaPilha.simbolo === ".")) {
			topoDaPilha = this.pilha.pop();
		}
		if (topoDaPilha === undefined) {
			this.arvore.raiz = nodoRaizDoAgrupamento;
			this.pilha.push(nodoRaizDoAgrupamento);
		} else if (Utilitarios.instanciaDe(topoDaPilha, SimboloDeAgrupamento) && topoDaPilha.simbolo === "(") {
			this.pilha.push(topoDaPilha);
			this.arvore.raiz = nodoRaizDoAgrupamento;
			this.pilha.push(nodoRaizDoAgrupamento);
		} else if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
			var nodoDaOperacao = this.arvore.adicionarRaiz(new OperacaoBinaria("."));
			this.arvore.adicionarFilhoNaEsquerda(nodoDaOperacao, topoDaPilha);
			this.arvore.adicionarNodoFilhoNaDireita(nodoDaOperacao, nodoRaizDoAgrupamento);
			this.pilha.push(nodoDaOperacao);
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && ((Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria) && topoDaPilha.elemento.simbolo === ".") || Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoUnaria) || topoDaPilha.elemento.inicioDeAgrupamento)) {
			var nodoDaOperacao = this.arvore.adicionarPai(topoDaPilha, new OperacaoBinaria("."));
			this.arvore.adicionarNodoFilhoNaDireita(nodoDaOperacao, nodoRaizDoAgrupamento);
			this.pilha.push(nodoDaOperacao);
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria) && topoDaPilha.elemento.simbolo === "|") {
			var nodoDaOperacao = this.arvore.adicionarPai(topoDaPilha.filhoDaDireita, new OperacaoBinaria("."));
			this.arvore.adicionarNodoFilhoNaDireita(nodoDaOperacao, nodoRaizDoAgrupamento);
			this.pilha.push(topoDaPilha);
		} else if (Utilitarios.instanciaDe(topoDaPilha, OperacaoBinaria) && topoDaPilha.simbolo === "|") {
			topoDaPilha = this.pilha.pop();
			if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
				var nodoDaOperacao = this.arvore.adicionarRaiz(new OperacaoBinaria("|"));
				this.arvore.adicionarFilhoNaEsquerda(nodoDaOperacao, topoDaPilha);
				this.arvore.adicionarNodoFilhoNaDireita(nodoDaOperacao, nodoRaizDoAgrupamento);
				this.pilha.push(nodoDaOperacao);
			} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && (Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria) || Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoUnaria))) {
				var nodoDaOperacao = this.arvore.adicionarPai(topoDaPilha, new OperacaoBinaria("|"));
				this.arvore.adicionarNodoFilhoNaDireita(nodoDaOperacao, nodoRaizDoAgrupamento);
				this.pilha.push(nodoDaOperacao);
			} else {
				throw this.excecaoDeExpressaoRegularInvalida;
			}
		} else {
			throw this.excecaoDeExpressaoRegularInvalida;
		}
	},
	
	/**
	 * Função: operacaoUnaria
	 * Parâmetros:
	 * 	- operacaoUnaria: operação que será efetivada
	 * Descrição: cria um novo nodo da árvore contendo a operação fornecida. Essa operação consumirá
	 * da pilha um símbolo ou agrupamento
	 */
	"operacaoUnaria": function(operacaoUnaria) {
		var topoDaPilha = this.pilha.pop();
		if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
			var nodoDaOperacao = this.arvore.adicionarRaiz(operacaoUnaria);
			this.arvore.adicionarFilhoNaEsquerda(nodoDaOperacao, topoDaPilha);
			this.pilha.push(nodoDaOperacao);
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria)) {
			var nodoAtual = topoDaPilha;
			while (!nodoAtual.elemento.inicioDeAgrupamento) {
				nodoAtual = nodoAtual.filhoDaDireita;
				if (nodoAtual === null) {
					throw this.excecaoDeExpressaoRegularInvalida;
				}
			}
			this.arvore.adicionarPai(nodoAtual, operacaoUnaria);
			this.pilha.push(this.arvore.raiz);
		} else {
			throw this.excecaoDeExpressaoRegularInvalida;
		}	
	},
	
	/**
	 * Função: *
	 * Descrição: chama a função operacaoUnaria com o parâmetro *
	 */
	"*": function() {
		this.operacaoUnaria(new OperacaoUnaria("*"));
	},
	
	/**
	 * Função: .
	 * Descrição: adiciona uma operação binária pendente no topo da pilha
	 */
	".": function() {
		var topoDaPilha = this.pilha.pop();
		if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
			this.pilha.push(topoDaPilha);
			this.pilha.push(new OperacaoBinaria("."));
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria)) {
			this.pilha.push(topoDaPilha);
			this.pilha.push(new OperacaoBinaria("."));
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoUnaria)) {
			this.pilha.push(topoDaPilha);
			this.pilha.push(new OperacaoBinaria("."));
		} else {
			throw this.excecaoDeExpressaoRegularInvalida;
		}
	},
	
	/**
	 * Função: |
	 * Descrição: adiciona uma operação binária pendente no topo da pilha
	 */
	"|": function() {
		var topoDaPilha = this.pilha.pop();
		if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
			this.pilha.push(topoDaPilha);
			this.pilha.push(new OperacaoBinaria("|"));
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria)) {
			this.pilha.push(topoDaPilha);
			this.pilha.push(new OperacaoBinaria("|"));
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoUnaria)) {
			this.pilha.push(topoDaPilha);
			this.pilha.push(new OperacaoBinaria("|"));
		} else {
			throw this.excecaoDeExpressaoRegularInvalida;
		}
	},
	
	/**
	 * Função: +
	 * Descrição: decompõe a operação a+ em uma operação aa* e adiciona na árvore as operações
	 * resultante dessa decomposição
	 */
	"+": function() {
		/**
		 * Função: clonarElemento
		 * Parâmetros: 
		 * 	- elemento: elemento que será clonado
		 * Descrição: clona um elemento que será duplicado na árvore
		 */
		var clonarElemento = function(elemento) {
			var novoElemento = null;
			if (!Utilitarios.instanciaDe(elemento, SimboloDeAgrupamento)) {
				if (Utilitarios.instanciaDe(elemento, SimboloDoAlfabeto)) {
					novoElemento = new SimboloDoAlfabeto(elemento.simbolo);
					this.nodosFolha++;
					novoElemento.indiceNaArvore = this.nodosFolha;
				} else if (Utilitarios.instanciaDe(elemento, OperacaoBinaria)) {
					novoElemento = new OperacaoBinaria(elemento.simbolo);
				} else if (Utilitarios.instanciaDe(elemento, OperacaoUnaria)) { 
					novoElemento = new OperacaoUnaria(elemento.simbolo);
				} 
				novoElemento.inicioDeAgrupamento = elemento.inicioDeAgrupamento;
			} else {
				novoElemento = new SimboloDeAgrupamento(elemento.simbolo, elemenento.arvoreSalva);
			}
			return novoElemento;
		};
		clonarElemento = clonarElemento.bind(this);
		/**
		 * Função: clonarRamo
		 * Parâmetros: 
		 * 	- nodoDePartida: nodo de partica do ramo a ser clonado
		 * Descrição: clona um ramo que será duplicado na árvore
		 */
		var clonarRamo = function(nodoDePartida) {
			var novaArvore = new ArvoreBinaria();
			var fila = [];
			var filaDosNovos = [];
			var indice = 0;
			var novoNodoDePartida = novaArvore.adicionarRaiz(clonarElemento(nodoDePartida.elemento));
			fila.push(nodoDePartida);
			filaDosNovos.push(novoNodoDePartida);
			while (indice < fila.length) {
				var nodoAtual = fila[indice];
				var nodoAtualNovo = filaDosNovos[indice];
				if (nodoAtual.filhoDaEsquerda !== null) {
					novaArvore.adicionarFilhoNaEsquerda(nodoAtualNovo, clonarElemento(nodoAtual.filhoDaEsquerda.elemento));
					fila.push(nodoAtual.filhoDaEsquerda);
					filaDosNovos.push(nodoAtualNovo.filhoDaEsquerda);
				}
				if (nodoAtual.filhoDaDireita !== null) {
					novaArvore.adicionarFilhoNaDireita(nodoAtualNovo, clonarElemento(nodoAtual.filhoDaDireita.elemento));
					fila.push(nodoAtual.filhoDaDireita);
					filaDosNovos.push(nodoAtualNovo.filhoDaDireita);
				}
				indice++;
			}
			return novaArvore.raiz;
		};
		clonarRamo = clonarRamo.bind(this);
		var topoDaPilha = this.pilha.pop();
		if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
			var novoNodoFolha = new SimboloDoAlfabeto(topoDaPilha.simbolo);
			this.nodosFolha++;
			novoNodoFolha.indiceNaArvore = this.nodosFolha;
			var nodoDaOperacao = this.arvore.adicionarRaiz(new OperacaoBinaria("."));
			this.arvore.adicionarFilhoNaEsquerda(nodoDaOperacao, topoDaPilha);
			var nodoDoFechamento = this.arvore.adicionarFilhoNaDireita(nodoDaOperacao, new OperacaoUnaria("*"));
			this.arvore.adicionarFilhoNaEsquerda(nodoDoFechamento, novoNodoFolha);
			this.pilha.push(nodoDaOperacao);
		} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo) && Utilitarios.instanciaDe(topoDaPilha.elemento, OperacaoBinaria)) {
			var nodoAtual = topoDaPilha;
			while (!nodoAtual.elemento.inicioDeAgrupamento) {
				nodoAtual = nodoAtual.filhoDaDireita;
				if (nodoAtual === null) {
					throw this.excecaoDeExpressaoRegularInvalida;
				}
			}
			var nodoDaOperacao = this.arvore.adicionarPai(nodoAtual, new OperacaoBinaria("."));
			var nodoDoFechamento = this.arvore.adicionarFilhoNaDireita(nodoDaOperacao, new OperacaoUnaria("*"));
			this.arvore.adicionarNodoFilhoNaEsquerda(nodoDoFechamento, clonarRamo(nodoAtual));
			this.pilha.push(this.arvore.raiz);
		} else {
			throw this.excecaoDeExpressaoRegularInvalida;
		}	
	},
	
	/**
	 * Função: *
	 * Descrição: chama a função operacaoUnaria com o parâmetro *
	 */
	"?": function() {
		this.operacaoUnaria(new OperacaoUnaria("?"));
	},
	
	/**
	 * Função: (
	 * Descrição: adiciona na pilha a abertura de um agrupamento
	 */
	"(": function() {
		this.pilha.push(new SimboloDeAgrupamento("(", this.arvore));
		this.arvore = new ArvoreBinaria();
	},
	
	/**
	 * Função: )
	 * Descrição: fecha um agrupamento que havia sido aberto anteriormente e adiciona na árvore
	 * a sub-árvore resultante que representa esse agrupamento
	 */
	")": function() {
		var topoDaPilha = this.pilha.pop();
		if (!(Utilitarios.instanciaDe(topoDaPilha, SimboloDeAgrupamento) && topoDaPilha.simbolo === "(")) {
			var simboloDeAbertura = this.pilha.pop();
			if (!(Utilitarios.instanciaDe(simboloDeAbertura, SimboloDeAgrupamento) && simboloDeAbertura.simbolo === "(")) {
				throw this.excecaoDeExpressaoRegularInvalida;
			}
			this.arvore = simboloDeAbertura.arvoreSalva;
			if (Utilitarios.instanciaDe(topoDaPilha, SimboloDoAlfabeto)) {
 				this.simboloDoAlfabeto(topoDaPilha.simbolo);
			} else if (Utilitarios.instanciaDe(topoDaPilha, Nodo)) {
				this.agrupamento(topoDaPilha);
			} else {
				throw this.excecaoDeExpressaoRegularInvalida;
			}
		}
	}
});

var OperacaoUnaria = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros: 
	 * 	- operacao: operação que representa a operação unária
	 * Descrição: inicializa as estruturas da operação unária: simbolo, inicioDeAgrupamento, nodo e costura
	 */
	inicializar: function(operacao) {
		this.simbolo = operacao;
		this.inicioDeAgrupamento = false;
		this.nodo = null;
		this.costura = null;
	},
	
	/**
	 * Função: comoTexto
	 * Descrição: fornece a representação textual da operação unária
	 */
	comoTexto: function() {
		return this.simbolo;
	},
	
	/**
	 * Função: subir
	 * Parâmetros: 
	 * 	- composicao: composicao que contém os nodos folha do percorrimento atual
	 * Descrição: sobe na árvore de acordo com a especificação subir de cada operação unária
	 */
	subir: function(composicao) {
		if (this.simbolo === "*") {
			this.nodo.filhoDaEsquerda.elemento.descer(composicao);
		}
		if (this.costura !== null) {
			this.costura.elemento.subir(composicao);
		} else {
			composicao.final = true;
		}
	},
	
	/**
	 * Função: descer
	 * Parâmetros: 
	 * 	- composicao: composicao que contém os nodos folha do percorrimento atual
	 * Descrição: desce na árvore de acordo com a especificação subir de cada operação unária
	 */
	descer: function(composicao) {
		this.nodo.filhoDaEsquerda.elemento.descer(composicao);
		if (this.costura !== null) {
			this.costura.elemento.subir(composicao);
		} else {
			composicao.final = true;
		}
	}
});

var OperacaoBinaria = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros: 
	 * 	- operacao: operação que representa a operação binária
	 * Descrição: inicializa as estruturas da operação binária: simbolo, inicioDeAgrupamento, nodo e costura
	 */
	inicializar: function(operacao) {
		this.simbolo = operacao;
		this.inicioDeAgrupamento = false;
		this.nodo = null;
		this.costura = null;
	},
	
	/**
	 * Função: comoTexto
	 * Descrição: fornece a representação textual da operaçã binária
	 */
	comoTexto: function() {
		return this.simbolo;
	},
	
	/**
	 * Função: subir
	 * Parâmetros: 
	 * 	- composicao: composicao que contém os nodos folha do percorrimento atual
	 * Descrição: sobe na árvore de acordo com a especificação subir de cada operação binária
	 */
	subir: function(composicao) {
		if (this.simbolo === ".") {
			this.costura.elemento.descer(composicao);
		} else	if (this.simbolo === "|") {
			if (this.costura !== null) { 
				this.costura.elemento.subir(composicao);
			} else {
				composicao.final = true;
			}
		}
	},
	
	/**
	 * Função: desce
	 * Parâmetros: 
	 * 	- composicao: composicao que contém os nodos folha do percorrimento atual
	 * Descrição: desce na árvore de acordo com a especificação subir de cada operação binária
	 */
	descer: function(composicao) {
		this.nodo.filhoDaEsquerda.elemento.descer(composicao);
		if (this.simbolo === "|") {
			this.nodo.filhoDaDireita.elemento.descer(composicao);
		}
	}
});

var SimboloDoAlfabeto = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros: 
	 * 	- simbolo: símbolo que representa o simbolo do alfabeto
	 * Descrição: inicializa as estruturas do simbolo do alfabeto: simbolo, inicioDeAgrupamento,
	 * indiceNaArvore, nodo e costura
	 */
	inicializar: function(simbolo) {
		this.simbolo = simbolo;
		this.inicioDeAgrupamento = true;
		this.indiceNaArvore = null;
		this.nodo = null;
		this.costura = null;
	},
	
	/**
	 * Função: comoTexto
	 * Descrição: fornece a representação textual do simbolo do alfabeto
	 */
	comoTexto: function() {
		return this.simbolo;
	},
	
	/**
	 * Função: subir
	 * Parâmetros: 
	 * 	- composicao: composicao que contém os nodos folha do percorrimento atual
	 * Descrição: sobe na árvore de acordo com a especificação subir dos símbolos do alfabeto
	 */
	subir: function(composicao) {
		if (this.costura !== null) {
			this.costura.elemento.subir(composicao);
		} else {
			composicao.final = true;
		}
	},
	
	/**
	 * Função: desce
	 * Parâmetros: 
	 * 	- composicao: composicao que contém os nodos folha do percorrimento atual
	 * Descrição: desce na árvore de acordo com a especificação subir dos símbolos do alfabeto
	 */
	descer: function(composicao) {
		if (composicao[this.simbolo] === undefined) {
			composicao[this.simbolo] = {};
		}
		composicao[this.simbolo][(this.indiceNaArvore).toString()] = this.nodo;
	}
});

var SimboloDeAgrupamento = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros: 
	 * 	- simbolo: símbolo de agrupamento que pode ser ( ou )
	 * 	- arvoreSalva: arvore existente no momento da abertura do agrupamento
	 * Descrição: inicializa as estruturas do simbolo de agrupamento: simbolo e arvoreSalva
	 */
	inicializar: function(simbolo, arvoreSalva) {
		this.simbolo = simbolo;
		this.arvoreSalva = arvoreSalva;
	},
	
	/**
	 * Função: comoTexto
	 * Descrição: fornece a representação textual do símbolo de agrupamento
	 */
	comoTexto: function() {
		return this.simbolo;
	}
});

var ProvedorDeSimbolosDeEstados = new Prototipo({
	/**
	 * Função: inicializar
	 * Parâmetros: 
	 * Descrição: inicializa as estruturas do provedor de simbolos de estados: simbolosDeEstados
	 */
	inicializar: function() {
		this.simbolosDeEstados = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "W", "V", "X", "Y", "Z"];
	},
	
	/**
	 * Função: fornecerNovo
	 * Descrição: fornece um novo símbolo de estado eleminando esse símbolo da lista de símbolos 
	 * que ainda podem ser fornecidos
	 */
	fornecerNovo: function() {
		return this.simbolosDeEstados.shift();
	}
});

var ExpressoesRegulares = {
	/**
	 * Função: criar
	 * Parâmetros: 
	 * 	- nome: nome da expressão regular a ser criada
	 * Descrição: cria uma nova expressão regular de acordo com o nome fornecido
	 */
	criar: function(nome) {
		if (ConjuntoDeExpressoesRegulares[nome] === undefined) {
			ConjuntoDeExpressoesRegulares[nome] = new ExpressaoRegular();
			return true;
		}
		return false;
	},
	
	/**
	 * Função: salvar
	 * Parâmetros: 
	 * 	- nome: nome da expressão regular a ser salva
	 * 	- expressaoRegularTextual: expressão regular textual a ser salva
	 * Descrição: salva a expressão regular caso seja possível construir a árvore e caso contrário
	 * não salva, pois a expressão regular fornecida é inválida
	 */
	salvar: function(nome, expressaoRegularTextual) {
		var expressaoRegular = ConjuntoDeExpressoesRegulares[nome];
		var construtorDaArvore = new TabelaDeSimbolosConstrutora();
		if (expressaoRegular !== undefined && construtorDaArvore.construir(expressaoRegularTextual)) {
			expressaoRegular.expressaoRegularTextual = expressaoRegularTextual;
			expressaoRegular.arvoreDeConstrucao = construtorDaArvore.arvore;
			return true;
		} else {
			expressaoRegular.arvoreDeConstrucao = null;
		}
		return false;
	},
	
	/**
	 * Função: converterParaAutomatoFinito
	 * Parâmetros: 
	 * 	- nome: nome da expressão regular a ser convertida
	 * Descrição: caso a árvore de construção da expressão regular exista, então usa as funções
	 * de subir e descer para andar pela árvore e construir as composições para finalmente
	 * construir o autômato finito
	 */
	converterParaAutomatoFinito: function(nome) {
		var expressaoRegular = ConjuntoDeExpressoesRegulares[nome];
		if (expressaoRegular !== undefined && expressaoRegular.arvoreDeConstrucao !== null) {
			var provedorDeSimbolosDeEstados = new ProvedorDeSimbolosDeEstados();
			var estadosPendentes = [];
			var estados = {};
			var estadosAvaliadosEPendentes = {};
			var simboloDoEstadoInicial = provedorDeSimbolosDeEstados.fornecerNovo();
			var estadoInicial = this.criarEstado(simboloDoEstadoInicial, null);
			estadoInicial.inicial = true;
			estados[simboloDoEstadoInicial] = estadoInicial; 
			estadosAvaliadosEPendentes[simboloDoEstadoInicial] = estadoInicial;
			expressaoRegular.arvoreDeConstrucao.raiz.elemento.descer(estadoInicial.composicao);
			estadoInicial.final = estadoInicial.composicao.final;
			delete estadoInicial.composicao["final"];
			Utilitarios.paraCada(estadoInicial.composicao, function(nodosFolha, simbolo) {
				var simboloDoEstado = provedorDeSimbolosDeEstados.fornecerNovo();
				var estadoDeTransicao = this.criarEstado(simboloDoEstado, nodosFolha);
				estadosPendentes.push(estadoDeTransicao);
				estadosAvaliadosEPendentes[simboloDoEstado] = estadoDeTransicao;
				estadoInicial.transicoes[simbolo] = estadoDeTransicao; 
			}, this);
			while (estadosPendentes.length > 0) {
				var estadoPendente = estadosPendentes.shift();
				Utilitarios.paraCada(estadoPendente.nodosFolha, function(nodoFolha, indiceDoNodoFolha) {
					nodoFolha.elemento.subir(estadoPendente.composicao);
					estadoPendente.final = estadoPendente.composicao.final;
				});
				delete estadoPendente.composicao["final"];
				var estadoEquivalente = this.encontrarEstadoEquivalente(estados, estadoPendente.composicao);
				if (estadoEquivalente !== null) {
					Utilitarios.paraCada(estadosAvaliadosEPendentes, function(estado, simboloDoEstado) {
						Utilitarios.paraCada(estado.transicoes, function(transicao, simboloDaTransicao) {
							if (transicao === estadoPendente) {
								estado.transicoes[simboloDaTransicao] = estadoEquivalente;
							}
						});
					});
					delete estadosAvaliadosEPendentes[estadoPendente.simbolo];
				} else {
					Utilitarios.paraCada(estadoPendente.composicao, function(nodosFolha, simbolo) {
						var estadoDeTransicao = this.encontrarEstadoDeTransicao(estadosAvaliadosEPendentes, nodosFolha);
						if (estadoDeTransicao === null) {
							var simboloDoEstado = provedorDeSimbolosDeEstados.fornecerNovo();
							estadoDeTransicao = this.criarEstado(simboloDoEstado, nodosFolha);
							estadosPendentes.push(estadoDeTransicao);
							estadosAvaliadosEPendentes[simboloDoEstado] = estadoDeTransicao;
						}
						estadoPendente.transicoes[simbolo] = estadoDeTransicao; 
					}, this);
					estados[estadoPendente.simbolo] = estadoPendente;
				}
			}
			return estados;
		}
		return {};
	},
	
	/**
	 * Função: criarEstado
	 * Parâmetros: 
	 * 	- simbolo: simbolo do estado a ser criado
	 * 	- nodosFolha: nodos folha que foram responsáveis para a criação desse estado
	 * Descrição: função que é usada pela função converterParaAutomatoFinito e cria um novo estado
	 * resultante de uma composição
	 */
	criarEstado: function(simbolo, nodosFolha) {
		if (nodosFolha === null) {
			nodosFolha = {};
		}
		var estado = {
			simbolo: simbolo,
			transicoes: {},
			composicao: {
				final: false
			},
			nodosFolha: nodosFolha,
			final: false,
			inicial: false
		};
		return estado;
	},
	
	/**
	 * Função: encontrarEstadoDeTransicao
	 * Parâmetros: 
	 * 	- estados: estados existentes no autômato pré-construído
	 * 	- nodosFolha: nodos folha da composição do estado o qual se deseja encontrar as transições
	 * Descrição: função que é usada pela função converterParaAutomatoFinito e essa função é chamada após 
	 * a realização da composição de um estado. Seu objetivo é verificar se o estado da transição que vai ser 
	 * gerada a partir dessa composição já existe ou se é necessário criar um estado novo
	 */
	encontrarEstadoDeTransicao: function(estados, nodosFolha) {
		var estadoDaTransicao = null;
		Utilitarios.paraCada(estados, function(estado, simboloDoEstado) {
			var encontrouEstadoDeTransicao = true;
			if (estado.nodosFolha !== undefined && Object.keys(estado.nodosFolha).length === Object.keys(nodosFolha).length) {
				Utilitarios.paraCada(nodosFolha, function(nodoFolha, indiceDoNodoFolha) {
					var nodoFolhaDoEstadoDeTransicao = estado.nodosFolha[indiceDoNodoFolha];
					if (nodoFolhaDoEstadoDeTransicao === undefined || nodoFolhaDoEstadoDeTransicao !== nodoFolha) {
						encontrouEstadoDeTransicao = false;
					}
				});
			} else {
				encontrouEstadoDeTransicao = false;
			}
			if (encontrouEstadoDeTransicao) {
				estadoDaTransicao = estado;
				return;
			}
		});
		return estadoDaTransicao;
	},
	
	/**
	 * Função: encontrarEstadoEquivalente
	 * Parâmetros: 
	 * 	- estados: estados exsitentes no autômato pré construído
	 * 	- composicao: do estado o qual se deseja encontrar estados equivalentes
	 * Descrição: função que é usada pela função converterParaAutomatoFinito que verifica se um estado
	 * criado já possui um equivalente e se possuir elimina-o do autômato
	 */
	encontrarEstadoEquivalente: function(estados, composicao) {
		var estadoEquivalente = null;
		Utilitarios.paraCada(estados, function(estado, simboloDoEstado) {
			if (Object.keys(estado.composicao).length === Object.keys(composicao).length) {
				var encontrouEstadoEquivalente = true;
				Utilitarios.paraCada(composicao, function(agrupamentoDoSimbolo, simbolo) {
					var agrupamentoDoSimboloDoEstado = estado.composicao[simbolo];
					if (agrupamentoDoSimboloDoEstado !== undefined && Object.keys(agrupamentoDoSimboloDoEstado).length === Object.keys(agrupamentoDoSimbolo).length) {
						Utilitarios.paraCada(agrupamentoDoSimbolo, function(nodoFolha, indiceDoNodoFolha) {
							var nodoFolhaDoEstado = agrupamentoDoSimboloDoEstado[indiceDoNodoFolha];
							if (nodoFolhaDoEstado === undefined || nodoFolhaDoEstado !== nodoFolha) {
								encontrouEstadoEquivalente = false;
								return;
							}
						});
					} else {
						encontrouEstadoEquivalente = false;
						return;
					}
				});
				if (encontrouEstadoEquivalente) {
					estadoEquivalente = estado;
					return;
				}
			}
		});
		return estadoEquivalente;
	},
	
	
	/**
	 * Função: clonar
	 * Parâmetros: 
	 * 	- nomeDaExpressaoRegular: nome da expressão regular a ser clonada
	 * 	- nomeDaExpressaoRegularClonada: nome da expressão regular resultante da clonagem
	 * Descrição: clona uma dada expressão regular
	 */
	clonar: function(nomeDaExpressaoRegular, nomeDaExpressaoRegularClonada) {
		 var expressaoRegular = ConjuntoDeExpressoesRegulares[nomeDaExpressaoRegular];
		 if (expressaoRegular !== undefined && this.criar(nomeDaExpressaoRegularClonada)) {
			 return this.salvar(nomeDaExpressaoRegularClonada, expressaoRegular.expressaoRegularTextual);
		 }
		 return false;
	},
	 
	/**
	 * Função: remover
	 * Parâmetros: 
	 * 	- nomeDaExpressaoRegular: nome da expressão regular a ser removida
	 * Descrição: remove a expressão regular desejada do ConjuntoDeExpressoesRegulares
	 */
	remover: function(nomeDaExpressaoRegular) {
		 delete ConjuntoDeExpressoesRegulares[nomeDaExpressaoRegular];
	}
};