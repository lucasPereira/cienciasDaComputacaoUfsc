(function (global) {
	"use strict";

	var ExcecaoLinda = function (mensagem) {
		this.mensagem = mensagem;
		this.message = mensagem;
	};

	ExcecaoLinda.prototype.comoTexto = function () {
		return "ExcecaoLinda: " + this.mensagem;
	};

	ExcecaoLinda.prototype.toString = function () {
		return this.comoTexto();
	};

	var Linda = {
		documento: document,
		janela: window,
		historico: window.history,
		localizacao: window.location,
		performance: window.performance,
		global: global,

		propriedadesDeAtributos: {
			configuravel: false,
			enumeravel: false,
			gravavel: false,
			funcaoFornecer: undefined,
			funcaoFixar: undefined,
			valor: undefined
		},

		propriedadesDeAtributosGravaveis: {
			configuravel: false,
			enumeravel: false,
			gravavel: true,
			funcaoFornecer: undefined,
			funcaoFixar: undefined,
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

		fornecerPrototipoDe: function (objeto) {
			return Object.getPrototypeOf(objeto);
		},

		instanciaDe: function (objeto, tipo) {
			if (!this.tipoDe(tipo, Function)) {
				return false;
			}
			return this.privadoInstanciaDeTipoPrimitivo(objeto, tipo);
		},

		privadoInstanciaDeTipoPrimitivo: function (objeto, tipo) {
			if (this.tipoDe(objeto, String) ||
					this.tipoDe(objeto, Number) ||
					this.tipoDe(objeto, Boolean) ||
					this.tipoDe(objeto, undefined)) {
				return this.tipoDe(objeto, tipo);
			}
			return this.privadoInstanciaDeDiretaOuIndireta(objeto, tipo);
		},

		privadoInstanciaDeDiretaOuIndireta: function (objeto, tipo) {
			while (!this.nulo(objeto) && (objeto !== tipo.prototype)) {
				objeto = this.fornecerPrototipoDe(objeto);
			}
			return (objeto === tipo.prototype);
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

		assegureQue: function (condicao) {
			if (!condicao) {
				throw new ExcecaoLinda("Asserção inválida. Quebra de contrato.");
			}
		},

		assegureQueNao: function (condicao) {
			this.assegureQue(!condicao);
		},

		selecionar: function (selecao) {
			return document.querySelector(selecao);
		},

		selecionarTodos: function (selecao) {
			return document.querySelectorAll(selecao);
		},

		obterPelaClasse: function (classe) {
			return document.getElementsByClassName(classe)[0];
		},

		obterTodosPelaClasse: function (classe) {
			return document.getElementsByClassName(classe);
		},

		obterPeloNome: function (nome) {
			return document.getElementsByName(nome)[0];
		},

		obterTodosPeloNome: function (nome) {
			return document.getElementsByName(nome);
		},

		obterPeloIdentificador: function (identificador) {
			return document.getElementById(identificador);
		},

		criarElemento: function (elemento) {
			return document.createElement(elemento);
		},

		avaliar: function (texto) {
			return window.eval(texto);
		},

		habilitarTelaCheia: function () {
			this.privadoHabilitarTelaCheia();
			this.privadoHabilitarTelaCheiaChrome();
			this.privadoHabilitarTelaCheiaFirefox();
		},

		privadoHabilitarTelaCheia: function () {
			if (this.instanciaDe(document.documentElement.requestFullScreen, Function)) {
				document.documentElement.requestFullScreen();
			}
		},

		privadoHabilitarTelaCheiaChrome: function () {
			if (this.instanciaDe(document.documentElement.mozRequestFullScreen, Function)) {
				document.documentElement.mozRequestFullScreen();
			}
		},

		privadoHabilitarTelaCheiaFirefox: function () {
			if (this.instanciaDe(document.documentElement.webkitRequestFullScreen, Function)) {
				document.documentElement.webkitRequestFullScreen();
			}
		},

		desabilitarTelaCheia: function () {
			this.privadoDesabilitarTelaCheia();
			this.privadoDesabilitarTelaCheiaChrome();
			this.privadoDesabilitarTelaCheiaFirefox();
		},

		privadoDesabilitarTelaCheia: function () {
			if (this.instanciaDe(document.cancelFullScreen, Function)) {
				document.cancelFullScreen();
			}
		},

		privadoDesabilitarTelaCheiaChrome: function () {
			if (this.instanciaDe(document.webkitCancelFullScreen, Function)) {
				document.webkitCancelFullScreen();
			}
		},

		privadoDesabilitarTelaCheiaFirefox: function () {
			if (this.instanciaDe(document.mozCancelFullScreen, Function)) {
				document.mozCancelFullScreen();
			}
		}
	};

	global.Linda = Linda;
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
/*global Linda*/
/*global TipoDeObservacao*/

(function () {
	"use strict";

	Object.implementar({
		definirPropriedade: function (atributo, definicao) {
			var propriedades = {};
			this.privadoDefinirPropriedade(propriedades, "value", definicao.valor);
			this.privadoDefinirPropriedade(propriedades, "get", definicao.funcaoFornecer);
			this.privadoDefinirPropriedade(propriedades, "set", definicao.funcaoFixar);
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

		fornecerPropriedades: function () {
			return Object.getOwnPropertyNames(this);
		},

		fornecerPropriedadesEnumeraveis: function () {
			return Object.keys(this);
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
			this.observar(tratador, propriedade, TipoDeObservacao.ATUALIZACAO);
		},

		observarCriacao: function (tratador, propriedade) {
			this.observar(tratador, propriedade, TipoDeObservacao.CRIACAO);
		},

		observarReconfiguracao: function (tratador, propriedade) {
			this.observar(tratador, propriedade, TipoDeObservacao.RECONFIGURACAO);
		},

		observarRemocao: function (tratador, propriedade) {
			this.observar(tratador, propriedade, TipoDeObservacao.REMOCAO);
		},

		desobservar: function (tratador) {
			Object.unobserve(this, tratador);
		},

		paraCada: function (funcaoDeIteracao, escopo) {
			funcaoDeIteracao = funcaoDeIteracao.vincularEscopo(escopo);
			for (var chave in this) {
				if (this.possuiPropriedadePropria(chave)) {
					funcaoDeIteracao(this[chave], chave);
				}
			}
		},

		possuiPropriedade: function (propriedade) {
			return (propriedade in this);
		},

		possuiPropriedadePropria: function (propriedade) {
			return this.hasOwnProperty(propriedade);
		},

		prototipoDe: function (prototipado) {
			return this.isPrototypeOf(prototipado);
		}
	});
}(this));
/*global Linda*/

(function () {
	"use strict";

	Array.implementar({
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
			funcaoFornecer: function () {
				return this[0];
			}
		},

		primeiroIndice: {
			funcaoFornecer: function () {
				return 0;
			}
		},

		ultimo: {
			funcaoFornecer: function () {
				return this[this.length - 1];
			}
		},

		ultimoIndice: {
			funcaoFornecer: function () {
				return (this.length - 1);
			}
		}
	});
} ());
(function () {
	"use strict";

	String.implementar({
		paraInteiro: function () {
			return parseInt(this, 10);
		},

		paraFlutuante: function () {
			return parseFloat(this, 10);
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
			funcaoFornecer: function () {
				return Number.MAX_VALUE;
			}
		},

		minimo: {
			funcaoFornecer: function () {
				return Number.MIN_VALUE;
			}
		},

		maisInfinito: {
			funcaoFornecer: function () {
				return Number.POSITIVE_INFINITY;
			},
		},

		menosInfinito: {
			funcaoFornecer: function () {
				return Number.NEGATIVE_INFINITY;
			}
		}
	});
}());
/*global Linda*/

(function (global) {
	"use strict";

	var Objeto = function Objeto() {};

	Objeto.implementar({
		igual: function (outro) {
			return (this === outro);
		}
	});

	var Classe = function Classe() {};

	Classe.estender({
		criar: function (corpoDaClasse) {
			var SuperClasse = corpoDaClasse.estende;
			var estende = Linda.instanciaDe(SuperClasse, Function);
			var inicializa = Linda.instanciaDe(corpoDaClasse.inicializar, Function);
			var NovaClasse = function Objeto() { this.inicializar.aplicarComEscopo(this, arguments); };
			var prototipo = Objeto.prototype;
			if (estende) {
				prototipo = SuperClasse.prototype;
				delete corpoDaClasse.estende;
			}
			NovaClasse.prototype = Object.create(prototipo);
			NovaClasse.prototipo = NovaClasse.prototype;
			corpoDaClasse.inicializar = (inicializa) ? corpoDaClasse.inicializar : function () {};
			NovaClasse.implementar(corpoDaClasse);
			return NovaClasse;
		},

		criarSingleton: function(corpoDaClasse) {
			var NovaClasseUnica = Classe.criar(corpoDaClasse);
			NovaClasseUnica.estender({
				instanciaUnica: null,
				instancia: function () {
					this.instanciaUnica = Object.create(this.prototipo);
					this.aplicarComEscopo(this.instanciaUnica, arguments);
					this.definirPropriedades({
						instanciaUnica: Linda.propriedadesDeAtributos,
						instancia: {
							configuravel: false,
							enumeravel: false,
							funcaoFornecer: function () {
								return this.instanciaUnica;
							}
						}
					});
					return this.instanciaUnica;
				}
			});
			return NovaClasseUnica;
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
			var NovaEnumeracaoDeConstantes = new Enumeracao();
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
				if (enumeracao.chave === chave) {
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

	global.Classe = Classe;
	global.Objeto = Objeto;
	global.Enumeracao = Enumeracao;
}(this));
/*global Linda*/
/*global Classe*/

(function (global) {
	"use strict";

	var Tipo = Classe.criarEnumeracaoDeConstantes(Linda.tipos);

	var Evento = Classe.criarEnumeracaoDeConstantes({
		TECLA_PRESSIONADA: "keydown",
		TECLA_SOLTA: "keyup",
		CARREGADO: "load",
		CLIQUE: "click",
		DUPLO_CLIQUE: "dbclick"
	});

	var Tecla = Classe.criarEnumeracaoDeConstantes({
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
		ARRAY_BUFFER: "arraybuffer"
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
		VIDEO: ["video"]
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
		TEXTO: [TipoGenericoDeMidia.TEXTO, "plain"],
		MP4: [TipoGenericoDeMidia.VIDEO, "mp4"],
		MPEG: [TipoGenericoDeMidia.VIDEO, "mpeg"],
		OGG: [TipoGenericoDeMidia.VIDEO, "ogg"],
		VORBIS: [TipoGenericoDeMidia.VIDEO, "vorbis"],
		WEBM: [TipoGenericoDeMidia.VIDEO, "webm"]
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

		comoTextoIngles: function () {
			return this.textoIngles;
		},

		informacional: function () {
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

	global.Tipo = Tipo;
	global.Evento = Evento;
	global.Tecla = Tecla;
	global.AtributoHttp = AtributoHttp;
	global.MetodoHttp = MetodoHttp;
	global.CodigoHttp = CodigoHttp;
	global.TipoDeResposta = TipoDeResposta;
	global.TipoDeMidia = TipoDeMidia;
	global.TipoGenericoDeMidia = TipoGenericoDeMidia;
	global.TipoDeObservacao = TipoDeObservacao;
}(this));
/*global Classe*/
/*global CodigoHttp*/
/*global Evento*/
/*global Linda*/
/*global MetodoHttp*/
/*global TipoDeResposta*/

(function (global) {
	"use strict";

	var RequisicaoHttp = Classe.criar({
		inicializar: function (uri, tipoDeResposta) {
			this.requisicaoXml = new XMLHttpRequest();
			this.requisicaoXml.responseType = tipoDeResposta;
			this.uri = uri;
			this.usuario = null;
			this.senha = null;
			this.adicionarTratadoresDeEventos();
			this.cabecalho = [];
		},

		adicionarTratadoresDeEventos: function () {
			this.requisicaoXml.onloadstart = function (evento) {
				this.tratarInicio(evento.loaded, evento.total, evento.timeStamp);
			}.vincularEscopo(this);
			this.requisicaoXml.onprogress = function (evento) {
				this.tratarProgresso(evento.loaded, evento.total, evento.timeStamp);
			}.vincularEscopo(this);
			this.requisicaoXml.onloadend = function (evento) {
				this.tratarTermino(evento.loaded, evento.total, evento.timeStamp);
			}.vincularEscopo(this);
			this.requisicaoXml.onabort = function (evento) {
				this.tratarAborto(evento.loaded, evento.total, evento.timeStamp);
			}.vincularEscopo(this);
			this.requisicaoXml.onerror = function (evento) {
				this.tratarErro(evento.loaded, evento.total, evento.timeStamp);
			}.vincularEscopo(this);
			this.requisicaoXml.ontimeout = function (evento) {
				this.tratarEstouroDeTempo(evento.loaded, evento.total, evento.timeStamp);
			}.vincularEscopo(this);
			this.requisicaoXml.onload = function (evento) {
				var resposta = this.fornecerResposta();
				var codigoDeEstado = CodigoHttp.mapear(this.requisicaoXml.status);
				var carregado = evento.loaded;
				var total = evento.total;
				var estampaDeTempo = evento.timeStamp;
				if (codigoDeEstado.sucesso()) {
					this.tratarSucesso(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
				} else if (codigoDeEstado.redirecionamento()) {
					this.tratarRedirecionamento(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
				} else if (codigoDeEstado.erroDoCliente()) {
					this.tratarErroDoCliente(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
				} else if (codigoDeEstado.erroDoServidor()) {
					this.tratarErroDoServidor(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
				}
				this.tratarResposta(resposta, codigoDeEstado, carregado, total, estampaDeTempo);
			}.vincularEscopo(this);
		},

		enviar: function (metodo, dados, assincrono) {
			assincrono = !!assincrono;
			metodo = MetodoHttp.mapear(metodo);
			this.requisicaoXml.open(metodo, this.uri, assincrono, this.usuario, this.senha);
			this.cabecalho.paraCada(function (atributo) {
				this.requisicaoXml.setRequestHeader(atributo.nome, atributo.valor);
			}, this);
			this.requisicaoXml.send(dados);
			if (!assincrono) {
				return this.fornecerResposta();
			}
		},

		enviarGet: function (assincrono) {
			return this.enviar(MetodoHttp.GET, null, assincrono);
		},

		enviarPut: function (dados, assincrono) {
			return this.enviar(MetodoHttp.PUT, dados, assincrono);
		},

		enviarPost: function (dados, assincrono) {
			return this.enviar(MetodoHttp.POST, dados, assincrono);
		},

		envirDelete: function (assincrono) {
			return this.enviar(MetodoHttp.DELETE, null, assincrono);
		},

		tratarInicio: function () {},

		tratarProgresso: function () {},

		tratarTermino: function () {},

		tratarErro: function () {},

		tratarAborto: function () {},

		tratarEstouroDeTempo: function () {},

		tratarResposta: function () {},

		tratarRedirecionamento: function () {},

		tratarSucesso: function () {},

		tratarErroDoCliente: function () {},

		tratarErroDoServidor: function () {},

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
			return this.requisicaoXml.response;
		}
	});

	var RequisicaoJson = Classe.criar({
		estende: RequisicaoHttp,

		inicializar: function (uri) {
			RequisicaoHttp.prototipo.inicializar.chamarComEscopo(this, uri, TipoDeResposta.JSON);
		},

		fornecerResposta: function () {
			return JSON.parse(this.requisicaoXml.response);
		}
	});

	var RequisicaoDocumento = Classe.criar({
		estende: RequisicaoHttp,

		inicializar: function (uri) {
			RequisicaoHttp.prototipo.inicializar.chamarComEscopo(this, uri, TipoDeResposta.DOCUMENTO);
		}
	});

	var RequisicaoTexto = Classe.criar({
		estende: RequisicaoHttp,

		inicializar: function (uri) {
			RequisicaoHttp.prototipo.inicializar.chamarComEscopo(this, uri, TipoDeResposta.TEXTO);
		}
	});

	var Tratador = Classe.criar({
		inicializar: function (elemento) {
			this.elemento = (Linda.nuloOuIndefinido(elemento)) ? Linda.janela : elemento;
			this.tratadores = [];
		},

		adicionar: function (evento, tratador) {
			var eventoTratador = {};
			eventoTratador.evento = evento;
			eventoTratador.tratador = tratador;
			this.tratadores.push(eventoTratador);
			this.elemento.addEventListener(evento, tratador);
		},

		remover: function () {
			this.tratadores.paraCada(function (eventoTratador) {
				this.elemento.removeEventListener(eventoTratador.evento, eventoTratador.tratador);
			}, this);
		}
	});

	var TratadorDeTeclado = Classe.criar({
		estende: Tratador,

		inicializar: function (tecla, elemento) {
			Tratador.prototipo.inicializar.chamarComEscopo(this, elemento);
			this.tecla = tecla;
		},

		paraTeclaPressionada: function (tratador) {
			this.adicionar(Evento.TECLA_PRESSIONADA, this.adicionarTratadorDeTeclado(tratador));
			return this;
		},

		paraTeclaSolta: function (tratador) {
			this.adicionar(Evento.TECLA_SOLTA, this.adicionarTratadorDeTeclado(tratador));
			return this;
		},

		adicionarTratadorDeTeclado: function (tratador) {
			return function (evento) {
				if (this.tecla === evento.keyCode) {
					tratador();
				}
			}.vincularEscopo(this);
		}
	});

	var TratadorDeMouse = Classe.criar({
		estende: Tratador,

		inicializar: function (elemento) {
			Tratador.prototipo.inicializar.chamarComEscopo(this, elemento);
		},

		paraClique: function (tratador) {
			this.adicionar(Evento.CLIQUE, tratador);
			return this;
		}
	});

	var TratadorDePagina = Classe.criar({
		estende: Tratador,

		inicializar: function (elemento) {
			Tratador.prototipo.inicializar.chamarComEscopo(this, elemento);
		},

		paraCarregamento: function (tratador) {
			this.adicionar(Evento.CARREGADO, tratador);
			return this;
		}
	});

	global.RequisicaoJson = RequisicaoJson;
	global.RequisicaoDocumento = RequisicaoDocumento;
	global.RequisicaoTexto = RequisicaoTexto;
	global.TratadorDeTeclado = TratadorDeTeclado;
	global.TratadorDeMouse = TratadorDeMouse;
	global.TratadorDePagina = TratadorDePagina;
}(this));
/*global HTMLCollection*/
/*global HTMLTemplateElement*/
/*global Linda*/
/*global NodeList*/
/*global TratadorDeMouse*/
/*global TratadorDePagina*/
/*global TratadorDeTeclado*/

(function () {
	"use strict";

	Node.implementar = Function.prototype.implementar;
	NodeList.implementar = Function.prototype.implementar;
	HTMLCollection.implementar = Function.prototype.implementar;

	Node.implementar({
		limpar: function () {
			var nodosFilhos = this.children;
			for (var indice = 0; indice < nodosFilhos.length; indice++) {
				var nodoFilho = nodosFilhos[indice];
				if (!Linda.instanciaDe(nodoFilho, HTMLTemplateElement)) {
					this.removeChild(nodoFilho);
					indice--;
				}
			}
		},

		selecionar: function (selecao) {
			return this.querySelector(selecao);
		},

		selecionarTodos: function (selecao) {
			return this.querySelectorAll(selecao);
		},

		tratadorDeClique: function (tratador) {
			return new TratadorDeMouse(this).paraClique(tratador);
		},

		tratadorDeCarregamento: function (tratador) {
			return new TratadorDePagina(this).paraCarregamento(tratador);
		},

		tratadorDeTeclaPressionada: function (tecla, tratador) {
			return new TratadorDeTeclado(tecla, this).paraTeclaPressionada(tratador);
		},

		tratadorDeTeclaSolta: function (tecla, tratador) {
			return new TratadorDeTeclado(tecla, this).paraTeclaSolta(tratador);
		}
	});

	NodeList.implementar({
		paraCada: Array.prototype.paraCada
	});

	HTMLCollection.implementar({
		paraCada: Array.prototype.paraCada
	});
}(this));
