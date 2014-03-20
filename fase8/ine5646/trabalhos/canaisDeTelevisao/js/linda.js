(function (contexto) {
	"use strict";

	var ExcecaoLinda = function (mensagem) {
		this.mensagem = mensagem;
		this.message = mensagem;
	};

	ExcecaoLinda.prototype.comoTexto = function () {
		return ("ExcecaoLinda: " + this.mensagem);
	};

	var Linda = {
		propriedadesDeAtributos: {
			configuravel: false,
			enumeravel: false,
			gravavel: false,
			fornecer: undefined,
			fixar: undefined,
			valor: undefined
		},

		propriedadesDeAtributosGravaveis: {
			configuravel: false,
			enumeravel: false,
			gravavel: true,
			fornecer: undefined,
			fixar: undefined,
			valor: undefined
		},

		propriedadesDeAtributosGravaveisConfiguraveis: {
			configuravel: true,
			enumeravel: false,
			gravavel: true,
			fornecer: undefined,
			fixar: undefined,
			valor: undefined
		},

		tipos: {
			OBJETO: "object",
			FUNCAO: "function",
			TEXTO: "string",
			NUMERO: "number",
			BOOLEANO: "boolean",
			INDEFINIDO: "undefined"
		},

		instanciaDe: function (objeto, tipo) {
			if (!this.tipoDe(tipo, Function) || this.nulo(objeto)) {
				return false;
			}
			if (this.tipoPrimitivo(objeto)) {
				return this.tipoDe(objeto, tipo);
			}
			return objeto.instanciaDe(tipo);
		},

		tipoPrimitivo: function (valor) {
			return (
				this.tipoDe(valor, String) ||
				this.tipoDe(valor, Number) ||
				this.tipoDe(valor, Boolean) ||
				this.tipoDe(valor, undefined)
			);
		},

		tipoDe: function (tipo, tipoComparado) {
			var tipoComparadoTextual = "";
			if (tipoComparado === Object) {
				tipoComparadoTextual = this.tipos.OBJETO;
			} else if (tipoComparado === Function) {
				tipoComparadoTextual = this.tipos.FUNCAO;
			} else if (tipoComparado === String) {
				tipoComparadoTextual = this.tipos.TEXTO;
			} else if (tipoComparado === Number) {
				tipoComparadoTextual = this.tipos.NUMERO;
			} else if (tipoComparado === Boolean) {
				tipoComparadoTextual = this.tipos.BOOLEANO;
			} else if (tipoComparado === undefined) {
				tipoComparadoTextual = this.tipos.INDEFINIDO;
			}
			return (typeof tipo === tipoComparadoTextual);
		},

		nuloOuIndefinido: function (valor) {
			return (valor === null || valor === undefined);
		},

		nulo: function (valor) {
			return (valor === null);
		},

		indefinido: function (valor) {
			return (valor === undefined);
		},

		existe: function (valor) {
			return (valor !== null && valor !== undefined);
		},

		assegureQue: function (condicao) {
			if (!condicao) {
				throw new ExcecaoLinda("Asserção inválida. Quebra de contrato.");
			}
		},

		assegureQueNao: function (condicao) {
			this.assegureQue(!condicao);
		}
	};

	contexto.Linda = Linda;
}(this));
(function () {
	"use strict";

	Function.prototype.implementar = function (implementacoes) {
		for (var implementacao in implementacoes) {
			if (implementacoes.hasOwnProperty(implementacao)) {
				this.prototype[implementacao] = implementacoes[implementacao];
			}
		}
	};

	Function.implementar({
		aplicarComEscopo: Function.prototype.apply,

		chamarComEscopo: Function.prototype.call,

		estender: function (implementacoes) {
			for (var implementacao in implementacoes) {
				if (implementacoes.hasOwnProperty(implementacao)) {
					this[implementacao] = implementacoes[implementacao];
				}
			}
		},

		vincularEscopo: function (escopo) {
			var essaFuncao = this;
			var funcaoComEscopoVinculado = function () {
				return essaFuncao.aplicarComEscopo(escopo, arguments);
			};
			return funcaoComEscopoVinculado;
		}
	});
}(this));
(function (contexto) {
	"use strict";

	var Linda = contexto.Linda;

	Object.implementar({
		cadaPropriedade: function (iterador, escopo) {
			iterador = iterador.vincularEscopo(escopo);
			var propriedades = this.fornecerPropriedades();
			for (var indice = 0, tamanho = propriedades.length; indice < tamanho; indice++) {
				var chave = propriedades[indice];
				iterador(this[chave], chave);
			}
		},

		cadaPropriedadeEnumeravel: function (iterador, escopo) {
			iterador = iterador.vincularEscopo(escopo);
			for (var chave in this) {
				iterador(this[chave], chave);
			}
		},

		cadaPropriedadeInvisivel: function (iterador, escopo) {
			iterador = iterador.vincularEscopo(escopo);
			var propriedadesInvisiveis = this.fornecerPropriedadesInvisiveis();
			for (var indice = 0, tamanho = propriedadesInvisiveis.length; indice < tamanho; indice++) {
				var chave = propriedadesInvisiveis[indice];
				iterador(this[chave], chave);
			}
		},

		cadaPropriedadePropria: function (iterador, escopo) {
			iterador = iterador.vincularEscopo(escopo);
			var propriedadesProprias = this.fornecerPropriedadesProprias();
			for (var indice = 0, tamanho = propriedadesProprias.length; indice < tamanho; indice++) {
				var chave = propriedadesProprias[indice];
				iterador(this[chave], chave);
			}
		},

		cadaPropriedadePropriaEnumeravel: function (iterador, escopo) {
			iterador = iterador.vincularEscopo(escopo);
			var propriedadesPropriasEnumeraveis = this.fornecerPropriedadesPropriasEnumeraveis();
			for (var indice = 0, tamanho = propriedadesPropriasEnumeraveis.length; indice < tamanho; indice++) {
				var chave = propriedadesPropriasEnumeraveis[indice];
				iterador(this[chave], chave);
			}
		},

		cadaPropriedadePropriaInvisivel: function (iterador, escopo) {
			iterador = iterador.vincularEscopo(escopo);
			var propriedadesPropriasInvisiveis = this.fornecerPropriedadesPropriasInvisiveis();
			for (var indice = 0, tamanho = propriedadesPropriasInvisiveis.length; indice < tamanho; indice++) {
				var chave = propriedadesPropriasInvisiveis[indice];
				iterador(this[chave], chave);
			}
		},

		cadaPropriedadeHerdada: function (iterador, escopo) {
			iterador = iterador.vincularEscopo(escopo);
			var propriedadesHerdadas = this.fornecerPropriedadesHerdadas();
			for (var indice = 0, tamanho = propriedadesHerdadas.length; indice < tamanho; indice++) {
				var chave = propriedadesHerdadas[indice];
				iterador(this[chave], chave);
			}
		},

		cadaPropriedadeHerdadaEnumeravel: function (iterador, escopo) {
			iterador = iterador.bind(escopo);
			for (var chave in this) {
				if (!this.possuiPropriedadePropriaEnumeravel(chave)) {
					iterador(this[chave], chave);
				}
			}
		},

		cadaPropriedadeHerdadaInvisivel: function (iterador, escopo) {
			iterador = iterador.vincularEscopo(escopo);
			var propriedadesHerdadasInvisiveis = this.fornecerPropriedadesHerdadasInvisiveis();
			for (var indice = 0, tamanho = propriedadesHerdadasInvisiveis.length; indice < tamanho; indice++) {
				var chave = propriedadesHerdadasInvisiveis[indice];
				iterador(this[chave], chave);
			}
		},

		fornecerPropriedades: function () {
			var propriedades = this.fornecerPropriedadesProprias();
			var prototipo = this.fornecerPrototipo();
			while (!Linda.nulo(prototipo)) {
				propriedades.push.aplicarComEscopo(propriedades, prototipo.fornecerPropriedadesProprias());
				prototipo = prototipo.fornecerPrototipo();
			}
			return propriedades;
		},

		fornecerPropriedadesEnumeraveis: function () {
			var propriedadesEnumeraveis = [];
			for (var propriedade in this) {
				propriedadesEnumeraveis.push(propriedade);
			}
			return propriedadesEnumeraveis;
		},

		fornecerPropriedadesInvisiveis: function () {
			var propriedades = this.fornecerPropriedades();
			var propriedadesInvisiveis = [];
			for (var indice = 0, tamanho = propriedades.length; indice < tamanho; indice++) {
				var propriedade = propriedades[indice];
				if (!this.possuiPropriedadeEnumeravel(propriedade)) {
					propriedadesInvisiveis.push(propriedade);
				}
			}
			return propriedadesInvisiveis;
		},

		fornecerPropriedadesProprias: function () {
			return Object.getOwnPropertyNames(this);
		},

		fornecerPropriedadesPropriasEnumeraveis: function () {
			return Object.keys(this);
		},

		fornecerPropriedadesPropriasInvisiveis: function () {
			var propriedadesProprias = this.fornecerPropriedadesProprias();
			var propriedadesPropriasInvisiveis = [];
			for (var indice = 0, tamanho = propriedadesProprias.length; indice < tamanho; indice++) {
				var propriedadePropria = propriedadesProprias[indice];
				if (!this.possuiPropriedadePropriaEnumeravel(propriedadePropria)) {
					propriedadesPropriasInvisiveis.push(propriedadePropria);
				}
			}
			return propriedadesPropriasInvisiveis;
		},

		fornecerPropriedadesHerdadas: function () {
			var propriedadesHerdadas = [];
			var prototipo = this.fornecerPrototipo();
			while (!Linda.nulo(prototipo)) {
				propriedadesHerdadas.push.aplicarComEscopo(propriedadesHerdadas, prototipo.fornecerPropriedadesProprias());
				prototipo = prototipo.fornecerPrototipo();
			}
			return propriedadesHerdadas;
		},

		fornecerPropriedadesHerdadasEnumeraveis: function () {
			var propriedadesHerdadasEnumeraveis = [];
			for (var propriedadeEnumeravel in this) {
				if (!this.possuiPropriedadePropriaEnumeravel(propriedadeEnumeravel)) {
					propriedadesHerdadasEnumeraveis.push(propriedadeEnumeravel);
				}
			}
			return propriedadesHerdadasEnumeraveis;
		},

		fornecerPropriedadesHerdadasInvisiveis: function () {
			var propriedadesHerdadas = this.fornecerPropriedadesHerdadas();
			var propriedadesHerdadasInvisiveis = [];
			for (var indice = 0, tamanho = propriedadesHerdadas.length; indice < tamanho; indice++) {
				var propriedadeHerdada = propriedadesHerdadas[indice];
				if (!this.possuiPropriedadeHerdadaEnumeravel(propriedadeHerdada)) {
					propriedadesHerdadasInvisiveis.push(propriedadeHerdada);
				}
			}
			return propriedadesHerdadasInvisiveis;
		},

		possuiPropriedade: function (propriedade) {
			return (propriedade in this);
		},

		possuiPropriedadeEnumeravel: function (propriedade) {
			for (var minhaPropriedade in this) {
				if (minhaPropriedade === propriedade) {
					return true;
				}
			}
			return false;
		},

		possuiPropriedadeInvisivel: function (propriedade) {
			return (this.possuiPropriedade(propriedade) && !this.possuiPropriedadeEnumeravel(propriedade));
		},

		possuiPropriedadePropria: function (propriedade) {
			return this.hasOwnProperty(propriedade);
		},

		possuiPropriedadePropriaEnumeravel: function (propriedade) {
			return this.propertyIsEnumerable(propriedade);
		},

		possuiPropriedadePropriaInvisivel: function (propriedade) {
			return (this.possuiPropriedadePropria(propriedade) && !this.possuiPropriedadePropriaEnumeravel(propriedade));
		},

		possuiPropriedadeHerdada: function (propriedade) {
			return (this.possuiPropriedade(propriedade) && !this.possuiPropriedadePropria(propriedade));
		},

		possuiPropriedadeHerdadaEnumeravel: function (propriedade) {
			return (this.possuiPropriedadeEnumeravel(propriedade) && !this.possuiPropriedadePropriaEnumeravel(propriedade));
		},

		possuiPropriedadeHerdadaInvisivel: function (propriedade) {
			return (this.possuiPropriedadeHerdada(propriedade) && !this.possuiPropriedadeHerdadaEnumeravel(propriedade));
		},

		instanciaDe: function (tipo) {
			if (!Linda.tipoDe(tipo, Function)) {
				return false;
			}
			return tipo.prototype.prototipoDe(this);
		},

		prototipadoDe: function (prototipoDoTipo) {
			var prototipoDoObjeto = this.fornecerPrototipo();
			while (!Linda.nulo(prototipoDoObjeto) && prototipoDoObjeto !== prototipoDoTipo) {
				prototipoDoObjeto = prototipoDoObjeto.fornecerPrototipo();
			}
			return (prototipoDoObjeto === prototipoDoTipo);
		},

		prototipoDe: function (objeto) {
			var prototipoDoObjeto = objeto.fornecerPrototipo();
			while (!Linda.nulo(prototipoDoObjeto) && prototipoDoObjeto !== this) {
				prototipoDoObjeto = prototipoDoObjeto.fornecerPrototipo();
			}
			return (prototipoDoObjeto === this);
		},

		fornecerPrototipo: function () {
			return Object.getPrototypeOf(this);
		},

		fornecerDescritorDePropriedade: function (propriedade) {
			var descritorOriginal = Object.getOwnPropertyDescriptor(this, propriedade);
			var descritor = {};
			this.privadoFornecerDescritorDePropriedade(descritor, descritorOriginal.value, "valor");
			this.privadoFornecerDescritorDePropriedade(descritor, descritorOriginal.get, "fornecer");
			this.privadoFornecerDescritorDePropriedade(descritor, descritorOriginal.set, "fixar");
			this.privadoFornecerDescritorDePropriedade(descritor, descritorOriginal.writable, "gravavel");
			this.privadoFornecerDescritorDePropriedade(descritor, descritorOriginal.enumerable, "enumeravel");
			this.privadoFornecerDescritorDePropriedade(descritor, descritorOriginal.configurable, "configuravel");
			return descritor;
		},

		privadoFornecerDescritorDePropriedade: function (descritor, propriedade, chave) {
			if (!Linda.indefinido(propriedade)) {
				descritor[chave] = propriedade;
			}
		},

		definirPropriedade: function (atributo, definicao) {
			var propriedades = {};
			this.privadoDefinirPropriedade(propriedades, "value", definicao.valor);
			this.privadoDefinirPropriedade(propriedades, "get", definicao.fornecer);
			this.privadoDefinirPropriedade(propriedades, "set", definicao.fixar);
			this.privadoDefinirPropriedade(propriedades, "writable", definicao.gravavel);
			this.privadoDefinirPropriedade(propriedades, "enumerable", definicao.enumeravel);
			this.privadoDefinirPropriedade(propriedades, "configurable", definicao.configuravel);
			Object.defineProperty(this, atributo, propriedades);
		},

		definirPropriedades: function (definicoes) {
			for (var indice = 0, propriedades = Object.getOwnPropertyNames(definicoes), tamanho = propriedades.length; indice < tamanho; indice++) {
				var propriedade = propriedades[indice];
				this.definirPropriedade(propriedade, definicoes[propriedade]);
			}
		},

		privadoDefinirPropriedade: function (propriedades, chave, valor) {
			if (!Linda.indefinido(valor)) {
				propriedades[chave] = valor;
			}
		},

		fundir: function (outro) {
			for (var chave in outro) {
				if (outro.possuiPropriedadePropria(chave)) {
					this[chave] = outro[chave];
				}
			}
		},

		observar: function (tratador, propriedade, tipoDeObservacao) {
			Object.observe(this, function (observacoes) {
				for (var indice = 0, tamanho = observacoes.length; indice < tamanho; indice++) {
					var observacao = observacoes[indice];
					var observacaoDesejada = (observacao.type === tipoDeObservacao || Linda.nuloOuIndefinido(tipoDeObservacao));
					var propriedadeDesejada = (observacao.name === propriedade || Linda.nuloOuIndefinido(propriedade));
					if (observacaoDesejada && propriedadeDesejada) {
						tratador(observacao.object, observacao.name, observacao.type, observacao.oldValue);
					}
				}
			});
		},

		observarAtualizacao: function (tratador, propriedade) {
			var TipoDeObservacao = contexto.TipoDeObservacao;
			this.observar(tratador, propriedade, TipoDeObservacao.ATUALIZACAO);
		},

		observarCriacao: function (tratador, propriedade) {
			var TipoDeObservacao = contexto.TipoDeObservacao;
			this.observar(tratador, propriedade, TipoDeObservacao.CRIACAO);
		},

		observarReconfiguracao: function (tratador, propriedade) {
			var TipoDeObservacao = contexto.TipoDeObservacao;
			this.observar(tratador, propriedade, TipoDeObservacao.RECONFIGURACAO);
		},

		observarRemocao: function (tratador, propriedade) {
			var TipoDeObservacao = contexto.TipoDeObservacao;
			this.observar(tratador, propriedade, TipoDeObservacao.REMOCAO);
		},

		desobservar: function (tratador) {
			Object.unobserve(this, tratador);
		},

		removerPropriedade: function (propriedade) {
			delete this[propriedade];
		}
	});

	Object.implementar({
		paraCada: Object.cadaPropriedadePropriaEnumeravel
	});
}(this));
(function (contexto) {
	"use strict";

	var Linda = contexto.Linda;

	Array.implementar({
		adicionar: function () {
			this.push.aplicarComEscopo(this, arguments);
		},

		tirar: function () {
			return this.pop();
		},

		adicionarNoInicio: function () {
			this.unshift.aplicarComEscopo(this, arguments);
		},

		tirarDoInicio: function () {
			return this.shift();
		},

		clonar: function () {
			var clone = new Array(this.length);
			for (var indice = 0; indice < this.length; indice++) {
				var elemento = this[indice];
				if (Linda.tipoDe(elemento.clonar, Function)) {
					elemento = elemento.clonar();
				}
				clone[indice] = elemento;
			}
			return clone;
		},

		contem: function (valor) {
			return (this.indexOf(valor) >= 0);
		},

		juntarEmTexto: function (separador) {
			return this.join(separador);
		},

		ordenar: function (comparador) {
			return this.sort(comparador);
		},

		embaralhar: function () {
			for (var indice = 0; indice < this.length; indice++) {
				var novoIndice = Number.sortearInteiro(0, this.length - 1);
				var valorSalvo = this[indice];
				this[indice] = this[novoIndice];
				this[novoIndice] = valorSalvo;
			}
		},

		dentroDosLimites: function (indice) {
			return (this.length !== 0 && indice >= 0 && indice < this.length);
		},

		fornecerIndice: function (elemento) {
			return this.indexOf(elemento);
		},

		fundir: function (outra) {
			this.push.aplicarComEscopo(this, outra);
		},

		limpar: function () {
			this.splice(0, this.length);
		},

		paraCada: function (funcaoDeIteracao, escopo) {
			funcaoDeIteracao = funcaoDeIteracao.vincularEscopo(escopo);
			for (var indice = 0; indice < this.length; indice++) {
				funcaoDeIteracao(this[indice], indice);
			}
		},

		quantidadeMenorQue: function (quantidade) {
			return (this.length < quantidade);
		},

		quantidadeMenorIgualQue: function (quantidade) {
			return (this.length <= quantidade);
		},

		quantidadeMaiorQue: function (quantidade) {
			return (this.length > quantidade);
		},

		quantidadeMaiorIgualQue: function (quantidade) {
			return (this.length >= quantidade);
		},

		quantidadeIgual: function (quantidade) {
			return (this.length === quantidade);
		},

		reduzir: function (funcaoDeReducao, valorAtual, escopo) {
			funcaoDeReducao = funcaoDeReducao.vincularEscopo(escopo);
			valorAtual = valorAtual || 0;
			for (var indice = 0; indice < this.length; indice++) {
				valorAtual = funcaoDeReducao(valorAtual, this[indice], indice);
			}
			return valorAtual;
		},

		reduzirSemPrimeiro: function (funcaoDeReducao, valorAtual, escopo) {
			funcaoDeReducao = funcaoDeReducao.vincularEscopo(escopo);
			valorAtual = valorAtual || 0;
			for (var indice = 1; indice < this.length; indice++) {
				valorAtual = funcaoDeReducao(valorAtual, this[indice], indice);
			}
			return valorAtual;
		},

		reduzirSemUltimo: function (funcaoDeReducao, valorAtual, escopo) {
			funcaoDeReducao = funcaoDeReducao.vincularEscopo(escopo);
			valorAtual = valorAtual || 0;
			for (var indice = 0; indice < (this.length - 1); indice++) {
				valorAtual = funcaoDeReducao(valorAtual, this[indice], indice);
			}
			return valorAtual;
		},

		removerPosicao: function (posicao) {
			this.splice(posicao, 1);
		},

		removerElemento: function (elemento) {
			this.removerPosicao(this.fornecerIndice(elemento));
		},

		vazio: function () {
			return (this.length === 0);
		}
	});

	Array.prototype.definirPropriedades({
		primeiro: {
			fornecer: function () {
				return this[0];
			}
		},

		primeiroIndice: {
			fornecer: function () {
				return 0;
			}
		},

		quantidade: {
			fornecer: function () {
				return this.length;
			}
		},

		ultimo: {
			fornecer: function () {
				return this[this.length - 1];
			}
		},

		ultimoIndice: {
			fornecer: function () {
				return (this.length - 1);
			}
		}
	});
} (this));
(function () {
	"use strict";

	String.implementar({
		combinar: function (padrao) {
			return this.match(padrao);
		},

		emBranco: function () {
			var padraoSemEspaco = /^\s*$/;
			return padraoSemEspaco.test(this);
		},

		formatarNumero: function (formato) {
			var formatado = formato;
			var padrao = /[^0-9]/g;
			var padraoDeSubstituicao = /#/;
			var vazio = "";
			var numeros = this.replace(padrao, vazio).split(vazio);
			for (var indice = 0, tamanho = numeros.length; indice < tamanho; indice++) {
				formatado = formatado.replace(padraoDeSubstituicao, numeros[indice]);
			}
			var proximaSubstituicao = formatado.search(padraoDeSubstituicao);
			if (proximaSubstituicao !== -1) {
				formatado = formatado.slice(0, proximaSubstituicao);
			}
			return formatado;
		},

		paraCaixaAlta: function () {
			return this.toUpperCase();
		},

		paraCaixaBaixa: function () {
			return this.toLowerCase();
		},

		paraInteiro: function () {
			return parseInt(this, 10);
		},

		paraFlutuante: function () {
			return parseFloat(this, 10);
		},

		separar: function (padrao) {
			return this.split(padrao);
		},

		substituir: function (padrao, novoTexto) {
			return this.replace(padrao, novoTexto);
		},

		substituirTodos: function (padrao, novoTexto) {
			padrao = new RegExp(padrao, "g");
			return this.replace(padrao, novoTexto);
		}
	});

	String.estender({
		concatenar: function () {
			var texto = "";
			for (var indice = 0, tamanho = arguments.length; indice < tamanho; indice++) {
				texto = texto + arguments[indice];
			}
			return texto;
		},

		concatenarComEspaco: function () {
			var texto = "";
			for (var indice = 0, tamanho = arguments.length; indice < tamanho; indice++) {
				texto = texto + " " + arguments[indice];
			}
			return (arguments.length > 0) ? texto.substr(1, texto.length - 1) : texto;
		},

		formatar: function (mensagem) {
			for (var indice = 1, tamanho = arguments.length; indice < tamanho; indice++) {
				mensagem = mensagem.replace(new RegExp("%@"), arguments[indice]);
				mensagem = mensagem.replace(new RegExp("%" + indice, "g"), arguments[indice]);
			}
			mensagem = mensagem.replace(new RegExp("%@", "g"), "");
			mensagem = mensagem.replace(new RegExp("%[1-9]", "g"), "");
			return mensagem;
		}
	});
}());
(function () {
	"use strict";

	Number.estender({
		naoNumero: function (valor) {
			return (valor !== valor);
		},

		sortear: function (limiteA, limiteB) {
			var limiteInferior = Math.min(limiteA, limiteB);
			var limiteSuperior = Math.max(limiteA, limiteB);
			return (Math.random() * (limiteSuperior - limiteInferior) + limiteInferior);
		},

		sortearInteiro: function (limiteA, limiteB) {
			var limiteInferior = Math.min(limiteA, limiteB);
			var limiteSuperior = Math.max(limiteA, limiteB);
			return (Math.floor(Math.random() * (limiteSuperior - limiteInferior + 1)) + Math.floor(limiteInferior));
		}
	});

	Number.definirPropriedades({
		maximo: {
			fornecer: function () {
				return Number.MAX_VALUE;
			}
		},

		minimo: {
			fornecer: function () {
				return Number.MIN_VALUE;
			}
		},

		maisInfinito: {
			fornecer: function () {
				return Number.POSITIVE_INFINITY;
			},
		},

		menosInfinito: {
			fornecer: function () {
				return Number.NEGATIVE_INFINITY;
			}
		}
	});
}());
(function (contexto) {
	"use strict";

	var Linda = contexto.Linda;

	function Objeto() {}

	Objeto.implementar({
		inicializar: function () {},

		destruir: function () {},

		super: function () {
			this.SuperClasse.prototipo.inicializar.aplicarComEscopo(this, arguments);
		},

		igual: function (outro) {
			return (this === outro);
		}
	});

	Objeto.estender({
		prototipo: Objeto.prototype
	});

	function Classe() {}

	Classe.estender({
		criar: function (corpoDaClasse) {
			var SuperClasse = corpoDaClasse.SuperClasse;
			var estende = Linda.instanciaDe(SuperClasse, Function);
			function ClasseLinda() {
				this.inicializar.aplicarComEscopo(this, arguments);
			}
			SuperClasse = (estende) ? SuperClasse : Objeto;
			corpoDaClasse.SuperClasse = SuperClasse;
			ClasseLinda.prototype = Object.create(SuperClasse.prototype);
			ClasseLinda.prototipo = ClasseLinda.prototype;
			ClasseLinda.implementar(corpoDaClasse);
			ClasseLinda.prototype.definirPropriedades({
				SuperClasse: Linda.propriedadesDeAtributosGravaveisConfiguraveis
			});
			return ClasseLinda;
		},

		criarSingleton: function(corpoDaClasse) {
			var ClasseLindaUnica = Classe.criar(corpoDaClasse);
			ClasseLindaUnica.estender({
				instanciaUnica: null,
				instancia: function () {
					this.instanciaUnica = Object.create(this.prototipo);
					this.aplicarComEscopo(this.instanciaUnica, arguments);
					this.definirPropriedades({
						instanciaUnica: Linda.propriedadesDeAtributos,
						instancia: {
							configuravel: false,
							enumeravel: false,
							fornecer: function () {
								return this.instanciaUnica;
							}
						}
					});
					return this.instanciaUnica;
				}
			});
			return ClasseLindaUnica;
		},

		criarEnumeracao: function (enumeracoes, corpoDaClasse) {
			var ClasseEnumeracao = Classe.criar(corpoDaClasse);
			var NovaEnumeracao = new Enumeracao(ClasseEnumeracao);
			enumeracoes.paraCada(function (argumentos, enumeracao) {
				this[enumeracao] = Object.create(ClasseEnumeracao.prototipo);
				ClasseEnumeracao.aplicarComEscopo(this[enumeracao], argumentos);
			}, NovaEnumeracao);
			return NovaEnumeracao;
		},

		criarEnumeracaoDeConstantes: function (enumeracoes) {
			var NovaEnumeracaoDeConstantes = new EnumeracaoDeConstantes();
			enumeracoes.paraCada(function (valor, enumeracao) {
				this[enumeracao] = valor;
			}, NovaEnumeracaoDeConstantes);
			return NovaEnumeracaoDeConstantes;
		}
	});

	var Enumeracao = Classe.criar({
		inicializar: function (classe) {
			this.definirPropriedades({
				classe: {
					gravavel: false,
					enumeravel: false,
					configuravel: false,
					valor: classe
				}
			});
		},

		mapear: function (chave) {
			var enumeracaoEncontrada = null;
			this.paraCada(function (enumeracao) {
				if (enumeracao.chave === chave || enumeracao === chave) {
					enumeracaoEncontrada = enumeracao;
					return;
				}
			}, this);
			return enumeracaoEncontrada;
		},

		comoLista: function () {
			var lista = [];
			this.paraCada(function (enumeracao) {
				if (!Linda.nuloOuIndefinido(enumeracao.chave)) {
					lista.push(enumeracao);
				}
			}, this);
			return lista;
		}
	});

	var EnumeracaoDeConstantes = Classe.criar({
		mapear: function (chave) {
			var enumeracaoEncontrada = null;
			this.paraCada(function (enumeracao) {
				if (enumeracao === chave) {
					enumeracaoEncontrada = enumeracao;
					return;
				}
			}, this);
			return enumeracaoEncontrada;
		},

		comoLista: function () {
			var lista = [];
			this.paraCada(function (enumeracao) {
				lista.push(enumeracao);
			}, this);
			return lista;
		}
	});

	contexto.Classe = Classe;
	contexto.Objeto = Objeto;
}(this));
(function (contexto) {
	"use strict";

	var Linda = contexto.Linda;
	var Classe = contexto.Classe;

	var Tipo = Classe.criarEnumeracaoDeConstantes(Linda.tipos);

	var Evento = Classe.criarEnumeracaoDeConstantes({
		ABORTADO: "abort",
		ALTERADO: "change",
		CARREGADO: "load",
		CARREGAMENTO_INICIADO: "loadstart",
		CARREGAMENTO_FINALIZADO: "loadend",
		CLIQUE: "click",
		DUPLO_CLIQUE: "dbclick",
		ESTADO_REMOVIDO: "popstate",
		ESTOURO_DE_TEMPO: "timeout",
		ERRO: "error",
		PROGRESSO: "progress",
		TECLA_PRESSIONADA: "keydown",
		TECLA_SOLTA: "keyup"
	});

	var Tecla = Classe.criarEnumeracaoDeConstantes({
		APAGAR: 8,
		CIMA: 38,
		BAIXO: 40,
		ESQUERDA: 37,
		DIREITA: 39
	});

	var AtributoHttp = Classe.criarEnumeracaoDeConstantes({
		CONTENT_TYPE: "Content-Type",
		ACCEPT: "Accept",
		ACCEPT_CHARSET: "Accept-Charset",
		ACCEPT_ENCODING: "Accept-Encoding",
		ACCESS_CONTROL_REQUEST_HEADERS: "Access-Control-Request-Headers",
		ACCESS_CONTROL_REQUEST_METHOD: "Access-Control-Request-Method",
		CONNECTION: "Connection",
		CONTENT_LENGTH: "Content-Length",
		COOKIE: "Cookie",
		COOKIE_2: "Cookie2",
		CONTENT_TRANSFER_ENCODING: "Content-Transfer-Encoding",
		DATE: "Date",
		EXPECT: "Expect",
		HOST: "Host",
		KEEP_ALIVE: "Keep-Alive",
		ORIGIN: "Origin",
		REFERER: "Referer",
		TE: "TE",
		TRAILER: "Trailer",
		TRANSFER_ENCODING: "Transfer-Encoding",
		UPGRADE: "Upgrade",
		USER_AGENT: "User-Agent",
		VIA: "Via"
	});

	var MetodoHttp = Classe.criarEnumeracaoDeConstantes({
		GET: "GET",
		PUT: "PUT",
		POST: "POST",
		DELETE: "DELETE",
		HEAD: "HEAD",
		OPTIONS: "OPTIONS"
	});

	var TipoDeResposta = Classe.criarEnumeracaoDeConstantes({
		JSON: "",
		TEXTO: "text",
		DOCUMENTO: "document",
		BLOB: "blob",
		ARRAY_BUFFER: "arraybuffer",
		QUALQUER: "",
	});

	var TipoDeObservacao = Classe.criarEnumeracaoDeConstantes({
		ATUALIZACAO: "updated",
		RECONFIGURACAO: "reconfigured",
		REMOCAO: "deleted",
		CRIACAO: "new"
	});

	var TipoGenericoDeMidia = Classe.criarEnumeracao({
		APLICACAO: ["application"],
		AUDIO: ["audio"],
		IMAGEM: ["image"],
		MENSAGEM: ["message"],
		MODELO: ["model"],
		MULTIPARTE: ["multipart"],
		TEXTO: ["text"],
		VIDEO: ["video"],
		QUALQUER: ["*"]
	}, {
		inicializar: function (chave) {
			this.chave = chave;
		},

		comoTexto: function () {
			return this.chave;
		},

		comoTextoGenerico: function () {
			return String.formatar("%@/*", this.chave);
		}
	});

	var TipoDeMidia = Classe.criarEnumeracao({
		JS: [TipoGenericoDeMidia.APLICACAO, "javascript"],
		JSON: [TipoGenericoDeMidia.APLICACAO, "json"],
		PDF: [TipoGenericoDeMidia.APLICACAO, "pdf"],
		XML: [TipoGenericoDeMidia.APLICACAO, "xml"],
		ZIP: [TipoGenericoDeMidia.APLICACAO, "zip"],
		MP3: [TipoGenericoDeMidia.AUDIO, "mpeg"],
		GIF: [TipoGenericoDeMidia.IMAGEM, "gif"],
		JPEG: [TipoGenericoDeMidia.IMAGEM, "jpeg"],
		PNG: [TipoGenericoDeMidia.IMAGEM, "png"],
		SVG: [TipoGenericoDeMidia.IMAGEM, "svg+xml"],
		FORMULARIO: [TipoGenericoDeMidia.MULTIPARTE, "form-data"],
		CSS: [TipoGenericoDeMidia.TEXTO, "css"],
		CSV: [TipoGenericoDeMidia.TEXTO, "csv"],
		HTML: [TipoGenericoDeMidia.TEXTO, "html"],
		TXT: [TipoGenericoDeMidia.TEXTO, "plain"],
		MP4: [TipoGenericoDeMidia.VIDEO, "mp4"],
		MPEG: [TipoGenericoDeMidia.VIDEO, "mpeg"],
		OGG: [TipoGenericoDeMidia.VIDEO, "ogg"],
		VORBIS: [TipoGenericoDeMidia.VIDEO, "vorbis"],
		WEBM: [TipoGenericoDeMidia.VIDEO, "webm"],
		QUALQUER: [TipoGenericoDeMidia.QUALQUER, "*"]
	}, {
		inicializar: function (tipoGenerico, tipo) {
			this.tipoGenerico = tipoGenerico;
			this.tipo = tipo;
			this.chave = String.formatar("%@/%@", this.tipoGenerico.comoTexto(), this.tipo);
		},

		comoTexto: function () {
			return this.chave;
		},

		comoTextoGenerico: function () {
			return this.tipoGenerico.comoTextoGenerico();
		}
	});

	var CodigoHttp = Classe.criarEnumeracao({
		HTTP_100: [100, "Continuar", "Continue"],
		HTTP_101: [101, "Trocando protocolos", "Switching Protocols"],
		HTTP_200: [200, "Certo", "OK"],
		HTTP_201: [201, "Criado", "Created"],
		HTTP_202: [202, "Aceito", "Accepted"],
		HTTP_203: [203, "Informações não autorizadas", "Non-Authoritative Information"],
		HTTP_204: [204, "Sem conteúdo", "No Content"],
		HTTP_205: [205, "Conteúdo reiniciado", "Reset Content"],
		HTTP_206: [206, "Conteúdo parcial", "Partial Content"],
		HTTP_300: [300, "Múltiplas escolhas", "Multiple Choices"],
		HTTP_301: [301, "Movido permanentemente", "Moved Permanently"],
		HTTP_302: [302, "Encontrado", "Found"],
		HTTP_303: [303, "Olhar outro", "See Other"],
		HTTP_304: [304, "Não modificado", "Not Modified"],
		HTTP_305: [305, "Usar procurador", "Use Proxy"],
		HTTP_306: [306, "", ""],
		HTTP_307: [307, "Redirecionado temporariamente", "Temporary Redirect"],
		HTTP_400: [400, "Requisição ruim", "Bad Request"],
		HTTP_401: [401, "Não autorizado", "Unauthorized"],
		HTTP_402: [402, "Pagamento requerido", "Payment Required"],
		HTTP_403: [403, "Proibido", "Forbidden"],
		HTTP_404: [404, "Não encontrado", "Not Found"],
		HTTP_405: [405, "Método não permitido", "Method Not Allowed"],
		HTTP_406: [406, "Não aceitável", "Not Acceptable"],
		HTTP_407: [407, "Autenticação do procurador requerida", "Proxy Authentication Required"],
		HTTP_408: [408, "Estouro de tempo", "Request Time-out"],
		HTTP_409: [409, "Conflito", "Conflict"],
		HTTP_410: [410, "Desaparecido", "Gone"],
		HTTP_411: [411, "Tamanho requerido", "Length Required"],
		HTTP_412: [412, "Pré-condição não satisfeita", "Precondition Failed"],
		HTTP_413: [413, "Entidade muito grande", "Request Entity Too Large"],
		HTTP_414: [414, "URI muito longa", "Request-URI Too Large"],
		HTTP_415: [415, "Tipo de mídia não suportado", "Unsupported Media Type"],
		HTTP_416: [416, "Intervalo não satisfatório", "Requested range not satisfiable"],
		HTTP_417: [417, "Expectativa não satisfeita", "Expectation Failed"],
		HTTP_500: [500, "Erro interno no servidor", "Internal Server Error"],
		HTTP_501: [501, "Não implementado", "Not Implemented"],
		HTTP_502: [502, "Portão de acesso ruim", "Bad Gateway"],
		HTTP_503: [503, "Serviço indisponível", "Service Unavailable"],
		HTTP_504: [504, "Estouro de tempo do portão de acesso", "Gateway Time-out"],
		HTTP_505: [505, "Versão do protocolo não suportada", "HTTP Version not supported"]
	}, {
		inicializar: function (chave, texto, textoIngles) {
			this.chave = chave;
			this.texto = texto;
			this.textoIngles = textoIngles;
		},

		comoNumero: function () {
			return this.chave;
		},

		comoTexto: function () {
			return this.texto;
		},

		comoTextoFormatado: function () {
			return String.formatar("%@ - %@", this.comoNumero(), this.comoTexto());
		},

		comoTextoIngles: function () {
			return this.textoIngles;
		},

		informacao: function () {
			return (this.chave >= 100 && this.chave < 200);
		},

		sucesso: function () {
			return (this.chave >= 200 && this.chave < 300);
		},

		redirecionamento: function () {
			return (this.chave >= 300 && this.chave < 400);
		},

		erroDoCliente: function () {
			return (this.chave >= 400 && this.chave < 500);
		},

		erroDoServidor: function () {
			return (this.chave >= 500 && this.chave < 600);
		}
	});

	contexto.Tipo = Tipo;
	contexto.Evento = Evento;
	contexto.Tecla = Tecla;
	contexto.AtributoHttp = AtributoHttp;
	contexto.MetodoHttp = MetodoHttp;
	contexto.CodigoHttp = CodigoHttp;
	contexto.TipoDeResposta = TipoDeResposta;
	contexto.TipoDeMidia = TipoDeMidia;
	contexto.TipoGenericoDeMidia = TipoGenericoDeMidia;
	contexto.TipoDeObservacao = TipoDeObservacao;
}(this));
/*global Document*/
/*global Element*/
/*global History*/
/*global HTMLCollection*/
/*global Location*/
/*global Node*/
/*global NodeList*/
/*global Window*/

(function (contexto) {
	"use strict";

	var Linda = contexto.Linda;
	var Classe = contexto.Classe;

	var Dom = Classe.criarSingleton({
		inicializar: function () {
			this.janela = window;
			this.documento = this.janela.document;
			this.localizacao = this.janela.location;
			this.historico = this.janela.history;
		},

		carregarComponentes: function () {
			this.janelaDom = this.encapsular(this.janela);
			this.documentoDom = this.encapsular(this.documento);
		},

		encapsular: function (elementoDom) {
			var Documento = contexto.Documento;
			var Elemento = contexto.Elemento;
			var Janela = contexto.Janela;
			var Nodo = contexto.Nodo;
			var Notificavel = contexto.Notificavel;
			if (Linda.instanciaDe(elementoDom, NodeList)) {
				return new ListaDom(elementoDom);
			} else if (Linda.instanciaDe(elementoDom, HTMLCollection)) {
				return new ListaDom(elementoDom);
			} else if (Linda.instanciaDe(elementoDom, Element)) {
				return new Elemento(elementoDom);
			} else if (Linda.instanciaDe(elementoDom, Document)) {
				return new Documento(elementoDom);
			} else if (Linda.instanciaDe(elementoDom, Node)) {
				return new Nodo(elementoDom);
			} else if (Linda.instanciaDe(elementoDom, Window)) {
				return new Janela(elementoDom);
			} else if (Linda.instanciaDe(elementoDom, Location)) {
				return new Localizacao(elementoDom);
			} else if (Linda.instanciaDe(elementoDom, History)) {
				return new Historico(elementoDom);
			} else {
				return new Notificavel(elementoDom);
			}
		},

		extrair: function (suplementoDom) {
			return suplementoDom.elementoDom;
		},

		$: function (seletorOuElemento) {
			if (Linda.instanciaDe(seletorOuElemento, String)) {
				return this.documentoDom.selecionar(seletorOuElemento);
			}
			return this.encapsular(seletorOuElemento);
		},

		$$: function (seletorOuElemento) {
			if (Linda.instanciaDe(seletorOuElemento, String)) {
				return this.documentoDom.selecionarTodos(seletorOuElemento);
			}
			return this.encapsular(seletorOuElemento);
		}
	}).instancia();

	var ListaDom = Classe.criar({
		inicializar: function (elementosDom) {
			this.elementosDom = elementosDom;
			this.elementoDom = elementosDom;
		},

		paraCada: function (tratador, escopo) {
			for (var indice = 0; indice < this.elementosDom.length; indice++) {
				tratador.chamarComEscopo(escopo, Dom.encapsular(Dom.extrair(this).item(indice), indice));
			}
		}
	});

	var Localizacao = Classe.criar({
		inicializar: function (elementoDom) {
			var Notificavel = contexto.Notificavel;
			Notificavel.prototipo.inicializar.chamarComEscopo(this, elementoDom);
		},

		fornecerUri: function () {
			return String.concatenar(this.protocolo, "://", this.endereco, this.caminho, this.ancora, this.busca);
		},

		fornecerUriComPorta: function () {
			return String.concatenar(this.protocolo, "://", this.endereco, ":", this.porta, this.caminho, this.ancora, this.busca);
		}
	});

	Localizacao.prototipo.definirPropriedades({
		ancora: {
			fornecer: function () {
				return Dom.extrair(this).hash;
			}
		},

		busca: {
			fornecer: function () {
				return Dom.extrair(this).search;
			}
		},

		caminho: {
			fornecer: function () {
				return Dom.extrair(this).pathname;
			}
		},

		endereco: {
			fornecer: function () {
				return Dom.extrair(this).hostname;
			}
		},

		porta: {
			fornecer: function () {
				var elemento = Dom.extrair(this);
				return (elemento.port === "") ? 80 : elemento.port.paraInteiro();
			}
		},

		protocolo: {
			fornecer: function () {
				return Dom.extrair(this).protocol.substituir(/:$/, "");
			}
		}
	});

	var Historico = Classe.criar({
		inicializar: function (elementoDom) {
			var Notificavel = contexto.Notificavel;
			Notificavel.prototipo.inicializar.chamarComEscopo(this, elementoDom);
		},

		adicionarEstado: function (uri, estado, titulo) {
			if (!Linda.existe(titulo)) {
				titulo = Dom.documentoDom.titulo;
			}
			Dom.extrair(this).pushState(estado, titulo, uri);
		},

		avancar: function () {
			Dom.extrair(this).forward();
		},

		ir: function (distancia) {
			Dom.extrair(this).go(distancia);
		},

		substituirEstado: function (uri, estado, titulo) {
			if (!Linda.existe(titulo)) {
				titulo = Dom.documentoDom.titulo;
			}
			Dom.extrair(this).replaceState(estado, titulo, uri);
		},

		voltar: function () {
			Dom.extrair(this).back();
		}
	});

	Historico.prototipo.definirPropriedades({
		estado: {
			fornecer: function () {
				return Dom.extrair(this).state;
			}
		}
	});

	contexto.addEventListener("load", function () {
		Dom.carregarComponentes();
	});

	contexto.Dom = Dom;
	contexto.ListaDom = ListaDom;
	contexto.Localizacao = Localizacao;
	contexto.Localizacao = Historico;
	contexto.documento = Dom.documento;
	contexto.localizacao = Dom.localizacao;
	contexto.historico = Dom.historico;
	contexto.janela = Dom.janela;
}(this));
(function (contexto) {
	"use strict";

	var Dom = contexto.Dom;
	var Classe = contexto.Classe;
	var Tecla = contexto.Tecla;

	var Notificavel = Classe.criar({
		inicializar: function (elementoDom) {
			this.elementoDom = elementoDom;
		},

		deixarDeTratar: function (evento, funcao) {
			Dom.extrair(this).removeEventListener(evento, funcao);
		},

		tratarAlteracao: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("change", tratador);
			return tratador;
		},

		deixarDeTratarAlteracao: function (funcao) {
			this.deixarDeTratar("change", funcao);
		},

		tratarAlteracaoNoHistorico: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("popstate", tratador);
			return tratador;
		},

		deixarDeTratarAlteracaoNoHistorico: function (funcao) {
			this.deixarDeTratar("popstate", funcao);
		},

		tratarErro: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("error", tratador);
			return tratador;
		},

		deixarDeTratarErro: function (funcao) {
			this.deixarDeTratar("error", funcao);
		},

		tratarCarregamento: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("load", tratador);
			return tratador;
		},

		deixarDeTratarCarregamento: function (funcao) {
			this.deixarDeTratar("load", funcao);
		},

		tratarCarregamentoIniciado: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("loadstart", tratador);
			return tratador;
		},

		deixarDeTratarCarregamentoIniciado: function (funcao) {
			this.deixarDeTratar("loadstart", funcao);
		},

		tratarCarregamentoFinalizado: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("loadend", tratador);
			return tratador;
		},

		deixarDeTratarCarregamentoFinalizado: function (funcao) {
			this.deixarDeTratar("loadend", funcao);
		},

		tratarProgresso: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("progress", tratador);
			return tratador;
		},

		deixarDeTratarProgresso: function (funcao) {
			this.deixarDeTratar("progress", funcao);
		},

		tratarAborto: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("abort", tratador);
			return tratador;
		},

		deixarDeTratarAborto: function (funcao) {
			this.deixarDeTratar("abort", funcao);
		},

		tratarEstouroDeTempo: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("timeout", tratador);
			return tratador;
		},

		deixarDeTratarEstouroDeTempo: function (funcao) {
			this.deixarDeTratar("timeout", funcao);
		},

		tratarClique: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("click", tratador);
			return tratador;
		},

		deixarDeTratarClique: function (funcao) {
			this.deixarDeTratar("click", funcao);
		},

		tratarCliqueDuplo: function (tratador, escopo) {
			tratador = tratador.vincularEscopo(escopo);
			Dom.extrair(this).addEventListener("dbclick", tratador);
			return tratador;
		},

		deixarDeTratarCliqueDuplo: function (funcao) {
			this.deixarDeTratar("dbclick", funcao);
		},

		tratarTecla: function (tecla, tratador, escopo) {
			var tratadorPersonalizado = function (evento) {
				if (!Linda.existe(tecla) || tecla === evento.keyCode) {
					tratador.chamarComEscopo(escopo);
				}
			};
			Dom.extrair(this).addEventListener("keypress", tratadorPersonalizado);
			return tratadorPersonalizado;
		},

		tratarTeclaPressionada: function (tecla, tratador, escopo) {
			var tratadorPersonalizado = function (evento) {
				if (!Linda.existe(tecla) || tecla === evento.keyCode) {
					tratador.chamarComEscopo(escopo);
				}
			};
			Dom.extrair(this).addEventListener("keydown", tratadorPersonalizado);
			return tratadorPersonalizado;
		},

		deixarDeTratarTeclaPressionada: function (funcao) {
			this.deixarDeTratar("keydown", funcao);
		},

		tratarTeclaSolta: function (tecla, tratador, escopo) {
			var tratadorPersonalizado = function (evento) {
				if (!Linda.existe(tecla) || tecla === evento.keyCode) {
					tratador.chamarComEscopo(escopo);
				}
			};
			Dom.extrair(this).addEventListener("keyup", tratadorPersonalizado);
			return tratadorPersonalizado;
		},

		deixarDeTratarTeclaSolta: function (funcao) {
			this.deixarDeTratar("keyup", funcao);
		},

		tratarQualquerTeclaPressionada: function (tratador, escopo) {
			var tratadorPersonalizado = function (evento) {
				if (Tecla.APAGAR !== evento.keyCode) {
					tratador.chamarComEscopo(escopo);
				}
			};
			Dom.extrair(this).addEventListener("keydown", tratadorPersonalizado);
			return tratadorPersonalizado;
		},

		tratarQualquerTeclaSolta: function (tratador, escopo) {
			var tratadorPersonalizado = function (evento) {
				if (Tecla.APAGAR !== evento.keyCode) {
					tratador.chamarComEscopo(escopo);
				}
			};
			Dom.extrair(this).addEventListener("keyup", tratadorPersonalizado);
			return tratadorPersonalizado;
		}
	});

	contexto.Notificavel = Notificavel;
}(this));
(function (contexto) {
	"use strict";

	var Dom = contexto.Dom;
	var Notificavel = contexto.Notificavel;
	var Classe = contexto.Classe;

	var Janela = Classe.criar({
		SuperClasse: Notificavel,

		inicializar: function (elementoDom) {
			Notificavel.prototipo.inicializar.chamarComEscopo(this, elementoDom);
		},

		iniciarTemporizador: function (tratador, tempo, escopo) {
			return Dom.extrair(this).setTimeout(tratador.vincularEscopo(escopo), tempo);
		},

		iniciarTemporizadorContinuo: function (tratador, tempo, escopo) {
			return Dom.extrair(this).setInterval(tratador.vincularEscopo(escopo), tempo);
		},

		iniciarTemporizadorImediato: function (tratador, tempo, escopo) {
			return Dom.extrair(this).setImmediate(tratador.vincularEscopo(escopo), tempo);
		},

		cancelarTemporizador: function (identificador) {
			Dom.extrair(this).clearTimeout(identificador);
		},

		cancelarTemporizadorContinuo: function (identificador) {
			Dom.extrair(this).clearInterval(identificador);
		},

		cancelarTemporizadorImediato: function (identificador) {
			Dom.extrair(this).clearImediate(identificador);
		}
	});

	contexto.Janela = Janela;
}(this));
(function (contexto) {
	"use strict";

	var Dom = contexto.Dom;
	var Notificavel = contexto.Notificavel;
	var Classe = contexto.Classe;

	var Nodo = Classe.criar({
		SuperClasse: Notificavel,

		inicializar: function (elementoDom) {
			Notificavel.prototipo.inicializar.chamarComEscopo(this, elementoDom);
		},

		adicionarNodo: function (nodo) {
			return Dom.extrair(this).appendChild(Dom.extrair(nodo));
		},

		adicionarNodoNoInicio: function (nodo) {
			return Dom.extrair(this).insertBefore(Dom.extrair(nodo), Dom.extrair(this.primeiroFilho));
		},

		adicionarNodoAntesDe: function (nodo, nodoReferencia) {
			return Dom.extrair(this).insertBefore(Dom.extrair(nodo), Dom.extrair(nodoReferencia));
		},

		clonarNodo: function (clonarFilhos) {
			return Dom.extrair(this).cloneNode(clonarFilhos);
		},

		normalizarNodos: function () {
			Dom.extrair(this).normalize();
		},

		possuiNodos: function () {
			return Dom.extrair(this).hasChildNodes();
		},

		possuiNodo: function (nodo) {
			return Dom.extrair(this).contains(Dom.extrair(nodo));
		},

		removerNodo: function (nodo) {
			return Dom.extrair(this).removeChild(Dom.extrair(nodo));
		},

		substituirNodo: function (nodoNovo, nodoAntigo) {
			return Dom.extrair(this).replaceChild(Dom.extrair(nodoNovo), Dom.extrair(nodoAntigo));
		}
	});

	Nodo.prototype.definirPropriedades({
		texto: {
			fornecer: function () {
				return Dom.extrair(this).textContent;
			},

			fixar: function (valor) {
				Dom.extrair(this).textContent = valor;
			}
		},

		nodoFilhos: {
			fornecer: function () {
				return Dom.encapsular(Dom.extrair(this).childNodes);
			}
		},

		primeiroNodoFilho: {
			fornecer: function () {
				return Dom.encapsular(Dom.extrair(this).firstChild);
			}
		},

		ultimoNodoFilho: {
			fornecer: function () {
				return Dom.encapsular(Dom.extrair(this).lastChild);
			}
		},

		nodoPai: {
			fornecer: function () {
				return Dom.encapsular(Dom.extrair(this).parentNode);
			}
		}
	});

	contexto.Nodo = Nodo;
}(this));
(function (contexto) {
	"use strict";

	var Dom = contexto.Dom;
	var Nodo = contexto.Nodo;
	var Linda = contexto.Linda;
	var Classe = contexto.Classe;

	var Documento = Classe.criar({
		SuperClasse: Nodo,

		inicializar: function (elementoDom) {
			Nodo.prototipo.inicializar.chamarComEscopo(this, elementoDom);
		},

		criarComentario: function (comentario) {
			return Dom.encapsular(Dom.extrair(this).createComment(comentario));
		},

		criarElemento: function (elemento) {
			return Dom.encapsular(Dom.extrair(this).createElement(elemento));
		},

		criarTexto: function (texto) {
			return Dom.encapsular(Dom.extrair(this).createTextNode(texto));
		},

		selecionar: function (seletor) {
			return Dom.encapsular(Dom.extrair(this).querySelector(seletor));
		},

		selecionarTodos: function (seletor) {
			return Dom.encapsular(Dom.extrair(this).querySelectorAll(seletor));
		},

		habilitarTelaCheia: function () {
			if (Linda.instanciaDe(Dom.extrair(this).documentElement.requestFullScreen, Function)) {
				Dom.extrair(this).documentElement.requestFullScreen();
			} else if (Linda.instanciaDe(Dom.extrair(this).documentElement.mozRequestFullScreen, Function)) {
				Dom.extrair(this).documentElement.mozRequestFullScreen();
			} else if (Linda.instanciaDe(Dom.extrair(this).documentElement.webkitRequestFullScreen, Function)) {
				Dom.extrair(this).documentElement.webkitRequestFullScreen();
			}
		},

		desabilitarTelaCheia: function () {
			if (Linda.instanciaDe(Dom.extrair(this).cancelFullScreen, Function)) {
				Dom.extrair(this).cancelFullScreen();
			} else if (Linda.instanciaDe(Dom.extrair(this).webkitCancelFullScreen, Function)) {
				Dom.extrair(this).webkitCancelFullScreen();
			} else if (Linda.instanciaDe(Dom.extrair(this).mozCancelFullScreen, Function)) {
				Dom.extrair(this).mozCancelFullScreen();
			}
		}
	});

	Documento.prototipo.definirPropriedades({
		titulo: {
			fornecer: function () {
				return Dom.extrair(this).title;
			}
		}
	});

	contexto.Documento = Documento;
}(this));
(function (contexto) {
	"use strict";

	var Dom = contexto.Dom;
	var Nodo = contexto.Nodo;
	var Classe = contexto.Classe;

	var Elemento = Classe.criar({
		SuperClasse: Nodo,

		inicializar: function (elementoDom) {
			Nodo.prototipo.inicializar.chamarComEscopo(this, elementoDom);
		},

		fornecerAtributo: function (nome) {
			return Dom.extrair(this).getAttribute(nome);
		},

		fixarAtributo: function (nome, valor) {
			Dom.extrair(this).setAttribute(nome, valor);
		},

		removerAtributo: function (nome) {
			Dom.extrair(this).removeAttribute(nome);
		},

		possuiAtributo: function (nome) {
			return Dom.extrair(this).hasAttribute(nome);
		},

		combina: function (seletor) {
			return Dom.extrair(this).matches(seletor);
		},

		rolarParaTopo: function () {
			Dom.extrair(this).scrollIntoView(true);
		},

		rolarParaBase: function () {
			Dom.extrair(this).scrollIntoView(false);
		},

		selecionar: function (selecao) {
			return Dom.encapsular(Dom.extrair(this).querySelector(selecao));
		},

		selecionarTodos: function (selecao) {
			return Dom.encapsular(Dom.extrair(this).querySelectorAll(selecao));
		},

		obterPelaClasse: function (classe) {
			return Dom.encapsular(Dom.extrair(this).getElementsByClassName(classe).item(0));
		},

		obterTodosPelaClasse: function (classe) {
			return Dom.encapsular(Dom.extrair(this).getElementsByClassName(classe));
		},

		obterPeloNome: function (nome) {
			return Dom.encapsular(Dom.extrair(this).getElementsByName(nome).item(0));
		},

		obterTodosPeloNome: function (nome) {
			return Dom.encapsular(Dom.extrair(this).getElementsByName(nome));
		},

		obterPeloIdentificador: function (identificador) {
			return Dom.encapsular(Dom.extrair(this).getElementById(identificador));
		},

		adicionarClasse: function (classe) {
			Dom.extrair(this).classList.add(classe);
		},

		removerClasse: function (classe) {
			Dom.extrair(this).classList.remove(classe);
		}
	});

	Elemento.prototype.definirPropriedades({
		filhos: {
			fornecer: function () {
				return Dom.encapsular(Dom.extrair(this).children);
			}
		},

		primeiroFilho: {
			fornecer: function () {
				return Dom.encapsular(Dom.extrair(this).firstElementChild);
			}
		},

		ultimoFilho: {
			fornecer: function () {
				return Dom.encapsular(Dom.extrair(this).lastElementChild);
			}
		},

		identificador: {
			fornecer: function () {
				return Dom.extrair(this).id;
			},

			fixar: function (novoIdentificador) {
				Dom.extrair(this).id = novoIdentificador;
			}
		},

		classe: {
			fornecer: function () {
				return Dom.extrair(this).className;
			},

			fixar: function (novaClasse) {
				Dom.extrair(this).className = novaClasse;
			}
		},

		htmlInterno: {
			fornecer: function () {
				return Dom.extrair(this).innerHTML;
			},

			fixar: function (html) {
				Dom.extrair(this).innerHTML = html;
			}
		},

		htmlExterno: {
			fornecer: function () {
				return Dom.extrair(this).outerHTML;
			},

			fixar: function (html) {
				Dom.extrair(this).outerHTML = html;
			}
		},

		valor: {
			fornecer: function () {
				return Dom.extrair(this).value;
			},

			fixar: function (valor) {
				Dom.extrair(this).value = valor;
			}
		}
	});

	contexto.Elemento = Elemento;
}(this));
(function (contexto) {
	"use strict";

	var Dom = contexto.Dom;
	var Linda = contexto.Linda;
	var Classe = contexto.Classe;
	var AtributoHttp = contexto.AtributoHttp;
	var CodigoHttp = contexto.CodigoHttp;
	var MetodoHttp = contexto.MetodoHttp;
	var TipoDeMidia = contexto.TipoDeMidia;
	var TipoDeResposta = contexto.TipoDeResposta;

	var RequisicaoHttp = Classe.criar({
		inicializar: function (uri, assincrono) {
			this.requisicaoXml = new XMLHttpRequest();
			this.uri = uri;
			this.usuario = null;
			this.senha = null;
			this.codigoDeEstado = null;
			this.metodo = null;
			this.respostaDecodificada = null;
			this.assincrono = Linda.indefinido(assincrono) ? true : !!assincrono;
			this.cabecalho = [];
		},

		aceita: function (tipoDeResposta, tipoDeMidia, decodificadorDeReposta) {
			if (this.assincrono) {
				// this.requisicaoXml.responseType = tipoDeResposta;
			}
			this.fixarAtributoDeCabecalho(AtributoHttp.ACCEPT, tipoDeMidia);
			this.decodificarResposta = decodificadorDeReposta;
			return this;
		},

		aceitaJson: function () {
			this.aceita(TipoDeResposta.JSON, TipoDeMidia.JSON.comoTexto(), this.decodificarRespostaJson);
			return this;
		},

		aceitaHtml: function () {
			this.aceita(TipoDeResposta.DOCUMENTO, TipoDeMidia.HTML.comoTexto(), this.decodificarRespostaHtml);
			return this;
		},

		aceitaTxt: function () {
			this.aceita(TipoDeResposta.TEXTO, TipoDeMidia.TXT.comoTexto(), this.decodificarRespostaTxt);
			return this;
		},

		aceitaQualquer: function () {
			this.aceita(TipoDeReposta.QUALQUER, TipoDeMidia.QUALQUER.comoTexto(), this.decodificarResposta);
			return this;
		},

		envia: function (tipoDeMidia, codificadorDeEnvio) {
			this.fixarAtributoDeCabecalho(AtributoHttp.CONTENT_TYPE, tipoDeMidia);
			this.codificarEnvio = codificadorDeEnvio;
			return this;
		},

		enviaJson: function () {
			this.envia(TipoDeMidia.JSON.comoTexto(), this.codificarEnvioJson);
			return this;
		},

		enviaHtml: function () {
			this.envia(TipoDeMidia.HTML.comoTexto(), this.codificarEnvioHtml);
			return this;
		},

		enviaTexto: function () {
			this.envia(TipoDeMidia.TXT.comoTexto(), this.codificarEnvioTxt);
			return this;
		},

		decodificarResposta: function (dado) {
			return dado;
		},

		decodificarRespostaJson: function (dado) {
			try {
				return JSON.parse(dado);
			} catch (excecao) {
				return dado;
			}
		},

		decodificarRespostaHtml: function (dado) {
			return dado;
		},

		decodificarRespostaTxt: function (dado) {
			return dado;
		},

		codificarEnvio: function (dado) {
			return dado;
		},

		codificarEnvioJson: function (dado) {
			return JSON.stringify(dado);
		},

		codificarEnvioHtm: function (dado) {
			return dado;
		},

		codificarEnvioTxt: function (dado) {
			return dado;
		},

		enviar: function (metodo, dados) {
			this.metodo = MetodoHttp.mapear(metodo);
			this.requisicaoXml.open(this.metodo, this.uri, this.assincrono, this.usuario, this.senha);
			this.cabecalho.paraCada(function (atributo) {
				this.requisicaoXml.setRequestHeader(atributo.nome, atributo.valor);
			}, this);
			this.requisicaoXml.send(this.codificarEnvio(dados));
			if (!this.assincrono) {
				return this.fornecerResposta();
			}
			return this;
		},

		get: function (dados) {
			return this.enviar(MetodoHttp.GET, dados);
		},

		put: function (dados) {
			return this.enviar(MetodoHttp.PUT, dados);
		},

		post: function (dados) {
			return this.enviar(MetodoHttp.POST, dados);
		},

		delete: function (dados) {
			return this.enviar(MetodoHttp.DELETE, dados);
		},

		tratarInicio: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarCarregamento(tratador, escopo);
			return this;
		},

		tratarProgresso: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarProgresso(tratador, escopo);
			return this;
		},

		tratarTermino: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarCarregamentoFinalizado(tratador, escopo);
			return this;
		},

		tratarAborto: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarAborto(tratador, escopo);
			return this;
		},

		tratarEstouroDeTempo: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarEstouroDeTempo(tratador, escopo);
			return this;
		},

		tratarErro: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarErro(tratador, escopo);
			return this;
		},

		tratarResposta: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarCarregamento(function () {
				tratador.chamarComEscopo(escopo, this.fornecerResposta(), this.fornecerCodigoDeEstado(), this);
			}, this);
			return this;
		},

		tratarInformacao: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarCarregamento(function () {
				var codigoDeEstado = this.fornecerCodigoDeEstado();
				if (codigoDeEstado.informacao()) {
					tratador.chamarComEscopo(escopo, this.fornecerResposta(), codigoDeEstado, this);
				}
			}, this);
			return this;
		},

		tratarSucesso: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarCarregamento(function () {
				var codigoDeEstado = this.fornecerCodigoDeEstado();
				if (codigoDeEstado.sucesso()) {
					tratador.chamarComEscopo(escopo, this.fornecerResposta(), codigoDeEstado, this);
				}
			}, this);
			return this;
		},

		tratarRedirecionamento: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarCarregamento(function () {
				var codigoDeEstado = this.fornecerCodigoDeEstado();
				if (codigoDeEstado.redirecionamento()) {
					tratador.chamarComEscopo(escopo, this.fornecerResposta(), codigoDeEstado, this);
				}
			}, this);
			return this;
		},

		tratarErroDoCliente: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarCarregamento(function () {
				var codigoDeEstado = this.fornecerCodigoDeEstado();
				if (codigoDeEstado.erroDoCliente()) {
					tratador.chamarComEscopo(escopo, this.fornecerResposta(), codigoDeEstado, this);
				}
			}, this);
			return this;
		},

		tratarErroDoServidor: function (tratador, escopo) {
			Dom.$(this.requisicaoXml).tratarCarregamento(function () {
				var codigoDeEstado = this.fornecerCodigoDeEstado();
				if (codigoDeEstado.erroDoServidor()) {
					tratador.chamarComEscopo(escopo, this.fornecerResposta(), codigoDeEstado, this);
				}
			}, this);
			return this;
		},

		abortar: function () {
			this.requisicaoXml.abort();
			return this;
		},

		fixarAtributoDeCabecalho: function (nome, valor) {
			this.cabecalho.push({nome: nome, valor: valor});
			return this;
		},

		fixarAutenticacao: function (usuario, senha) {
			this.usuario = usuario;
			this.senha = senha;
			return this;
		},

		fixarTempoLimite: function (tempoLimite) {
			this.requisicaoXml.timeout = tempoLimite;
			return this;
		},

		fornecerResposta: function () {
			if (Linda.nulo(this.respostaDecodificada)) {
				this.respostaDecodificada = this.decodificarResposta(this.requisicaoXml.response);
			}
			return this.respostaDecodificada;
		},

		fornecerCodigoDeEstado: function () {
			if (Linda.nulo(this.codigoDeEstado)) {
				this.codigoDeEstado = CodigoHttp.mapear(this.requisicaoXml.status);
			}
			return this.codigoDeEstado;
		}
	});

	contexto.RequisicaoHttp = RequisicaoHttp;
}(this));
(function (contexto) {
	"use strict";

	var Linda = contexto.Linda;

	Object.prototype.definirPropriedades({
		cadaPropriedade: Linda.propriedadesDeAtributos,
		cadaPropriedadeEnumeravel: Linda.propriedadesDeAtributos,
		cadaPropriedadeInvisivel: Linda.propriedadesDeAtributos,
		cadaPropriedadePropria: Linda.propriedadesDeAtributos,
		cadaPropriedadePropriaEnumeravel: Linda.propriedadesDeAtributos,
		cadaPropriedadePropriaInvisivel: Linda.propriedadesDeAtributos,
		cadaPropriedadeHerdada: Linda.propriedadesDeAtributos,
		cadaPropriedadeHerdadaEnumeravel: Linda.propriedadesDeAtributos,
		cadaPropriedadeHerdadaInvisivel: Linda.propriedadesDeAtributos,
		fornecerPropriedades: Linda.propriedadesDeAtributos,
		fornecerPropriedadesEnumeraveis: Linda.propriedadesDeAtributos,
		fornecerPropriedadesInvisiveis: Linda.propriedadesDeAtributos,
		fornecerPropriedadesProprias: Linda.propriedadesDeAtributos,
		fornecerPropriedadesPropriasEnumeraveis: Linda.propriedadesDeAtributos,
		fornecerPropriedadesPropriasInvisiveis: Linda.propriedadesDeAtributos,
		fornecerPropriedadesHerdadas: Linda.propriedadesDeAtributos,
		fornecerPropriedadesHerdadasEnumeraveis: Linda.propriedadesDeAtributos,
		fornecerPropriedadesHerdadasInvisiveis: Linda.propriedadesDeAtributos,
		possuiPropriedade: Linda.propriedadesDeAtributos,
		possuiPropriedadeEnumeravel: Linda.propriedadesDeAtributos,
		possuiPropriedadeInvisivel: Linda.propriedadesDeAtributos,
		possuiPropriedadePropria: Linda.propriedadesDeAtributos,
		possuiPropriedadePropriaEnumeravel: Linda.propriedadesDeAtributos,
		possuiPropriedadePropriaInvisivel: Linda.propriedadesDeAtributos,
		possuiPropriedadeHerdada: Linda.propriedadesDeAtributos,
		possuiPropriedadeHerdadaEnumeravel: Linda.propriedadesDeAtributos,
		possuiPropriedadeHerdadaInvisivel: Linda.propriedadesDeAtributos,
		instanciaDe: Linda.propriedadesDeAtributos,
		prototipadoDe: Linda.propriedadesDeAtributos,
		prototipoDe: Linda.propriedadesDeAtributos,
		fornecerPrototipo: Linda.propriedadesDeAtributos,
		fornecerDescritorDePropriedade: Linda.propriedadesDeAtributos,
		privadoFornecerDescritorDePropriedade: Linda.propriedadesDeAtributos,
		definirPropriedade: Linda.propriedadesDeAtributos,
		definirPropriedades: Linda.propriedadesDeAtributos,
		// removerPropriedade: Linda.propriedadesDeAtributos,
		privadoDefinirPropriedade: Linda.propriedadesDeAtributos,
		fundir: Linda.propriedadesDeAtributos,
		observar: Linda.propriedadesDeAtributos,
		observarAtualizacao: Linda.propriedadesDeAtributos,
		observarCriacao: Linda.propriedadesDeAtributos,
		observarReconfiguracao: Linda.propriedadesDeAtributos,
		observarRemocao: Linda.propriedadesDeAtributos,
		desobservar: Linda.propriedadesDeAtributos,
		paraCada: Linda.propriedadesDeAtributosGravaveis
	});

	Function.prototype.definirPropriedades({
		aplicarComEscopo: Linda.propriedadesDeAtributos,
		chamarComEscopo: Linda.propriedadesDeAtributos,
		estender: Linda.propriedadesDeAtributos,
		implementar: Linda.propriedadesDeAtributos,
		vincularEscopo: Linda.propriedadesDeAtributos
	});

	Array.prototype.definirPropriedades({
		adicionar: Linda.propriedadesDeAtributos,
		adicionarNoInicio: Linda.propriedadesDeAtributos,
		clonar: Linda.propriedadesDeAtributos,
		contem: Linda.propriedadesDeAtributos,
		dentroDosLimites: Linda.propriedadesDeAtributos,
		embaralhar: Linda.propriedadesDeAtributos,
		fornecerIndice: Linda.propriedadesDeAtributos,
		fundir: Linda.propriedadesDeAtributos,
		limpar: Linda.propriedadesDeAtributos,
		paraCada: Linda.propriedadesDeAtributos,
		quantidadeMenorQue: Linda.propriedadesDeAtributos,
		quantidadeMenorIgualQue: Linda.propriedadesDeAtributos,
		quantidadeMaiorQue: Linda.propriedadesDeAtributos,
		quantidadeMaiorIgualQue: Linda.propriedadesDeAtributos,
		quantidadeIgual: Linda.propriedadesDeAtributos,
		reduzir: Linda.propriedadesDeAtributos,
		reduzirSemPrimeiro: Linda.propriedadesDeAtributos,
		reduzirSemUltimo: Linda.propriedadesDeAtributos,
		removerPosicao: Linda.propriedadesDeAtributos,
		removerElemento: Linda.propriedadesDeAtributos,
		vazio: Linda.propriedadesDeAtributos,
		tirar: Linda.propriedadesDeAtributos,
		tirarDoInicio: Linda.propriedadesDeAtributos
	});

	String.prototype.definirPropriedades({
		combinar: Linda.propriedadesDeAtributos,
		emBranco: Linda.propriedadesDeAtributos,
		formatarNumero: Linda.propriedadesDeAtributos,
		paraInteiro: Linda.propriedadesDeAtributos,
		paraFlutuante: Linda.propriedadesDeAtributos,
		separar: Linda.propriedadesDeAtributos,
		substituir: Linda.propriedadesDeAtributos,
		substituirTodos: Linda.propriedadesDeAtributos
	});

	String.definirPropriedades({
		concatenar: Linda.propriedadesDeAtributos,
		concatenarComEspaco: Linda.propriedadesDeAtributos,
		formatar: Linda.propriedadesDeAtributos
	});

	Number.definirPropriedades({
		naoNumero: Linda.propriedadesDeAtributos,
		sortear: Linda.propriedadesDeAtributos,
		sortearInteiro: Linda.propriedadesDeAtributos
	});
}(this));
